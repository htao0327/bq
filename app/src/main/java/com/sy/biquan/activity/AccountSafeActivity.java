package com.sy.biquan.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.sy.biquan.R;

public class AccountSafeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_safe);
        RelativeLayout rlback = findViewById(R.id.rl_back);
        LinearLayout deal = findViewById(R.id.ll_deal_pwd);
        LinearLayout login = findViewById(R.id.ll_login_pwd);
        rlback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        deal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(AccountSafeActivity.this,SetDealPwdActivity.class).putExtra("type",0));
            }
        });
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(AccountSafeActivity.this,SetDealPwdActivity.class).putExtra("type",1));
            }
        });
    }
}
