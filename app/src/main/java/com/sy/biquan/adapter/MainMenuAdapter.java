package com.sy.biquan.adapter;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.List;

public class MainMenuAdapter extends FragmentPagerAdapter {

    private List<String> tabs;
    private Context context;
    private List<Fragment> fragments;

    public MainMenuAdapter(@NonNull FragmentManager fm, int behavior,List<String> tabs,Context context,List<Fragment> fragments) {
        super(fm, behavior);
        this.context = context;
        this.tabs = tabs;
        this.fragments = fragments;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }
}
