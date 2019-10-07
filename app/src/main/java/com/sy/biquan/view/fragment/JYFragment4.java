package com.sy.biquan.view.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.sy.biquan.R;

public class JYFragment4 extends Fragment {

    public JYFragment4(){}
    private View rootView;
    private RecyclerView rcy;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_jy_all, container, false);
//        ButterKnife.bind(this, mTestView);
        rcy = rootView.findViewById(R.id.rcy);
        return rootView;
    }

}
