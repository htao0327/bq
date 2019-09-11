package com.sy.biquan.activity;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import com.sy.biquan.R;
import com.sy.biquan.presenter.LoginPresenter;
import com.sy.biquan.view.ILoginView;

public class LoginActivity extends AppCompatActivity implements ILoginView , View.OnClickListener {
    private EditText etPhone,etPwd;
    private ImageView ivClose;
    private Button btnLogin;
    private TextView tvForgetPwd,tvRegister;
    private LoginPresenter mPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initView();
        mPresenter = new LoginPresenter(this);
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

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if (hasFocus) {
            View decorView = getWindow().getDecorView();
            decorView.setSystemUiVisibility(
                    View.SYSTEM_UI_FLAG_HIDE_NAVIGATION|View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
        }
    }

    @Override
    public String getAccount() {
        return etPhone.getText().toString();
    }

    @Override
    public String getPassword() {
        return etPwd.getText().toString();
    }

    @Override
    public void onLoginSuccess() {
        Toast.makeText(this,"登陆成功",Toast.LENGTH_LONG).show();
    }

    @Override
    public void onLoginFails() {
        Toast.makeText(this,"登陆失败",Toast.LENGTH_LONG).show();
    }

    @Override
    public void onClick(View view) {
        if(view == btnLogin){
            mPresenter.login();
        }else if(view == tvForgetPwd){
            mPresenter.goToFindPwd(LoginActivity.this);
        }else if(view == tvRegister){
            mPresenter.goToRegister(LoginActivity.this);
        }else if(view == ivClose){
//            DialogUtil.showLoginAlertDialog(this, 0, "取消后发布采购将中断，","是否确认取消？", null, "是", "否", false, new DialogUtil.AlertDialogBtnClickListener() {
//                @Override
//                public void clickPositive() {
//                    finish();
//                }
//
//                @Override
//                public void clickNegative() {
//
//                }
//            });
            finish();
        }
    }
}
