package com.sy.biquan.activity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.sy.biquan.Contants;
import com.sy.biquan.R;
import com.sy.biquan.bean.BindUserBean;
import com.sy.biquan.bean.RegisterBean;
import com.sy.biquan.bean.UserInfo;
import com.sy.biquan.proxy.HttpCallback;
import com.sy.biquan.proxy.HttpProxy;
import com.sy.biquan.util.SharedPreferencesUtil;
import com.tencent.openqq.protocol.imsdk.msgcomm;
import com.tencent.qcloud.tim.uikit.utils.ToastUtil;

import java.util.HashMap;
import java.util.Map;

public class SetDealPwdActivity extends AppCompatActivity {

    private EditText phone,yzm,pwd,pwd2;
    private TextView title,t1,t2;
    private Button btn;
    private Button yzm_btn;
    private RelativeLayout rl_back;
    private TimeCount time;

    private int type = 0;//0交易密码 1 登录密码

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_deal_pwd);

        type = getIntent().getIntExtra("type",0);

        t1 = findViewById(R.id.t1);
        t2 = findViewById(R.id.t2);
        title = findViewById(R.id.title);
        phone = findViewById(R.id.et_phone);
        yzm = findViewById(R.id.et_yzm);
        pwd = findViewById(R.id.et_pwd);
        pwd2 = findViewById(R.id.et_pwd2);
        btn = findViewById(R.id.btn);
        yzm_btn = findViewById(R.id.btn_register_get_yzm);
        rl_back = findViewById(R.id.rl_back);


        if(type == 1){
            title.setText("设置登录密码");
            t1.setText("登录密码");
            t1.setText("确认登录密码");
        }






        time = new TimeCount(60000, 1000);
        rl_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        yzm_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(phone.getText().toString().length()<11){
                    ToastUtil.toastLongMessage("手机号码不正确");
                }else{
                    time.start();
                    Map<String,String> params = new HashMap<>();
//                params.put("phone",etPhone.getText().toString().trim());
//                params.put("captchaType",Contants.GET_YZM_REGISTER);
                    String captchaType = "";
                    if(type == 0){
                        captchaType = "5";
                    }else{
                        captchaType = "6";
                    }

                    HttpProxy.obtain().get(Contants.URL + Contants.GETYZM+"?phone="+phone.getText().toString().trim()+"&captchaType="+captchaType, params, new HttpCallback<RegisterBean>() {
                        @Override
                        public void onFailure(String e) {
                            Log.e("SetDealPwdActivity", "onFailure: " + e);
                        }

                        @Override
                        public void onSuccess(RegisterBean registerBean) {
                            Log.e("SetDealPwdActivity", "Network result：" + registerBean.toString());
//                            if(registerBean.getCode() == Contants.GET_DATA_SUCCESS){
//
//                            }else {//显示错误信息
                                ToastUtil.toastLongMessage(registerBean.getMsg());
//                            }
                        }
                    });
                }
            }
        });

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(phone.getText().toString().length()<11){
                    ToastUtil.toastLongMessage("手机号码不正确");
                }else if("".equals(yzm.getText().toString().trim())){
                    ToastUtil.toastLongMessage("请输入验证码");
                }else if("".equals(pwd.getText().toString().trim()) && pwd.getText().toString().trim().equals(pwd2.getText().toString().trim()) ){
                    ToastUtil.toastLongMessage("两次密码不一样");
                }else{
                    if(type == 0){
                        Map<String,String> params = new HashMap<>();
                        params.put("token", SharedPreferencesUtil.getToken());
                        params.put("phone",phone.getText().toString());
                        params.put("code",yzm.getText().toString());
                        params.put("dealPassword",pwd.getText().toString());
                        HttpProxy.obtain().post(Contants.URL + Contants.DEAL_PWD, params, new HttpCallback<BindUserBean>() {
                            @Override
                            public void onFailure(String e) {

                            }

                            @Override
                            public void onSuccess(BindUserBean bindUserBean) {
                                ToastUtil.toastLongMessage("设置成功");
                                UserInfo userInfo = SharedPreferencesUtil.newGetUserInfo();
                                userInfo.setDealPassword("1");
                                SharedPreferencesUtil.setUserinfo(userInfo);
                                finish();
                            }
                        });
                    }else{
                        Map<String,String> params = new HashMap<>();
//                        params.put("token", SharedPreferencesUtil.getToken());
                        params.put("phone",phone.getText().toString());
                        params.put("code",yzm.getText().toString());
                        params.put("password",pwd.getText().toString());
                        HttpProxy.obtain().post(Contants.URL + Contants.RESET, params, new HttpCallback<FindPwdBean>() {
                            @Override
                            public void onFailure(String e) {

                            }

                            @Override
                            public void onSuccess(FindPwdBean bindUserBean) {
                                ToastUtil.toastLongMessage("设置成功");

                                finish();
                            }
                        });
                    }

                }
            }
        });






    }


    class TimeCount extends CountDownTimer {

        public TimeCount(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);
        }

        @Override
        public void onTick(long millisUntilFinished) {
            yzm_btn.setBackground(getResources().getDrawable(R.drawable.btn_yzm_noclick_bg));
            yzm_btn.setClickable(false);
            yzm_btn.setText("("+millisUntilFinished / 1000 +") 秒");
        }

        @Override
        public void onFinish() {
            yzm_btn.setText("获取验证码");
            yzm_btn.setClickable(true);
            yzm_btn.setBackground(getResources().getDrawable(R.drawable.btn_bg_getyzm));

        }
    }

}
