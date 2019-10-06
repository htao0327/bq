package com.sy.biquan.activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.sy.biquan.Contants;
import com.sy.biquan.MyApplication;
import com.sy.biquan.R;
import com.sy.biquan.adapter.CFMMAdapter1;
import com.sy.biquan.adapter.JBFragmentAdapter;
import com.sy.biquan.bean.AddWalletBean;
import com.sy.biquan.bean.JbDetailBean;
import com.sy.biquan.bean.MainListData;
import com.sy.biquan.bean.RegisterBean;
import com.sy.biquan.bean.UserInfo;
import com.sy.biquan.proxy.HttpCallback;
import com.sy.biquan.proxy.HttpProxy;
import com.sy.biquan.util.SharedPreferencesUtil;
import com.sy.biquan.viewutil.CircleImageView;
import com.sy.biquan.viewutil.DialogUtil;
import com.tencent.qcloud.tim.uikit.utils.ToastUtil;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JBDetailActivity extends AppCompatActivity {

    private RelativeLayout rlBack;
    public static final String ORDER_ID = "order_id";
    public static final String TAG = "JBDetailActivity";
    private TextView name,title,success,sy,dqzf,yqzf,endTime,money,money2,ddCount,jys,more;
    private ProgressBar progressBar;
    private RecyclerView rec;
    private Button suo,buy,gz;
    private ImageView ivSuccess;
    private CircleImageView userImg;
    private int qdPrice = 0;//荐币解锁价格
    private int isFollow;//1 已关注  0 未关注
    private String userID = "";
    private String orderId = "";
    private LinearLayout ll_tjjb;
    List<JbDetailBean.DataBean.BourseListBean> bourseList;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jb_detail);
        initView();
//        rec.setNestedScrollingEnabled(false);
        getData();
        rlBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        buy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if("".equals(orderId)){
                    ToastUtil.toastLongMessage("找不到该订单");
                }else {
//                    RegisterBean registerBean = SharedPreferencesUtil.getUserInfo();
                    UserInfo userInfo = SharedPreferencesUtil.newGetUserInfo();
                    double qdCounts = userInfo.getQbNumber();
                    if (qdCounts < qdPrice) {//提示去充值

                    } else {//提示确认购买
                        Log.e("JBDetailActivity","orderId:"+orderId);
                        Map<String, String> params = new HashMap<>();
                        params.put("token", SharedPreferencesUtil.getToken());
                        params.put("orderId", orderId);
                        HttpProxy.obtain().post(Contants.URL + Contants.BUY, params, new HttpCallback<AddWalletBean>() {
                            @Override
                            public void onFailure(String e) {

                            }

                            @Override
                            public void onSuccess(AddWalletBean addWalletBean) {
                                if(addWalletBean.getCode() == Contants.GET_DATA_SUCCESS){
                                    ToastUtil.toastLongMessage("购买成功");
                                    getData();
                                }else {
                                    ToastUtil.toastLongMessage(addWalletBean.getMsg());
                                }

                            }
                        });
                    }
                }
            }
        });
        more.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DialogUtil.showJysDialog(JBDetailActivity.this,bourseList);
            }
        });
        gz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if("".equals(userID)){
                    ToastUtil.toastLongMessage("找不到该大咖！");
                }else {
                    Map<String,String> params = new HashMap<>();
                    params.put("token",SharedPreferencesUtil.getToken());
                    params.put("followerId",userID);
                    if(isFollow == 1){//取消关注
                        HttpProxy.obtain().post(Contants.URL + Contants.UNFOLLOW, params, new HttpCallback<AddWalletBean>() {
                            @Override
                            public void onFailure(String e) {
                                ToastUtil.toastLongMessage("取关失败");
                            }

                            @Override
                            public void onSuccess(AddWalletBean addWalletBean) {
                                ToastUtil.toastLongMessage("取关成功");
                                isFollow = 0;
                                gz.setText("关注");
                            }
                        });
                    }else if(isFollow == 0){//关注
                        HttpProxy.obtain().post(Contants.URL + Contants.FOLLOW, params, new HttpCallback<AddWalletBean>() {
                            @Override
                            public void onFailure(String e) {
                                ToastUtil.toastLongMessage("关注失败");
                            }

                            @Override
                            public void onSuccess(AddWalletBean addWalletBean) {
                                ToastUtil.toastLongMessage("关注成功");
                                isFollow = 1;
                                gz.setText("取消关注");
                            }
                        });
                    }
                }
            }
        });
    }

    private void initView(){
        name = findViewById(R.id.name);
        title = findViewById(R.id.title);
        success = findViewById(R.id.success);
        sy = findViewById(R.id.sy);
        dqzf = findViewById(R.id.tv_dqzf);
        yqzf = findViewById(R.id.tv_yqzf);
        endTime = findViewById(R.id.end_time);
        money = findViewById(R.id.money);
        money2 = findViewById(R.id.money2);
        ddCount = findViewById(R.id.tv_dd_count);
        jys = findViewById(R.id.jys);
        progressBar = findViewById(R.id.progress);
        rec = findViewById(R.id.rec);
        suo = findViewById(R.id.iv_suo);
        buy = findViewById(R.id.btn_buy);
        ivSuccess = findViewById(R.id.iv_success);
        more = findViewById(R.id.more);
        userImg = findViewById(R.id.civ_user_img);
        gz = findViewById(R.id.btn_gz);
        rlBack = findViewById(R.id.rl_back);
    }

    private void getData(){
        Map<String,String> params = new HashMap<>();
        params.put("token", SharedPreferencesUtil.getToken());
        params.put("orderId", getIntent().getStringExtra(ORDER_ID));

        HttpProxy.obtain().post(Contants.URL + Contants.JB_DETIAL, params, new HttpCallback<JbDetailBean>() {
            @Override
            public void onFailure(String e) {

            }

            @Override
            public void onSuccess(JbDetailBean jbDetailBean) {
                getJbList();
                if(jbDetailBean.getCode() == Contants.GET_DATA_SUCCESS) {
                    orderId = jbDetailBean.getData().getId();
                    userID = jbDetailBean.getData().getUserId();
                    qdPrice = jbDetailBean.getData().getQbNumber();
                    bourseList = jbDetailBean.getData().getBourseList();
                    name.setText(jbDetailBean.getData().getUserName());
                    if (jbDetailBean.getData().getIsMe() == 1) {//大咖是本人
                        buy.setVisibility(View.GONE);
                        suo.setBackground(getResources().getDrawable(R.drawable.green_circle));
                        suo.setText(jbDetailBean.getData().getCurrency());
                        gz.setVisibility(View.GONE);
                    }else{//不是本人
                        if(jbDetailBean.getData().getIsLock() == 1){//锁定
                            suo.setBackground(getResources().getDrawable(R.drawable.suo));
                            suo.setText("");
                            buy.setVisibility(View.VISIBLE);
                        }else if(jbDetailBean.getData().getIsLock() == 0){//解锁
                            buy.setVisibility(View.GONE);
                            suo.setBackground(getResources().getDrawable(R.drawable.green_circle));
                            suo.setText(jbDetailBean.getData().getCurrency());
                        }
                    }

                    if (jbDetailBean.getData().getStatus() == 1) {
                        title.setText("进行中");
                    } else {
                        title.setText("交易完成");
                        buy.setVisibility(View.GONE);
                        suo.setBackground(getResources().getDrawable(R.drawable.green_circle));
                        suo.setText(jbDetailBean.getData().getCurrency());
                    }

                    success.setText(jbDetailBean.getData().getExpectedSucRise() + "%");
                    sy.setText(jbDetailBean.getData().getAvgRecommendRise() + "%");
                    if (jbDetailBean.getData().getNowRise() < 0) {
                        dqzf.setText(jbDetailBean.getData().getNowRise() + "%");
                    } else {
                        dqzf.setText("+" + jbDetailBean.getData().getNowRise() + "%");
                    }
                    yqzf.setText(jbDetailBean.getData().getNowRise() + "%");
                    endTime.setText("" + jbDetailBean.getData());
                    money.setText("¥" + jbDetailBean.getData().getTuiJianPrice());
                    money2.setText("¥" + jbDetailBean.getData().getNowPrice());
                    ddCount.setText("x" + jbDetailBean.getData().getQbNumber());
                    if (jbDetailBean.getData().getBourseList().size() > 0) {
                        StringBuffer sb = new StringBuffer();
                        sb.append("交易所：");
                        for (int i = 0; i < jbDetailBean.getData().getBourseList().size(); i++) {
                            if (i == jbDetailBean.getData().getBourseList().size() - 1) {
                                sb.append(jbDetailBean.getData().getBourseList().get(i).getExchangeName());
                            } else {
                                sb.append(jbDetailBean.getData().getBourseList().get(i).getExchangeName() + "、");
                            }
                            if (i == 3) {
                                i = jbDetailBean.getData().getBourseList().size();
                            }
                        }
                        jys.setText(sb);
                    } else {
                        jys.setText("交易所");
                    }

                    String nowTime = jbDetailBean.getData().getNowTime();
                    String startTime = jbDetailBean.getData().getStartTime();
                    String endTimeStr = jbDetailBean.getData().getEndTime();

//                    Log.e(TAG, "nowTime:" + nowTime);
//                    Log.e(TAG, "startTime:" + startTime);
//                    Log.e(TAG, "endTime:" + endTimeStr);
//                    Log.e(TAG, "%:" + (Long.valueOf(nowTime) - Long.valueOf(startTime)) / (Long.valueOf(endTimeStr) - Long.valueOf(startTime)));
                    progressBar.setProgress(Integer.parseInt(String.valueOf((Long.valueOf(nowTime) - Long.valueOf(startTime)) / (Long.valueOf(endTimeStr) - Long.valueOf(startTime)))));
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd天hh时mm分ss秒");
                    long time = Long.valueOf(endTimeStr) - Long.valueOf(nowTime);
                    Date date = new Date(time);
                    String timeStr = simpleDateFormat.format(date);
                    endTime.setText("距离结束截止：" + timeStr);

                    Glide.with(MyApplication.instance())
                            .load(jbDetailBean.getData().getUserAvatar())
                            .into(userImg);
                    if(jbDetailBean.getData().getIsSuccess()==1){
                        ivSuccess.setVisibility(View.VISIBLE);
                    }else {
                        ivSuccess.setVisibility(View.GONE);
                    }
                    isFollow = jbDetailBean.getData().getIsFollow();
                    if(jbDetailBean.getData().getIsFollow() == 1){//已关注
                        gz.setText("取消关注");
                    }else{//未关注
                        gz.setText("关注");
                    }

//                progressBar.setProgress();
                }

            }
        });
    }

    private void getJbList(){
        Map<String,String> params = new HashMap<>();
        params.put("token",SharedPreferencesUtil.getToken());
        HttpProxy.obtain().post(Contants.URL + Contants.TUIJIANJB, params, new HttpCallback<MainListData>() {
            @Override
            public void onFailure(String e) {

            }

            @Override
            public void onSuccess(final MainListData mainListData) {
                JBFragmentAdapter adapter = new JBFragmentAdapter(JBDetailActivity.this,mainListData);
                adapter.setOnItemClickListener(new JBFragmentAdapter.OnItemClickListener() {
                    @Override
                    public void onItemClick(View v, int position) {
                        startActivity(new Intent(JBDetailActivity.this,JBDetailActivity.class)
                                .putExtra(JBDetailActivity.ORDER_ID,mainListData.getData().get(position).getId()));
                    }
                });
                rec.setLayoutManager(new LinearLayoutManager(JBDetailActivity.this));
                rec.setAdapter(adapter);
            }
        });
    }

}
