package com.sy.biquan.view.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.sy.biquan.Contants;
import com.sy.biquan.MyApplication;
import com.sy.biquan.R;
import com.sy.biquan.activity.JBDetailActivity;
import com.sy.biquan.activity.LoginActivity;
import com.sy.biquan.adapter.CFMMAdapter1;
import com.sy.biquan.adapter.JBFragmentAdapter;
import com.sy.biquan.bean.MainListData;
import com.sy.biquan.bean.RegisterBean;
import com.sy.biquan.bean.UserInfo;
import com.sy.biquan.proxy.HttpCallback;
import com.sy.biquan.proxy.HttpProxy;
import com.sy.biquan.util.SharedPreferencesUtil;

import java.util.HashMap;
import java.util.Map;

public class MainHotFragment extends Fragment {
    private static final String TAG ="TestFragment";
    private  int mIndex;
    //    @BindView(R.id.tv_content)
//    TextView mContentTv;
    private View mTestView;
    private RecyclerView recyclerView;
    private JBFragmentAdapter adapter;

    UserInfo userInfo = null;

    public MainHotFragment(){

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mTestView = inflater.inflate(R.layout.main_menu_fragment, container, false);
//        ButterKnife.bind(this, mTestView);
        recyclerView = mTestView.findViewById(R.id.main_menu_rec);
        return mTestView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
//        mContentTv.setText("TestFragment" + mIndex);
        getData();
//        adapter = new JBFragmentAdapter(getActivity());
//        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
//        recyclerView.setNestedScrollingEnabled(false);
//        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mIndex = getArguments().getInt("index");//根据不同的额index显示不同的内容

    }

    private void getData(){

        Map<String,String> params = new HashMap<>();
        if(userInfo != null && !"".equals(userInfo.toString().trim())){
            params.put("token", SharedPreferencesUtil.getToken());
        }else{
            params.put("token", "");
        }
        params.put("pageNum","1");
        params.put("pageSize","10");
        params.put("tag","hot");
        HttpProxy.obtain().post(Contants.URL + Contants.HOME_JB_LIST, params, new HttpCallback<MainListData>() {
            @Override
            public void onFailure(String e) {

            }

            @Override
            public void onSuccess(final MainListData mainListData) {
                adapter = new JBFragmentAdapter(getActivity(),mainListData);
                adapter.setOnItemClickListener(new JBFragmentAdapter.OnItemClickListener() {
                    @Override
                    public void onItemClick(View v, int position) {
                        userInfo = SharedPreferencesUtil.newGetUserInfo();
                        if(userInfo == null ){
                            startActivity(new Intent(MyApplication.instance(), LoginActivity.class));
                            return;
                        }
                        startActivity(new Intent(getActivity(), JBDetailActivity.class)
                                .putExtra(JBDetailActivity.ORDER_ID,mainListData.getData().get(position).getId()));
                    }
                });
                recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
                recyclerView.setNestedScrollingEnabled(false);
                recyclerView.setAdapter(adapter);
            }
        });

    }

    @Override
    public void onStart() {
        super.onStart();
        Log.d(TAG,"onStart()" + mIndex);
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d(TAG,"onPause()" + mIndex);
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d(TAG,"onResume()" + mIndex);
    }
}
