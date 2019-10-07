package com.sy.biquan.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.sy.biquan.Contants;
import com.sy.biquan.R;
import com.sy.biquan.adapter.QdDetailAdapter;
import com.sy.biquan.bean.QdDetailBean;
import com.sy.biquan.proxy.HttpCallback;
import com.sy.biquan.proxy.HttpProxy;
import com.sy.biquan.util.SharedPreferencesUtil;

import java.util.HashMap;
import java.util.Map;

public class MyQdDetail extends AppCompatActivity {

    private Button left,right;
    private RelativeLayout rl_back;
    private RecyclerView rcy;
    private int type = 0;
    private QdDetailBean qdDetailBean1 = null;
    private QdDetailBean qdDetailBean2 = null;

    private QdDetailAdapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qd_detail);
        initView();
        getData(type);
        rcy.setLayoutManager(new LinearLayoutManager(this));
        rl_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        left.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                left.setBackground(getResources().getDrawable(R.drawable.btn_money_bg));
                left.setTextColor(getResources().getColor(R.color.white));
                right.setBackground(null);
                right.setTextColor(getResources().getColor(R.color.colorLoginTitle));
                type = 0;
                if(qdDetailBean1 != null){
                    adapter = new QdDetailAdapter(qdDetailBean1,MyQdDetail.this,type);
                    adapter.notifyDataSetChanged();
                    rcy.setAdapter(adapter);
                }else{
                    getData(type);
                }

            }
        });
        right.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                right.setBackground(getResources().getDrawable(R.drawable.btn_money_bg));
                right.setTextColor(getResources().getColor(R.color.white));
                left.setBackground(null);
                left.setTextColor(getResources().getColor(R.color.colorLoginTitle));
                type = 1;
                if(qdDetailBean2 != null){
                    adapter = new QdDetailAdapter(qdDetailBean2,MyQdDetail.this,type);
                    adapter.notifyDataSetChanged();
                    rcy.setAdapter(adapter);
                }else{
                    getData(type);
                }
            }
        });
    }

    private void initView(){
        left = findViewById(R.id.btn_send_money_luck);
        right = findViewById(R.id.btn_send_money_normal);
        rl_back = findViewById(R.id.rl_back);
        rcy = findViewById(R.id.rcy);

    }

    private void getData(final int mType){
        Map<String,String> params = new HashMap<>();
        params.put("token", SharedPreferencesUtil.getToken());
        params.put("type",String.valueOf(mType));
        params.put("pageNum","1");
        params.put("pageSize","30");
        HttpProxy.obtain().post(Contants.URL + Contants.QD_DETAIL, params, new HttpCallback<QdDetailBean>() {
            @Override
            public void onFailure(String e) {

            }

            @Override
            public void onSuccess(QdDetailBean qdDetailBean) {
                if(qdDetailBean.getCode() == Contants.GET_DATA_SUCCESS){
                    if(mType == 0){
                        qdDetailBean1 = qdDetailBean;
                        adapter = new QdDetailAdapter(qdDetailBean1,MyQdDetail.this,mType);
                        adapter.notifyDataSetChanged();
                        rcy.setAdapter(adapter);

                    }else if(mType == 1){
                        qdDetailBean2 = qdDetailBean;
                        adapter = new QdDetailAdapter(qdDetailBean2,MyQdDetail.this,mType);
                        adapter.notifyDataSetChanged();
                        rcy.setAdapter(adapter);
                    }
                }
            }
        });
    }
}
