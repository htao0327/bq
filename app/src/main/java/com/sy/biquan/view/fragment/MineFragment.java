package com.sy.biquan.view.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.bumptech.glide.Glide;
import com.google.gson.Gson;
import com.shehuan.niv.NiceImageView;
import com.sy.biquan.Contants;
import com.sy.biquan.MainActivity;
import com.sy.biquan.MyApplication;
import com.sy.biquan.R;
import com.sy.biquan.activity.AccountSafeActivity;
import com.sy.biquan.activity.BaseSetActivity;
import com.sy.biquan.activity.JYActivity;
import com.sy.biquan.activity.MyJbActivity;
import com.sy.biquan.activity.MyWalletActivity;
import com.sy.biquan.activity.SetInvitePersonActivity;
import com.sy.biquan.bean.MineDataBean;
import com.sy.biquan.bean.RegisterBean;
import com.sy.biquan.bean.UserInfo;
import com.sy.biquan.proxy.HttpCallback;
import com.sy.biquan.proxy.HttpProxy;
import com.sy.biquan.util.SharedPreferencesUtil;
import com.sy.biquan.viewutil.CircleImageView;

import java.util.HashMap;
import java.util.Map;

public class MineFragment extends Fragment {

    private View rootView;
    private LinearLayout ll_my_deal,ll_my_jb,ll_qb,ll_set,ll_register,ll_aq;
    private TextView name;//用户姓名
    private TextView userMsg;//用户slogan
    private TextView gz;//关注
    private TextView fs;//粉丝
    private TextView qd;//Q豆
    private TextView bj;//编辑
    private Button exit;//编辑
    private CircleImageView userImg;//用户头像
    private MineDataBean mMineDataBean;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        rootView = inflater.inflate(R.layout.fragment_mine, container, false);
        initView();
        getData();
        return rootView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
//        initView();
//        getData();

        ll_aq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), AccountSafeActivity.class));
            }
        });

                bj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), BaseSetActivity.class));
            }
        });
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                android.os.Process.killProcess(android.os.Process.myPid());
            SharedPreferencesUtil.clearData(MyApplication.instance());
            MyApplication.instance().startActivity(new Intent(MyApplication.instance(),MainActivity.class).setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK));
            }
        });
        ll_my_jb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), MyJbActivity.class));
            }
        });

        ll_my_deal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), JYActivity.class));
            }
        });

        ll_qb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), MyWalletActivity.class));

            }
        });
        ll_set.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), BaseSetActivity.class));
            }
        });
        ll_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), SetInvitePersonActivity.class));
            }
        });
    }

    private void initView(){
        ll_my_deal = rootView.findViewById(R.id.ll_my_deal);
        ll_my_jb = rootView.findViewById(R.id.ll_my_jb);
        ll_qb = rootView.findViewById(R.id.ll_qb);
        name = rootView.findViewById(R.id.tv_user_name);
        userMsg = rootView.findViewById(R.id.tv_user_msg);
        gz = rootView.findViewById(R.id.tv_gz_counts);
        fs = rootView.findViewById(R.id.tv_fans_counts);
        qd = rootView.findViewById(R.id.tv_qd_counts);
        userImg = rootView.findViewById(R.id.iv_user);
        ll_set = rootView.findViewById(R.id.ll_set);
        bj = rootView.findViewById(R.id.tv_bj);
        exit = rootView.findViewById(R.id.btn_exit);
        ll_register = rootView.findViewById(R.id.ll_register);
        ll_aq = rootView.findViewById(R.id.ll_aq);

    }

    private void getData(){
        Map<String,String> params = new HashMap<>();
        params.put("token", SharedPreferencesUtil.getToken());
        HttpProxy.obtain().post(Contants.URL + Contants.MINE_INFO, params, new HttpCallback<MineDataBean>() {
            @Override
            public void onFailure(String e) {

            }

            @Override
            public void onSuccess(MineDataBean mineDataBean) {
                if(mineDataBean.getCode() == Contants.GET_DATA_SUCCESS){
//                    RegisterBean registerBean = new RegisterBean();
//                    registerBean.getData().setSlogan(mineDataBean.getData().getSlogan());
//                    registerBean.getData().setFansCount(mineDataBean.getData().getFansCount());
//                    registerBean.getData().setFollowCount(mineDataBean.getData().getFollowCount());
//                    registerBean.getData().setUserAlias(mineDataBean.getData().getUserAlias());
//                    registerBean.getData().setUserAvatar(mineDataBean.getData().getUserAvatar());
//                    registerBean.getData().setAllScore(mineDataBean.getData().getQbNumber());
//                    registerBean.getData().setUserPhone(mineDataBean.getData().getUserPhone());
//                    registerBean.getData().setDeal_password(Integer.valueOf(mineDataBean.getData().getDeal_password()));
//                    registerBean.getData().setSlogan(mineDataBean.getData().getSlogan());
//                    mMineDataBean = mineDataBean;
//                    Gson gson = new Gson();
//                    String jsonUserInfo = gson.toJson(mineDataBean);
//                    SharedPreferencesUtil.userInfoPutString(MyApplication.instance(),Contants.USERINFO2,jsonUserInfo);
                    SharedPreferencesUtil.setMineUserInfo(mineDataBean);
                }
            }
        });
    }

    @Override
    public void onStart() {
        super.onStart();
        setData();
    }

    private void setData(){
//        MineDataBean mineDataBean = SharedPreferencesUtil.getUserInfo2();
        UserInfo userInfo = SharedPreferencesUtil.newGetUserInfo();
        if(userInfo!= null){
            name.setText(userInfo.getUserAlias());
            qd.setText(String.valueOf(userInfo.getQbNumber()));
            fs.setText(String.valueOf(userInfo.getFansCount()));
            gz.setText(String.valueOf(userInfo.getFollowCount()));
            userMsg.setText(String.valueOf(userInfo.getSlogan()));
            Glide.with(this)
                    .load(userInfo
                    .getUserAvatar())
                    .into(userImg);
        }

    }


}
