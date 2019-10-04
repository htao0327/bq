package com.sy.biquan.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.sy.biquan.Contants;
import com.sy.biquan.R;
import com.sy.biquan.adapter.CFMMAdapter1;
import com.sy.biquan.adapter.KTAdapter;
import com.sy.biquan.adapter.XMAdapter;
import com.sy.biquan.bean.KTListBean;
import com.sy.biquan.bean.XMListBean;
import com.sy.biquan.proxy.HttpCallback;
import com.sy.biquan.proxy.HttpProxy;
import com.sy.biquan.util.SharedPreferencesUtil;

import java.util.HashMap;
import java.util.Map;

public class XMActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RelativeLayout rl_back;
    private XMAdapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xm);
        initView();
        getData();
//        adapter = new XMAdapter(this);
//        recyclerView.setLayoutManager(new LinearLayoutManager(this));
//        recyclerView.setAdapter(adapter);
        rl_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    private void initView(){
        recyclerView = findViewById(R.id.rv);
        rl_back = findViewById(R.id.rl_back);
    }


    private void getData(){
        Map<String,String> params = new HashMap<>();
//        params.put("token", SharedPreferencesUtil.getToken());
        params.put("pageNum","1");
        params.put("pageSize","10");
        HttpProxy.obtain().get(Contants.URL + Contants.XM_LIST+"?pageNum=1&pageSize=10", params, new HttpCallback<XMListBean>() {
            @Override
            public void onFailure(String e) {

            }

            @Override
            public void onSuccess(final XMListBean xmListBean) {
                adapter = new XMAdapter(XMActivity.this,xmListBean);
                adapter.setOnItemClickListener(new XMAdapter.OnRecyclerViewItemClickListener() {
                    @Override
                    public void onClick(View view, XMAdapter.ViewName viewName, int position) {
                        startActivity(new Intent(XMActivity.this,XMDetail.class)
                                .putExtra(XMDetail.PROJECT_ID,xmListBean.getData().get(position).getProjectId())
                                .putExtra(XMDetail.PROJECT_NAME,xmListBean.getData().get(position).getProjectName())
                                .putExtra(XMDetail.PROJECT_IMG,xmListBean.getData().get(position).getProjectImg())
                                .putExtra(XMDetail.PROJECT_GROUP_NUM,xmListBean.getData().get(position).getGroups())
                                .putExtra(XMDetail.PROJECT_DESC,xmListBean.getData().get(position).getProjectDesc())
                                .putExtra(XMDetail.PROJECT_WEBSIT,xmListBean.getData().get(position).getWebSite())
                        );
                    }

                });
                recyclerView.setLayoutManager(new LinearLayoutManager(XMActivity.this));
                recyclerView.setAdapter(adapter);
            }
        });
    }


}
