package com.sy.biquan.activity;

import android.os.Bundle;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.sy.biquan.Contants;
import com.sy.biquan.R;
import com.sy.biquan.bean.JbDetailBean;
import com.sy.biquan.proxy.HttpCallback;
import com.sy.biquan.proxy.HttpProxy;
import com.sy.biquan.util.SharedPreferencesUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JBDetailActivity extends AppCompatActivity {

    public static final String ORDER_ID = "order_id";
    private TextView name,title,success,sy,dqzf,yqzf,endTime,money,money2,ddCount,jys;
    private ProgressBar progressBar;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jb_detail);
        initView();
        getData();
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
                name.setText(jbDetailBean.getData().getUserName());
                if(jbDetailBean.getData().getStatus() == 1){
                    title.setText("进行中");
                }else {
                    title.setText("交易完成");
                }
                success.setText(jbDetailBean.getData().getExpectedSucRise()+"%");
                sy.setText(jbDetailBean.getData().getAvgRecommendRise()+"%");
                if(jbDetailBean.getData().getNowRise()<0){
                    dqzf.setText(jbDetailBean.getData().getNowRise()+"%");
                }else {
                    dqzf.setText("+"+jbDetailBean.getData().getNowRise()+"%");
                }
                yqzf.setText(jbDetailBean.getData().getNowRise()+"%");
                endTime.setText(""+jbDetailBean.getData());
                money.setText("¥"+jbDetailBean.getData().getTuiJianPrice());
                money2.setText("¥"+jbDetailBean.getData().getNowPrice());
                ddCount.setText("x"+jbDetailBean.getData().getQbNumber());
                if(jbDetailBean.getData().getBourseList().size()>0){
                    StringBuffer sb = new StringBuffer();
                    sb.append("交易所：");
                    for(int i=0;i<jbDetailBean.getData().getBourseList().size();i++){
                        if(i==jbDetailBean.getData().getBourseList().size()-1){
                            sb.append(jbDetailBean.getData().getBourseList().get(i).getExchangeName());
                        }else {
                            sb.append(jbDetailBean.getData().getBourseList().get(i).getExchangeName()+"、");
                        }
                    }
                }else {
                    jys.setText("交易所");
                }

                progressBar.setProgress();



            }
        });
    }

}
