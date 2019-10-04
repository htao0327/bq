package com.sy.biquan.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.sy.biquan.Contants;
import com.sy.biquan.R;
import com.sy.biquan.adapter.KTAdapter;
import com.sy.biquan.bean.KTListBean;
import com.sy.biquan.proxy.HttpCallback;
import com.sy.biquan.proxy.HttpProxy;
import com.sy.biquan.util.SharedPreferencesUtil;

import java.util.HashMap;
import java.util.Map;

public class KTActivity extends AppCompatActivity {

    private RelativeLayout rl_back;
    private RecyclerView mRecyclerView;
    private KTAdapter adapter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kt);
        initView();
        getData();
        rl_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    private void getData(){
        Map<String,String> params = new HashMap<>();
        params.put("token", SharedPreferencesUtil.getToken());
        params.put("pageNum","1");
        params.put("pageSize","10");
        HttpProxy.obtain().post(Contants.URL + Contants.KT_LIST, params, new HttpCallback<KTListBean>() {
            @Override
            public void onFailure(String e) {

            }

            @Override
            public void onSuccess(KTListBean ktListBean) {
                adapter = new KTAdapter(KTActivity.this,ktListBean);
                mRecyclerView.setLayoutManager(new LinearLayoutManager(KTActivity.this));
                mRecyclerView.setAdapter(adapter);
            }
        });
    }

    private void initView(){
        mRecyclerView = findViewById(R.id.rv);
        rl_back = findViewById(R.id.rl_back);
    }

}
