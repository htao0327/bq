package com.sy.biquan.activity;

import android.os.Bundle;
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

import com.sy.biquan.R;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {

    private RelativeLayout rlBack;
    private EditText etPhone,etPwd,etYzm;
    private Button btnGetYzm,btnNext;
    private TextView tvGoToLogin,tvProtocol;
    private String TAG = "RegisterActivity";

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

            }
        });
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

        rlBack.setOnClickListener(this);
        etPhone.setOnClickListener(this);
        etPwd.setOnClickListener(this);
        etYzm.setOnClickListener(this);
        btnGetYzm.setOnClickListener(this);
        btnNext.setOnClickListener(this);
        tvGoToLogin.setOnClickListener(this);
        tvProtocol.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(view == rlBack){
            finish();
        }else if(view == etPhone){

        }else if(view == etPwd){

        }else if(view == etYzm){

        }else if(view == btnGetYzm){

        }else if(view == btnNext){

        }else if(view == tvGoToLogin){

        }else if(view == tvProtocol){

        }
    }
}
