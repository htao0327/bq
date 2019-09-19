package com.sy.biquan.chat;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;

import com.sy.biquan.Contants;
import com.sy.biquan.R;
import com.sy.biquan.viewutil.DialogUtil;
import com.tencent.qcloud.tim.uikit.modules.chat.base.ChatInfo;
//import com.tencent.qcloud.tim.uikit.modules.chat.base.ChatInfo;

public class ChatActivity extends Activity {

    private ChatFragment mChatFragment;
    private ChatInfo mChatInfo;

//    public void showRedEnvelopesDialog(){
//        DialogUtil.showRedEnvelopesDialog(ChatActivity.this);
//    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chat_activity);

        Bundle bundle = getIntent().getExtras();
        if (bundle == null) {
//            startSplashActivity();
        } else {
            mChatInfo = (ChatInfo) bundle.getSerializable(Contants.CHAT_INFO);
            if (mChatInfo == null) {
//                startSplashActivity();
                return;
            }
            mChatFragment = new ChatFragment();
            mChatFragment.setArguments(bundle);
            getFragmentManager().beginTransaction().replace(R.id.empty_view, mChatFragment).commitAllowingStateLoss();
        }
    }
//    private void startSplashActivity() {
//        Intent intent = new Intent(ChatActivity.this, SplashActivity.class);
//        startActivity(intent);
//        finish();
//    }
}
