package com.sy.biquan.model;

import android.util.Log;

import com.sy.biquan.Contants;
import com.sy.biquan.bean.LoginBean;
import com.sy.biquan.model.lisentener.LoginLisentener;
import com.sy.biquan.proxy.HttpCallback;
import com.sy.biquan.proxy.HttpProxy;
import com.tencent.qcloud.tim.uikit.TUIKit;
import com.tencent.qcloud.tim.uikit.utils.ToastUtil;

import java.util.HashMap;
import java.util.Map;

public class LoginModel implements IModel {

    String ac = "18358108782";
    String pwd = "123456";
    public void login(String username, String password, final LoginLisentener lisentener) {
        if (lisentener == null) {
            return;
        }
        Map<String,String> params = new HashMap<>();
        params.put("phone",username);
        params.put("password",password);
        HttpProxy.obtain().post(Contants.MYURL + Contants.LOGIN, params, new HttpCallback<LoginBean>() {
            @Override
            public void onFailure(String e) {
                Log.e("LoginModel", "onFailure: " + e);
                lisentener.onFails();
            }

            @Override
            public void onSuccess(LoginBean loginBean) {
                Log.e("LoginModel", "Network result：" + loginBean.toString());
                if(loginBean.getCode() == 200){//数据正常
                    lisentener.onSuccess();

                }else {//数据异常
//                    Log.e(TAG, "Network result：" + "连接服务器失败" );
                    lisentener.onFails();
                }
            }
        });
        //验证用户名和密码
        if (ac.equals(username)){
            lisentener.onSuccess();

        } else {
            lisentener.onFails();
        }
    }


}
