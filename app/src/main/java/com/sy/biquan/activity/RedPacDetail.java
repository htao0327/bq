package com.sy.biquan.activity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.sy.biquan.MyApplication;
import com.sy.biquan.R;
import com.sy.biquan.adapter.RedAdapter;
import com.sy.biquan.bean.GetRedC2CBean;
import com.sy.biquan.bean.GetRedCheck;
import com.sy.biquan.bean.UserInfo;
import com.sy.biquan.util.SharedPreferencesUtil;
import com.sy.biquan.viewutil.CircleImageView;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class RedPacDetail extends AppCompatActivity {

    private TextView tv_content,tv_money,tv_user_name,tv_tips;
    private CircleImageView civ;
    private RecyclerView rcy;

    private RedAdapter adapter;

//    private GetRedCheck getRedCheck;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_red_detail);
        EventBus.getDefault().register(this);
        tv_content = findViewById(R.id.tv_content);
        tv_money = findViewById(R.id.tv_money);
        tv_user_name = findViewById(R.id.tv_user_name);
        tv_tips = findViewById(R.id.tv_tips);
        civ = findViewById(R.id.civ_user_img);
        rcy = findViewById(R.id.rcy);

//        tv_user_name.setText();

    }

    @Subscribe(threadMode = ThreadMode.POSTING, sticky = true)
    public void getData(GetRedCheck getRedCheck){
        Log.e("RedPacDetail","-----------------------"+getRedCheck.toString());
//        tv_content
        if(getRedCheck.getData().getIsMe() == 1){
            UserInfo userInfo = SharedPreferencesUtil.newGetUserInfo();

            tv_user_name.setText(userInfo.getUserAlias());
            Glide.with(MyApplication.instance())
                    .load(userInfo.getUserAvatar())
                    .into(civ);
        }

        if(getRedCheck.getData().getPacketList() == null || getRedCheck.getData().getPacketList().size()<=0){

        }else{
            adapter = new RedAdapter(RedPacDetail.this,getRedCheck);
            rcy.setLayoutManager(new LinearLayoutManager(RedPacDetail.this));
            rcy.setAdapter(adapter);
        }
    }

    @Subscribe(threadMode = ThreadMode.POSTING, sticky = true)
    public void getData2(GetRedC2CBean getRedC2CBean){
        Log.e("RedPacDetail","-----------------------"+getRedC2CBean.toString());

    }

    @Override
    protected void onDestroy() {
        //移除全部粘性事件
        EventBus.getDefault().removeAllStickyEvents();
        //解绑事件
        EventBus.getDefault().unregister(this);
        super.onDestroy();

    }
}
