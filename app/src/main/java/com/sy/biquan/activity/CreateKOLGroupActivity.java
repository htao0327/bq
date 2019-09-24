package com.sy.biquan.activity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.Gson;
import com.sy.biquan.Contants;
import com.sy.biquan.R;
import com.sy.biquan.bean.GetHasGroupCounts;
import com.sy.biquan.bean.RegisterBean;
import com.sy.biquan.proxy.HttpCallback;
import com.sy.biquan.proxy.HttpProxy;
import com.sy.biquan.util.SharedPreferencesUtil;

import java.util.HashMap;
import java.util.Map;

public class CreateKOLGroupActivity extends AppCompatActivity {

    private final String TAG = "CreateKOLGroupActivity";
    private EditText groupName;
    private EditText coinName;
    private Button btnCreate;
    private TextView hasGroupCounts;//剩余可创建群数量

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_kol_group);
        initView();
        getCounts();
    }

    private void initView(){
        groupName = findViewById(R.id.et_group_name);
        coinName = findViewById(R.id.et_coin_name);
        btnCreate = findViewById(R.id.btn_create_group);
        hasGroupCounts = findViewById(R.id.tv_counts);
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

}
