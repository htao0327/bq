package com.sy.biquan.model;

import com.sy.biquan.Contants;
import com.sy.biquan.model.lisentener.NetLisentener;

public class RegisterModel implements IModel {

    public void getYzm(String phone, NetLisentener lisentener){
        if(lisentener == null){
            return;
        }
        if(true){
            lisentener.onSuccess();
        }else {
            lisentener.onFails();
        }
    }

    /**
     * 点击下一步按钮请求网络
     * @param phone
     * @param yzm
     * @param password
     */
    public void next(String phone,String yzm,String password){

    }

    /**
     * @param phone
     * @param yzm
     * @param password
     * @return 0表示验证通过
     */
    public int check(String phone,String yzm,String password){
        if(phone.length()<11){
            return Contants.PHONE_NUM_INPUT_ERROR;
        }else if(yzm.length()<6){
            return Contants.YZM_NUM_INPUT_ERROR;
        }else if(password.length()<6 || password.length()>20){
            return Contants.PASSWORD_INPUT_ERROR;
        }else {
            return  Contants.CHECK_OK;
        }
    }

    public boolean btnPromitClick(String phone,String yzm,String password){
//        if(phone == null || "".equals(phone) || yzm == null || "".equals(yzm) || password== null || "".equals(password)){
//            return false;
//        }else {
//            return true;
//        }
        return !(phone == null || "".equals(phone) || yzm == null || "".equals(yzm) || password== null || "".equals(password));
    }
}
