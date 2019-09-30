package com.sy.biquan.activity;

import android.os.Bundle;
import android.util.Log;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.sy.biquan.Contants;
import com.sy.biquan.R;
import com.sy.biquan.adapter.CheckDealInfoWalletAdapter;
import com.sy.biquan.bean.MyWalletBean;
import com.sy.biquan.proxy.HttpCallback;
import com.sy.biquan.proxy.HttpProxy;
import com.sy.biquan.util.SharedPreferencesUtil;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CheckDealInfoAddWalletActivity extends AppCompatActivity {

    private CheckDealInfoWalletAdapter adapter;
    private TextView title;
    private RelativeLayout rl_back;
    private RecyclerView mRecyclerView;
    private List<MyWalletBean.DataBean> dataBeans;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_wallet);
        initView();
        title.setText("选择公链");
    }

    private void initView(){
        title = findViewById(R.id.tv_title);
        rl_back = findViewById(R.id.rl_back);
        mRecyclerView = findViewById(R.id.rv_my_wallet);
    }

    @Override
    protected void onStart() {
        super.onStart();
        getWalletList();
    }

    private void getWalletList(){
        Map<String,String> params = new HashMap<>();
        params.put("token", SharedPreferencesUtil.getToken());
        HttpProxy.obtain().post(Contants.URL + Contants.MY_WALLET_LIST, params, new HttpCallback<MyWalletBean>() {
            @Override
            public void onFailure(String e) {
                Log.e("MyWalletActivity","onFailure"+e);
            }

            @Override
            public void onSuccess(MyWalletBean myWalletBean) {
                dataBeans = myWalletBean.getData();
                adapter = new CheckDealInfoWalletAdapter(CheckDealInfoAddWalletActivity.this,dataBeans);
                mRecyclerView.setLayoutManager(new LinearLayoutManager(CheckDealInfoAddWalletActivity.this));
                mRecyclerView.setAdapter(adapter);
            }
        });
    }

}
