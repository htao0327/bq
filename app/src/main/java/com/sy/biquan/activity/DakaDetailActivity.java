package com.sy.biquan.activity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.sy.biquan.Contants;
import com.sy.biquan.MyApplication;
import com.sy.biquan.R;
import com.sy.biquan.adapter.DaKarDetailAdapter;
import com.sy.biquan.adapter.DakarOrderAdapter;
import com.sy.biquan.bean.DakaDetailBean;
import com.sy.biquan.bean.DakaOrderBean;
import com.sy.biquan.proxy.HttpCallback;
import com.sy.biquan.proxy.HttpProxy;
import com.sy.biquan.util.SharedPreferencesUtil;
import com.sy.biquan.viewutil.CircleImageView;

import java.util.HashMap;
import java.util.Map;

public class DakaDetailActivity extends AppCompatActivity {

    public static final String USER_ID = "id";
    private TextView name;//昵称
    private TextView slogan;//签名
    private TextView fans;//粉丝数
    private TextView jbCounts;//荐币数
    private TextView su1;//当前涨幅完成率
    private TextView su2;//平均推荐收益率
    private CircleImageView userImg;//用户头像



    private Button btnGz;//关注

    private RecyclerView c1;//当前荐币

    private RecyclerView c2;//历史荐币

    private String userID;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daka_detail);
        initView();
        LinearLayoutManager manager = new LinearLayoutManager(this);
        manager.setOrientation(LinearLayoutManager.HORIZONTAL);
        c1.setLayoutManager(manager);
        c2.setLayoutManager(new LinearLayoutManager(this));
        userID = getIntent().getStringExtra(USER_ID);
        getDakarDetailData();
        getDakarOrderData();
        btnGz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }

    private void initView(){
        name = findViewById(R.id.title);
        slogan = findViewById(R.id.message);
        fans = findViewById(R.id.tv_fans_counts);
        jbCounts = findViewById(R.id.tv_sy);
        su1 = findViewById(R.id.tv_);
        su2 = findViewById(R.id.tv_sr);
        userImg = findViewById(R.id.icon);
        btnGz = findViewById(R.id.btn_gz);
        c1 = findViewById(R.id.dqjb_recycler);
        c2 = findViewById(R.id.lsjb_recycler);
    }

    private void getDakarDetailData(){
        Map<String,String> params = new HashMap<>();
        params.put("token", SharedPreferencesUtil.getToken());
        params.put("userId",userID);
        Log.e("DakaDetailActivity","大咖详情userID:"+userID);
        HttpProxy.obtain().post(Contants.URL + Contants.DAKA_DETAIL, params, new HttpCallback<DakaDetailBean>() {
            @Override
            public void onFailure(String e) {
                Log.e("DakaDetailActivity","大咖详情onFailure:"+e);
            }

            @Override
            public void onSuccess(DakaDetailBean dakaDetailBean) {
                Log.e("DakaDetailActivity","大咖详情onSuccess");
                if(dakaDetailBean.getCode() == Contants.GET_DATA_SUCCESS) {
                    name.setText(dakaDetailBean.getData().getUserName());
                    slogan.setText(dakaDetailBean.getData().getSlogan());
                    fans.setText(dakaDetailBean.getData().getFansNum()+"");
                    jbCounts.setText(dakaDetailBean.getData().getJb_num()+"");
                    su1.setText(dakaDetailBean.getData().getExpectedSucRate()+"%");
                    su2.setText(dakaDetailBean.getData().getAvgIncomeRate()+"%");

                    Glide.with(MyApplication.instance())
                            .load(dakaDetailBean.getData().getUserAvatar())
                            .into(userImg);
                    DaKarDetailAdapter  adapter = new DaKarDetailAdapter(DakaDetailActivity.this,dakaDetailBean);
                    c1.setAdapter(adapter);

                }

            }
        });
    }
    private void getDakarOrderData(){
        Map<String,String> params = new HashMap<>();
        params.put("token", SharedPreferencesUtil.getToken());
        params.put("userId",userID);
        Log.e("DakaDetailActivity","历史荐币userID:"+userID);
        HttpProxy.obtain().post(Contants.URL + Contants.DAKA_ORDER, params, new HttpCallback<DakaOrderBean>() {
            @Override
            public void onFailure(String e) {
                Log.e("DakaDetailActivity","历史荐币onFailure:"+e);
            }

            @Override
            public void onSuccess(DakaOrderBean dakaOrderBean) {
                Log.e("DakaDetailActivity","历史荐币onSuccess");
                if(dakaOrderBean.getCode() == Contants.GET_DATA_SUCCESS){
                    c2.setAdapter(new DakarOrderAdapter(DakaDetailActivity.this,dakaOrderBean));
                }
            }
        });

    }



}
