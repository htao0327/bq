package com.sy.biquan.presenter;

import android.content.Context;
import android.widget.Toast;

import com.sy.biquan.Contants;
import com.sy.biquan.model.RegisterModel;
import com.sy.biquan.view.IRegisterView;
import com.sy.biquan.view.IView;

import java.lang.ref.WeakReference;

public class RegisterPresenter extends PresenterFather {
    public RegisterPresenter(IRegisterView registerView){
        this.iModel = new RegisterModel();
        this.iViewReference = new WeakReference<IView>(registerView);
    }

    public void register(){

    }

    public void check(Context context){
        IRegisterView registerView = (IRegisterView) iViewReference.get();
        String phone = registerView.getAccount();
        String yzm = registerView.getYzm();
        String password = registerView.getPwd();
        if(((RegisterModel)iModel).check(phone,yzm,password) == Contants.PHONE_NUM_INPUT_ERROR){
            Toast.makeText(context,"手机号码格式不正确",Toast.LENGTH_LONG).show();
        }else if(((RegisterModel)iModel).check(phone,yzm,password) == Contants.YZM_NUM_INPUT_ERROR){
            Toast.makeText(context,"验证码格式不正确",Toast.LENGTH_LONG).show();
        }else if(((RegisterModel)iModel).check(phone,yzm,password) == Contants.PASSWORD_INPUT_ERROR){
            Toast.makeText(context,"密码不正确",Toast.LENGTH_LONG).show();
        }else{

        }
    }


}
