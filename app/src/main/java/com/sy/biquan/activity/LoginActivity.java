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

import com.google.gson.Gson;
import com.sy.biquan.Contants;
import com.sy.biquan.MainActivity;
import com.sy.biquan.R;
import com.sy.biquan.bean.LoginBean;
import com.sy.biquan.bean.RegisterBean;
import com.sy.biquan.bean.UserInfo;
import com.sy.biquan.presenter.LoginPresenter;
import com.sy.biquan.proxy.HttpCallback;
import com.sy.biquan.proxy.HttpProxy;
import com.sy.biquan.util.MD5;
import com.sy.biquan.util.SharedPreferencesUtil;
import com.sy.biquan.view.ILoginView;
import com.tencent.qcloud.tim.uikit.TUIKit;
import com.tencent.qcloud.tim.uikit.base.IUIKitCallBack;
import com.tencent.qcloud.tim.uikit.utils.SharedPreferenceUtils;
import com.tencent.qcloud.tim.uikit.utils.ToastUtil;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

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
            if(etPhone.getText()!=null && etPhone.getText().length() == 11 && etPwd.getText()!= null  ){
//                postDataWithParame();
                Map<String,String> params = new HashMap<>();
                params.put("phone",etPhone.getText().toString().trim());
                params.put("password", MD5.md5Password(etPwd.getText().toString().trim()));
                HttpProxy.obtain().post(Contants.URL + Contants.LOGIN, params, new HttpCallback<RegisterBean>() {
                    @Override
                    public void onFailure(String e) {
                        Log.e("LoginActivity", "onFailure: " + e);

                    }

                    @Override
                    public void onSuccess(RegisterBean registerBean) {

                        if (registerBean.getCode() == Contants.GET_DATA_SUCCESS) {
//                            Gson gson = new Gson();
//                            String jsonUserInfo = gson.toJson(registerBean);
//                            SharedPreferencesUtil.userInfoPutString(LoginActivity.this, Contants.USERINFO, jsonUserInfo);
                            SharedPreferencesUtil.setLoginUserInfo(registerBean);

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
                            startActivity(new Intent(LoginActivity.this, MainActivity.class));
                        } else {//显示错误信息
                            ToastUtil.toastLongMessage(registerBean.getMsg());
                        }
                    }
                });
            }
        }
        else if(view == tvForgetPwd){
//            mPresenter.goToFindPwd(LoginActivity.this);
        }else if(view == tvRegister){
//            mPresenter.goToRegister(LoginActivity.this);
            startActivity(new Intent(LoginActivity.this,RegisterActivity.class));
        }else if(view == ivClose){
            finish();
        }
    }



//    private void postDataWithParame() {
//        OkHttpClient client = new OkHttpClient();//创建OkHttpClient对象。
////        RequestBody body = FormBody.create(MediaType.parse("application/json"), requestMsg);
//        LoginBeanSend s = new LoginBeanSend();
//        s.setPassword(MD5.md5Password(etPwd.getText().toString().trim()));
//        s.setPhone(etPhone.getText().toString().trim());
//        MediaType MEDIA_TYPE_TEXT = MediaType.parse("application/json");
//        Gson gson = new Gson();
//        String st = gson.toJson(s);
////        FormBody.Builder formBody = new FormBody.Builder();//创建表单请求体
////        formBody.add("phone",etPhone.getText().toString().trim());//传递键值对参数
////        formBody.add("password",MD5.md5Password(etPwd.getText().toString().trim()));//传递键值对参数
//        Request request = new Request.Builder()//创建Request 对象。
//                .url(Contants.URL+Contants.LOGIN)
//                .post(RequestBody.create(MEDIA_TYPE_TEXT, st))//传递请求体
//                .build();
//        client.newCall(request).enqueue(new Callback() {
//            @Override
//            public void onFailure(Call call, IOException e) {
//                Log.e("LoginActivity", "onFailure: " + e);
//            }
//
//            @Override
//            public void onResponse(Call call, Response response) throws IOException {
//                String result = response.body().string();
//                Log.e("LoginActivity", "onResponse: " + result);
//            }
//        });//此处省略回调方法。
//    }

}
