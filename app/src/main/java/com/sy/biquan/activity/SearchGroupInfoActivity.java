package com.sy.biquan.activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.sy.biquan.Contants;
import com.sy.biquan.MyApplication;
import com.sy.biquan.R;
import com.sy.biquan.bean.RegisterBean;
import com.sy.biquan.chat.ChatActivity;
import com.sy.biquan.util.SharedPreferencesUtil;
import com.sy.biquan.viewutil.CircleImageView;
import com.tencent.imsdk.TIMCallBack;
import com.tencent.imsdk.TIMConversationType;
import com.tencent.imsdk.TIMGroupManager;
import com.tencent.qcloud.tim.uikit.modules.chat.base.ChatInfo;
import com.tencent.qcloud.tim.uikit.utils.ToastUtil;

public class SearchGroupInfoActivity extends AppCompatActivity {

    public static final String IS_KOL = "is_kol";
    public static final String IS_HERE = "is_here";
    public static final String GROUP_NAME = "group_name";
    public static final String GROUP_ID = "group_id";
    public static final String GROUP_NUM = "group_num";
    public static final String GROUP_IMG = "group_img";
    public static final String GROUP_QZ_NAME = "group_qz_name";
    public static final String GROUP_QZ_IMG = "group_qz_img";
    public static final String GROUP_QZ_ID = "group_qz_id";
    public static final String GROUP_PROJECT_NAME = "group_project_name";

    private TextView groupName;
    private TextView projectName;
    private TextView groupNum;
    private TextView qzName;
    private Button btn;
    private CircleImageView groupImg,qzImg;
    private EditText t1;

    private LinearLayout ll_check_msg;
    private LinearLayout ll_group_project;

    private int kol;//1 是 0 否
    private int isHere;//1 是 0 否  是否在群里
    private String groupId = "";


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_group_info);
        groupName = findViewById(R.id.tv_group_name);
        projectName = findViewById(R.id.tv_group_project_name);
        groupNum = findViewById(R.id.tv_group_people_count);
        ll_check_msg = findViewById(R.id.ll_check_msg);
        ll_group_project = findViewById(R.id.ll_group_project);
        groupImg = findViewById(R.id.civ_group_img);
        qzImg = findViewById(R.id.civ_qz_img);
        btn = findViewById(R.id.btn);
        qzName = findViewById(R.id.tv_qz_name);
        t1 = findViewById(R.id.t1);

        RegisterBean registerBean = SharedPreferencesUtil.getUserInfo();
        String id = registerBean.getData().getId();


        qzName.setText(getIntent().getStringExtra(GROUP_QZ_NAME));
        kol = getIntent().getIntExtra(IS_KOL,0);
        isHere = getIntent().getIntExtra(IS_HERE,0);
        groupId = getIntent().getStringExtra(GROUP_ID);
        if(kol == 0 && isHere == 0){
            ll_check_msg.setVisibility(View.VISIBLE);
        }else{
            ll_check_msg.setVisibility(View.GONE);
        }
        Log.e("SearchGroupInfoActivity","id:"+id+"--GROUP_QZ_ID:"+getIntent().getStringExtra(GROUP_QZ_ID));
        if(isHere == 0 && !id.equals(getIntent().getStringExtra(GROUP_QZ_ID))){
            btn.setText("加入群聊");
            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    addGroup();
                }
            });
        }else {
            btn.setText("发消息");
            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    startChat();
                }
            });
        }
        if(kol == 0){
            ll_group_project.setVisibility(View.GONE);
        }else{
            ll_group_project.setVisibility(View.VISIBLE);
            projectName.setText(getIntent().getStringExtra(GROUP_PROJECT_NAME));
        }


        groupNum.setText(String.valueOf(getIntent().getIntExtra(GROUP_NUM,1)));
        groupName.setText(getIntent().getStringExtra(GROUP_NAME));
        Glide.with(MyApplication.instance())
                .load(getIntent().getStringExtra(GROUP_IMG))
                .into(groupImg);
        Glide.with(MyApplication.instance())
                .load(getIntent().getStringExtra(GROUP_QZ_IMG))
                .into(qzImg);


    }


    private void startChat(){
        ChatInfo chatInfo = new ChatInfo();
        chatInfo.setType(TIMConversationType.Group);
        chatInfo.setId(getIntent().getStringExtra(GROUP_ID));
        chatInfo.setChatName(getIntent().getStringExtra(GROUP_NAME));
        Intent intent = new Intent(MyApplication.instance(), ChatActivity.class);
        intent.putExtra(Contants.CHAT_INFO, chatInfo);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        MyApplication.instance().startActivity(intent);
    }


    public void addGroup() {
        String id = groupId;
        if (TextUtils.isEmpty(id)) {
            return;
        }
        TIMGroupManager.getInstance().applyJoinGroup(id, t1.getText().toString(), new TIMCallBack() {

            @Override
            public void onError(int i, String s) {
//                DemoLog.e(TAG, "addGroup err code = " + i + ", desc = " + s);
                ToastUtil.toastShortMessage("Error code = " + i + ", desc = " + s);
            }

            @Override
            public void onSuccess() {
//                DemoLog.i(TAG, "addGroup success");
                if(kol == 1){
                    startChat();
                }else{
                    ToastUtil.toastShortMessage("加群请求已发送");
                finish();
                }

            }
        });
    }


}
