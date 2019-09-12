package com.sy.biquan.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;
import com.sy.biquan.R;
import com.sy.biquan.adapter.JBAdapter;
import com.sy.biquan.viewutil.TabLayoutUtil;
import com.tencent.qcloud.tim.uikit.base.BaseFragment;

import java.util.ArrayList;
import java.util.List;

public class JBActivity extends AppCompatActivity {

    private TabLayout tabLayout;
    private ViewPager viewPager;
    private List<String> mTabTitles = new ArrayList<>();
    private RelativeLayout rl_back;

    private List<BaseFragment> mFragments = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jb);
        initView();
        mTabTitles.add("全新");
        mTabTitles.add("最新");
        mTabTitles.add("最热");
        mTabTitles.add("当前涨幅");
        mTabTitles.add("预期涨幅");
        viewPager.setAdapter(new JBAdapter(getSupportFragmentManager(),mFragments,mTabTitles));
        TabLayoutUtil.setTabLayoutIndicator(tabLayout);
        tabLayout.setupWithViewPager(viewPager);

        rl_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
    private void initView(){
        tabLayout = findViewById(R.id.tab_layout);
        viewPager = findViewById(R.id.title_view_pager);
        rl_back = findViewById(R.id.rl_back);
    }
}
