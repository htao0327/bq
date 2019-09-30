package com.sy.biquan.activity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.Gson;
import com.sy.biquan.Contants;
import com.sy.biquan.MyApplication;
import com.sy.biquan.R;
import com.sy.biquan.bean.AddWalletBean;
import com.sy.biquan.bean.MineDataBean;
import com.sy.biquan.proxy.HttpCallback;
import com.sy.biquan.proxy.HttpProxy;
import com.sy.biquan.util.SharedPreferencesUtil;
import com.tencent.qcloud.tim.uikit.utils.ToastUtil;

import java.util.HashMap;
import java.util.Map;

public class SlognSetActivity extends AppCompatActivity {

    private EditText et;
    private TextView etSize;
    private Button commit;
    private RelativeLayout rl_back;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_slogan);
        et = findViewById(R.id.edt_order_note_text);
        etSize = findViewById(R.id.tv_edit_size);
        commit = findViewById(R.id.btn_commit);
        rl_back = findViewById(R.id.rl_back);
        rl_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        et.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                etSize.setText(String.valueOf(et.getText().length()));
            }
        });

        commit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!"".equals(et.getText().toString().trim())){

                    Map<String,String> map = new HashMap<>();
                    map.put("token", SharedPreferencesUtil.getToken());
                    map.put("slogan",et.getText().toString().trim());
                    map.put("userAlias","");
                    HttpProxy.obtain().post(Contants.URL + Contants.SET_NAME, map, new HttpCallback<AddWalletBean>() {
                        @Override
                        public void onFailure(String e) {

                        }

                        @Override
                        public void onSuccess(AddWalletBean addWalletBean) {
                            if(addWalletBean.getCode() == Contants.GET_DATA_SUCCESS){
                                MineDataBean mineDataBean = SharedPreferencesUtil.getUserInfo2();
                                mineDataBean.getData().setSlogan(et.getText().toString().trim());
                                Gson gson = new Gson();
                                String jsonUserInfo = gson.toJson(mineDataBean);
                                SharedPreferencesUtil.userInfoPutString(MyApplication.instance(),Contants.USERINFO2,jsonUserInfo);
                                ToastUtil.toastLongMessage("修改完成");
                                finish();
                            }
                        }
                    });
                }
            }
        });
    }
}
