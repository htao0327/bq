package com.sy.biquan.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.Gson;
import com.sy.biquan.Contants;
import com.sy.biquan.MyApplication;
import com.sy.biquan.R;
import com.sy.biquan.bean.AddWalletBean;
import com.sy.biquan.bean.MineDataBean;
import com.sy.biquan.bean.UserInfo;
import com.sy.biquan.proxy.HttpCallback;
import com.sy.biquan.proxy.HttpProxy;
import com.sy.biquan.util.SharedPreferencesUtil;
import com.tencent.qcloud.tim.uikit.utils.ToastUtil;

import java.util.HashMap;
import java.util.Map;

public class NameSetActivity extends AppCompatActivity {

    private Button btnCommit;
    private EditText etName;
    private RelativeLayout rl_back;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_name);
        btnCommit = findViewById(R.id.btn_commit);
        etName = findViewById(R.id.et_name);
        rl_back = findViewById(R.id.rl_back);
        rl_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        btnCommit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!"".equals(etName.getText().toString().trim())){

                    Map<String,String> map = new HashMap<>();
                    map.put("token", SharedPreferencesUtil.getToken());
                    map.put("userAlias",etName.getText().toString().trim());
                    map.put("slogan","");
                    HttpProxy.obtain().post(Contants.URL + Contants.SET_NAME, map, new HttpCallback<AddWalletBean>() {
                        @Override
                        public void onFailure(String e) {

                        }

                        @Override
                        public void onSuccess(AddWalletBean addWalletBean) {
                            if(addWalletBean.getCode() == Contants.GET_DATA_SUCCESS){
                                UserInfo userInfo = SharedPreferencesUtil.newGetUserInfo();
                                userInfo.setUserAlias(etName.getText().toString().trim());
                                Gson gson = new Gson();
                                String jsonUserInfo = gson.toJson(userInfo);
                                SharedPreferencesUtil.userInfoPutString(MyApplication.instance(),Contants.USERINFO,jsonUserInfo);
                                ToastUtil.toastLongMessage("修改完成");
                                finish();
                            }
                        }
                    });
                }
            }
        });
    }
}
