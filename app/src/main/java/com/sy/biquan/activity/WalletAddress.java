package com.sy.biquan.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.sy.biquan.Contants;
import com.sy.biquan.R;
import com.sy.biquan.bean.AddWalletBean;
import com.sy.biquan.proxy.HttpCallback;
import com.sy.biquan.proxy.HttpProxy;
import com.sy.biquan.util.SharedPreferencesUtil;
import com.sy.biquan.viewutil.DialogUtil;
import com.tencent.qcloud.tim.uikit.utils.ToastUtil;

import java.util.HashMap;
import java.util.Map;

public class WalletAddress extends AppCompatActivity {

    public final static String NAME = "COIN_NAME";
    public final static String ADDRESS = "COIN_ADDRESS";
    public final static String ID = "ID";
    public final static String IMG_UEL = "URL";

    private TextView tips,name,title;
    private Button commit;
    private ImageView coinImg;
    private EditText address;
    private String nameStr,addressStr,id,url;
    private RelativeLayout rlBack;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wallet_address);
        title = findViewById(R.id.tv_title);
        tips = findViewById(R.id.tv_tips);
        name = findViewById(R.id.tv_coin_name);
        commit = findViewById(R.id.btn_commit);
        address = findViewById(R.id.et_address);
        rlBack = findViewById(R.id.rl_back);
        coinImg = findViewById(R.id.iv_coin_logo);
        url = getIntent().getStringExtra(IMG_UEL);
        Glide.with(this)
                .load(url)
                .into(coinImg);
        nameStr = getIntent().getStringExtra(NAME);
        addressStr = getIntent().getStringExtra(ADDRESS);
        id = getIntent().getStringExtra(ID);
        name.setText(nameStr);

        if("".equals(addressStr)){
            title.setText("添加地址");
            tips.setVisibility(View.VISIBLE);
            commit.setText("保存");
            commit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if("".equals(address.getText().toString())){
                        ToastUtil.toastLongMessage("请填写钱包地址");
                    }else{
                        Map<String,String> params = new HashMap<>();
                        params.put("token", SharedPreferencesUtil.getToken());
                        params.put("currency", nameStr);
                        params.put("walletAddress", address.getText().toString());

                        HttpProxy.obtain().post(Contants.URL + Contants.ADD_WALLET, params, new HttpCallback<AddWalletBean>() {
                            @Override
                            public void onFailure(String e) {
                                ToastUtil.toastLongMessage("连接失败"+e);
                            }

                            @Override
                            public void onSuccess(AddWalletBean addWalletBean) {
                                if(addWalletBean.getCode() == Contants.GET_DATA_SUCCESS){
                                    ToastUtil.toastLongMessage("添加成功");
                                    finish();
                                }
                            }
                        });
                    }

                }
            });
        }else{
            title.setText(nameStr);
            tips.setVisibility(View.GONE);
            commit.setText("删除");
            address.setText(addressStr);
            address.setEnabled(false);
            commit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    DialogUtil.showTipsAlertDialog(WalletAddress.this,
                            R.drawable.dialog_tips_icon, "是否确认删除钱包地址？",
                            "取消", "确认", false, new DialogUtil.AlertDialogBtnClickListener() {
                                @Override
                                public void clickPositive() {

                                }

                                @Override
                                public void clickNegative() {
                                    Map<String,String> params = new HashMap<>();
                                    params.put("token", SharedPreferencesUtil.getToken());
                                    params.put("id", id);
                                    HttpProxy.obtain().post(Contants.URL + Contants.DELETE_WALLET, params, new HttpCallback<AddWalletBean>() {
                                        @Override
                                        public void onFailure(String e) {
                                            ToastUtil.toastLongMessage("连接失败"+e);
                                        }

                                        @Override
                                        public void onSuccess(AddWalletBean addWalletBean) {
                                            if(addWalletBean.getCode() == Contants.GET_DATA_SUCCESS){
                                                ToastUtil.toastLongMessage("删除成功");
                                                finish();
                                            }
                                        }
                                    });
                                }
                            });

                }
            });
        }
        rlBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });


    }
}
