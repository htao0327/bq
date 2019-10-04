package com.sy.biquan.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.sy.biquan.Contants;
import com.sy.biquan.R;
import com.sy.biquan.bean.BindUserBean;
import com.sy.biquan.proxy.HttpCallback;
import com.sy.biquan.proxy.HttpProxy;
import com.sy.biquan.util.SharedPreferencesUtil;
import com.tencent.qcloud.tim.uikit.utils.ToastUtil;

import java.util.HashMap;
import java.util.Map;

public class SetInvitePersonActivity extends AppCompatActivity {

    private EditText et;
    private Button btn;
    private RelativeLayout rlBack;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_invite_person);
        rlBack = findViewById(R.id.rl_back);
        et = findViewById(R.id.et_phone);
        btn = findViewById(R.id.btn);

        rlBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if("".equals(et.getText().toString())){
                    Map<String,String> params = new HashMap<>();
                    params.put("token", SharedPreferencesUtil.getToken());
                    params.put("inviteCode",et.getText().toString());
                    HttpProxy.obtain().post(Contants.URL + Contants.BIND_USER, params, new HttpCallback<BindUserBean>() {
                        @Override
                        public void onFailure(String e) {

                        }

                        @Override
                        public void onSuccess(BindUserBean bindUserBean) {
                            if(bindUserBean.getCode() == Contants.GET_DATA_SUCCESS){
                                ToastUtil.toastLongMessage("绑定成功");
                                finish();
                            }else{
                                ToastUtil.toastLongMessage(bindUserBean.getMsg());
                            }

                        }
                    });
                }
            }
        });
    }
}
