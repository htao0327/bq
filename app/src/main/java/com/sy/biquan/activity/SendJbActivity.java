package com.sy.biquan.activity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.github.lzyzsd.jsbridge.BridgeHandler;
import com.github.lzyzsd.jsbridge.BridgeWebView;
import com.github.lzyzsd.jsbridge.CallBackFunction;
import com.github.lzyzsd.jsbridge.DefaultHandler;
import com.google.gson.Gson;
import com.sy.biquan.Contants;
import com.sy.biquan.R;
import com.sy.biquan.bean.AddWalletBean;
import com.sy.biquan.bean.FBJBWebReturnBean;
import com.sy.biquan.util.SharedPreferencesUtil;
import com.tencent.qcloud.tim.uikit.utils.ToastUtil;


public class SendJbActivity extends AppCompatActivity {

    private BridgeWebView web;
    private RelativeLayout rlBack;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.send_jb_activity);
        web = findViewById(R.id.web);
        rlBack = findViewById(R.id.rl_back);
        rlBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        web.setDefaultHandler(new DefaultHandler());
        web.setWebChromeClient(new WebChromeClient());
        web.loadUrl("http://192.168.1.28:8080/bz/StartOrder.html");

        web.registerHandler("submitFromWeb", new BridgeHandler() {
            @Override
            public void handler(String data, CallBackFunction function) {
                Log.e("TAG", "js返回：" + data);
                //显示js传递给Android的消息
                Toast.makeText(SendJbActivity.this, "js返回:" + data, Toast.LENGTH_LONG).show();
                //Android返回给JS的消息
                function.onCallBack("1234"+SharedPreferencesUtil.getToken());
            }
        });

        web.setDefaultHandler(new DefaultHandler(){
            @Override
            public void handler(String data, CallBackFunction function) {
                Toast.makeText(SendJbActivity.this, data, Toast.LENGTH_SHORT).show();
                Gson gson = new Gson();
                FBJBWebReturnBean addWalletBean = gson.fromJson(data,FBJBWebReturnBean.class);
                if(addWalletBean.getCode() == Contants.GET_DATA_SUCCESS){
                    ToastUtil.toastLongMessage("发布成功");
                    finish();
                }else{
                    ToastUtil.toastLongMessage(addWalletBean.getMessage());
                }
            }
        });
        web.send(SharedPreferencesUtil.getToken(), new CallBackFunction() {
            @Override
            public void onCallBack(String data) {
//                      接收js的回调数据
                Toast.makeText(SendJbActivity.this, data, Toast.LENGTH_SHORT).show();
            }
        });
    }
}