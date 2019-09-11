package com.sy.biquan.view;

public interface ILoginView extends IView {
    String getAccount();
    String getPassword();

    void onLoginSuccess();
    void onLoginFails();
}
