package com.sy.biquan.adapter;

import android.content.Context;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.tencent.qcloud.tim.uikit.base.BaseFragment;

import java.util.List;

public class DealAdapter extends FragmentPagerAdapter {
    private List<String> mTabTitles ;
    private static final int FRAGMENT_COUNT = 5;

    public DealAdapter(@NonNull FragmentManager fm, List<BaseFragment> fragments, List<String> tabTitles) {
        super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return null;
    }

    @Override
    public int getCount() {
        return 0;
    }
}
