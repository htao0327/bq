package com.sy.biquan.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.google.gson.Gson;
import com.sy.biquan.R;
import com.sy.biquan.bean.MineDataBean;
import com.sy.biquan.util.SharedPreferencesUtil;
import com.sy.biquan.viewutil.CircleImageView;

public class BaseSetActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView name;//昵称
    private TextView phone;//电话号码
    private TextView invite;//邀请人
    private TextView idCard;//是否实名认证
    private CircleImageView userImg;//头像

    private LinearLayout ll_user_img;
    private LinearLayout ll_name;
    private LinearLayout ll_slogan;
    private LinearLayout ll_phone;
    private LinearLayout ll_invite;
    private LinearLayout ll_id_card;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base_set);
        initView();

        ll_user_img.setOnClickListener(this);
        ll_name.setOnClickListener(this);
        ll_slogan.setOnClickListener(this);
        ll_phone.setOnClickListener(this);
        ll_invite.setOnClickListener(this);
        ll_id_card.setOnClickListener(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        setData();
    }

    private void setData(){

        MineDataBean mineDataBean = SharedPreferencesUtil.getUserInfo2();
        Glide.with(this)
                .load(mineDataBean.getData().getUserAvatar())
                .into(userImg);
        name.setText(mineDataBean.getData().getUserAlias());
        phone.setText(mineDataBean.getData().getUserPhone());
        if("1".equals(mineDataBean.getData().getHasInviteCode())){
            invite.setText(mineDataBean.getData().getInviteUserAlias());
        }else {
            invite.setText("未绑定");
        }
        if("0".equals(mineDataBean.getData().getAuthStatus())){//是否实名认证 0-未认证 1-审核中 2-认证成功 3-认证失败
            idCard.setText("未认证");
        }else if("1".equals(mineDataBean.getData().getAuthStatus())){//是否实名认证 0-未认证 1-审核中 2-认证成功 3-认证失败
            idCard.setText("审核中");
        }else if("2".equals(mineDataBean.getData().getAuthStatus())){//是否实名认证 0-未认证 1-审核中 2-认证成功 3-认证失败
            idCard.setText("认证成功");
        }else if("3".equals(mineDataBean.getData().getAuthStatus())){//是否实名认证 0-未认证 1-审核中 2-认证成功 3-认证失败
            idCard.setText("认证失败");
        }
    }

    private void initView(){

        ll_user_img = findViewById(R.id.ll_user_img);
        ll_name = findViewById(R.id.ll_name);
        ll_slogan = findViewById(R.id.ll_slogan);
        ll_phone = findViewById(R.id.ll_phone);
        ll_invite = findViewById(R.id.ll_invite);
        ll_id_card = findViewById(R.id.ll_id_card);

        name = findViewById(R.id.tv_set_user_name);
        phone = findViewById(R.id.tv_set_user_phone);
        invite = findViewById(R.id.tv_set_invite);
        idCard = findViewById(R.id.tv_set_id_card);
        userImg = findViewById(R.id.civ_user_img);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.ll_user_img:

                break;
            case R.id.ll_name:
                startActivity(new Intent(BaseSetActivity.this,NameSetActivity.class));
                break;
            case R.id.ll_slogan:
                startActivity(new Intent(BaseSetActivity.this,SlognSetActivity.class));
                break;
            case R.id.ll_phone:

                break;
            case R.id.ll_invite:

                break;
            case R.id.ll_id_card:

                break;

        }
    }
}
