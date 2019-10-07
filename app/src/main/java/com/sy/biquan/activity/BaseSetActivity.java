package com.sy.biquan.activity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.FileProvider;

import com.bumptech.glide.Glide;
import com.google.gson.Gson;
import com.sy.biquan.R;
import com.sy.biquan.bean.MineDataBean;
import com.sy.biquan.bean.UserInfo;
import com.sy.biquan.util.SharedPreferencesUtil;
import com.sy.biquan.viewutil.CircleImageView;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class BaseSetActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView name;//昵称
    private TextView phone;//电话号码
    private TextView invite;//邀请人
    private TextView idCard;//是否实名认证
    private CircleImageView userImg;//头像

    private LinearLayout ll_user_img;
    private LinearLayout ll_name;
    private LinearLayout ll_slogan;
    private LinearLayout ll_phone;
    private LinearLayout ll_invite;
    private LinearLayout ll_id_card;
    private RelativeLayout rlBack;



    //调用照相机返回图片文件
    private File tempFile;

    private PopupWindow popupWindow;
    private WindowManager.LayoutParams params;
    private boolean mIsShowing = false;

    //相册请求码
    private static final int ALBUM_REQUEST_CODE = 1;
    //相机请求码
    private static final int CAMERA_REQUEST_CODE = 2;
    //剪裁请求码
    private static final int CROP_REQUEST_CODE = 3;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base_set);
        params = getWindow().getAttributes();
        initView();
        rlBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        ll_user_img.setOnClickListener(this);
        ll_name.setOnClickListener(this);
        ll_slogan.setOnClickListener(this);
        ll_phone.setOnClickListener(this);
        ll_invite.setOnClickListener(this);
        ll_id_card.setOnClickListener(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        setData();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            // 调用相机后返回
            case CAMERA_REQUEST_CODE:
                if (resultCode == RESULT_OK) {
                    //用相机返回的照片去调用剪裁也需要对Uri进行处理
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                        Uri contentUri = FileProvider.getUriForFile(BaseSetActivity.this, "com.hansion.chosehead", tempFile);
                        cropPhoto(contentUri);//裁剪图片
                    } else {
                        cropPhoto(Uri.fromFile(tempFile));//裁剪图片
                    }
                }
                break;
            //调用相册后返回
            case ALBUM_REQUEST_CODE:
                if (resultCode == RESULT_OK) {
                    Uri uri = data.getData();
                    cropPhoto(uri);//裁剪图片
                }
                break;
            //调用剪裁后返回
            case CROP_REQUEST_CODE:
                Bundle bundle = data.getExtras();
                if (bundle != null) {
                    //在这里获得了剪裁后的Bitmap对象，可以用于上传
                    Bitmap image = bundle.getParcelable("data");
                    //设置到ImageView上
                    userImg.setImageBitmap(image);
                    //也可以进行一些保存、压缩等操作后上传
                    String path = saveImage("userHeader", image);
//                    File file = new File(path);
                    /*
                     *上传文件的额操作
                     */
                }
                break;
        }
    }

    private void setData(){

//        MineDataBean mineDataBean = SharedPreferencesUtil.getUserInfo2();
        UserInfo userInfo = SharedPreferencesUtil.newGetUserInfo();
        Glide.with(this)
                .load(userInfo.getUserAvatar())
                .into(userImg);
        name.setText(userInfo.getUserAlias());
        phone.setText(userInfo.getUserPhone());
        if("1".equals(userInfo.getHasInviteCode())){
            invite.setText(userInfo.getInviteUserAlias());
        }else {
            invite.setText("未绑定");
        }
        if("0".equals(userInfo.getAuthStatus())){//是否实名认证 0-未认证 1-审核中 2-认证成功 3-认证失败
            idCard.setText("未认证");
        }else if("1".equals(userInfo.getAuthStatus())){//是否实名认证 0-未认证 1-审核中 2-认证成功 3-认证失败
            idCard.setText("审核中");
        }else if("2".equals(userInfo.getAuthStatus())){//是否实名认证 0-未认证 1-审核中 2-认证成功 3-认证失败
            idCard.setText("认证成功");
        }else if("3".equals(userInfo.getAuthStatus())){//是否实名认证 0-未认证 1-审核中 2-认证成功 3-认证失败
            idCard.setText("认证失败");
        }
    }

    private void initView(){

        ll_user_img = findViewById(R.id.ll_user_img);
        ll_name = findViewById(R.id.ll_name);
        ll_slogan = findViewById(R.id.ll_slogan);
        ll_phone = findViewById(R.id.ll_phone);
        ll_invite = findViewById(R.id.ll_invite);
        ll_id_card = findViewById(R.id.ll_id_card);

        name = findViewById(R.id.tv_set_user_name);
        phone = findViewById(R.id.tv_set_user_phone);
        invite = findViewById(R.id.tv_set_invite);
        idCard = findViewById(R.id.tv_set_id_card);
        userImg = findViewById(R.id.civ_user_img);
        rlBack = findViewById(R.id.rl_back);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.ll_user_img:
                popup();
                break;
            case R.id.ll_name:
                startActivity(new Intent(BaseSetActivity.this,NameSetActivity.class));
                break;
            case R.id.ll_slogan:
                startActivity(new Intent(BaseSetActivity.this,SlognSetActivity.class));
                break;
            case R.id.ll_phone:

                break;
            case R.id.ll_invite:
                startActivity(new Intent(BaseSetActivity.this, SetInvitePersonActivity.class));
                break;
            case R.id.ll_id_card:
                startActivity(new Intent(BaseSetActivity.this, SetIDCard.class));
                break;

        }
    }

    public void popup(){
        if(popupWindow == null){
            initPopup();
        }
        if(!mIsShowing){
            params.alpha= 0.3f;
            getWindow().setAttributes(params);
            popupWindow.showAtLocation(findViewById(R.id.layout_main), Gravity.BOTTOM,0,0);
            mIsShowing = true;
        }
    }

    private void initPopup() {
        View pop = View.inflate(this, R.layout.select_camera_pop, null);
        popupWindow = new PopupWindow(pop, ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT);
        popupWindow.setTouchable(true);
        popupWindow.setOutsideTouchable(false);
        popupWindow.setBackgroundDrawable(new BitmapDrawable(getResources(), (Bitmap) null));
//        popupWindow.setAnimationStyle(R.style.anim_menu_bottombar);
        mIsShowing = false;
        TextView xj = pop.findViewById(R.id.tv_xj);
        TextView xc = pop.findViewById(R.id.tv_xc);
        TextView qx = pop.findViewById(R.id.tv_qx);

        xj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dismiss();
                getPicFromCamera();
            }
        });

        xc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dismiss();
                getPicFromAlbm();
            }
        });

        qx.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dismiss();
            }
        });
    }


    public void dismiss(){
        if(popupWindow != null &&mIsShowing){
            popupWindow.dismiss();
            mIsShowing = false;
            params.alpha= 1f;
            getWindow().setAttributes(params);
        }
    }



    /**
     * 从相机获取图片
     */
    private void getPicFromCamera() {
        //用于保存调用相机拍照后所生成的文件
        tempFile = new File(Environment.getExternalStorageDirectory().getPath(), System.currentTimeMillis() + ".jpg");
        //跳转到调用系统相机
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        //判断版本
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {   //如果在Android7.0以上,使用FileProvider获取Uri
            intent.setFlags(Intent.FLAG_GRANT_WRITE_URI_PERMISSION);
            //创建文件夹
            File file = new File("com.bq.photo");
            if (!file.exists()) {
                file.mkdir();
            }
            Uri contentUri = FileProvider.getUriForFile(BaseSetActivity.this, "com.bq.photo", tempFile);
            intent.putExtra(MediaStore.EXTRA_OUTPUT, contentUri);
        } else {    //否则使用Uri.fromFile(file)方法获取Uri
            intent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(tempFile));
        }
        startActivityForResult(intent, CAMERA_REQUEST_CODE);
    }
    /**
     * 从相册获取图片
     */
    private void getPicFromAlbm() {
        Intent photoPickerIntent = new Intent(Intent.ACTION_PICK, MediaStore.Audio.Media.EXTERNAL_CONTENT_URI);
        photoPickerIntent.setType("image/*");
        startActivityForResult(photoPickerIntent, ALBUM_REQUEST_CODE);
    }

    /**
     * 裁剪图片
     */
    private void cropPhoto(Uri uri) {
        Intent intent = new Intent("com.android.camera.action.CROP");
        intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
        intent.addFlags(Intent.FLAG_GRANT_WRITE_URI_PERMISSION);
        intent.setDataAndType(uri, "image/*");
        intent.putExtra("crop", "true");
        intent.putExtra("aspectX", 1);
        intent.putExtra("aspectY", 1);
        intent.putExtra("outputX", 300);
        intent.putExtra("outputY", 300);
        intent.putExtra("return-data", true);
        startActivityForResult(intent, CROP_REQUEST_CODE);
    }

    /**
     * 保存图片到本地
     *
     * @param name
     * @param bmp
     * @return
     */
    public String saveImage(String name, Bitmap bmp) {
        File appDir = new File(Environment.getExternalStorageDirectory().getPath());
        if (!appDir.exists()) {
            appDir.mkdir();
        }
        String fileName = name + ".jpg";
        File file = new File(appDir, fileName);
        try {
            FileOutputStream fos = new FileOutputStream(file);
            bmp.compress(Bitmap.CompressFormat.JPEG, 100, fos);
            fos.flush();
            fos.close();
            return file.getAbsolutePath();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }




}
