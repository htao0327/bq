package com.sy.biquan.activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.sy.biquan.Contants;
import com.sy.biquan.R;
import com.sy.biquan.bean.RegisterBean;
import com.sy.biquan.bean.UserInfo;
import com.sy.biquan.proxy.HttpCallback;
import com.sy.biquan.proxy.HttpProxy;
import com.sy.biquan.util.SharedPreferencesUtil;
import com.sy.biquan.viewutil.ChatLayoutHelper;
import com.sy.biquan.viewutil.DialogUtil;
import com.tencent.qcloud.tim.uikit.utils.ToastUtil;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.HashMap;
import java.util.Map;

public class GiveRedEnevlopeC2C extends AppCompatActivity {

    public static final String USER_ID = "user_id";

    private RelativeLayout rl_back;
    private EditText money;
    private EditText content;
    private Button  btn;

    private String userId = "";
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_c2c_money);
        EventBus.getDefault().register(this);
        userId = getIntent().getStringExtra(USER_ID);
        rl_back = findViewById(R.id.rl_back);
        money = findViewById(R.id.et_money);
        content = findViewById(R.id.et_text);
        btn = findViewById(R.id.btn_send);
        rl_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UserInfo userInfo = SharedPreferencesUtil.newGetUserInfo();
                String mDealPwd = userInfo.getDealPassword();

                if("".equals(money.getText().toString().trim())){
                    ToastUtil.toastLongMessage("请输入Q豆数量");
                    return;
                }

                if("0".equals(mDealPwd)){
                    DialogUtil.createGroupAlertDialog(GiveRedEnevlopeC2C.this, "",
                            "你还未设计交易密码，请先设置交易密码再进行打赏。",
                            "取消", "去设置", false, new DialogUtil.AlertDialogBtnClickListener() {
                        @Override
                        public void clickPositive() {

                        }

                        @Override
                        public void clickNegative() {
                            startActivity(new Intent(GiveRedEnevlopeC2C.this,SetDealPwdActivity.class));
                        }
                    });
                }else{
                    CodeActivity.inputPassword(GiveRedEnevlopeC2C.this, 6);

                }

            }
        });
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void getPwd(String pwd){
        Log.e("GiveRedEnevlopeC2C","---pwd---"+pwd);
        if(!"".equals(money.getText().toString().trim())){
            Map<String,String> params = new HashMap<>();
            params.put("token", SharedPreferencesUtil.getToken());
            params.put("dealPassword", pwd);
            params.put("receiveId", userId);
            params.put("number", "1");
            params.put("type", "2");
            params.put("money",money.getText().toString());
            if(content.getText() == null || "".equals(content.getText().toString())){
                params.put("remark","每日一赏");
            }else {
                params.put("remark",content.getText().toString());
            }

            HttpProxy.obtain().post(Contants.URL + Contants.RED_PAC_C2C, params, new HttpCallback<ChatLayoutHelper.CustomMessageData>() {
                @Override
                public void onFailure(String e) {
                    Log.e("GiveRedEnvelope","onFailure"+e);
                }

                @Override
                public void onSuccess(ChatLayoutHelper.CustomMessageData redEnvelopeBean) {
                    Log.e("GiveRedEnvelope","onSuccess"+redEnvelopeBean.toString());
                    if(redEnvelopeBean.getCode() == Contants.GET_DATA_SUCCESS){

                        ChatLayoutHelper.CustomMessageData customMessageData = redEnvelopeBean;
                        customMessageData.setVersion(1);
                        customMessageData.setType(1);
                        EventBus.getDefault().post(customMessageData);

                        finish();
                    }else {
                        ToastUtil.toastLongMessage(redEnvelopeBean.getMsg());
                    }
                }
            });
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
}
