package com.sy.biquan.activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.sy.biquan.Contants;
import com.sy.biquan.MyApplication;
import com.sy.biquan.R;
import com.sy.biquan.bean.GroupInfoBean;
import com.sy.biquan.proxy.HttpCallback;
import com.sy.biquan.proxy.HttpProxy;
import com.sy.biquan.util.SharedPreferencesUtil;
import com.tencent.imsdk.TIMFriendshipManager;
import com.tencent.imsdk.TIMGroupManager;
import com.tencent.imsdk.TIMGroupMemberInfo;
import com.tencent.imsdk.TIMUserProfile;
import com.tencent.imsdk.TIMValueCallBack;
import com.tencent.qcloud.tim.uikit.utils.ToastUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyGroupInfoActivity extends AppCompatActivity implements View.OnClickListener {

    public static final String GROUP_ID = "group_id";
    public static final String GROUP_NAME = "group_NAME";

    private LinearLayout ll_group_member;//群成员
    private LinearLayout ll_group_name;//群名称
    private LinearLayout ll_group_project;//群项目
    private LinearLayout ll_qr_code;//群二维码
    private LinearLayout ll_change_group_manager;//群管理转让
    private LinearLayout ll_my_name;//我的群昵称
    private LinearLayout ll_search_group_content;//查找聊天内容
    private LinearLayout ll_clear_chat_content;//清空聊天内容
    private LinearLayout ll_get_out_forever;//永久踢出群聊
    private TextView groupName;
    private TextView projectName;

    private ImageView ivPlus;//加人
    private ImageView ivSub;//踢人

    private String groupId = "";
//    private String groupName = "";
    List<String> userIds = new ArrayList<>();//群用户id列表
    ImageView img1,img2,img3;
    TextView userName1,userName2,userName3;
    List<ImageView> faceImgs =  new ArrayList<>();
    List<TextView> userNames =  new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_group_info);
        groupId = getIntent().getStringExtra(GROUP_ID);
        initView();

        ll_group_name.setOnClickListener(this);

        TIMGroupManager.getInstance().getGroupMembers(groupId, new TIMValueCallBack<List<TIMGroupMemberInfo>>() {
            @Override
            public void onError(int i, String s) {

            }

            @Override
            public void onSuccess(List<TIMGroupMemberInfo> timGroupMemberInfos) {
                if(timGroupMemberInfos.size()>0){
                    for (int i=0;i<timGroupMemberInfos.size();i++){
                        userIds.add(timGroupMemberInfos.get(i).getUser());
                        Log.e("MyGroupInfoActivity","userId:"+userIds.get(i));
                        TIMFriendshipManager.getInstance().getUsersProfile(userIds,true, new TIMValueCallBack<List<TIMUserProfile>>(){
                            @Override
                            public void onError(int i, String s) {
                                Log.e("MyGroupInfoActivity","getUsersProfile-onError:---s---|"+s+"|---i---"+i);
                            }

                            @Override
                            public void onSuccess(List<TIMUserProfile> timUserProfiles) {
                                Log.e("MyGroupInfoActivity","getUsersProfile-onSuccess:"+timUserProfiles.size());
                                if(timUserProfiles.size()>0){
                                    for (int i=0;i<timUserProfiles.size();i++){
                                        Glide.with(MyApplication.instance())
                                                .load(timUserProfiles.get(i).getFaceUrl())
                                                .into(faceImgs.get(i));
                                        userNames.get(i).setText(timUserProfiles.get(i).getNickName());
                                        Log.e("MyGroupInfoActivity","userName:"+timUserProfiles.get(i).getNickName());
                                        if(i>=2){
                                            i = timUserProfiles.size();
                                        }
                                    }
                                }
                            }
                        });
                    }
                }
            }
        });



    }

    private void getGroupInfo(){

        Map<String,String> params = new HashMap<>();
        params.put("token", SharedPreferencesUtil.getToken());
        params.put("groupId",groupId);
        HttpProxy.obtain().post(Contants.URL + Contants.GET_GROUP_INFO, params, new HttpCallback<GroupInfoBean>() {
            @Override
            public void onFailure(String e) {
                ToastUtil.toastLongMessage("连接服务器失败"+e);
            }

            @Override
            public void onSuccess(GroupInfoBean groupInfoBean) {
                if(groupInfoBean.getCode() == Contants.GET_DATA_SUCCESS) {
                    groupName.setText(groupInfoBean.getData().getGroupName());
                    if ("".equals(groupInfoBean.getData().getGongLianName())) {
                        ll_group_project.setVisibility(View.GONE);
                    }
                    if (groupInfoBean.getData().getIsOwner() == 1) {
                        ivPlus.setVisibility(View.VISIBLE);
                        ivSub.setVisibility(View.VISIBLE);
                    } else {
                        ivPlus.setVisibility(View.GONE);
                        ivSub.setVisibility(View.GONE);
                    }
                }
            }
        });

    }

    private void initView(){
        ll_group_member = findViewById(R.id.ll_group_member);
        ll_group_name = findViewById(R.id.ll_group_name);
        ll_group_project = findViewById(R.id.ll_group_project);
        ll_qr_code = findViewById(R.id.ll_qr_code);
        ll_change_group_manager = findViewById(R.id.ll_change_group_manager);
        ll_my_name = findViewById(R.id.ll_my_name);
        ll_search_group_content = findViewById(R.id.ll_search_group_content);
        ll_clear_chat_content = findViewById(R.id.ll_clear_chat_content);
        ll_get_out_forever = findViewById(R.id.ll_get_out_forever);
        groupName = findViewById(R.id.tv_group_name);
        projectName = findViewById(R.id.tv_group_project_name);
        ivPlus = findViewById(R.id.iv_plus);
        ivSub = findViewById(R.id.iv_sub);
        img1 = findViewById(R.id.img1);
        img2 = findViewById(R.id.img2);
        img3 = findViewById(R.id.img3);

        userName1 = findViewById(R.id.tv_user_name_1);
        userName2 = findViewById(R.id.tv_user_name_2);
        userName3 = findViewById(R.id.tv_user_name_3);

        faceImgs.add(img1);
        faceImgs.add(img2);
        faceImgs.add(img3);
        userNames.add(userName1);
        userNames.add(userName2);
        userNames.add(userName3);


    }

    @Override
    protected void onStart() {
        super.onStart();
        getGroupInfo();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.ll_group_member:

                break;
            case R.id.ll_group_name:
                startActivity(new Intent(MyGroupInfoActivity.this,ModifyGroupName.class)
                        .putExtra(GROUP_NAME,groupName.getText().toString())
                        .putExtra(GROUP_ID,groupId));
                break;
            case R.id.ll_group_project:

                break;
            case R.id.ll_qr_code:

                break;
            case R.id.ll_change_group_manager:

                break;
            case R.id.ll_my_name:

                break;
            case R.id.ll_search_group_content:

                break;
            case R.id.ll_clear_chat_content:

                break;
            case R.id.ll_get_out_forever:

                break;

        }
    }
}
