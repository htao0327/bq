package com.sy.biquan.activity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;
import com.sy.biquan.Contants;
import com.sy.biquan.R;
import com.sy.biquan.adapter.JBAdapter;
import com.sy.biquan.bean.MyDealListBean;
import com.sy.biquan.proxy.HttpCallback;
import com.sy.biquan.proxy.HttpProxy;
import com.sy.biquan.util.SharedPreferencesUtil;
import com.sy.biquan.view.fragment.JYAllFragment;
import com.sy.biquan.view.fragment.JYFragment;
import com.sy.biquan.view.fragment.JYFragment2;
import com.sy.biquan.view.fragment.JYFragment3;
import com.sy.biquan.view.fragment.JYFragment4;
import com.sy.biquan.viewutil.TabLayoutUtil;
import com.sy.biquan.viewutil.ViewPagerForScrollView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 交易
 */
public class JYActivity extends AppCompatActivity {

    private TabLayout tabLayout;
    private ViewPagerForScrollView viewPager;
    private RelativeLayout rl_back;

    private Button dealReceived;//收到的交易 按钮
    private Button dealLaunch;//发起的交易 按钮
    private boolean isLaunch = true;
    private List<String> mTabTitles = new ArrayList(){};//{"全部","待确认","待支付","待打币","待收币"}
    private List<Fragment> mFragments = new ArrayList<>();
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jy);
        initView();
        mTabTitles.add("全新");
        mTabTitles.add("待确认");
        mTabTitles.add("待支付");
        mTabTitles.add("待打币");
        mTabTitles.add("待收币");
        Fragment fragment = new JYAllFragment();
        Fragment fragment1 = new JYFragment();
        Fragment fragment2 = new JYFragment2();
        Fragment fragment3 = new JYFragment3();
        Fragment fragment4 = new JYFragment4();

        mFragments.add(fragment);
        mFragments.add(fragment1);
        mFragments.add(fragment2);
        mFragments.add(fragment3);
        mFragments.add(fragment4);
        viewPager.setAdapter(new JBAdapter(JYActivity.this.getSupportFragmentManager(),mFragments,mTabTitles));
        TabLayoutUtil.setTabLayoutIndicator(tabLayout);
        tabLayout.setupWithViewPager(viewPager);
        rl_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        dealReceived.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isLaunch){
                    dealLaunch.setBackground(null);
                    dealReceived.setBackground(getResources().getDrawable(R.drawable.jy_btn_selected_bg));
                    isLaunch = false;
                    dealLaunch.setTextColor(getResources().getColor(R.color.colorLoginBtn));
                    dealReceived.setTextColor(getResources().getColor(R.color.white));
                }
            }
        });
        dealLaunch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!isLaunch){
                    dealReceived.setBackground(null);
                    dealLaunch.setBackground(getResources().getDrawable(R.drawable.jy_btn_selected_bg));
                    isLaunch = true;
                    dealReceived.setTextColor(getResources().getColor(R.color.colorLoginBtn));
                    dealLaunch.setTextColor(getResources().getColor(R.color.white));
                }
            }
        });
        getDealList();
    }

    private void initView(){
        rl_back = findViewById(R.id.rl_back);
        tabLayout = findViewById(R.id.tab_layout);
        viewPager = findViewById(R.id.vp_deal);
        dealLaunch = findViewById(R.id.btn_deal_launch);
        dealReceived = findViewById(R.id.btn_deal_receive);
    }

    private void getDealList(){
        Map<String,String> params = new HashMap<>();
        params.put("token", SharedPreferencesUtil.getToken());
        params.put("page","1");
        params.put("limit","10");
        params.put("type","9");
        params.put("transcation_type","1");
        HttpProxy.obtain().post(Contants.URL + Contants.MY_DEAL_LIST, params, new HttpCallback<MyDealListBean>() {
            @Override
            public void onFailure(String e) {
                Log.e("JYActivity","onFailure"+e);
            }

            @Override
            public void onSuccess(MyDealListBean myDealListBean) {
                Log.e("JYActivity","onSuccess"+myDealListBean.toString());
            }
        });
    }
}



