package com.sy.biquan.proxy;

import com.google.gson.Gson;
import com.tencent.qcloud.tim.uikit.utils.ToastUtil;

/**
 * Created by Administrator on 2017/5/23.
 */

public abstract class HttpCallback<Result> implements ICallBack{

    @Override
    public void onSuccess(String result) {
        Gson gson = new Gson();
        Class<?> cls = HttpHelper.analysisClazzInfo(this);
        try{
            Result objResult = (Result) gson.fromJson(result,cls);
            onSuccess(objResult);
        }catch (Exception e){
            ToastUtil.toastLongMessage("数据格式错误");
        }

    }

    public abstract void onSuccess(Result result);



}
