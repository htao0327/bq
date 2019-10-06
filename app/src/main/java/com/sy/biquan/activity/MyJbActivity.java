package com.sy.biquan.activity;

import android.content.Intent;
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
import com.sy.biquan.adapter.MyJbAdapter;
import com.sy.biquan.bean.MyJb1Bean;
import com.sy.biquan.proxy.HttpCallback;
import com.sy.biquan.proxy.HttpProxy;
import com.sy.biquan.util.SharedPreferencesUtil;
import com.tencent.qcloud.tim.uikit.utils.ToastUtil;

import java.util.HashMap;
import java.util.Map;

public class MyJbActivity extends AppCompatActivity {

    private Button dealReceived;//我的发布
    private Button dealLaunch;//我的购买
    private Button gz;//我的关注
    private RecyclerView rcy;
    private RelativeLayout rlBack;


    private int btn = 1;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_jb);
        dealLaunch = findViewById(R.id.btn_deal_launch);
        dealReceived = findViewById(R.id.btn_deal_receive);
        rlBack = findViewById(R.id.rl_back);
        gz = findViewById(R.id.btn_deal_gz);
        rcy = findViewById(R.id.rcy);
        getData();
        rlBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        dealReceived.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(btn != 2){
                    dealLaunch.setBackground(null);
                    dealReceived.setBackground(getResources().getDrawable(R.drawable.jy_btn_selected_bg));
                    gz.setBackground(null);
                    btn = 2;
                    dealLaunch.setTextColor(getResources().getColor(R.color.colorLoginBtn));
                    gz.setTextColor(getResources().getColor(R.color.colorLoginBtn));
                    dealReceived.setTextColor(getResources().getColor(R.color.white));

                    Map<String,String> params = new HashMap<>();
                    params.put("token", SharedPreferencesUtil.getToken());
                    params.put("pageNum","1");
                    params.put("pageSize","20");
                    HttpProxy.obtain().post(Contants.URL + Contants.MY_JB_1, params, new HttpCallback<MyJb1Bean>() {
                        @Override
                        public void onFailure(String e) {

                        }

                        @Override
                        public void onSuccess(final MyJb1Bean myJb1Bean) {
                            if(myJb1Bean.getData() != null) {
                                rcy.setLayoutManager(new LinearLayoutManager(MyJbActivity.this));
                                MyJbAdapter adapter = new MyJbAdapter(MyJbActivity.this, myJb1Bean);

                                rcy.setAdapter(adapter);
                                adapter.setOnItemClickListener(new MyJbAdapter.OnItemClickListener() {
                                    @Override
                                    public void onItemClick(View v, int position) {
//                                startActivity(new Intent(MyJbActivity.this,JBDetailActivity.class)
//                                        .putExtra(JBDetailActivity.ORDER_ID,myJb1Bean.getData().get(position).getId()));
                                    }
                                });
                            }else{
                                ToastUtil.toastLongMessage("没有数据");
                            }
                        }
                    });
                }

            }
        });
        dealLaunch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(btn != 1){
                    gz.setBackground(null);
                    dealReceived.setBackground(null);
                    dealLaunch.setBackground(getResources().getDrawable(R.drawable.jy_btn_selected_bg));
                    btn = 1;
                    dealReceived.setTextColor(getResources().getColor(R.color.colorLoginBtn));
                    gz.setTextColor(getResources().getColor(R.color.colorLoginBtn));
                    dealLaunch.setTextColor(getResources().getColor(R.color.white));

                    Map<String,String> params = new HashMap<>();
                    params.put("token", SharedPreferencesUtil.getToken());
                    params.put("pageNum","1");
                    params.put("pageSize","20");
                    HttpProxy.obtain().post(Contants.URL + Contants.MY_JB_2, params, new HttpCallback<MyJb1Bean>() {
                        @Override
                        public void onFailure(String e) {

                        }

                        @Override
                        public void onSuccess(MyJb1Bean myJb1Bean) {
                            if(myJb1Bean.getData() != null) {
                                rcy.setLayoutManager(new LinearLayoutManager(MyJbActivity.this));
                                MyJbAdapter adapter = new MyJbAdapter(MyJbActivity.this, myJb1Bean);

                                rcy.setAdapter(adapter);
                                adapter.setOnItemClickListener(new MyJbAdapter.OnItemClickListener() {
                                    @Override
                                    public void onItemClick(View v, int position) {
//                                startActivity(new Intent(MyJbActivity.this,JBDetailActivity.class)
//                                        .putExtra(JBDetailActivity.ORDER_ID,myJb1Bean.getData().get(position).getId()));
                                    }
                                });
                            }else{
                                ToastUtil.toastLongMessage("没有数据");
                            }
                        }
                    });
                }

            }
        });

        gz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(btn != 3) {
                    btn = 3;
                    gz.setTextColor(getResources().getColor(R.color.white));
                    gz.setBackground(getResources().getDrawable(R.drawable.jy_btn_selected_bg));
                    dealReceived.setBackground(null);
                    dealLaunch.setBackground(null);
                    dealReceived.setTextColor(getResources().getColor(R.color.colorLoginBtn));
                    dealLaunch.setTextColor(getResources().getColor(R.color.colorLoginBtn));

//                    Map<String,String> params = new HashMap<>();
//                    params.put("token", SharedPreferencesUtil.getToken());
//                    params.put("pageNum","1");
//                    params.put("pageSize","20");
//                    HttpProxy.obtain().post(Contants.URL + Contants.MY_JB_3, params, new HttpCallback<MyJb1Bean>() {
//                        @Override
//                        public void onFailure(String e) {
//
//                        }
//
//                        @Override
//                        public void onSuccess(MyJb1Bean myJb1Bean) {
//                            if(myJb1Bean.getData() != null) {
//                                rcy.setLayoutManager(new LinearLayoutManager(MyJbActivity.this));
//                                MyJbAdapter adapter = new MyJbAdapter(MyJbActivity.this, myJb1Bean);
//
//                                rcy.setAdapter(adapter);
//                                adapter.setOnItemClickListener(new MyJbAdapter.OnItemClickListener() {
//                                    @Override
//                                    public void onItemClick(View v, int position) {
////                                startActivity(new Intent(MyJbActivity.this,JBDetailActivity.class)
////                                        .putExtra(JBDetailActivity.ORDER_ID,myJb1Bean.getData().get(position).getId()));
//                                    }
//                                });
//                            }else{
//                                ToastUtil.toastLongMessage("没有数据");
//                            }
//                        }
//                    });
                }

            }
        });
    }

    private void getData(){
        Map<String,String> params = new HashMap<>();
        params.put("token", SharedPreferencesUtil.getToken());
        params.put("pageNum","1");
        params.put("pageSize","20");
        HttpProxy.obtain().post(Contants.URL + Contants.MY_JB_1, params, new HttpCallback<MyJb1Bean>() {
            @Override
            public void onFailure(String e) {

            }

            @Override
            public void onSuccess(final MyJb1Bean myJb1Bean) {
                if(myJb1Bean.getData() != null) {
                    rcy.setLayoutManager(new LinearLayoutManager(MyJbActivity.this));
                    MyJbAdapter adapter = new MyJbAdapter(MyJbActivity.this, myJb1Bean);

                    rcy.setAdapter(adapter);
                    adapter.setOnItemClickListener(new MyJbAdapter.OnItemClickListener() {
                        @Override
                        public void onItemClick(View v, int position) {
//                                startActivity(new Intent(MyJbActivity.this,JBDetailActivity.class)
//                                        .putExtra(JBDetailActivity.ORDER_ID,myJb1Bean.getData().get(position).getId()));
                        }
                    });
                }else{
                    ToastUtil.toastLongMessage("没有数据");
                }
            }
        });
    }
}
