package com.sy.biquan.activity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.sy.biquan.Contants;
import com.sy.biquan.R;
import com.sy.biquan.adapter.XMDetailGroupListAdapter;
import com.sy.biquan.bean.XMDetailBean;
import com.sy.biquan.proxy.HttpCallback;
import com.sy.biquan.proxy.HttpProxy;
import com.sy.biquan.viewutil.CircleImageView;

import java.util.HashMap;
import java.util.Map;

public class XMDetail extends AppCompatActivity {

    public static final String PROJECT_ID = "project_id";
    public static final String PROJECT_NAME = "project_name";
    public static final String PROJECT_WEBSIT = "project_web";
    public static final String PROJECT_IMG = "project_img";
    public static final String PROJECT_DESC = "project_desc";
    public static final String PROJECT_GROUP_NUM = "project_group_num";

    private CircleImageView userImg;
    private TextView xmName,xmGw,xmAsGroup,xmDec;
    private RelativeLayout rlBack;
    private RecyclerView rv;
    private String project_id = "";//项目id
    private String project_name = "";//项目名称
    private String project_web = "";//项目网址
    private String project_img = "";//项目图片
    private String project_desc = "";//项目描述
    private int project_group_num = 0;//项目相关群数
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.xm_detail);
        initView();
        setData();
        getXMDetailGroupListData();
        rlBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
    private void setData(){
        project_id = getIntent().getStringExtra(PROJECT_ID);
        project_name = getIntent().getStringExtra(PROJECT_NAME);
        project_web = getIntent().getStringExtra(PROJECT_WEBSIT);
        project_img = getIntent().getStringExtra(PROJECT_IMG);
        project_desc = getIntent().getStringExtra(PROJECT_DESC);
        project_group_num = getIntent().getIntExtra(PROJECT_GROUP_NUM,0);
        Glide.with(XMDetail.this)
                .load(project_img)
                .into(userImg);
        xmAsGroup.setText("相关群聊：" + project_group_num + "个");
        xmName.setText(project_name);
        xmDec.setText(project_desc);
        xmGw.setText("官      网：" + project_web);
    }

    private void initView(){
        userImg = findViewById(R.id.civ_xm_img);
        xmName = findViewById(R.id.tv_xm_name);
        xmGw = findViewById(R.id.tv_xm_gw);
        xmAsGroup = findViewById(R.id.tv_xm_as_group);
        xmDec = findViewById(R.id.tv_xm_description);
        rv = findViewById(R.id.rv_group_list);
        rlBack = findViewById(R.id.rl_back);
    }

    private void getXMDetailGroupListData(){
        Map<String,String> params = new HashMap<>();
        Log.e("XMDetail","group_list_url:"+Contants.URL + Contants.XM_DETAIL_GROUP_LIST+"?projectId="+project_id+"&pageNum=1&pageSize=10");
        HttpProxy.obtain().post(Contants.URL + Contants.XM_DETAIL_GROUP_LIST+"?projectId="+project_id+"&pageNum=1&pageSize=10", params, new HttpCallback<XMDetailBean>() {
            @Override
            public void onFailure(String e) {

            }

            @Override
            public void onSuccess(XMDetailBean xmDetailBean) {
                if(xmDetailBean.getCode() == Contants.GET_DATA_SUCCESS) {
                    XMDetailGroupListAdapter adapter = new XMDetailGroupListAdapter(XMDetail.this,xmDetailBean);
                    rv.setLayoutManager(new LinearLayoutManager(XMDetail.this));
                    rv.setAdapter(adapter);
                }
            }
        });
    }

}
