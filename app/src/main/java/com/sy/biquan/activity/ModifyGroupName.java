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
import com.sy.biquan.bean.MyWalletBean;
import com.sy.biquan.proxy.HttpCallback;
import com.sy.biquan.proxy.HttpProxy;
import com.sy.biquan.util.SharedPreferencesUtil;
import com.tencent.qcloud.tim.uikit.utils.ToastUtil;

import java.util.HashMap;
import java.util.Map;

public class ModifyGroupName extends AppCompatActivity {

//    public String GROUP_ID = "group_id";
    private EditText etGroupName;
    private RelativeLayout rl_back;
    private Button commit;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modify_group_name);
        rl_back = findViewById(R.id.rl_back);
        etGroupName = findViewById(R.id.et_group_name);
        commit = findViewById(R.id.btn_commit);
        etGroupName.setHint(getIntent().getStringExtra(MyGroupInfoActivity.GROUP_NAME));
        rl_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        commit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!"".equals(etGroupName.getText().toString().trim())){
                    Map<String,String> params = new HashMap<>();
                    params.put("token", SharedPreferencesUtil.getToken());
                    params.put("groupId",getIntent().getStringExtra(MyGroupInfoActivity.GROUP_ID));
                    params.put("groupName",etGroupName.getText().toString().trim());
                    params.put("introduction","");
                    params.put("notification","");
                    params.put("faceUrl","");
                    HttpProxy.obtain().post(Contants.URL + Contants.MODIFY_GROUP_INFO, params, new HttpCallback<MyWalletBean>() {
                        @Override
                        public void onFailure(String e) {

                        }

                        @Override
                        public void onSuccess(MyWalletBean myWalletBean) {
                            ToastUtil.toastLongMessage("修改成功");
                            finish();
                        }
                    });
                }
            }
        });

    }
}
