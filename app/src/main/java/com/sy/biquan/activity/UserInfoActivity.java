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
import com.sy.biquan.chat.ChatActivity;
import com.sy.biquan.viewutil.CircleImageView;
import com.tencent.imsdk.TIMConversationType;
import com.tencent.imsdk.TIMFriendshipManager;
import com.tencent.imsdk.TIMValueCallBack;
import com.tencent.imsdk.friendship.TIMCheckFriendResult;
import com.tencent.imsdk.friendship.TIMFriendCheckInfo;
import com.tencent.imsdk.friendship.TIMFriendCheckType;
import com.tencent.imsdk.friendship.TIMFriendRequest;
import com.tencent.imsdk.friendship.TIMFriendResult;
import com.tencent.imsdk.friendship.TIMFriendStatus;
import com.tencent.qcloud.tim.uikit.modules.chat.base.ChatInfo;
import com.tencent.qcloud.tim.uikit.utils.ToastUtil;

import java.util.ArrayList;
import java.util.List;

public class UserInfoActivity extends AppCompatActivity {

    /**
     *  不是好友
     */
    public static final int TIM_FRIEND_RELATION_TYPE_NONE           = 0;

    /**
     *  对方在我的好友列表中
     */
    public static final int TIM_FRIEND_RELATION_TYPE_MY_UNI         = 1;

    /**
     *  我在对方的好友列表中
     */
    public static final int TIM_FRIEND_RELATION_TYPE_OTHER_UNI      = 2;

    /**
     *  互为好友
     */
    public static final int TIM_FRIEND_RELATION_TYPE_BOTH_WAY       = 3;

    public static final String USER_ID = "user_id";
    public static final String USER_IMG = "user_img";
    public static final String USER_NAME = "user_name";
    public static final String USER_IM_CODE = "user_im_code";
    public static final String USER_SLOGAN = "user_slogan";

    private CircleImageView userImg;
    private TextView userName;
    private TextView slogan;
    private EditText t1;//验证消息
    private EditText t2;//备注名
    private LinearLayout ll_user_main;//个人主页
    private LinearLayout ll_slogan;//个性签名
    private LinearLayout ll_check_msg;//验证消息
    private LinearLayout ll_name;//备注名

    private Button btn;

    List<String> imCode = new ArrayList<>();



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_info);
        userName = findViewById(R.id.tv_user_name);
        userImg = findViewById(R.id.civ_user_img);
        slogan = findViewById(R.id.tv_slogan);
        btn = findViewById(R.id.btn);
        t1 = findViewById(R.id.t1);

        ll_check_msg = findViewById(R.id.ll_check_msg);
        ll_user_main = findViewById(R.id.ll_user_main);
        ll_slogan = findViewById(R.id.ll_slogan);
        ll_name = findViewById(R.id.ll_name);

        ll_user_main.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(UserInfoActivity.this,DakaDetailActivity.class)
                        .putExtra(DakaDetailActivity.USER_ID,getIntent().getStringExtra(USER_ID)));
            }
        });

        userName.setText(getIntent().getStringExtra(USER_NAME));
        slogan.setText(getIntent().getStringExtra(USER_SLOGAN));
        Glide.with(MyApplication.instance())
                .load(getIntent().getStringExtra(USER_IMG))
                .into(userImg);


        imCode.add(getIntent().getStringExtra(USER_IM_CODE));

        TIMFriendCheckInfo checkInfo = new TIMFriendCheckInfo();
        checkInfo.setCheckType(TIMFriendCheckType.TIM_FRIEND_CHECK_TYPE_BIDIRECTION);
        checkInfo.setUsers(imCode);
        TIMFriendshipManager.getInstance().checkFriends(checkInfo,new TIMValueCallBack<java.util.List<TIMCheckFriendResult>>(){

            @Override
            public void onError(int i, String s) {

            }

            @Override
            public void onSuccess(List<TIMCheckFriendResult> timCheckFriendResults) {
                if(timCheckFriendResults.size()>0){
                    if(timCheckFriendResults.get(0).getResultType() == TIM_FRIEND_RELATION_TYPE_BOTH_WAY){
                        //互为好友
                        ll_user_main.setVisibility(View.VISIBLE);
                        ll_check_msg.setVisibility(View.GONE);
                        ll_name.setVisibility(View.GONE);
                        btn.setText("发消息");
                        btn.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                startChat();
                            }
                        });

                    }else{
                        ll_user_main.setVisibility(View.GONE);
                        ll_check_msg.setVisibility(View.VISIBLE);
                        ll_name.setVisibility(View.VISIBLE);
                        btn.setText("添加到通讯录");
                        btn.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                addFriend();
                            }
                        });

                    }
                }
            }
        });
    }

    private void startChat(){
        ChatInfo chatInfo = new ChatInfo();
        chatInfo.setType(TIMConversationType.C2C);
        chatInfo.setId(getIntent().getStringExtra(USER_IM_CODE));
        chatInfo.setChatName(getIntent().getStringExtra(USER_NAME));
        Intent intent = new Intent(MyApplication.instance(), ChatActivity.class);
        intent.putExtra(Contants.CHAT_INFO, chatInfo);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        MyApplication.instance().startActivity(intent);
    }

    public void addFriend() {
        String id = getIntent().getStringExtra(USER_IM_CODE);
        if (TextUtils.isEmpty(id)) {
            return;
        }

        TIMFriendRequest timFriendRequest = new TIMFriendRequest(id);
        timFriendRequest.setAddWording(t1.getText().toString());
        timFriendRequest.setAddSource("android");
        TIMFriendshipManager.getInstance().addFriend(timFriendRequest, new TIMValueCallBack<TIMFriendResult>() {
            @Override
            public void onError(int i, String s) {
//                DemoLog.e(TAG, "addFriend err code = " + i + ", desc = " + s);
                ToastUtil.toastShortMessage("Error code = " + i + ", desc = " + s);
            }

            @Override
            public void onSuccess(TIMFriendResult timFriendResult) {
//                DemoLog.i(TAG, "addFriend success result = " + timFriendResult.toString());
                switch (timFriendResult.getResultCode()) {
                    case TIMFriendStatus.TIM_FRIEND_STATUS_SUCC:
                        ToastUtil.toastShortMessage("成功");
                        break;
                    case TIMFriendStatus.TIM_FRIEND_PARAM_INVALID:
                        if (TextUtils.equals(timFriendResult.getResultInfo(), "Err_SNS_FriendAdd_Friend_Exist")) {
                            ToastUtil.toastShortMessage("对方已是您的好友");
                            break;
                        }
                    case TIMFriendStatus.TIM_ADD_FRIEND_STATUS_SELF_FRIEND_FULL:
                        ToastUtil.toastShortMessage("您的好友数已达系统上限");
                        break;
                    case TIMFriendStatus.TIM_ADD_FRIEND_STATUS_THEIR_FRIEND_FULL:
                        ToastUtil.toastShortMessage("对方的好友数已达系统上限");
                        break;
                    case TIMFriendStatus.TIM_ADD_FRIEND_STATUS_IN_SELF_BLACK_LIST:
                        ToastUtil.toastShortMessage("被加好友在自己的黑名单中");
                        break;
                    case TIMFriendStatus.TIM_ADD_FRIEND_STATUS_FRIEND_SIDE_FORBID_ADD:
                        ToastUtil.toastShortMessage("对方已禁止加好友");
                        break;
                    case TIMFriendStatus.TIM_ADD_FRIEND_STATUS_IN_OTHER_SIDE_BLACK_LIST:
                        ToastUtil.toastShortMessage("您已被被对方设置为黑名单");
                        break;
                    case TIMFriendStatus.TIM_ADD_FRIEND_STATUS_PENDING:
                        ToastUtil.toastShortMessage("等待好友审核同意");
                        break;
                    default:
                        ToastUtil.toastLongMessage(timFriendResult.getResultCode() + " " + timFriendResult.getResultInfo());
                        startChat();
                        break;
                }
                finish();
            }
        });
    }



}
