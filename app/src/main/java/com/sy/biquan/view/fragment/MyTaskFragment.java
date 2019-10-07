package com.sy.biquan.view.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.sy.biquan.Contants;
import com.sy.biquan.MyApplication;
import com.sy.biquan.R;
import com.sy.biquan.activity.MyQdDetail;
import com.sy.biquan.adapter.TaskAdapter;
import com.sy.biquan.bean.MyTaskBean;
import com.sy.biquan.bean.UserInfo;
import com.sy.biquan.proxy.HttpCallback;
import com.sy.biquan.proxy.HttpProxy;
import com.sy.biquan.util.SharedPreferencesUtil;
import com.sy.biquan.viewutil.CircleImageView;

import java.util.HashMap;
import java.util.Map;

public class MyTaskFragment extends Fragment {
    private CircleImageView civ_user_img;
    private Button btn_mx;
    private TextView tv_qd;
    private RecyclerView rcy;

    private View rootView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.activity_task, container, false);
        initView();
        getData();
        btn_mx.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MyApplication.instance(), MyQdDetail.class));
            }
        });
        return rootView;
    }

    private void initView(){
        civ_user_img = rootView.findViewById(R.id.civ_user_img);
        btn_mx = rootView.findViewById(R.id.btn_mx);
        tv_qd = rootView.findViewById(R.id.tv_qd);
        rcy = rootView.findViewById(R.id.rcy);
        UserInfo userInfo = SharedPreferencesUtil.newGetUserInfo();
        Glide.with(this)
                .load(userInfo
                .getUserAvatar())
                .into(civ_user_img);
        tv_qd.setText(String.valueOf(userInfo.getQbNumber()));
    }

    private void getData(){
        Map<String,String> params = new HashMap<>();
        params.put("token", SharedPreferencesUtil.getToken());
        Log.e("MyTaskFragment","------------------------------------------------------------------");
        HttpProxy.obtain().post(Contants.URL + Contants.TASK_LIST, params, new HttpCallback<MyTaskBean>() {
            @Override
            public void onFailure(String e) {
                Log.e("MyTaskFragment","onFailure------------------------------------------------------------------"+e);
            }

            @Override
            public void onSuccess(MyTaskBean taskListBean) {
                Log.e("MyTaskFragment","onSuccess------------------------------------------------------------------"+taskListBean);
                rcy.setLayoutManager(new LinearLayoutManager(MyApplication.instance()));
                TaskAdapter adapter = new TaskAdapter(taskListBean,MyApplication.instance());
                rcy.setAdapter(adapter);
            }
        });
    }
}
