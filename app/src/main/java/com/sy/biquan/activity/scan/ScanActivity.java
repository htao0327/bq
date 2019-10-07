package com.sy.biquan.activity.scan;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentTransaction;

import com.sy.biquan.R;

public class ScanActivity extends AppCompatActivity {

    Toolbar mToolbar;
    AppCompatTextView mToolbarTitle;
    private ScanFragment mScanFragment;

    //设置Toolbar标题
    protected void setToolBar(Toolbar toolBar, TextView tv, CharSequence title) {
        setSupportActionBar(toolBar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar == null) return;
        actionBar.setDisplayShowTitleEnabled(false);
        toolBar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        if (tv != null) tv.setText(title);

    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_base_activity);
        mToolbar = findViewById(R.id.toolbar);
        mToolbarTitle = findViewById(R.id.toolbar_title);

        setToolBar(mToolbar, mToolbarTitle, "扫一扫");

        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.add(R.id.base_container, mScanFragment = ScanFragment.getInstance());
        ft.commitNowAllowingStateLoss();
    }

}
