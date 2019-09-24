package com.sy.biquan.activity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.Gson;
import com.sy.biquan.Contants;
import com.sy.biquan.R;
import com.sy.biquan.bean.RedEnvelopeBean;
import com.sy.biquan.bean.RegisterBean;
import com.sy.biquan.proxy.HttpCallback;
import com.sy.biquan.proxy.HttpProxy;
import com.sy.biquan.util.SharedPreferencesUtil;
import com.sy.biquan.viewutil.ChatLayoutHelper;
import com.tencent.qcloud.tim.uikit.modules.chat.ChatLayout;
import com.tencent.qcloud.tim.uikit.modules.message.MessageInfo;
import com.tencent.qcloud.tim.uikit.modules.message.MessageInfoUtil;
import com.tencent.qcloud.tim.uikit.utils.ToastUtil;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.HashMap;
import java.util.Map;

public class GiveRedEnvelope extends AppCompatActivity implements View.OnClickListener {
    private Button btn_luck,btn_normal,btn_send;
    private EditText et_people,et_money,et_text;
    private String TYPE = "1";
    ChatLayout chatLayout;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        EventBus.getDefault().register(this);
        setContentView(R.layout.activity_send_group_money);
        initView();

        btn_normal.setOnClickListener(this);
        btn_luck.setOnClickListener(this);
        btn_send.setOnClickListener(this);
        et_money.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }
    private void initView(){
        btn_luck = findViewById(R.id.btn_send_money_luck);
        btn_normal = findViewById(R.id.btn_send_money_normal);
        btn_send = findViewById(R.id.btn_send);
        et_people = findViewById(R.id.et_people);
        et_money = findViewById(R.id.et_money);
        et_text = findViewById(R.id.et_text);
    }

    @Override
    public void onClick(View view) {
        if(view == btn_luck){
            ToastUtil.toastLongMessage("btn_luck");
            btn_luck.setBackground(getResources().getDrawable(R.drawable.btn_money_bg));
            btn_luck.setTextColor(getResources().getColor(R.color.white));
            btn_normal.setBackground(null);
            btn_normal.setTextColor(getResources().getColor(R.color.colorLoginTitle));
            TYPE = "1";
        }else if(view == btn_normal){
            ToastUtil.toastLongMessage("btn_normal");
            btn_normal.setBackground(getResources().getDrawable(R.drawable.btn_money_bg));
            btn_luck.setTextColor(getResources().getColor(R.color.colorLoginTitle));
            btn_normal.setTextColor(getResources().getColor(R.color.white));
            btn_luck.setBackground(null);
            TYPE = "2";
        }else if(view == btn_send){
            Gson gson = new Gson();
            RegisterBean registerBean;
            String gsonString = SharedPreferencesUtil.userInfoGetString(this,Contants.JSONUSERINFO);
            registerBean = gson.fromJson(gsonString,RegisterBean.class);
            ToastUtil.toastLongMessage("btn_send");
            Map<String,String> params = new HashMap<>();
            params.put("groupId","");
            params.put("money",et_money.getText().toString());
            if(et_text.getText() == null || "".equals(et_text.getText().toString())){
                params.put("congratulations","每日一赏");
            }else {
                params.put("congratulations",et_text.getText().toString());
            }

            params.put("number",et_people.getText().toString());
            params.put("type",TYPE);
            Log.e("GiveRedEnvelope","-----"+registerBean.getData().getToken());
            params.put("token",registerBean.getData().getToken());

            HttpProxy.obtain().post(Contants.URL + Contants.SENDREDENVELOPE, params, new HttpCallback<ChatLayoutHelper.CustomMessageData>() {
                @Override
                public void onFailure(String e) {
                    Log.e("GiveRedEnvelope","onFailure"+e);
                }

                @Override
                public void onSuccess(ChatLayoutHelper.CustomMessageData redEnvelopeBean) {
                    Log.e("GiveRedEnvelope","onSuccess"+redEnvelopeBean.toString());
                    if(redEnvelopeBean.getCode() == Contants.GET_DATA_SUCCESS){

                        ChatLayoutHelper.CustomMessageData customMessageData = redEnvelopeBean;
                        customMessageData.setVersion(1);
                        customMessageData.setType(1);
                        EventBus.getDefault().post(customMessageData);

                        finish();
                    }else {
                        ToastUtil.toastLongMessage(redEnvelopeBean.getMessage());
                    }
                }
            });
        }
    }

//    @Subscribe(threadMode = ThreadMode.MAIN)
//    public void sendRedEnvelopr(ChatLayout mChatLayout){
//        Log.e("GiveRedEnvelope","-=-==-=-=-=-=================================-------sendRedEnvelopr");
//        chatLayout = mChatLayout;
//    }

    @Override
    protected void onPause() {
        super.onPause();
//        EventBus.getDefault().unregister(this);
    }
}
