package com.sy.biquan.activity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.Gson;
import com.sy.biquan.Contants;
import com.sy.biquan.MainActivity;
import com.sy.biquan.R;
import com.sy.biquan.bean.RegisterBean;
import com.sy.biquan.proxy.HttpCallback;
import com.sy.biquan.proxy.HttpProxy;
import com.sy.biquan.util.MD5;
import com.sy.biquan.util.SharedPreferencesUtil;
import com.tencent.qcloud.tim.uikit.TUIKit;
import com.tencent.qcloud.tim.uikit.base.IUIKitCallBack;
import com.tencent.qcloud.tim.uikit.utils.ToastUtil;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {

    private RelativeLayout rlBack;
    private EditText etPhone,etPwd,etYzm,etYqm;
    private Button btnGetYzm,btnNext;
    private TextView tvGoToLogin,tvProtocol;
    private String TAG = "RegisterActivity";
    private TimeCount time;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        initView();

        etPwd.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if(checkRegisterBtn()){
                    btnNext.setBackground(getResources().getDrawable(R.drawable.btn_bg_register_next_click));
                    btnNext.setEnabled(true);
                }else {
                    btnNext.setBackground(getResources().getDrawable(R.drawable.btn_bg_register_next_noclick));
                    btnNext.setEnabled(false);
                }
            }
        });
        etYzm.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if(checkRegisterBtn()){
                    btnNext.setBackground(getResources().getDrawable(R.drawable.btn_bg_register_next_click));
                    btnNext.setEnabled(true);
                }else {
                    btnNext.setBackground(getResources().getDrawable(R.drawable.btn_bg_register_next_noclick));
                    btnNext.setEnabled(false);
                }
            }
        });
        etPhone.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if(checkRegisterBtn()){
                    btnNext.setBackground(getResources().getDrawable(R.drawable.btn_bg_register_next_click));
                    btnNext.setEnabled(true);
                }else {
                    btnNext.setBackground(getResources().getDrawable(R.drawable.btn_bg_register_next_noclick));
                    btnNext.setEnabled(false);
                }
            }
        });

        time = new TimeCount(60000, 1000);
    }

    private void initView(){
        rlBack = findViewById(R.id.rl_register_back);
        etPhone = findViewById(R.id.et_register_phone);
        etPwd = findViewById(R.id.et_register_pwd);
        etYzm = findViewById(R.id.et_register_yzm);
        btnGetYzm = findViewById(R.id.btn_register_get_yzm);
        btnNext = findViewById(R.id.btn_register_next);
        tvGoToLogin = findViewById(R.id.tv_register_go_login);
        tvProtocol = findViewById(R.id.tv_register_protocol);
        etYqm = findViewById(R.id.et_register_yqm);

        rlBack.setOnClickListener(this);
        etPhone.setOnClickListener(this);
        etPwd.setOnClickListener(this);
        etYzm.setOnClickListener(this);
        btnGetYzm.setOnClickListener(this);
        btnNext.setOnClickListener(this);
        tvGoToLogin.setOnClickListener(this);
        tvProtocol.setOnClickListener(this);
    }

    private boolean checkPhone(){
        if(etPhone.getText()!=null && etPhone.getText().length() == 11){
            return true;
        }else {
            return false;
        }
    }

    @Override
    public void onClick(View view) {
        if(view == rlBack){
            finish();
        }else if(view == etPhone){

        }else if(view == etPwd){

        }else if(view == etYzm){

        }else if(view == btnGetYzm){
            if(checkPhone()){
                time.start();
                Map<String,String> params = new HashMap<>();
//                params.put("phone",etPhone.getText().toString().trim());
//                params.put("captchaType",Contants.GET_YZM_REGISTER);

                HttpProxy.obtain().get(Contants.URL + Contants.GETYZM+"?phone="+etPhone.getText().toString().trim()+"&captchaType="+Contants.GET_YZM_REGISTER, params, new HttpCallback<RegisterBean>() {
                    @Override
                    public void onFailure(String e) {
                        Log.e(TAG, "onFailure: " + e);
                    }

                    @Override
                    public void onSuccess(RegisterBean registerBean) {
                        Log.e(TAG, "Network result：" + registerBean.toString());
//                        if(registerBean.getCode() == Contants.GET_DATA_SUCCESS){

//                        }else {//显示错误信息
                            ToastUtil.toastLongMessage(registerBean.getMsg());
//                        }
                    }
                });
            }else {
                ToastUtil.toastLongMessage("手机号码错误");
            }

        }else if(view == btnNext){
            if(checkPhone()){
                Map<String,String> params = new HashMap<>();
                params.put("phone",etPhone.getText().toString());
                params.put("password",MD5.md5Password(etPwd.getText().toString()));
                params.put("code",etYzm.getText().toString());
                params.put("inviteCode",etYqm.getText().toString());

                HttpProxy.obtain().post(Contants.URL + Contants.REGISTER, params, new HttpCallback<RegisterBean>() {
                    @Override
                    public void onFailure(String e) {
                        Log.e(TAG, "onFailure: " + e);
                    }

                    @Override
                    public void onSuccess(RegisterBean registerBean) {

                        if(registerBean.getCode() == Contants.GET_DATA_SUCCESS){
                            Gson gson = new Gson();
                            String jsonUserInfo = gson.toJson(registerBean);
                            SharedPreferencesUtil.userInfoPutString(RegisterActivity.this,Contants.USERINFO,jsonUserInfo);
                            TUIKit.login(registerBean.getData().getUserImCode(), registerBean.getData().getUserSig(), new IUIKitCallBack() {
                                @Override
                                public void onError(String module, final int code, final String desc) {
                                    runOnUiThread(new Runnable() {
                                        public void run() {
                                            ToastUtil.toastLongMessage("登录失败, errCode = " + code + ", errInfo = " + desc);
                                        }
                                    });
                                }

                                @Override
                                public void onSuccess(Object data) {

                                }
                            });
                            startActivity(new Intent(RegisterActivity.this, MainActivity.class));
                        }else {//显示错误信息
                            ToastUtil.toastLongMessage(registerBean.getMsg());
                        }

                    }
                });
            }else {
                ToastUtil.toastLongMessage("手机号码错误");
            }

        }else if(view == tvGoToLogin){

        }else if(view == tvProtocol){

        }
    }

    private boolean checkRegisterBtn(){
        if(etPhone.getText() != null && etPhone.getText().length()==11 &&etPwd.getText()!=null && etPwd.getText().length()>=6&&etYzm.getText()!=null&&etYzm.getText().length()>=4){
            return true;
        }else {
            return false;
        }
    }

    class TimeCount extends CountDownTimer {

        public TimeCount(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);
        }

        @Override
        public void onTick(long millisUntilFinished) {
            btnGetYzm.setBackground(getResources().getDrawable(R.drawable.btn_yzm_noclick_bg));
            btnGetYzm.setClickable(false);
            btnGetYzm.setText("("+millisUntilFinished / 1000 +") 秒");
        }

        @Override
        public void onFinish() {
            btnGetYzm.setText("获取验证码");
            btnGetYzm.setClickable(true);
            btnGetYzm.setBackground(getResources().getDrawable(R.drawable.btn_bg_getyzm));

        }
    }


}
