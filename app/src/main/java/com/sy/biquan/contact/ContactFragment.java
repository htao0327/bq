package com.sy.biquan.contact;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sy.biquan.MyApplication;
import com.sy.biquan.R;
import com.sy.biquan.activity.FriendProfileActivity;
import com.sy.biquan.activity.GroupListActivity;
import com.sy.biquan.activity.NewFriendActivity;
import com.sy.biquan.menu.Menu;
import com.tencent.qcloud.tim.uikit.base.BaseFragment;
import com.tencent.qcloud.tim.uikit.component.TitleBarLayout;
import com.tencent.qcloud.tim.uikit.modules.contact.ContactItemBean;
import com.tencent.qcloud.tim.uikit.modules.contact.ContactLayout;
import com.tencent.qcloud.tim.uikit.modules.contact.ContactListView;
import com.tencent.qcloud.tim.uikit.utils.TUIKitConstants;

public class ContactFragment extends BaseFragment {
    private static final String TAG = ContactFragment.class.getSimpleName();
    private ContactLayout mContactLayout;
    private Menu mMenu;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View baseView = inflater.inflate(R.layout.contact_fragment, container, false);
        initViews(baseView);

        return baseView;
    }

    private void initViews(View view) {
        // 从布局文件中获取通讯录面板
        mContactLayout = view.findViewById(R.id.contact_layout);
        mMenu = new Menu(getActivity(), mContactLayout.getTitleBar(), Menu.MENU_TYPE_CONTACT);
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
                    Intent intent = new Intent(MyApplication.instance(), NewFriendActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    MyApplication.instance().startActivity(intent);
                } else if (position == 1) {
                    Intent intent = new Intent(MyApplication.instance(), GroupListActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    MyApplication.instance().startActivity(intent);
                }
//                else if (position == 2) {
//                    Intent intent = new Intent(MyApplication.instance(), BlackListActivity.class);
//                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//                    MyApplication.instance().startActivity(intent);
//                }
                else {
                    Intent intent = new Intent(MyApplication.instance(), FriendProfileActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    intent.putExtra(TUIKitConstants.ProfileType.CONTENT, contact);
                    MyApplication.instance().startActivity(intent);
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
        Log.i(TAG, "onResume");
        refreshData();
    }
}
