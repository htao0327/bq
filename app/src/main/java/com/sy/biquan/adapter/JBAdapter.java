package com.sy.biquan.adapter;

import android.os.Bundle;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.sy.biquan.view.fragment.JBFragment;
import com.tencent.qcloud.tim.uikit.base.BaseFragment;

import java.util.List;

public class JBAdapter extends FragmentPagerAdapter {
    private List<String> mTabTitles ;
    private static final int FRAGMENT_COUNT = 5;

    public JBAdapter(FragmentManager fragmentManager, List<BaseFragment> fragments, List<String> tabTitles) {
        super(fragmentManager);
        this.mTabTitles = tabTitles;
    }

    @Override
    public Fragment getItem(int position) {
        JBFragment testFragment = new JBFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("index",position);//传入不同的index
        testFragment.setArguments(bundle);
        return testFragment;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        return super.instantiateItem(container, position);
    }

    @Override
    public int getCount() {
        return FRAGMENT_COUNT;
    }

    //设置Tab的标题
    @Override
    public CharSequence getPageTitle(int position) {
        return mTabTitles.get(position);
    }
}
