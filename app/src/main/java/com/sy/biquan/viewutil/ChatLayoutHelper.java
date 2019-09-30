package com.sy.biquan.viewutil;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.google.gson.Gson;
import com.sy.biquan.Contants;
import com.sy.biquan.MyApplication;
import com.sy.biquan.R;
import com.sy.biquan.activity.CheckDealInfoActivity;
import com.sy.biquan.activity.GiveRedEnvelope;
import com.sy.biquan.activity.LaunchDealActivity;
import com.sy.biquan.bean.DealBean;
import com.sy.biquan.bean.DealCheckBean;
import com.sy.biquan.bean.GetRedCheck;
import com.sy.biquan.bean.RegisterBean;
import com.sy.biquan.proxy.HttpCallback;
import com.sy.biquan.proxy.HttpProxy;
import com.sy.biquan.util.SharedPreferencesUtil;
import com.tencent.imsdk.TIMCustomElem;
import com.tencent.qcloud.tim.uikit.modules.chat.ChatLayout;
import com.tencent.qcloud.tim.uikit.modules.chat.layout.input.InputLayout;
import com.tencent.qcloud.tim.uikit.modules.chat.layout.inputmore.InputMoreActionUnit;
import com.tencent.qcloud.tim.uikit.modules.chat.layout.message.MessageLayout;
import com.tencent.qcloud.tim.uikit.modules.chat.layout.message.holder.ICustomMessageViewGroup;
import com.tencent.qcloud.tim.uikit.modules.chat.layout.message.holder.IOnCustomMessageDrawListener;
import com.tencent.qcloud.tim.uikit.modules.message.MessageInfo;

import org.greenrobot.eventbus.EventBus;

import java.util.HashMap;
import java.util.Map;

public class ChatLayoutHelper {

    private static final String TAG = ChatLayoutHelper.class.getSimpleName();
    public static Context context;
    public ChatLayoutHelper(Context context){
        this.context = context;

    }

    public void dealCharLayout(final ChatLayout layout){
        MessageLayout messageLayout = layout.getMessageLayout();
        messageLayout.setOnCustomMessageDrawListener(new DealMessageDraw());
        InputLayout inputLayout = layout.getInputLayout();
        InputMoreActionUnit unit = new InputMoreActionUnit();
        unit.setIconResId(R.drawable.deal_icon);
        unit.setTitleId(R.string.custom_message_jy);
        unit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Gson gson = new Gson();
//                CustomMessageData customMessageData = new CustomMessageData();
//                String data = gson.toJson(customMessageData);
//                MessageInfo info = MessageInfoUtil.buildCustomMessage(data);
//                layout.sendMessage(info, false);
//                MyApplication.instance().startActivity(new Intent(MyApplication.instance(), GiveRedEnvelope.class));
                Map<String,String> params = new HashMap<>();
                params.put("token",SharedPreferencesUtil.getToken());
                HttpProxy.obtain().post(Contants.URL + Contants.DEAL_CHECK, params, new HttpCallback<DealCheckBean>() {
                    @Override
                    public void onFailure(String e) {
                        Log.e("ChatLayoutHelper","onFailure"+e);
                    }

                    @Override
                    public void onSuccess(DealCheckBean dealCheckBean) {
                        Log.e("ChatLayoutHelper","onSuccess"+dealCheckBean);
                        if("n".equals(dealCheckBean.getData().getBullet_box())){//不弹窗，表示点击交易是在允许的时间内（9:00-18:00客服上班时间）
//                            if("y".equals(dealCheckBean.getData().getChecked_type()) && "y".equals(dealCheckBean.getData().getEth_address_type())){
//                            if("y".equals(dealCheckBean.getData().getEth_address_type())){
                                MyApplication.instance().startActivity(new Intent(MyApplication.instance(), LaunchDealActivity.class));
//                            }else {
//                                MyApplication.instance().startActivity(new Intent(MyApplication.instance(), CheckDealInfoActivity.class).putExtra(CheckDealInfoActivity.IDCARD_TYPE,dealCheckBean.getData().getChecked_type()).putExtra(CheckDealInfoActivity.WALLET_TYPE,dealCheckBean.getData().getEth_address_type()));
//                            }
                        }
                    }
                });

            }
        });
        inputLayout.addAction(unit);
    }

    public void customizeChatLayout(final ChatLayout layout) {
//        Log.e(TAG,"context==="+context);

//        //====== NoticeLayout使用范例 ======//
//        NoticeLayout noticeLayout = layout.getNoticeLayout();
//        noticeLayout.alwaysShow(true);
//        noticeLayout.getContent().setText("现在插播一条广告");
//        noticeLayout.getContentExtra().setText("参看有奖");
//        noticeLayout.setOnNoticeClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                ToastUtil.toastShortMessage("赏白银五千两");
//            }
//        });
//
        //====== MessageLayout使用范例 ======//
        MessageLayout messageLayout = layout.getMessageLayout();
//        ////// 设置聊天背景 //////
//        messageLayout.setBackground(new ColorDrawable(0xFFEFE5D4));
//        ////// 设置头像 //////
//        // 设置默认头像，默认与朋友与自己的头像相同
//        messageLayout.setAvatar(R.drawable.ic_more_file);
//        // 设置头像圆角
//        messageLayout.setAvatarRadius(50);
//        // 设置头像大小
//        messageLayout.setAvatarSize(new int[]{48, 48});
//
//        ////// 设置昵称样式（对方与自己的样式保持一致）//////
//        messageLayout.setNameFontSize(12);
//        messageLayout.setNameFontColor(0xFF8B5A2B);
//
//        ////// 设置气泡 ///////
//        // 设置自己聊天气泡的背景
//        messageLayout.setRightBubble(new ColorDrawable(0xFFCCE4FC));
//        // 设置朋友聊天气泡的背景
//        messageLayout.setLeftBubble(new ColorDrawable(0xFFE4E7EB));
//
//        ////// 设置聊天内容 //////
//        // 设置聊天内容字体字体大小，朋友和自己用一种字体大小
//        messageLayout.setChatContextFontSize(15);
//        // 设置自己聊天内容字体颜色
//        messageLayout.setRightChatContentFontColor(0xFFA9A9A9);
//        // 设置朋友聊天内容字体颜色
//        messageLayout.setLeftChatContentFontColor(0xFFA020F0);
//
//        ////// 设置聊天时间 //////
//        // 设置聊天时间线的背景
//        messageLayout.setChatTimeBubble(new ColorDrawable(0xFFE4E7EB));
//        // 设置聊天时间的字体大小
//        messageLayout.setChatTimeFontSize(12);
//        // 设置聊天时间的字体颜色
//        messageLayout.setChatTimeFontColor(0xFF7E848C);
//
//        ////// 设置聊天的提示信息 //////
//        // 设置提示的背景
//        messageLayout.setTipsMessageBubble(new ColorDrawable(0xFFE4E7EB));
//        // 设置提示的字体大小
//        messageLayout.setTipsMessageFontSize(12);
//        // 设置提示的字体颜色
//        messageLayout.setTipsMessageFontColor(0xFF7E848C);
//
        // 设置自定义的消息渲染时的回调
        messageLayout.setOnCustomMessageDrawListener(new CustomMessageDraw());
//
//        // 新增一个PopMenuAction
//        PopMenuAction action = new PopMenuAction();
//        action.setActionName("test");
//        action.setActionClickListener(new PopActionClickListener() {
//            @Override
//            public void onActionClick(int position, Object data) {
//                ToastUtil.toastShortMessage("新增一个pop action");
//            }
//        });
//        messageLayout.addPopAction(action);
//
//        final MessageLayout.OnItemClickListener l = messageLayout.getOnItemClickListener();
//        messageLayout.setOnItemClickListener(new MessageLayout.OnItemClickListener() {
//            @Override
//            public void onMessageLongClick(View view, int position, MessageInfo messageInfo) {
//                l.onMessageLongClick(view, position, messageInfo);
//                ToastUtil.toastShortMessage("demo中自定义长按item");
//            }
//
//            @Override
//            public void onUserIconClick(View view, int position, MessageInfo messageInfo) {
//                l.onUserIconClick(view, position, messageInfo);
//                ToastUtil.toastShortMessage("demo中自定义点击头像");
//            }
//        });


        //====== InputLayout使用范例 ======//
        InputLayout inputLayout = layout.getInputLayout();

//        // TODO 隐藏音频输入的入口，可以打开下面代码测试
//        inputLayout.disableAudioInput(true);
//        // TODO 隐藏表情输入的入口，可以打开下面代码测试
//        inputLayout.disableEmojiInput(true);
//        // TODO 隐藏更多功能的入口，可以打开下面代码测试
//        inputLayout.disableMoreInput(true);
//        // TODO 可以用自定义的事件来替换更多功能的入口，可以打开下面代码测试
//        inputLayout.replaceMoreInput(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                ToastUtil.toastShortMessage("自定义的更多功能按钮事件");
//                MessageInfo info = MessageInfoUtil.buildTextMessage("自定义的消息");
//                layout.sendMessage(info, false);
//            }
//        });
//        // TODO 可以用自定义的fragment来替换更多功能，可以打开下面代码测试
//        inputLayout.replaceMoreInput(new CustomInputFragment().setChatLayout(layout));
//
//        // TODO 可以disable更多面板上的各个功能，可以打开下面代码测试
//        inputLayout.disableCaptureAction(true);
//        inputLayout.disableSendFileAction(true);
//        inputLayout.disableSendPhotoAction(true);
//        inputLayout.disableVideoRecordAction(true);
        // TODO 可以自己增加一些功能，可以打开下面代码测试
        InputMoreActionUnit unit = new InputMoreActionUnit();
        unit.setIconResId(R.drawable.hb);
        unit.setTitleId(R.string.laoyao);
        unit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Gson gson = new Gson();
//                CustomMessageData customMessageData = new CustomMessageData();
//                String data = gson.toJson(customMessageData);
//                MessageInfo info = MessageInfoUtil.buildCustomMessage(data);
//                layout.sendMessage(info, false);
//                EventBus.getDefault().post(layout);
                MyApplication.instance().startActivity(new Intent(MyApplication.instance(), GiveRedEnvelope.class));

            }
        });
        inputLayout.addAction(unit);
    }

    /**
     * 自定义消息的bean实体，用来与json的相互转化
     */
    public static class CustomMessageData {
          private int type = 1;

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        private  int version = 1 ;
//        String text = "欢迎加入云通信IM大家庭！";
//        String link = "https://cloud.tencent.com/document/product/269/3794";

        public int getVersion() {
            return version;
        }

        public void setVersion(int version) {
            this.version = version;
        }

        /**
         * code : 200
         * message : ok
         * data : {"id":"1174987434899439618","userId":"1174940561761329154","receiverId":"","userName":null,"groupId":"","money":5,"congratulations":"","number":5,"remainNumber":5,"createTime":"2019-09-20 18:03:29","expire":0,"type":1}
         */

        private int code;
        private String message;
        private DataBean data;

        public int getCode() {
            return code;
        }

        public void setCode(int code) {
            this.code = code;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

        public DataBean getData() {
            return data;
        }

        public void setData(DataBean data) {
            this.data = data;
        }

        public static class DataBean {
            /**
             * id : 1174987434899439618
             * userId : 1174940561761329154
             * receiverId :
             * userName : null
             * groupId :
             * money : 5.0
             * congratulations :
             * number : 5
             * remainNumber : 5
             * createTime : 2019-09-20 18:03:29
             * expire : 0
             * type : 1
             */

            private String id;
            private String userId;
            private String receiverId;
            private Object userName;
            private String groupId;
            private double money;
            private String congratulations;
            private int number;
            private int remainNumber;
            private String createTime;
            private int expire;
            private int type;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getUserId() {
                return userId;
            }

            public void setUserId(String userId) {
                this.userId = userId;
            }

            public String getReceiverId() {
                return receiverId;
            }

            public void setReceiverId(String receiverId) {
                this.receiverId = receiverId;
            }

            public Object getUserName() {
                return userName;
            }

            public void setUserName(Object userName) {
                this.userName = userName;
            }

            public String getGroupId() {
                return groupId;
            }

            public void setGroupId(String groupId) {
                this.groupId = groupId;
            }

            public double getMoney() {
                return money;
            }

            public void setMoney(double money) {
                this.money = money;
            }

            public String getCongratulations() {
                return congratulations;
            }

            public void setCongratulations(String congratulations) {
                this.congratulations = congratulations;
            }

            public int getNumber() {
                return number;
            }

            public void setNumber(int number) {
                this.number = number;
            }

            public int getRemainNumber() {
                return remainNumber;
            }

            public void setRemainNumber(int remainNumber) {
                this.remainNumber = remainNumber;
            }

            public String getCreateTime() {
                return createTime;
            }

            public void setCreateTime(String createTime) {
                this.createTime = createTime;
            }

            public int getExpire() {
                return expire;
            }

            public void setExpire(int expire) {
                this.expire = expire;
            }

            public int getType() {
                return type;
            }

            public void setType(int type) {
                this.type = type;
            }
        }


    }

    public static class DealMessageDraw implements  IOnCustomMessageDrawListener{

        @Override
        public void onDraw(ICustomMessageViewGroup parent, MessageInfo info) {
            TIMCustomElem elem = (TIMCustomElem) info.getTIMMessage().getElement(0);
            final DealBean dealBean = new Gson().fromJson(new String(elem.getData()),DealBean.class);
            if(dealBean == null){
                return;
            }
            // 把自定义消息view添加到TUIKit内部的父容器里
            View view = LayoutInflater.from(MyApplication.instance()).inflate(R.layout.deal_message, null, false);
            parent.addMessageContentView(view);


        }
    }

    public static class CustomMessageDraw implements IOnCustomMessageDrawListener {
        private static AlertDialog dialog;
        /**
         * 自定义消息渲染时，会调用该方法，本方法实现了自定义消息的创建，以及交互逻辑
         * @param parent 自定义消息显示的父View，需要把创建的自定义消息view添加到parent里
         * @param info 消息的具体信息
         */
        @Override
        public void onDraw(ICustomMessageViewGroup parent, MessageInfo info) {
            // 获取到自定义消息的json数据
            TIMCustomElem elem = (TIMCustomElem) info.getTIMMessage().getElement(0);
            // 自定义的json数据，需要解析成bean实例
            final CustomMessageData customMessageData = new Gson().fromJson(new String(elem.getData()), CustomMessageData.class);
            if (customMessageData == null) {
//                DemoLog.e(TAG, "No Custom Data: " + new String(elem.getData()));
                return;
            }

            // 把自定义消息view添加到TUIKit内部的父容器里
            View view = LayoutInflater.from(MyApplication.instance()).inflate(R.layout.hb_item, null, false);
            parent.addMessageContentView(view);

            // 自定义消息view的实现，这里仅仅展示文本信息，并且实现超链接跳转
            TextView textView = view.findViewById(R.id.tv_text);
            if(customMessageData.getData()!=null){
                textView.setText(customMessageData.getData().getCongratulations());
            }
            view.setClickable(true);
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Log.e(TAG,"---------------------------------点击了");
                    Log.e(TAG,"context==="+context);
                    Gson gson = new Gson();
                    RegisterBean registerBean;
                    String gsonString = SharedPreferencesUtil.userInfoGetString(MyApplication.instance(),Contants.JSONUSERINFO);
                    registerBean = gson.fromJson(gsonString,RegisterBean.class);
                    Map<String,String> map = new HashMap<>();
                    map.put("token",registerBean.getData().getToken());
                    map.put("id",customMessageData.getData().id);
                    HttpProxy.obtain().post(Contants.URL + Contants.GETREDENVELOPE, map, new HttpCallback<GetRedCheck>() {
                        @Override
                        public void onFailure(String e) {

                        }

                        @Override
                        public void onSuccess(GetRedCheck getRedCheck) {
                            if(getRedCheck.getCode() == Contants.GET_DATA_SUCCESS){
                                boolean isMe = getRedCheck.getData().isIsMe();
                                boolean hasRedPack = getRedCheck.getData().isHasRedPack();
                                boolean isExpire = getRedCheck.getData().isIsExpire();
                                boolean allowRob = getRedCheck.getData().isAllowRob();

                                if(allowRob){//没抢过，允许抢红包
                                    DialogUtil.showRedEnvelopesDialog(context, isMe, hasRedPack, isExpire, new DialogUtil.AlertDialogBtnClickListener() {
                                        @Override
                                        public void clickPositive() {

                                        }

                                        @Override
                                        public void clickNegative() {

                                        }
                                    });
                                }else {//已经抢过了，直接进红包详情页

                                }

                            }

                        }
                    });

                }
            });
        }
    }

}
