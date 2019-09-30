package com.sy.biquan.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.sy.biquan.R;

public class CheckDealInfoActivity extends AppCompatActivity {

    public final static String IDCARD_TYPE = "idCard";
    public final static String WALLET_TYPE = "walletType";

    private String idCardType;
    private String walletType;

    private Button idCard,wallet,ok;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_deal_info);
        idCard = findViewById(R.id.btn_id_card);
        wallet = findViewById(R.id.btn_wallet);
        ok = findViewById(R.id.btn_ok);

        wallet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(CheckDealInfoActivity.this,CheckDealInfoAddWalletActivity.class));
            }
        });

        idCardType = getIntent().getStringExtra(IDCARD_TYPE);
        walletType = getIntent().getStringExtra(WALLET_TYPE);

    }

    @Override
    protected void onPostResume() {
        super.onPostResume();
        if("y".equals(idCardType)){
            idCard.setBackground(getResources().getDrawable(R.drawable.btn_bg_deal_check_gray));
            idCard.setFocusable(false);
        }else {
            idCard.setBackground(getResources().getDrawable(R.drawable.btn_bg_deal_check_green));
            idCard.setFocusable(true);
        }

        if("y".equals(walletType)){
            wallet.setBackground(getResources().getDrawable(R.drawable.btn_bg_deal_check_gray));
            wallet.setFocusable(false);
        }else {
            wallet.setBackground(getResources().getDrawable(R.drawable.btn_bg_deal_check_green));
            wallet.setFocusable(true);
        }


    }
}
