package com.sy.biquan.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import com.google.gson.Gson;
import com.sy.biquan.Contants;
import com.sy.biquan.MyApplication;
import com.sy.biquan.activity.CreateKOLGroupActivity;
import com.sy.biquan.bean.LoginBean;
import com.sy.biquan.bean.MineDataBean;
import com.sy.biquan.bean.RegisterBean;
import com.sy.biquan.bean.UserInfo;
import com.tencent.imsdk.TIMCallBack;
import com.tencent.imsdk.TIMManager;
import com.tencent.qcloud.tim.uikit.TUIKit;

public class SharedPreferencesUtil {

    public static final int TYPE_INT = 1;
    public static final int TYPE_STRING = 2;
    public static final int TYPE_LONG = 3;
    public static final int TYPE_BOOLEAN = 4;
    public static final int TYPE_FLOAT = 5;
    private static final String USERINFO = "userInfo";//登录注册时存的用户信息


    public static void clearData(Context context){
        SharedPreferences sharedPreferences = context.getSharedPreferences(USERINFO, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.clear();
        editor.commit();
        TIMManager.getInstance().logout(new TIMCallBack() {
            @Override
            public void onError(int i, String s) {

            }

            @Override
            public void onSuccess() {
                Log.e("","IM退出成功");
            }
        });

    }

    public static void setUserinfo(UserInfo userinfo){
        Gson gson = new Gson();
        String str = gson.toJson(userinfo);
        userInfoPutString(MyApplication.instance(),Contants.USERINFO,str);
    }

    public static String getToken(){
        Gson gson = new Gson();
        String userInfoString = userInfoGetString(MyApplication.instance(), Contants.USERINFO);
        UserInfo user = gson.fromJson(userInfoString,UserInfo.class);
        return user.getToken();
    }

    public static UserInfo newGetUserInfo(){
        String userInfoStr = userInfoGetString(MyApplication.instance(),Contants.USERINFO);
        return new Gson().fromJson(userInfoStr,UserInfo.class);
    }


    public static boolean isLogin(){
        String userInfoStr = userInfoGetString(MyApplication.instance(),Contants.USERINFO);
        if(userInfoStr == null ){
            Log.e("SharedPreferencesUtil","未登录");
            return false;
        }else{
            Log.e("SharedPreferencesUtil","已 登录");
            return true;
        }
    }

    public static void setLoginUserInfo(RegisterBean registerBean){
        String userInfoStr = userInfoGetString(MyApplication.instance(),Contants.USERINFO);
        UserInfo userInfo;
        Gson gson = new Gson();
        if(userInfoStr == null || "".equals(userInfoStr)){
            userInfo = new UserInfo();
        }else{

            userInfo = gson.fromJson(userInfoStr,UserInfo.class);
        }
        userInfo.setUserAlias(registerBean.getData().getUserAlias());

        userInfo.setDealPassword(String.valueOf(registerBean.getData().getDeal_password()));
        userInfo.setFansCount(registerBean.getData().getFansCount());
        userInfo.setFollowCount(registerBean.getData().getFollowCount());
        userInfo.setHasInviteCode(registerBean.getData().getInviteCode());

        userInfo.setQbNumber(registerBean.getData().getAllScore());
        userInfo.setSlogan(registerBean.getData().getSlogan());
        userInfo.setToken(registerBean.getData().getToken());
        userInfo.setUserAvatar(registerBean.getData().getUserAvatar());
        userInfo.setUserImCode(registerBean.getData().getUserImCode());
        userInfo.setUserId(registerBean.getData().getId());
        userInfo.setUserPhone(registerBean.getData().getUserPhone());
        userInfo.setUserType(String.valueOf(registerBean.getData().getUserType()));
//        userInfo.setAuthStatus(registerBean.getData().get);
        //        userInfo.setInviteUserAlias(registerBean.getData().getIn);
//        userInfo.setInviteUserId(registerBean.getData().);

        String str = gson.toJson(userInfo);
        userInfoPutString(MyApplication.instance(),Contants.USERINFO,str);

    }

    public static void setMineUserInfo(MineDataBean mineDataBean){

        String userInfoStr = userInfoGetString(MyApplication.instance(),Contants.USERINFO);
        UserInfo userInfo;
        Gson gson = new Gson();
        if(userInfoStr == null || "".equals(userInfoStr)){
            userInfo = new UserInfo();
        }else{

            userInfo = gson.fromJson(userInfoStr,UserInfo.class);
        }
        userInfo.setUserAlias(mineDataBean.getData().getUserAlias());

        userInfo.setDealPassword(mineDataBean.getData().getDeal_password());
        userInfo.setFansCount(mineDataBean.getData().getFansCount());
        userInfo.setFollowCount(mineDataBean.getData().getFollowCount());
        userInfo.setHasInviteCode(mineDataBean.getData().getHasInviteCode());

        userInfo.setQbNumber(mineDataBean.getData().getQbNumber());
        userInfo.setSlogan(mineDataBean.getData().getSlogan());
        userInfo.setToken(mineDataBean.getData().getToken());
        userInfo.setUserAvatar(mineDataBean.getData().getUserAvatar());
        userInfo.setUserImCode(mineDataBean.getData().getUserImCode());
        userInfo.setUserId(mineDataBean.getData().getId());
        userInfo.setUserPhone(mineDataBean.getData().getUserPhone());
        userInfo.setUserType(mineDataBean.getData().getUserType());
        userInfo.setAuthStatus(mineDataBean.getData().getAuthStatus());
        userInfo.setInviteUserAlias(mineDataBean.getData().getInviteUserAlias());
        userInfo.setInviteUserId(mineDataBean.getData().getInviteUserId());

        String str = gson.toJson(userInfo);
        userInfoPutString(MyApplication.instance(),Contants.USERINFO,str);

    }


    public static String userInfoGetString(Context context,String key){
        SharedPreferences sharedPreferences = context.getSharedPreferences(USERINFO, Context.MODE_PRIVATE);//
        return sharedPreferences.getString(key, null);
    }
//
//    public static RegisterBean getUserInfo(){
//        Gson gson = new Gson();
//        String userInfoString = userInfoGetString(MyApplication.instance(), Contants.USERINFO);
//        return gson.fromJson(userInfoString,RegisterBean.class);
//    }
//    public static MineDataBean getUserInfo2(){
//        Gson gson = new Gson();
//        String userInfoString = userInfoGetString(MyApplication.instance(), Contants.USERINFO2);
//        return gson.fromJson(userInfoString,MineDataBean.class);
//    }

    public static boolean userInfoPutString(Context context,String key,String value){
        SharedPreferences sharedPreferences = context.getSharedPreferences(USERINFO, Context.MODE_PRIVATE);//
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(key,value);//写入String类型的数据
        return editor.commit();//提交
    }

//    public static boolean userInfoPutString2(Context context,String key,String value){
//        SharedPreferences sharedPreferences = context.getSharedPreferences(USERINFO, Context.MODE_PRIVATE);//
//        SharedPreferences.Editor editor = sharedPreferences.edit();
//        editor.putString(key,value);//写入String类型的数据
//        return editor.commit();//提交
//    }

    public static boolean userInfoPutInt(Context context,String key,int value){
        SharedPreferences sharedPreferences = context.getSharedPreferences(USERINFO, Context.MODE_PRIVATE);//
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(key,value);//写入Int类型的值
        return editor.commit();//提交
    }

    public static boolean userInfoPutBoolean(Context context,String key,boolean value){
        SharedPreferences sharedPreferences = context.getSharedPreferences(USERINFO, Context.MODE_PRIVATE);//
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean(key,value);//写入Boolean类型的值
        return editor.commit();//提交
    }

    public static boolean userInfoPutLong(Context context,String key,Long value){
        SharedPreferences sharedPreferences = context.getSharedPreferences(USERINFO, Context.MODE_PRIVATE);//
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putLong(key,value);//写入长整形
        return editor.commit();//提交
    }

    public static boolean userInfoPutFloat(Context context,String key,float value){
        SharedPreferences sharedPreferences = context.getSharedPreferences(USERINFO, Context.MODE_PRIVATE);//
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putFloat(key,value);//写入浮点型数据
        return editor.commit();//提交
    }



    public static int userInfoGetInt(Context context,String key){
        SharedPreferences sharedPreferences = context.getSharedPreferences(USERINFO, Context.MODE_PRIVATE);//
        return sharedPreferences.getInt(key, 0);
    }


}
