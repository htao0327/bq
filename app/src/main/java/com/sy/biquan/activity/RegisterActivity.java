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

import com.sy.biquan.Contants;
import com.sy.biquan.R;
import com.sy.biquan.bean.RegisterBean;
import com.sy.biquan.proxy.HttpCallback;
import com.sy.biquan.proxy.HttpProxy;

import java.util.HashMap;
import java.util.Map;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {

    private RelativeLayout rlBack;
    private EditText etPhone,etPwd,etYzm,etYqm;
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

    @Override
    public void onClick(View view) {
        if(view == rlBack){
            finish();
        }else if(view == etPhone){

        }else if(view == etPwd){

        }else if(view == etYzm){

        }else if(view == btnGetYzm){

        }else if(view == btnNext){
            Map<String,String> params = new HashMap<>();
            params.put("phone",etPhone.getText().toString());
            params.put("password",etPwd.getText().toString());
            params.put("code",etYzm.getText().toString());
            params.put("inviteCode",etYqm.getText().toString());

            HttpProxy.obtain().post(Contants.URL + Contants.REGISTER, params, new HttpCallback<RegisterBean>() {
                @Override
                public void onFailure(String e) {
                    Log.e(TAG, "onFailure: " + e);
                }

                @Override
                public void onSuccess(RegisterBean registerBean) {
                    Log.e(TAG, "Network result：" + registerBean.toString());
                }
            });
        }else if(view == tvGoToLogin){

        }else if(view == tvProtocol){

        }
    }

    private boolean checkRegisterBtn(){
        if(etPhone.getText() != null && etPhone.getText().length()==11 &&etPwd.getText()!=null && etPwd.getText().length()>6&&etYzm.getText()!=null&&etYzm.getText().length()==6){
            return true;
        }else {
            return false;
        }
    }
}
