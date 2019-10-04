package com.sy.biquan.activity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.FileProvider;

import com.google.gson.Gson;
import com.sy.biquan.Contants;
import com.sy.biquan.MyApplication;
import com.sy.biquan.R;
import com.sy.biquan.bean.CreateGroupBean;
import com.sy.biquan.bean.RegisterBean;
import com.sy.biquan.chat.ChatActivity;
import com.sy.biquan.proxy.HttpCallback;
import com.sy.biquan.proxy.HttpProxy;
import com.sy.biquan.util.SharedPreferencesUtil;
import com.sy.biquan.viewutil.CircleImageView;
import com.sy.biquan.viewutil.DialogUtil;
import com.tencent.imsdk.TIMConversationType;
import com.tencent.qcloud.tim.uikit.modules.chat.base.ChatInfo;
import com.tencent.qcloud.tim.uikit.utils.ToastUtil;

import org.json.JSONObject;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class CreateGroupActivity extends AppCompatActivity {
    private Button btnCreate;
    private EditText editGroupName;

    private CircleImageView groupImg;
    private ImageView camera;



    private String icon = "上传地址";

    //相册请求码
    private static final int ALBUM_REQUEST_CODE = 1;
    //相机请求码
    private static final int CAMERA_REQUEST_CODE = 2;
    //剪裁请求码
    private static final int CROP_REQUEST_CODE = 3;

    //调用照相机返回图片文件
    private File tempFile;

    private PopupWindow popupWindow;
    private WindowManager.LayoutParams params;
    private boolean mIsShowing = false;


    private String groupId = "";


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


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_group);
        params = getWindow().getAttributes();
        btnCreate = findViewById(R.id.btn_create_group);
        editGroupName = findViewById(R.id.et_group_name);
        groupImg = findViewById(R.id.user_img);
        camera = findViewById(R.id.iv_camera);
        groupImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                popup();
            }
        });
        if(editGroupName.getText() != null && "".equals(editGroupName.getText().toString())){

        }
        btnCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Gson gson = new Gson();
                String userInfoString = SharedPreferencesUtil.userInfoGetString(CreateGroupActivity.this,Contants.USERINFO);
                RegisterBean user = gson.fromJson(userInfoString,RegisterBean.class);
                Map<String,String> params = new HashMap<>();
                params.put("token",user.getData().getToken());
                params.put("kol","0");
                params.put("currency","");
                params.put("currency_id","");
                params.put("Name",editGroupName.getText().toString());
                params.put("FaceUrl","https://landscape-test.oss-cn-hangzhou.aliyuncs.com/default_avatar/%E6%9D%A8%E9%A2%96.jpeg");
                String mapJson = gson.toJson(params);

                Log.e("CreateGroupActivity","mapJson--->"+mapJson);
                HttpProxy.obtain().post(Contants.URL + Contants.CREATE_GROUP, params, new HttpCallback<CreateGroupBean>() {
                    @Override
                    public void onFailure(String e) {

                    }

                    @Override
                    public void onSuccess(CreateGroupBean createGroupBean) {
                        if(createGroupBean.getCode() == Contants.GET_DATA_SUCCESS){
                            groupId = createGroupBean.getData();
                            //建群成功
                            DialogUtil.createGroupAlertDialog(CreateGroupActivity.this,  "创建群聊成功",  "恭喜你新建群成功，现在可以去添加群成员了。",
                                    "先不添加", "邀请好友进群", false, new DialogUtil.AlertDialogBtnClickListener() {
                                        @Override
                                        public void clickPositive() {
                                            startChat();
                                        }

                                        @Override
                                        public void clickNegative() {

                                        }
                                    });
                        }else if(createGroupBean.getCode() == Contants.GET_DATA_FAIL){
                            ToastUtil.toastLongMessage("创建群聊失败："+createGroupBean.getMsg());
                        }
                    }
                });
            }
        });
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
                        Uri contentUri = FileProvider.getUriForFile(CreateGroupActivity.this, "com.hansion.chosehead", tempFile);
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
                    groupImg.setImageBitmap(image);
                    camera.setVisibility(View.GONE);
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

    private void startChat(){
        ChatInfo chatInfo = new ChatInfo();
        chatInfo.setType(TIMConversationType.Group);
        chatInfo.setId(groupId);
        chatInfo.setChatName(editGroupName.getText().toString());
        Intent intent = new Intent(MyApplication.instance(), ChatActivity.class);
        intent.putExtra(Contants.CHAT_INFO, chatInfo);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        MyApplication.instance().startActivity(intent);
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
            Uri contentUri = FileProvider.getUriForFile(CreateGroupActivity.this, "com.bq.photo", tempFile);
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
