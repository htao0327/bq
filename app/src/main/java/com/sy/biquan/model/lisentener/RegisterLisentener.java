package com.sy.biquan.model.lisentener;

import com.sy.biquan.model.IModel;

public interface RegisterLisentener extends IModel {

    void onGetYzmSuccess();
    void onGetYzmFails();
    void onCheckPhone();


}
