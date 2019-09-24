package com.sy.biquan.proxy;

import java.util.Map;

/**
 * @package com.xiangxue.alvin.proxymodel.proxy
 * @fileName IHttp
 * @date on 2018/10/18
 * @qq 2464061231
 **/

//行为规范的接口,表示代理类能代理什么事
public interface IHttp {
    // post
    public void post(String url, Map<String, String> params, ICallBack callback);

    // get
    public void get(String url, Map<String, String> params, ICallBack callback);

    // down

    // upload
}
