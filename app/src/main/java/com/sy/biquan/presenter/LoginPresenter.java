package com.sy.biquan.presenter;

import android.content.Context;
import android.content.Intent;

import com.sy.biquan.activity.RegisterActivity;
import com.sy.biquan.activity.ResetPwd;
import com.sy.biquan.model.LoginModel;
import com.sy.biquan.model.lisentener.LoginLisentener;
import com.sy.biquan.view.ILoginView;
import com.sy.biquan.view.IView;

import java.lang.ref.WeakReference;

public class LoginPresenter extends PresenterFather {
    public  LoginPresenter(ILoginView loginView) {
        this.iModel = new LoginModel();
        this.iViewReference = new WeakReference<IView>(loginView);
    }
    public void login(){
        if (iModel != null && iViewReference != null && iViewReference.get() != null) {

            ILoginView loginView = (ILoginView) iViewReference.get();
            String name = loginView.getAccount();
            String passWord = loginView.getPassword();
            loginView = null;
            //此时LoginListener作为匿名内部类是持有外部类的引用的。
            ((LoginModel)iModel).login(name, passWord, new LoginLisentener() {
                @Override
                public void onSuccess() {
                    if (iViewReference.get() != null) {
                        ((ILoginView)iViewReference.get()).onLoginSuccess();
                    }
                }

                @Override
                public void onFails() {
                    if (iViewReference.get() != null) {
                        if (iViewReference.get() != null) {
                            ((ILoginView)iViewReference.get()).onLoginFails();
                        }
                    }
                }
            });
        }
    }

    public void goToRegister(Context context){
        context.startActivity(new Intent(context, RegisterActivity.class));
    }
    public void goToFindPwd(Context context){
        context.startActivity(new Intent(context, ResetPwd.class));
    }
}
