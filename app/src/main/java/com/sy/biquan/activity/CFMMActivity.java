package com.sy.biquan.activity;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.sy.biquan.R;
import com.sy.biquan.adapter.CFMMAdapter1;
import com.sy.biquan.adapter.CFMMAdapter2;

public class CFMMActivity extends AppCompatActivity {

    private RecyclerView dfbRecycler,dktjRecycler;
    private RelativeLayout rlBack;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cfmm);
        initView();

        LinearLayoutManager manager = new LinearLayoutManager(this);
        manager.setOrientation(LinearLayoutManager.HORIZONTAL);
        dfbRecycler.setLayoutManager(manager);

        dfbRecycler.setAdapter(new CFMMAdapter1());

        dktjRecycler.setLayoutManager(new LinearLayoutManager(this));
        dktjRecycler.setAdapter(new CFMMAdapter2());

        rlBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }

    private void initView(){
        dfbRecycler = findViewById(R.id.dfb_recycler);
        dktjRecycler = findViewById(R.id.dktj_recycler);
        rlBack = findViewById(R.id.rl_back);

    }
}
