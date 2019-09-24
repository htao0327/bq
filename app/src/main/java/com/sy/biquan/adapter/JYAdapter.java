package com.sy.biquan.adapter;

import android.content.Context;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class JYAdapter extends RecyclerView.Adapter {
    private List<String> mTabTitles ;
    private static final int FRAGMENT_COUNT = 5;
    public JYAdapter(Context context, List<String> tabs, List<Fragment> fragments) {
        this.mTabTitles = tabs;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
