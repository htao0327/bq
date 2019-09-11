package com.sy.biquan.model;

import com.sy.biquan.model.lisentener.LoginLisentener;

public class LoginModel implements IModel {

    String ac = "18358108782";
    String pwd = "123456";
    public void login(String username, String password, LoginLisentener lisentener) {
        if (lisentener == null) {
            return;
        }
        //验证用户名和密码
        if (ac.equals(username)){
            lisentener.onSuccess();
        } else {
            lisentener.onFails();
        }
    }
}
