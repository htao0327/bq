package com.sy.biquan.chat;

import android.Manifest;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.core.app.ActivityCompat;

import com.sy.biquan.MyApplication;
import com.sy.biquan.R;
import com.tencent.qcloud.tim.uikit.base.IUIKitCallBack;
import com.tencent.qcloud.tim.uikit.component.video.CameraActivity;
import com.tencent.qcloud.tim.uikit.component.video.JCameraView;
import com.tencent.qcloud.tim.uikit.modules.chat.base.BaseInputFragment;
import com.tencent.qcloud.tim.uikit.modules.chat.layout.input.InputLayout;
//import com.tencent.qcloud.tim.uikit.modules.chat.layout.input.InputLayoutUI;
import com.tencent.qcloud.tim.uikit.modules.message.MessageInfo;
import com.tencent.qcloud.tim.uikit.modules.message.MessageInfoUtil;
import com.tencent.qcloud.tim.uikit.utils.TUIKitConstants;
import com.tencent.qcloud.tim.uikit.utils.TUIKitLog;

import java.io.File;

public class CustomInputFragment extends BaseInputFragment {

    private static String TAG = "CustomInputFragment";

    protected static final int CAPTURE = 1;
    protected static final int AUDIO_RECORD = 2;
    protected static final int VIDEO_RECORD = 3;
    protected static final int SEND_PHOTO = 4;
    protected static final int SEND_FILE = 5;
    protected Activity mActivity;
    private AlertDialog mPermissionDialog;
    private InputLayout.ChatInputHandler mChatInputHandler;

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View baseView = inflater.inflate(R.layout.test_chat_input_custom_fragment, container, false);
        LinearLayout ll_xc = baseView.findViewById(R.id.ll_xc);//相册
        LinearLayout ll_ps = baseView.findViewById(R.id.ll_ps);//拍摄
        LinearLayout ll_wj = baseView.findViewById(R.id.ll_wj);//文件
        LinearLayout ll_ds = baseView.findViewById(R.id.ll_ds);//打赏
        LinearLayout ll_transaction = baseView.findViewById(R.id.ll_transaction);//发起交易
        mActivity = (Activity) getContext();

        ll_xc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TUIKitLog.i(TAG, "startCapture");
                if (!checkPermission(CAPTURE)) {
                    TUIKitLog.i(TAG, "startCapture checkPermission failed");
                    return;
                }
                Intent captureIntent = new Intent(MyApplication.instance(), CameraActivity.class);
                captureIntent.putExtra(TUIKitConstants.CAMERA_TYPE, JCameraView.BUTTON_STATE_ONLY_CAPTURE);
                CameraActivity.mCallBack = new IUIKitCallBack() {
                    @Override
                    public void onSuccess(Object data) {
                        Uri contentUri = Uri.fromFile(new File(data.toString()));
                        MessageInfo msg = MessageInfoUtil.buildImageMessage(contentUri, true);
//                        if (mMessageHandler != null) {
//                            mMessageHandler.sendMessage(msg);
//                            hideSoftInput();
//                        }
                    }

                    @Override
                    public void onError(String module, int errCode, String errMsg) {

                    }
                };
                MyApplication.instance().startActivity(captureIntent);
            }
        });

        return baseView;
    }


    protected boolean checkPermission(Context context, String permission) {
        TUIKitLog.i(TAG, "checkPermission permission:" + permission + "|sdk:" + Build.VERSION.SDK_INT);
        boolean flag = true;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            int result = ActivityCompat.checkSelfPermission(context, permission);
            if (PackageManager.PERMISSION_GRANTED != result) {
                showPermissionDialog();
                flag = false;
            }
        }
        return flag;
    }


    protected boolean checkPermission(int type) {
        if (!checkPermission(mActivity, Manifest.permission.WRITE_EXTERNAL_STORAGE)) {
            return false;
        }
        if (!checkPermission(mActivity, Manifest.permission.READ_EXTERNAL_STORAGE)) {
            return false;
        }
        if (type == SEND_FILE || type == SEND_PHOTO) {
            return true;
        } else if (type == CAPTURE) {
            return checkPermission(mActivity, Manifest.permission.CAMERA);
        } else if (type == AUDIO_RECORD) {
            return checkPermission(mActivity, Manifest.permission.RECORD_AUDIO);
        } else if (type == VIDEO_RECORD) {
            return checkPermission(mActivity, Manifest.permission.CAMERA)
                    && checkPermission(mActivity, Manifest.permission.RECORD_AUDIO);
        }
        return true;
    }


    private void cancelPermissionDialog() {
        mPermissionDialog.cancel();
    }

    private void showPermissionDialog() {
        if (mPermissionDialog == null) {
            mPermissionDialog = new AlertDialog.Builder(mActivity)
                    .setMessage("使用该功能，需要开启权限，鉴于您禁用相关权限，请手动设置开启权限")
                    .setPositiveButton("设置", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            cancelPermissionDialog();
                            Uri packageURI = Uri.parse("package:" + mActivity.getPackageName());
                            Intent intent = new Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS, packageURI);
                            mActivity.startActivity(intent);
                        }
                    })
                    .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            //关闭页面或者做其他操作
                            cancelPermissionDialog();
                        }
                    })
                    .create();
        }
        mPermissionDialog.show();
    }


}
