package com.sy.biquan.view.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.sy.biquan.R;
import com.sy.biquan.activity.JYActivity;

public class MineFragment extends Fragment {

    private View rootView;
    private LinearLayout ll_my_deal,ll_my_jb;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return rootView = inflater.inflate(R.layout.fragment_mine, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView();
        ll_my_jb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        ll_my_deal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), JYActivity.class));
            }
        });

    }
    private void initView(){
        ll_my_deal = rootView.findViewById(R.id.ll_my_deal);
        ll_my_jb = rootView.findViewById(R.id.ll_my_jb);
    }
}
