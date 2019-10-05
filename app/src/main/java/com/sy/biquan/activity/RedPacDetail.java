package com.sy.biquan.activity;

import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.sy.biquan.R;
import com.sy.biquan.viewutil.CircleImageView;

public class RedPacDetail extends AppCompatActivity {

    private TextView tv_content,tv_money,tv_user_name,tv_tips;
    private CircleImageView civ;
    private RecyclerView rcy;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_red_detail);
        tv_content = findViewById(R.id.tv_content);
        tv_money = findViewById(R.id.tv_money);
        tv_user_name = findViewById(R.id.tv_user_name);
        tv_tips = findViewById(R.id.tv_tips);
        civ = findViewById(R.id.civ_user_img);
        rcy = findViewById(R.id.rcy);

//        tv_user_name.setText();
    }
}
