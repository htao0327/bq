package com.sy.biquan.activity;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.sy.biquan.MyApplication;
import com.sy.biquan.R;
import com.sy.biquan.adapter.CFMMAdapter1;
import com.sy.biquan.adapter.CFMMAdapter2;
import com.sy.biquan.viewutil.DialogUtil;
import com.tencent.qcloud.tim.uikit.utils.ToastUtil;

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
        CFMMAdapter1 adapter1 = new CFMMAdapter1();
        adapter1.setOnItemClickListener(new CFMMAdapter1.OnItemClickListener() {
            @Override
            public void onItemClick(View v, int position) {
                DialogUtil.showPersonAlertDialog(CFMMActivity.this, R.drawable.img_test, "圆圆", "", "潇潇社区是集数字货币分析，优质项目推广广，资产风控管理，前端信息挖掘，区块链项目相关技术研发等多元化一体的区块链综合社区，旨传播正能量。",
                        "7887", "12%", "80.00", "主页", "关注", true, new DialogUtil.AlertDialogBtnClickListener() {
                            @Override
                            public void clickPositive() {

                            }

                            @Override
                            public void clickNegative() {

                            }
                        });
            }
        });
        dfbRecycler.setAdapter(adapter1);

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
