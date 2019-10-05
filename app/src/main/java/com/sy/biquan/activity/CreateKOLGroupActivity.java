package com.sy.biquan.activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.Gson;
import com.sy.biquan.Contants;
import com.sy.biquan.MyApplication;
import com.sy.biquan.R;
import com.sy.biquan.bean.CreateGroupBean;
import com.sy.biquan.bean.GetHasGroupCounts;
import com.sy.biquan.bean.MyWalletBean;
import com.sy.biquan.bean.RegisterBean;
import com.sy.biquan.chat.ChatActivity;
import com.sy.biquan.proxy.HttpCallback;
import com.sy.biquan.proxy.HttpProxy;
import com.sy.biquan.util.SharedPreferencesUtil;
import com.sy.biquan.viewutil.ChatLayoutHelper;
import com.sy.biquan.viewutil.DialogUtil;
import com.tencent.imsdk.TIMConversationType;
import com.tencent.qcloud.tim.uikit.modules.chat.base.ChatInfo;
import com.tencent.qcloud.tim.uikit.utils.ToastUtil;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.HashMap;
import java.util.Map;

public class CreateKOLGroupActivity extends AppCompatActivity {

    private final String TAG = "CreateKOLGroupActivity";
    private EditText groupName;
    private EditText coinName;
    private Button btnCreate;
    private TextView hasGroupCounts;//剩余可创建群数量
    private TextView glName;
    private String glId = "";
    private LinearLayout ll_select_gl;

    private String groupId;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_kol_group);
        EventBus.getDefault().register(this);
        initView();
        getCounts();
        ll_select_gl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(CreateKOLGroupActivity.this,AddGLianActivity.class));
            }
        });
        btnCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Gson gson = new Gson();
                String userInfoString = SharedPreferencesUtil.userInfoGetString(CreateKOLGroupActivity.this,Contants.USERINFO);
                RegisterBean user = gson.fromJson(userInfoString,RegisterBean.class);
                Map<String,String> params = new HashMap<>();
                params.put("token",user.getData().getToken());
                params.put("kol","1");
                params.put("currency",coinName.getText().toString().trim());
                params.put("currency_id",glId);
                params.put("Name",groupName.getText().toString());
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
                            DialogUtil.createGroupAlertDialog(CreateKOLGroupActivity.this,
                                    "创建群聊成功",  "恭喜你新建群成功，现在可以去添加群成员了。",
                                    "先不添加", "邀请好友进群", true, new DialogUtil.AlertDialogBtnClickListener() {
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

    private void initView(){
        groupName = findViewById(R.id.et_group_name);
        coinName = findViewById(R.id.et_coin_name);
        btnCreate = findViewById(R.id.btn_create_group);
        hasGroupCounts = findViewById(R.id.tv_counts);
        glName = findViewById(R.id.gl_name);
        ll_select_gl = findViewById(R.id.ll_select);
    }

    private void getCounts(){

        Map<String,String> params = new HashMap<>();
        params.put("token",SharedPreferencesUtil.getToken());
        HttpProxy.obtain().post(Contants.URL + Contants.GROUP_REMAIN, params, new HttpCallback<GetHasGroupCounts>() {
            @Override
            public void onFailure(String e) {
                Log.e(TAG,"onFailure:"+e);
            }

            @Override
            public void onSuccess(GetHasGroupCounts getHasGroupCounts) {
                Log.e(TAG,"onSuccess:"+getHasGroupCounts);
                hasGroupCounts.setText(String.valueOf(getHasGroupCounts.getData()));
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void sendRedEnvelopr(MyWalletBean.DataBean myWalletBean){
        glName.setText(myWalletBean.getCurrencyEnglish());
        glId = myWalletBean.getId();
    }


    private void startChat(){
        ChatInfo chatInfo = new ChatInfo();
        chatInfo.setType(TIMConversationType.Group);
        chatInfo.setId(groupId);
        chatInfo.setChatName(groupName.getText().toString());
        Intent intent = new Intent(MyApplication.instance(), ChatActivity.class);
        intent.putExtra(Contants.CHAT_INFO, chatInfo);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        MyApplication.instance().startActivity(intent);
    }


}
