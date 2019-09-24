package com.sy.biquan.util;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;
import com.sy.biquan.Contants;
import com.sy.biquan.MyApplication;
import com.sy.biquan.activity.CreateKOLGroupActivity;
import com.sy.biquan.bean.RegisterBean;

public class SharedPreferencesUtil {

    public static final int TYPE_INT = 1;
    public static final int TYPE_STRING = 2;
    public static final int TYPE_LONG = 3;
    public static final int TYPE_BOOLEAN = 4;
    public static final int TYPE_FLOAT = 5;
    private static final String USERINFO = "userInfo";

    public static String getToken(){
        Gson gson = new Gson();
        String userInfoString = userInfoGetString(MyApplication.instance(), Contants.USERINFO);
        RegisterBean user = gson.fromJson(userInfoString,RegisterBean.class);
        return user.getData().getToken();
    }

    public static RegisterBean getUserInfo(){
        Gson gson = new Gson();
        String userInfoString = userInfoGetString(MyApplication.instance(), Contants.USERINFO);
        return gson.fromJson(userInfoString,RegisterBean.class);
    }

    public static boolean userInfoPutString(Context context,String key,String value){
        SharedPreferences sharedPreferences = context.getSharedPreferences(USERINFO, Context.MODE_PRIVATE);//
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(key,value);//写入String类型的数据
//        editor.putInt("int", 3);//写入Int类型的值
//        editor.putLong("Long",1000000);//写入长整形
//        editor.putBoolean("boolean", true);//写入Boolean类型的值
//        editor.putFloat("Float",3.5f);//写入浮点型数据

        return editor.commit();//提交
    }

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

    public static String userInfoGetString(Context context,String key){
        SharedPreferences sharedPreferences = context.getSharedPreferences(USERINFO, Context.MODE_PRIVATE);//
        return sharedPreferences.getString(key, null);
    }

    public static int userInfoGetInt(Context context,String key){
        SharedPreferences sharedPreferences = context.getSharedPreferences(USERINFO, Context.MODE_PRIVATE);//
        return sharedPreferences.getInt(key, 0);
    }


}
