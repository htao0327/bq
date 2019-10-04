package com.sy.biquan.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.sy.biquan.MyApplication;
import com.sy.biquan.R;
import com.sy.biquan.menu.Menu;
import com.tencent.qcloud.tim.uikit.modules.contact.ContactItemBean;
import com.tencent.qcloud.tim.uikit.modules.contact.ContactLayout;
import com.tencent.qcloud.tim.uikit.modules.contact.ContactListView;
import com.tencent.qcloud.tim.uikit.utils.TUIKitConstants;

public class ContactActivity extends AppCompatActivity {
    private static final String TAG = ContactActivity.class.getSimpleName();
    private ContactLayout mContactLayout;
    private Menu mMenu;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.contact_fragment);
        initViews();
    }

    private void initViews() {
        // 从布局文件中获取通讯录面板
        mContactLayout = findViewById(R.id.contact_layout);
        mMenu = new Menu(this, mContactLayout.getTitleBar(), Menu.MENU_TYPE_CONTACT);
        mContactLayout.getTitleBar().setOnRightClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mMenu.isShowing()) {
                    mMenu.hide();
                } else {
                    mMenu.show();
                }
            }
        });
        mContactLayout.getContactListView().setOnItemClickListener(new ContactListView.OnItemClickListener() {
            @Override
            public void onItemClick(int position, ContactItemBean contact) {
                if (position == 0) {
                    Intent intent = new Intent(ContactActivity.this, NewFriendActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    ContactActivity.this.startActivity(intent);
                } else if (position == 1) {
                    Intent intent = new Intent(ContactActivity.this, GroupListActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    ContactActivity.this.startActivity(intent);
                }
//                else if (position == 2) {
//                    Intent intent = new Intent(ContactActivity.this, BlackListActivity.class);
//                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//                    ContactActivity.this.startActivity(intent);
//                }
                else {
                    Intent intent = new Intent(ContactActivity.this, FriendProfileActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    intent.putExtra(TUIKitConstants.ProfileType.CONTENT, contact);
                    ContactActivity.this.startActivity(intent);
                }
            }
        });
    }

    private void refreshData() {
        // 通讯录面板的默认UI和交互初始化
        mContactLayout.initDefault();
    }

    @Override
    public void onResume() {
        super.onResume();
//        DemoLog.i(TAG, "onResume");
        refreshData();
    }
}
