package com.sy.biquan.activity;

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

import org.greenrobot.eventbus.EventBus;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AddGLianActivity extends AppCompatActivity {

    private RelativeLayout rl_back;
    private RecyclerView mRecyclerView;
    private MyWalletAdapter adapter;
    private List<MyWalletBean.DataBean> dataBeans;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_glian);
        initView();

        getWalletList();
        rl_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    private void getWalletList(){
        Map<String,String> params = new HashMap<>();
        params.put("token", SharedPreferencesUtil.getToken());
        HttpProxy.obtain().post(Contants.URL + Contants.MY_WALLET_LIST, params, new HttpCallback<MyWalletBean>() {
            @Override
            public void onFailure(String e) {
                Log.e("AddGLianActivity","onFailure"+e);
            }

            @Override
            public void onSuccess(MyWalletBean myWalletBean) {
                dataBeans = myWalletBean.getData();
                setRecyclerAdapter();
            }
        });
    }

    private void setRecyclerAdapter(){
        adapter = new MyWalletAdapter(AddGLianActivity.this,dataBeans);
        adapter.setOnItemClickListener(new MyWalletAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View v, int position) {
                EventBus.getDefault().post(dataBeans.get(position));
                finish();
            }
        });
        mRecyclerView.setLayoutManager(new LinearLayoutManager(AddGLianActivity.this));
        mRecyclerView.setAdapter(adapter);
    }

    private void initView(){
        rl_back = findViewById(R.id.rl_back);
        mRecyclerView = findViewById(R.id.rv_my_wallet);
    }

}
