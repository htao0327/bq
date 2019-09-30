package com.sy.biquan.activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.RelativeLayout;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.sy.biquan.Contants;
import com.sy.biquan.R;
import com.sy.biquan.adapter.MyWalletAdapter;
import com.sy.biquan.bean.MyWalletBean;
import com.sy.biquan.proxy.HttpCallback;
import com.sy.biquan.proxy.HttpProxy;
import com.sy.biquan.util.SharedPreferencesUtil;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyWalletActivity extends AppCompatActivity {

    private RelativeLayout rl_back;
    private RecyclerView mRecyclerView;
    private MyWalletAdapter adapter;
    private List<MyWalletBean.DataBean> dataBeans;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_wallet);
        initView();
        rl_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
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
                setRecyclerAdapter();
            }
        });
    }

    private void setRecyclerAdapter(){
        adapter = new MyWalletAdapter(MyWalletActivity.this,dataBeans);
        adapter.setOnItemClickListener(new MyWalletAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View v, int position) {
                startActivity(new Intent(MyWalletActivity.this,WalletAddress.class)
                        .putExtra(WalletAddress.NAME,dataBeans.get(position).getCurrencyEnglish())
                        .putExtra(WalletAddress.ADDRESS,dataBeans.get(position).getWalletAddress())
                        .putExtra(WalletAddress.ID,dataBeans.get(position).getId())
                        .putExtra(WalletAddress.IMG_UEL,dataBeans.get(position).getCurrencyLogo())
                );
            }
        });
        mRecyclerView.setLayoutManager(new LinearLayoutManager(MyWalletActivity.this));
        mRecyclerView.setAdapter(adapter);
    }

    private void initView(){
        rl_back = findViewById(R.id.rl_back);
        mRecyclerView = findViewById(R.id.rv_my_wallet);
    }
}
