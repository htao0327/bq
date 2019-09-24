package com.sy.biquan.activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.Gson;
import com.sy.biquan.Contants;
import com.sy.biquan.R;
import com.sy.biquan.bean.CreateGroupBean;
import com.sy.biquan.bean.RegisterBean;
import com.sy.biquan.chat.ChatActivity;
import com.sy.biquan.proxy.HttpCallback;
import com.sy.biquan.proxy.HttpProxy;
import com.sy.biquan.util.SharedPreferencesUtil;
import com.sy.biquan.viewutil.DialogUtil;
import com.tencent.imsdk.TIMConversationType;
import com.tencent.qcloud.tim.uikit.modules.chat.base.ChatInfo;
import com.tencent.qcloud.tim.uikit.utils.ToastUtil;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class CreateGroupActivity extends AppCompatActivity {
    private Button btnCreate;
    private EditText editGroupName;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_group);
        btnCreate = findViewById(R.id.btn_create_group);
        editGroupName = findViewById(R.id.et_group_name);
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
                params.put("curreny","");
                params.put("currency_id","");
                params.put("Name",editGroupName.getText().toString());
                params.put("FaceUrl","https://landscape-test.oss-cn-hangzhou.aliyuncs.com/default_avatar/%E6%9D%A8%E9%A2%96.jpeg");
                params.put("MaxMemberCount","500");
                String mapJson = gson.toJson(params);

                Log.e("CreateGroupActivity","mapJson--->"+mapJson);
                HttpProxy.obtain().post(Contants.URL + Contants.CREATE_GROUP, params, new HttpCallback<CreateGroupBean>() {
                    @Override
                    public void onFailure(String e) {

                    }

                    @Override
                    public void onSuccess(CreateGroupBean createGroupBean) {
                        if(createGroupBean.getCode() == Contants.GET_DATA_SUCCESS){
                            //建群成功
                            DialogUtil.createGroupAlertDialog(CreateGroupActivity.this,  "创建群聊成功",  "恭喜你新建群成功，现在可以去添加群成员了。",
                                    "先不添加", "邀请好友进群", false, new DialogUtil.AlertDialogBtnClickListener() {
                                        @Override
                                        public void clickPositive() {

                                        }

                                        @Override
                                        public void clickNegative() {
//                                            ChatInfo chatInfo = new ChatInfo();
//                                            chatInfo.setType(TIMConversationType.Group);
//                                            String chatName = contact.getId();
//                                            if (!TextUtils.isEmpty(contact.getRemark())) {
//                                                chatName = contact.getRemark();
//                                            } else if (!TextUtils.isEmpty(contact.getNickname())) {
//                                                chatName = contact.getNickname();
//                                            }
//                                            chatInfo.setChatName(chatName);
//                                            chatInfo.setId(contact.getId());
//                                            Intent intent = new Intent(GroupListActivity.this, ChatActivity.class);
//                                            intent.putExtra(Contants.CHAT_INFO, chatInfo);
//                                            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//                                            startActivity(intent);
                                        }
                                    });
                        }else if(createGroupBean.getCode() == Contants.GET_DATA_FAIL){
                            ToastUtil.toastLongMessage("创建群聊失败，错误码："+createGroupBean.getData().getErrorCode());
                        }
                    }
                });
            }
        });
    }
}
