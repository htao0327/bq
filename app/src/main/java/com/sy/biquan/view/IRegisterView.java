package com.sy.biquan.view;

public interface IRegisterView extends IView {
    String getAccount();
    String getYzm();
    String getPwd();

    void onGetYzmSuccess();
    void onGetYzmFails();

    void onRegisterSuccess();
    void onRegisterFails();
}
