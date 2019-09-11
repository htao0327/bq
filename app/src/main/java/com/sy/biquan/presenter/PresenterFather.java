package com.sy.biquan.presenter;

import com.sy.biquan.model.IModel;
import com.sy.biquan.view.IView;

import java.lang.ref.WeakReference;

public class PresenterFather {

    protected IModel iModel;

    protected WeakReference<IView> iViewReference;
}
