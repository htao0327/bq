package com.sy.biquan.activity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.sy.biquan.Contants;
import com.sy.biquan.R;
import com.sy.biquan.bean.LaunchDealBean;
import com.sy.biquan.proxy.HttpCallback;
import com.sy.biquan.proxy.HttpProxy;
import com.sy.biquan.util.SharedPreferencesUtil;

import org.greenrobot.eventbus.EventBus;

import java.util.HashMap;
import java.util.Map;

public class LaunchDealActivity extends AppCompatActivity {

    private Button commit;
    private EditText remarks;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launch_deal);
        initView();

        commit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Map<String,String> params = new HashMap<>();
                params.put("token", SharedPreferencesUtil.getToken());
                params.put("currency_id", "1176733021449666561");
                params.put("currency_name", "XDD");
                params.put("address", "0xf3dbB77AE2894a39e3d2EdD8Aa53314C348DA5E3");
                params.put("transaction_number", "888");
                params.put("transaction_usdt", "699");
                params.put("eth_address", "0xf3dbB77AE2894a39e3d2EdD8Aa53314C348DA5E3");
                params.put("operate_address", "0xf3dbB77AE2894a39e3d2EdD8Aa53314C348DA5E3");
                params.put("remarks", remarks.getText().toString());
                params.put("user_im_code", "a340849523a247ada3cfffcb08304f7d");
                HttpProxy.obtain().post(Contants.URL + Contants.DEAL_LAUNCH, params, new HttpCallback<LaunchDealBean>() {
                    @Override
                    public void onFailure(String e) {
                        Log.e("LaunchDealActivity","onFailure"+e);
                    }

                    @Override
                    public void onSuccess(LaunchDealBean launchDealBean) {
                        Log.e("LaunchDealActivity","onSuccess--code:"+launchDealBean.getCode());
//                        EventBus.getDefault().post(customMessageData);
                    }
                });


            }
        });
    }

    private void initView(){
        commit = findViewById(R.id.btn_commit);
        remarks = findViewById(R.id.et_remarks);

    }





}
