package com.sy.biquan.chat;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;

import com.google.gson.Gson;
import com.sy.biquan.Contants;
import com.sy.biquan.MainActivity;
import com.sy.biquan.MyApplication;
import com.sy.biquan.R;
import com.sy.biquan.activity.FriendProfileActivity;
import com.sy.biquan.viewutil.ChatLayoutHelper;
import com.tencent.imsdk.TIMConversationType;
import com.tencent.qcloud.tim.uikit.base.BaseFragment;
import com.tencent.qcloud.tim.uikit.component.AudioPlayer;
import com.tencent.qcloud.tim.uikit.component.TitleBarLayout;
import com.tencent.qcloud.tim.uikit.modules.chat.ChatLayout;
import com.tencent.qcloud.tim.uikit.modules.chat.base.ChatInfo;
import com.tencent.qcloud.tim.uikit.modules.chat.layout.input.InputLayout;
import com.tencent.qcloud.tim.uikit.modules.chat.layout.inputmore.InputMoreActionUnit;
import com.tencent.qcloud.tim.uikit.modules.chat.layout.message.MessageLayout;
import com.tencent.qcloud.tim.uikit.modules.message.MessageInfo;
import com.tencent.qcloud.tim.uikit.modules.message.MessageInfoUtil;
import com.tencent.qcloud.tim.uikit.utils.TUIKitConstants;
import com.tencent.qcloud.tim.uikit.utils.ToastUtil;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;


public class ChatFragment extends BaseFragment {

    private View mBaseView;
    private ChatLayout mChatLayout;
    private TitleBarLayout mTitleBar;
    private ChatInfo mChatInfo;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        Bundle bundle = getArguments();
        mChatInfo = (ChatInfo) bundle.getSerializable(Contants.CHAT_INFO);
        EventBus.getDefault().register(this);
        if (mChatInfo == null) {
            return null;
        }
        mBaseView = inflater.inflate(R.layout.chat_fragment_2, container, false);
        initView();
        return mBaseView;
    }

    private void initView() {
        //从布局文件中获取聊天面板组件
        mChatLayout = mBaseView.findViewById(R.id.chat_layout);
//        EventBus.getDefault().post(mChatLayout);
//        MessageLayout messageLayout = mChatLayout.getMessageLayout();
        // 设置自己聊天气泡的背景
//        messageLayout.setRightBubble(MyApplication.instance().getResources().getDrawable(R.drawable.chat_bg_right));
        // 设置朋友聊天气泡的背景
//        messageLayout.setLeftBubble(MyApplication.instance().getResources().getDrawable(R.drawable.chat_bg_left));

        // 设置头像圆角，不设置则默认不做圆角处理
//        messageLayout.setAvatarRadius(50);
        // 设置头像大小
//        messageLayout.setAvatarSize(new int[]{35, 35});

        //单聊组件的默认UI和交互初始化
        mChatLayout.initDefault();

        // TODO 通过api设置ChatLayout各种属性的样例
        ChatLayoutHelper helper = new ChatLayoutHelper(getActivity());
        helper.customizeChatLayout(mChatLayout);
//        ChatLayoutHelper.customizeChatLayout(getActivity(), mChatLayout);


        /*
         * 需要聊天的基本信息
         */
        mChatLayout.setChatInfo(mChatInfo);

        //获取单聊面板的标题栏
        mTitleBar = mChatLayout.getTitleBar();

        mTitleBar.setBackgroundColor(MyApplication.instance().getResources().getColor(R.color.white));
        mTitleBar.setLeftIcon(R.drawable.black_back);

        //单聊面板标记栏返回按钮点击事件，这里需要开发者自行控制
        mTitleBar.setRightIcon(R.drawable.dot_1);

        mTitleBar.setOnLeftClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().finish();
            }
        });
        if (mChatInfo.getType() == TIMConversationType.C2C) {
            mTitleBar.setOnRightClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(MyApplication.instance(), FriendProfileActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    intent.putExtra(TUIKitConstants.ProfileType.CONTENT, mChatInfo);
                    MyApplication.instance().startActivity(intent);
                }
            });
        }

        mChatLayout.getMessageLayout().setOnItemClickListener(new MessageLayout.OnItemClickListener() {
            @Override
            public void onMessageLongClick(View view, int position, MessageInfo messageInfo) {
                //因为adapter中第一条为加载条目，位置需减1
                mChatLayout.getMessageLayout().showItemPopMenu(position - 1, messageInfo, view);
            }

            @Override
            public void onUserIconClick(View view, int position, MessageInfo messageInfo) {
                if (null == messageInfo || null == messageInfo.getTIMMessage()) {
                    return;
                }
                ChatInfo info = new ChatInfo();
                info.setId(messageInfo.getTIMMessage().getSender());
                Intent intent = new Intent(MyApplication.instance(), FriendProfileActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.putExtra(TUIKitConstants.ProfileType.CONTENT, info);
                MyApplication.instance().startActivity(intent);
            }
        });

        InputLayout inputLayout = mChatLayout.getInputLayout();

//        inputLayout.replaceMoreInput(new CustomInputFragment());
        inputLayout.setBackgroundColor(MyApplication.instance().getResources().getColor(R.color.white));

        // 隐藏发送文件
//        inputLayout.disableSendFileAction(true);
        // 定义一个动作单元
//        InputMoreActionUnit unit = new InputMoreActionUnit();
//        unit.setIconResId(R.drawable.default_user_icon); // 设置单元的图标
//        unit.setTitleId(R.string.profile); // 设置单元的文字标题
//        unit.setOnClickListener(new View.OnClickListener() { // 定义点击事件
//            @Override
//            public void onClick(View v) {
//                ToastUtil.toastShortMessage("自定义的更多功能");
//                MessageInfo info = MessageInfoUtil.buildTextMessage("我是谁");
//                mChatLayout.sendMessage(info, false);
//            }
//        });
//// 把定义好的单元增加到更多面板
//        inputLayout.addAction(unit);
    }

    @Override
    public void onPause() {
        super.onPause();
        AudioPlayer.getInstance().stopPlayRecord();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mChatLayout.exitChat();
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void sendRedEnvelopr(ChatLayoutHelper.CustomMessageData customMessageData){
        Gson gson = new Gson();
        String data = gson.toJson(customMessageData);
        MessageInfo info = MessageInfoUtil.buildCustomMessage(data);
        Log.e("ChatFragment","data--->"+data);
        mChatLayout.sendMessage(info, false);
    }



}
