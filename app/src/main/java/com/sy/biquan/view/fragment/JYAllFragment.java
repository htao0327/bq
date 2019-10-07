package com.sy.biquan.view.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.sy.biquan.Contants;
import com.sy.biquan.R;
import com.sy.biquan.bean.DealListBean;
import com.sy.biquan.proxy.HttpCallback;
import com.sy.biquan.proxy.HttpProxy;
import com.sy.biquan.util.SharedPreferencesUtil;

import java.util.HashMap;
import java.util.Map;

public class JYAllFragment extends Fragment {

    public JYAllFragment(){}
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

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getData();
    }

    private void getData(){
        Map<String,String> params = new HashMap<>();
        params.put("token", SharedPreferencesUtil.getToken());
        params.put("page","1");
        params.put("limit","10");
        params.put("type","9");
        params.put("transcation_type","1");
        HttpProxy.obtain().post(Contants.URL + Contants.DEAL_LSIT, params, new HttpCallback<DealListBean>() {
            @Override
            public void onFailure(String e) {

            }

            @Override
            public void onSuccess(DealListBean dealListBean) {

            }
        });
    }






}
