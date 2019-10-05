package com.sy.biquan.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.sy.biquan.Contants;
import com.sy.biquan.R;
import com.sy.biquan.bean.KOLListBean;
import com.sy.biquan.proxy.HttpCallback;
import com.sy.biquan.proxy.HttpProxy;
import com.sy.biquan.util.SharedPreferencesUtil;
import com.tencent.qcloud.tim.uikit.utils.ToastUtil;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class KOLListActivity extends AppCompatActivity {

    private RecyclerView mRv;
    private RelativeLayout rlBack;
    List<KOLListBean.DataBean> dataBeans;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kol_list);
        mRv = findViewById(R.id.rv_kol_list);
        rlBack = findViewById(R.id.rl_back);
        rlBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        getData();

    }

    private void getData(){
        Map<String,String> params = new HashMap<>();
        params.put("token", SharedPreferencesUtil.getToken());

        HttpProxy.obtain().post(Contants.URL + Contants.KOL_LIST, params, new HttpCallback<KOLListBean>() {
            @Override
            public void onFailure(String e) {

            }

            @Override
            public void onSuccess(KOLListBean kolListBean) {
                if(kolListBean.getCode() == Contants.GET_DATA_SUCCESS){
                    dataBeans = kolListBean.getData();
                }else{
                    ToastUtil.toastLongMessage(kolListBean.getMessage());
                }


            }
        });
    }
}
