package com.sy.biquan.activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.sy.biquan.Contants;
import com.sy.biquan.MyApplication;
import com.sy.biquan.R;
import com.sy.biquan.adapter.CFMMAdapter1;
import com.sy.biquan.adapter.CFMMAdapter2;
import com.sy.biquan.adapter.JBAdapter;
import com.sy.biquan.adapter.JBFragmentAdapter;
import com.sy.biquan.bean.AddWalletBean;
import com.sy.biquan.bean.MainListData;
import com.sy.biquan.bean.TopBean;
import com.sy.biquan.proxy.HttpCallback;
import com.sy.biquan.proxy.HttpProxy;
import com.sy.biquan.util.SharedPreferencesUtil;
import com.sy.biquan.viewutil.DialogUtil;
import com.tencent.qcloud.tim.uikit.utils.ToastUtil;

import java.util.HashMap;
import java.util.Map;

public class CFMMActivity extends AppCompatActivity {

    private RecyclerView dfbRecycler,dktjRecycler;
    private RelativeLayout rlBack;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cfmm);
        initView();
        getTopData();
        getJbListData();
        LinearLayoutManager manager = new LinearLayoutManager(this);
        manager.setOrientation(LinearLayoutManager.HORIZONTAL);
        dfbRecycler.setLayoutManager(manager);

        dktjRecycler.setLayoutManager(new LinearLayoutManager(this));
//        dktjRecycler.setAdapter(new CFMMAdapter2());

        rlBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    private void getTopData(){
        Map<String,String> params = new HashMap<>();
        params.put("token", SharedPreferencesUtil.getToken());
        HttpProxy.obtain().post(Contants.URL + Contants.HOME_TOP, params, new HttpCallback<TopBean>() {
            @Override
            public void onFailure(String e) {
                Log.e("CFMMActivity","onFailure"+e);
            }

            @Override
            public void onSuccess(final TopBean topBean) {
                if(topBean.getCode() == Contants.GET_DATA_SUCCESS) {

                    final CFMMAdapter1 adapter1 = new CFMMAdapter1(CFMMActivity.this, topBean);
                    adapter1.setOnItemClickListener(new CFMMAdapter1.OnItemClickListener() {
                        @Override
                        public void onItemClick(View v, final int position) {
                            Log.e("CFMMActivity","----onItemClickBtn----"+v.getId());
                            if(v.getId() == R.id.btn_gz){//点击关注

                                Log.e("CFMMActivity","----onItemClickBtn----");
                                Map<String,String> params = new HashMap<>();
                                params.put("token",SharedPreferencesUtil.getToken());
                                params.put("followerId",topBean.getData().get(position).getUserID());
                                if(topBean.getData().get(position).getIsFollow() == 1){//已关注
                                    HttpProxy.obtain().post(Contants.URL + Contants.UNFOLLOW, params, new HttpCallback<AddWalletBean>() {
                                        @Override
                                        public void onFailure(String e) {
                                            ToastUtil.toastLongMessage("取关失败");
                                        }

                                        @Override
                                        public void onSuccess(AddWalletBean addWalletBean) {
                                            ToastUtil.toastLongMessage("取关成功");
                                            topBean.getData().get(position).setIsFollow(0);
                                            adapter1.notifyItemChanged(position);

                                        }
                                    });
                                }else{//未关注

                                    HttpProxy.obtain().post(Contants.URL + Contants.FOLLOW, params, new HttpCallback<AddWalletBean>() {
                                        @Override
                                        public void onFailure(String e) {
                                            ToastUtil.toastLongMessage("关注失败");
                                        }

                                        @Override
                                        public void onSuccess(AddWalletBean addWalletBean) {
                                            topBean.getData().get(position).setIsFollow(1);
                                            ToastUtil.toastLongMessage("关注成功");
                                            adapter1.notifyItemChanged(position);
                                        }
                                    });
                                }

                            }else{
                                DialogUtil.showPersonAlertDialog(CFMMActivity.this, topBean.getData().get(position).getAvatar(),
                                        topBean.getData().get(position).getAlias(), "", topBean.getData().get(position).getSlogan(),
                                        topBean.getData().get(position).getFansNum()+"", topBean.getData().get(position).getSuccessRate()+"%",
                                        topBean.getData().get(position).getIncome()+"",
                                        "主页", "关注", true, new DialogUtil.AlertDialogBtnClickListener() {
                                            @Override
                                            public void clickPositive() {
                                                startActivity(new Intent(CFMMActivity.this,DakaDetailActivity.class)
                                                        .putExtra(DakaDetailActivity.USER_ID,topBean.getData().get(position).getUserID()));
                                            }

                                            @Override
                                            public void clickNegative() {

                                            }
                                        });
                            }

                        }
                    });
                    dfbRecycler.setAdapter(adapter1);
                }
            }
        });
    }

    private void getJbListData(){
        Map<String,String> params = new HashMap<>();
        params.put("token", SharedPreferencesUtil.getToken());
        params.put("pageNum", "1");
        params.put("pageSize", "10");
        HttpProxy.obtain().post(Contants.URL + Contants.KOL_ORDER, params, new HttpCallback<MainListData>() {
            @Override
            public void onFailure(String e) {
                Log.e("CFMMActivity","onFailure"+e);
            }

            @Override
            public void onSuccess(final MainListData mainListData) {
                if(mainListData.getCode() == Contants.GET_DATA_SUCCESS) {
                    JBFragmentAdapter adapter = new JBFragmentAdapter(CFMMActivity.this,mainListData);
                    dktjRecycler.setAdapter(adapter);
                    adapter.setOnItemClickListener(new JBFragmentAdapter.OnItemClickListener() {
                        @Override
                        public void onItemClick(View v, int position) {
                            startActivity(new Intent(CFMMActivity.this,JBDetailActivity.class)
                                    .putExtra(JBDetailActivity.ORDER_ID,mainListData.getData().get(position).getId()));

                        }
                    });
                }
            }
        });
    }

    private void initView(){
        dfbRecycler = findViewById(R.id.dfb_recycler);
        dktjRecycler = findViewById(R.id.dktj_recycler);
        rlBack = findViewById(R.id.rl_back);

    }
}
