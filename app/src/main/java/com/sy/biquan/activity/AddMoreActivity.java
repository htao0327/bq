package com.sy.biquan.activity;

import android.content.Context;
import android.os.Bundle;
import android.os.Message;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.sy.biquan.Contants;
import com.sy.biquan.R;
import com.sy.biquan.bean.SearchByPhoneBean;
import com.sy.biquan.bean.SearchGroupBeanByID;
import com.sy.biquan.proxy.HttpCallback;
import com.sy.biquan.proxy.HttpProxy;
import com.tencent.imsdk.TIMCallBack;
import com.tencent.imsdk.TIMFriendshipManager;
import com.tencent.imsdk.TIMGroupManager;
import com.tencent.imsdk.TIMValueCallBack;
import com.tencent.imsdk.friendship.TIMFriendRequest;
import com.tencent.imsdk.friendship.TIMFriendResult;
import com.tencent.imsdk.friendship.TIMFriendStatus;
import com.tencent.qcloud.tim.uikit.component.TitleBarLayout;
import com.tencent.qcloud.tim.uikit.utils.SoftKeyBoardUtil;
import com.tencent.qcloud.tim.uikit.utils.TUIKitConstants;
import com.tencent.qcloud.tim.uikit.utils.ToastUtil;

import java.util.HashMap;
import java.util.Map;

/**
 * 添加好友、群
 */
public class AddMoreActivity extends AppCompatActivity {

    private static final String TAG = AddMoreActivity.class.getSimpleName();

    private TitleBarLayout mTitleBar;
    private EditText mUserID;
    private EditText mAddWording;
    private boolean mIsGroup;
    private EditText etSearch;
//    private TextView search;
    private PopupWindow popupWindow;

    private TextView errorMsg;

    private View layout;

    private LinearLayout ll_title,ll_error,ll_find_people,ll_find_group;

    private TextView tv_people,tv_group;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getIntent() != null) {
            mIsGroup = getIntent().getExtras().getBoolean(TUIKitConstants.GroupType.GROUP);
        }

        setContentView(R.layout.contact_add_activity);

        etSearch = findViewById(R.id.et_search);
//        search = findViewById(R.id.tv_search);
        ll_title = findViewById(R.id.ll_title);
        ll_error = findViewById(R.id.ll_error);
        errorMsg = findViewById(R.id.tv_error_msg);
        //加载布局
        layout = LayoutInflater.from(AddMoreActivity.this).inflate(
                R.layout.popup_add, null);
        tv_group = layout.findViewById(R.id.tv_group);
        tv_people = layout.findViewById(R.id.tv_people);
        ll_find_people = layout.findViewById(R.id.ll_find_people);
        ll_find_group = layout.findViewById(R.id.ll_find_group);
        popupWindow = new PopupWindow(layout,500,300);//参数为1.View
        popupWindow.setFocusable(false);

        etSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                Log.e(TAG,"afterTextChanged--Text:"+etSearch.getText().toString());
                ll_error.setVisibility(View.GONE);
                if(etSearch.getText()!=null && etSearch.getText().toString().length()>0){
                    Log.e(TAG,"afterTextChanged--Text-length:"+etSearch.getText().toString().length());
                    if(!popupWindow.isShowing()){
                        popupWindow.showAsDropDown(ll_title);
                        ll_find_people.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                if(!(etSearch.getText() == null || "".equals(etSearch.getText().toString()))) {
                                    Log.e("AddMoreActivity","search.setOnClickListener===============if");
                                    Map<String,String> params = new HashMap<>();
                                    HttpProxy.obtain().get(Contants.URL + Contants.SEARCH_IMCODE_BY_PHONE+etSearch.getText().toString(), params, new HttpCallback<SearchByPhoneBean>() {
                                        @Override
                                        public void onFailure(String e) {
                                            Log.e("AddMoreActivity","search.setOnClickListener---------"+e);
                                            ll_error.setVisibility(View.VISIBLE);
                                        }
                                        @Override
                                        public void onSuccess(SearchByPhoneBean searchByPhoneBean) {
                                            Log.e("AddMoreActivity","search.setOnClickListener---------"+searchByPhoneBean);
                                            if(searchByPhoneBean.getCode() == Contants.GET_DATA_SUCCESS){
                                                ll_error.setVisibility(View.GONE);
                                            }else {
                                                ll_error.setVisibility(View.VISIBLE);
                                                errorMsg.setText(searchByPhoneBean.getMessage());
                                            }

                                        }
                                    });
                                }else {
                                    Log.e("AddMoreActivity","search.setOnClickListener===============else");
                                }
                            }
                        });
                        ll_find_group.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                if(!(etSearch.getText() == null || "".equals(etSearch.getText().toString()))) {
                                    Log.e("AddMoreActivity","SEARCH_GROUP.setOnClickListener===============if");
                                    Map<String,String> params = new HashMap<>();
                                    params.put("groupId",etSearch.getText().toString());
                                    HttpProxy.obtain().post(Contants.URL + Contants.SEARCH_GROUP, params, new HttpCallback<SearchGroupBeanByID>() {
                                        @Override
                                        public void onFailure(String e) {
                                            Log.e("AddMoreActivity","SEARCH_GROUP.setOnClickListener---------"+e);
                                            ll_error.setVisibility(View.VISIBLE);
                                        }
                                        @Override
                                        public void onSuccess(SearchGroupBeanByID searchGroupBeanByID) {
                                            Log.e("AddMoreActivity","SEARCH_GROUP.setOnClickListener---------"+searchGroupBeanByID);
                                            if(searchGroupBeanByID.getCode() == Contants.GET_DATA_SUCCESS){
                                                ll_error.setVisibility(View.GONE);
                                            }else {
                                                ll_error.setVisibility(View.VISIBLE);
                                                errorMsg.setText(searchGroupBeanByID.getMsg());
                                            }
                                        }
                                    });
                                }else {
                                    Log.e("AddMoreActivity","SEARCH_GROUP.setOnClickListener===============else");
                                }
                            }
                        });
                    }
                    tv_group.setText(etSearch.getText().toString());
                    tv_people.setText(etSearch.getText().toString());

                }else {
                    Log.e(TAG,"afterTextChanged--else");
                    if(popupWindow.isShowing()){
                        popupWindow.dismiss();
                    }
                }
            }
        });


//        search.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
////                popupWindow.showAsDropDown(ll_title);
//                Log.e("AddMoreActivity","search.setOnClickListener===============");
//
//            }
//        });

        mTitleBar = findViewById(R.id.add_friend_titlebar);
        mTitleBar.setTitle(mIsGroup ? getResources().getString(R.string.add_group) : getResources().getString(R.string.add_friend), TitleBarLayout.POSITION.LEFT);
        mTitleBar.setOnLeftClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        mTitleBar.getRightGroup().setVisibility(View.GONE);
        mUserID = findViewById(R.id.user_id);
        mAddWording = findViewById(R.id.add_wording);
    }

    public void add(View view) {
        if (mIsGroup) {
            addGroup(view);
        } else {
            addFriend(view);
        }
    }

    public void addFriend(View view) {
        String id = mUserID.getText().toString();
        if (TextUtils.isEmpty(id)) {
            return;
        }

        TIMFriendRequest timFriendRequest = new TIMFriendRequest(id);
        timFriendRequest.setAddWording(mAddWording.getText().toString());
        timFriendRequest.setAddSource("android");
        TIMFriendshipManager.getInstance().addFriend(timFriendRequest, new TIMValueCallBack<TIMFriendResult>() {
            @Override
            public void onError(int i, String s) {
//                DemoLog.e(TAG, "addFriend err code = " + i + ", desc = " + s);
                ToastUtil.toastShortMessage("Error code = " + i + ", desc = " + s);
            }

            @Override
            public void onSuccess(TIMFriendResult timFriendResult) {
//                DemoLog.i(TAG, "addFriend success result = " + timFriendResult.toString());
                switch (timFriendResult.getResultCode()) {
                    case TIMFriendStatus.TIM_FRIEND_STATUS_SUCC:
                        ToastUtil.toastShortMessage("成功");
                        break;
                    case TIMFriendStatus.TIM_FRIEND_PARAM_INVALID:
                        if (TextUtils.equals(timFriendResult.getResultInfo(), "Err_SNS_FriendAdd_Friend_Exist")) {
                            ToastUtil.toastShortMessage("对方已是您的好友");
                            break;
                        }
                    case TIMFriendStatus.TIM_ADD_FRIEND_STATUS_SELF_FRIEND_FULL:
                        ToastUtil.toastShortMessage("您的好友数已达系统上限");
                        break;
                    case TIMFriendStatus.TIM_ADD_FRIEND_STATUS_THEIR_FRIEND_FULL:
                        ToastUtil.toastShortMessage("对方的好友数已达系统上限");
                        break;
                    case TIMFriendStatus.TIM_ADD_FRIEND_STATUS_IN_SELF_BLACK_LIST:
                        ToastUtil.toastShortMessage("被加好友在自己的黑名单中");
                        break;
                    case TIMFriendStatus.TIM_ADD_FRIEND_STATUS_FRIEND_SIDE_FORBID_ADD:
                        ToastUtil.toastShortMessage("对方已禁止加好友");
                        break;
                    case TIMFriendStatus.TIM_ADD_FRIEND_STATUS_IN_OTHER_SIDE_BLACK_LIST:
                        ToastUtil.toastShortMessage("您已被被对方设置为黑名单");
                        break;
                    case TIMFriendStatus.TIM_ADD_FRIEND_STATUS_PENDING:
                        ToastUtil.toastShortMessage("等待好友审核同意");
                        break;
                    default:
                        ToastUtil.toastLongMessage(timFriendResult.getResultCode() + " " + timFriendResult.getResultInfo());
                        break;
                }
                finish();
            }
        });
    }

    public void addGroup(View view) {
        String id = mUserID.getText().toString();
        if (TextUtils.isEmpty(id)) {
            return;
        }
        TIMGroupManager.getInstance().applyJoinGroup(id, mAddWording.getText().toString(), new TIMCallBack() {

            @Override
            public void onError(int i, String s) {
//                DemoLog.e(TAG, "addGroup err code = " + i + ", desc = " + s);
                ToastUtil.toastShortMessage("Error code = " + i + ", desc = " + s);
            }

            @Override
            public void onSuccess() {
//                DemoLog.i(TAG, "addGroup success");
                ToastUtil.toastShortMessage("加群请求已发送");
                finish();
            }
        });
    }

    @Override
    public void finish() {
        super.finish();
        SoftKeyBoardUtil.hideKeyBoard(mUserID.getWindowToken());
    }
}
