package com.sy.biquan.proxy;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.util.Log;

import com.google.gson.Gson;
import com.sy.biquan.MyApplication;
import com.sy.biquan.activity.BaseActivity;
import com.sy.biquan.viewutil.DialogUtil;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.HttpUrl;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okio.BufferedSink;

/**
 * @package com.xiangxue.alvin.proxymodel.proxy
 * @fileName OkHttpModel
 **/

//必须实现统一的被代理的行为规范
public class OkHttpModel implements IHttp {
    private static final String TAG = "OkHttpModel";

    private OkHttpClient mOkHttpClient;
    private Handler myHandler;

    public OkHttpModel(Context context) {
        mOkHttpClient = new OkHttpClient();
        myHandler = new Handler();
    }

    /**
     * post的请求参数，构造RequestBody
     * @param BodyParams
     * @return
     */
    private RequestBody setRequestBody(Map<String, String> BodyParams){

//
        Gson gson = new Gson();

        RequestBody body=null;
        okhttp3.FormBody.Builder formEncodingBuilder=new okhttp3.FormBody.Builder();
        if(BodyParams != null){
            Iterator<String> iterator = BodyParams.keySet().iterator();
            String key = "";
            while (iterator.hasNext()) {
                key = iterator.next().toString();
                formEncodingBuilder.add(key, BodyParams.get(key));
                Log.d("post http", "post_Params==="+key+"===="+BodyParams.get(key));
            }
        }
        body=formEncodingBuilder.build();
        return body;


    }

    @Override
    //真正干活的地方，服务提供方法
    public void post(String url, Map<String, String> params,final ICallBack callback) {
//        RequestBody body=setRequestBody(params);
        //2 构造Request
//        DialogUtil.showNetDialog(BaseActivity.getCurrentActivity());
        Request.Builder requestBuilder = new Request.Builder();
//        Request request = requestBuilder.post(body).addHeader("Content-Type","application/json").url(url).build();
        Gson gson = new Gson();
        String mBody = gson.toJson(params);
        MediaType MEDIA_TYPE_TEXT = MediaType.parse("application/json");
        Request request = requestBuilder.post(RequestBody.create(MEDIA_TYPE_TEXT, mBody)).url(url).build();
        //3 将Request封装为Call
        Call call = mOkHttpClient.newCall(request);
        //4 执行Call
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                DialogUtil.dismissDialog();
                callback.onFailure(e.toString());
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
//                DialogUtil.dismissDialog();
                if (response.isSuccessful()) {
                    final String result = response.body().string();
                    myHandler.post(new Runnable() {
                        @Override
                        public void run() {
                            Log.d(TAG, "run: " + result);
                            callback.onSuccess(result);
                        }
                    });
                } else {
                    callback.onFailure(response.message().toString());
                }

            }
        });
    }

    @Override
    //真正干活的地方，服务提供方法
    public void get(String url, Map<String, String> params, final ICallBack callback) {
        HttpUrl.Builder urlBuilder =HttpUrl.parse(url)
                .newBuilder();
//        Iterator<String> iterator = params.keySet().iterator();
//        String key = "";
//        while (iterator.hasNext()) {
//            key = iterator.next().toString();
////            formEncodingBuilder.add(key, BodyParams.get(key));
//            urlBuilder.addQueryParameter(key,params.get(key).toString());
//            Log.e("post http", "post_Params==="+key+"===="+params.get(key).toString());
//        }
//
        final Request request = new Request.Builder()
                .url(urlBuilder.build())
                .addHeader("User-Agent", "Zh")
                .build();
        mOkHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                callback.onFailure(e.toString());
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if (response.isSuccessful()) {
                    final String result = response.body().string();
                    myHandler.post(new Runnable() {
                        @Override
                        public void run() {
                            Log.d(TAG, "run: " + result);
                            callback.onSuccess(result);
                        }
                    });
                } else {
                    callback.onFailure(response.message().toString());
                }
            }
        });
    }
}
