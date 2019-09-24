package com.sy.biquan.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;
import com.sy.biquan.R;

import java.util.ArrayList;
import java.util.List;

/**
 * 交易
 */
public class JYActivity extends AppCompatActivity {

    private TabLayout tabLayout;
    private ViewPager viewPager;
    private List<String> mTabTitles = new ArrayList<>();
    private RelativeLayout rl_back;

    private Button dealReceived;//收到的交易 按钮
    private Button dealLaunch;//发起的交易 按钮
    private boolean isLaunch = true;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jy);
        initView();
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
    }

    private void initView(){
        dealLaunch = findViewById(R.id.btn_deal_launch);
        dealReceived = findViewById(R.id.btn_deal_receive);
    }


}
