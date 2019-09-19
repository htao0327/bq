package com.sy.biquan.activity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import com.sy.biquan.Contants;
import com.sy.biquan.R;
import com.sy.biquan.bean.LoginBean;
import com.sy.biquan.presenter.LoginPresenter;
import com.sy.biquan.proxy.HttpCallback;
import com.sy.biquan.proxy.HttpProxy;
import com.sy.biquan.util.SharedPreferencesUtil;
import com.sy.biquan.view.ILoginView;
import com.tencent.qcloud.tim.uikit.utils.SharedPreferenceUtils;
import com.tencent.qcloud.tim.uikit.utils.ToastUtil;

import java.util.HashMap;
import java.util.Map;

public class LoginActivity extends AppCompatActivity implements  View.OnClickListener {
    private EditText etPhone,etPwd;
    private ImageView ivClose;
    private Button btnLogin;
    private TextView tvForgetPwd,tvRegister;
//    private LoginPresenter mPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initView();
//        mPresenter = new LoginPresenter(this);
    }

    private void initView(){
        etPhone = findViewById(R.id.et_login_phone);
        etPwd = findViewById(R.id.et_login_pwd);
        ivClose = findViewById(R.id.iv_login_close);
        btnLogin = findViewById(R.id.btn_login);
        tvForgetPwd = findViewById(R.id.tv_login_forgot_pwd);
        tvRegister = findViewById(R.id.tv_login_register);

        btnLogin.setOnClickListener(this);
        tvForgetPwd.setOnClickListener(this);
        tvRegister.setOnClickListener(this);
        ivClose.setOnClickListener(this);
    }
//
//    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
//    @Override
//    public void onWindowFocusChanged(boolean hasFocus) {
//        super.onWindowFocusChanged(hasFocus);
//        if (hasFocus) {
//            View decorView = getWindow().getDecorView();
//            decorView.setSystemUiVisibility(
//                    View.SYSTEM_UI_FLAG_HIDE_NAVIGATION|View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
//        }
//    }
//
//    private void getData(){
//        HttpProxy.obtain().post();
//    }
    @Override
    public void onClick(View view) {
        if(view == btnLogin){
//            mPresenter.login();
            if(etPhone.getText()!=null && etPhone.getText().length() == 11 && etPwd.getText()!= null ){
                Map<String,String> params = new HashMap<>();
                params.put("phone",etPhone.getText().toString());
                params.put("password",etPwd.getText().toString());
                HttpProxy.obtain().post(Contants.URL + Contants.LOGIN, params, new HttpCallback<LoginBean>() {
                    @Override
                    public void onFailure(String e) {
                        Log.e("LoginActivity", "onFailure: " + e);

                    }

                    @Override
                    public void onSuccess(LoginBean loginBean) {
                        Log.e("LoginActivity", "Network result：" + loginBean.toString());
                        if(loginBean.getCode() == 200){//数据正常
//                            SharedPreferencesUtil.userInfoPutString(LoginActivity.this,"");

                        }else {//数据异常
//                    Log.e(TAG, "Network result：" + "连接服务器失败" );

                        }
                    }
                });
            }else {
                ToastUtil.toastLongMessage("请输入正确的手机号或密码");
            }
        }else if(view == tvForgetPwd){
//            mPresenter.goToFindPwd(LoginActivity.this);
        }else if(view == tvRegister){
//            mPresenter.goToRegister(LoginActivity.this);
            startActivity(new Intent(LoginActivity.this,RegisterActivity.class));
        }else if(view == ivClose){

            finish();
        }
    }
}
