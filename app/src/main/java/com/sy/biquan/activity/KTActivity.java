package com.sy.biquan.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.sy.biquan.R;
import com.sy.biquan.adapter.KTAdapter;
public class KTActivity extends AppCompatActivity {

    private RelativeLayout rl_back;
    private RecyclerView mRecyclerView;
    private KTAdapter adapter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kt);
        initView();
        adapter = new KTAdapter(this);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(adapter);
        rl_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    private void initView(){
        mRecyclerView = findViewById(R.id.rv);
        rl_back = findViewById(R.id.rl_back);
    }

}
