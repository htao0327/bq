package com.sy.biquan.activity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Looper;
import android.os.MessageQueue;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.sy.biquan.util.MVPConfig;

public class BaseActivity extends AppCompatActivity {
    private View statusBarView;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setStatusBarFullTransparent();
        //延时加载数据.
        Looper.myQueue().addIdleHandler(new MessageQueue.IdleHandler() {
            @Override
            public boolean queueIdle() {
                if (isStatusBar()) {
                    initStatusBar();
                    getWindow().getDecorView().addOnLayoutChangeListener(new View.OnLayoutChangeListener() {
                        @Override
                        public void onLayoutChange(View v, int left, int top, int right, int bottom, int oldLeft, int oldTop, int oldRight, int oldBottom) {
                            initStatusBar();
                        }
                    });
                }
                //只走一次
                return false;
            }
        });
    }

    private void initStatusBar() {
        if (statusBarView == null) {
            int identifier = getResources().getIdentifier("statusBarBackground", "id", "android");
            statusBarView = getWindow().findViewById(identifier);
        }
        if (statusBarView != null) {
            if (isStatusBarLight()) {
                statusBarView.setBackgroundDrawable(null);
            }
            statusBarView.setBackgroundResource(MVPConfig.statusDrawable);
        }
    }
    //子类通过复写该方法,控制是否改变statusbar
    protected boolean isStatusBar() {
        return MVPConfig.isStatusBar();
    }
    //子类通过复写该方法,控制是否需要改变statusbar字体颜色
    protected boolean isStatusBarLight() {
        return MVPConfig.isStatusBarLight;
    }
//    /**
//     * 全透状态栏
//     */
//    protected void setStatusBarFullTransparent() {
//        if (Build.VERSION.SDK_INT >= 21) {//21表示5.0
//            Window window = getWindow();
//            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
//            window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
//                    | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
//            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
//            window.setStatusBarColor(Color.TRANSPARENT);
//        } else if (Build.VERSION.SDK_INT >= 19) {//19表示4.4
//            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
//            //虚拟键盘也透明
//            //getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
//        }
//        View decor = this.getWindow().getDecorView();
////            decor.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
//            decor.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
//    }

}
