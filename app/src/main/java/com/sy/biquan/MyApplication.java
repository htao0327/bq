package com.sy.biquan;

import android.app.Application;
import android.content.Intent;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.sy.biquan.proxy.HttpProxy;
import com.sy.biquan.proxy.OkHttpModel;
import com.sy.biquan.util.MVPConfig;
import com.tencent.imsdk.TIMSdkConfig;
import com.tencent.qcloud.tim.uikit.TUIKit;
import com.tencent.qcloud.tim.uikit.base.IUIKitCallBack;
import com.tencent.qcloud.tim.uikit.config.CustomFaceConfig;
import com.tencent.qcloud.tim.uikit.config.GeneralConfig;
import com.tencent.qcloud.tim.uikit.config.TUIKitConfigs;
import com.tencent.qcloud.tim.uikit.utils.ToastUtil;

public class MyApplication extends Application {
    private static MyApplication instance;
    @Override
    public void onCreate() {
        super.onCreate();
        MVPConfig.setToolbarDrawable(R.color.black);
        MVPConfig.setStatusbarDrawable(R.color.white);
        MVPConfig.setBackDrawable(R.drawable.back);
        MVPConfig.setIsStatusBarLight(true);
        // 配置 Config，请按需配置
        TUIKitConfigs configs = TUIKit.getConfigs();
        configs.setSdkConfig(new TIMSdkConfig(Contants.SDKAppID));
        configs.setCustomFaceConfig(new CustomFaceConfig());
        configs.setGeneralConfig(new GeneralConfig());

        TUIKit.init(this, Contants.SDKAppID, configs);
        Fresco.initialize(this);


        //设置网络请求库
        //        HttpProxy.init(VolleyModel.getInstance(getApplicationContext()));
        HttpProxy.init(new OkHttpModel(getApplicationContext()));
        instance = this;
    }


    public static MyApplication instance() {
        return instance;
    }

//    private void initOSS() {
//        String endpoint = "http://oss-cn-beijing.aliyuncs.com";
//        //推荐使用OSSAuthCredentialsProvider。token过期可以及时更新
//        OSSCredentialProvider credentialProvider = new OSSPlainTextAKSKCredentialProvider("LTAIwDPRYdxM2vyz", "qK2Bwfa4i8me1wMc6BIIyA8nlajz5I");
//        //该配置类如果不设置，会有默认配置，具体可看该类
//        ClientConfiguration conf = new ClientConfiguration();
//        conf.setConnectionTimeout(15 * 1000); // 连接超时，默认15秒
//        conf.setSocketTimeout(15 * 1000); // socket超时，默认15秒
//        conf.setMaxConcurrentRequest(5); // 最大并发请求数，默认5个
//        conf.setMaxErrorRetry(2); // 失败后最大重试次数，默认2次
//        mOss = new OSSClient(getApplicationContext(), endpoint, credentialProvider);
//        if (isDebug) {
//            OSSLog.enableLog();
//        }
//    }



}
