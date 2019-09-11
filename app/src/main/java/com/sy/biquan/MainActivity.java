package com.sy.biquan;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.sy.biquan.util.GenerateTestUserSig;
import com.sy.biquan.view.fragment.ChatFragment;
import com.sy.biquan.view.fragment.CustomerServiceFragment;
import com.sy.biquan.view.fragment.MainFragment;
import com.sy.biquan.view.fragment.MineFragment;
import com.sy.biquan.view.fragment.MyTaskFragment;
import com.sy.biquan.viewutil.BottomNavigationViewHelper;
import com.tencent.qcloud.tim.uikit.TUIKit;
import com.tencent.qcloud.tim.uikit.base.IUIKitCallBack;
import com.tencent.qcloud.tim.uikit.utils.ToastUtil;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView bottomNavigationView;
    private List<Fragment> fragments;
    private int lastIndex;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initData();
        initBottomNavigation();
        String account = "123";
        String userSig = GenerateTestUserSig.genTestUserSig(account);
        TUIKit.login(account, userSig, new IUIKitCallBack() {
            @Override
            public void onError(String module, final int code, final String desc) {
                runOnUiThread(new Runnable() {
                    public void run() {
                        ToastUtil.toastLongMessage("登录失败, errCode = " + code + ", errInfo = " + desc);
                    }
                });
            }

            @Override
            public void onSuccess(Object data) {

            }
        });
    }

    private void initView(){
        bottomNavigationView = findViewById(R.id.main_bottom_navigation);
    }

    private void initData(){
        fragments = new ArrayList<>();
        fragments.add(new MainFragment());
        fragments.add(new ChatFragment());
        fragments.add(new CustomerServiceFragment());
        fragments.add(new MyTaskFragment());
        fragments.add(new MineFragment());
        setFragmentPosition(0);
    }

    private void setFragmentPosition(int position) {
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        Fragment currentFragment = fragments.get(position);
        Fragment lastFragment = fragments.get(lastIndex);
        lastIndex = position;
        ft.hide(lastFragment);
        if (!currentFragment.isAdded()) {
            getSupportFragmentManager().beginTransaction().remove(currentFragment).commit();
            ft.add(R.id.ll_frameLayout, currentFragment);
        }
        ft.show(currentFragment);
        ft.commitAllowingStateLoss();
    }

    public void initBottomNavigation() {
        // 解决当item大于三个时，非平均布局问题
        BottomNavigationViewHelper.disableShiftMode(bottomNavigationView);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.navigation_home:
                        setFragmentPosition(0);
                        break;
                    case R.id.navigation_chat:
                        setFragmentPosition(1);
                        break;
                    case R.id.navigation_cus:
                        setFragmentPosition(2);
                        break;
                    case R.id.navigation_task:
                        setFragmentPosition(3);
                        break;
                    case R.id.navigation_user:
                        setFragmentPosition(4);
                        break;
                    default:
                        break;
                }
                // 这里注意返回true,否则点击失效
                return true;
            }
        });
    }


}
