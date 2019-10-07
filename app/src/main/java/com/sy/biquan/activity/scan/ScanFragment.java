package com.sy.biquan.activity.scan;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.Vibrator;
import android.provider.MediaStore;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

import com.sy.biquan.Contants;
import com.sy.biquan.R;
import com.sy.biquan.activity.SearchGroupInfoActivity;
import com.sy.biquan.bean.SearchGroupBeanByID;
import com.sy.biquan.proxy.HttpCallback;
import com.sy.biquan.proxy.HttpProxy;
import com.tbruyelle.rxpermissions2.RxPermissions;
import com.tencent.qcloud.tim.uikit.utils.ToastUtil;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import cn.bingoogolapple.qrcode.core.BarcodeType;
import cn.bingoogolapple.qrcode.core.QRCodeView;
import cn.bingoogolapple.qrcode.zxing.ZXingView;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

import static android.app.Activity.RESULT_OK;
import static android.content.Context.VIBRATOR_SERVICE;

public class ScanFragment extends Fragment implements QRCodeView.Delegate {

    private ZXingView mFragmentScanZxing;
    private FragmentActivity _mActivity;
    private View mRootView;

    private final int ALNUM = 0x23;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);//在fg中使用optionmenu
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        _mActivity = (FragmentActivity) context;
    }

    public static ScanFragment getInstance() {
        ScanFragment fragment = new ScanFragment();
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mRootView = inflater.inflate(R.layout.fragment_scan, container, false);
        initEventAndData();
        return mRootView;
    }

    private void initEventAndData() {
        mFragmentScanZxing = mRootView.findViewById(R.id.fragment_scan_zxing);
        mFragmentScanZxing.setDelegate(this);
        mFragmentScanZxing.setType(BarcodeType.ALL, null); // 识别所有类型的码
    }

    @Override
    public void onStart() {
        super.onStart();
        mFragmentScanZxing.startCamera(); // 打开后置摄像头开始预览，但是并未开始识别
        mFragmentScanZxing.startSpotAndShowRect(); // 显示扫描框，并开始识别
    }

    private void vibrate() {
        Vibrator vibrator = (Vibrator) _mActivity.getSystemService(VIBRATOR_SERVICE);
        vibrator.vibrate(200);
    }

    @Override
    public void onScanQRCodeSuccess(String result) {
//        vibrate();
        //扫描结果
        searchNumber(result);
    }

    @Override
    public void onCameraAmbientBrightnessChanged(boolean isDark) {

    }

    @Override
    public void onScanQRCodeOpenCameraError() {

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu_scan, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == item.getItemId()) {
            RxPermissions permissions = new RxPermissions(_mActivity);
            permissions.request(Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE)
                    .subscribe(new Observer<Boolean>() {
                        @Override
                        public void onSubscribe(Disposable d) {

                        }

                        @Override
                        public void onNext(Boolean aBoolean) {
                            if (aBoolean) {
                                //相册操作
                                getPicFromAlbm();

                            } else {
                                ToastUtil.toastLongMessage("请打开app读写权限");
                            }
                        }

                        @Override
                        public void onError(Throwable e) {
                            ToastUtil.toastLongMessage("请打开app读写权限");
                        }

                        @Override
                        public void onComplete() {

                        }
                    });
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Log.e("scan", "fragment_result");
        if (resultCode == RESULT_OK) {
            switch (requestCode) {
                case ALNUM:
                    try {
                        Uri uri = data.getData();
                        //uri转换成file
                        String[] arr = {MediaStore.Images.Media.DATA};
                        Cursor cursor = _mActivity.managedQuery(uri, arr, null, null, null);
                        int img_index = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
                        cursor.moveToFirst();
                        String img_path = cursor.getString(img_index);
                        File file = new File(img_path);
                        mFragmentScanZxing.decodeQRCode(file.getAbsolutePath());
                    } catch (Exception e) {
                        ToastUtil.toastShortMessage("图片获取失败");
                    }
                    break;
            }
        }
    }

    /**
     * 从相册获取图片
     */
    private void getPicFromAlbm() {
        Intent photoPickerIntent = new Intent(Intent.ACTION_PICK, MediaStore.Audio.Media.EXTERNAL_CONTENT_URI);
        photoPickerIntent.setType("image/*");
        startActivityForResult(photoPickerIntent, ALNUM);
    }

    private void searchNumber(String groupId) {
        Log.e("groupId", "" + groupId);
        Map<String, String> params = new HashMap<>();
        params.put("groupId", groupId);
        HttpProxy.obtain().post(Contants.URL + Contants.SEARCH_GROUP, params, new HttpCallback<SearchGroupBeanByID>() {
            @Override
            public void onFailure(String e) {
                _mActivity.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        mFragmentScanZxing.startSpot();
                    }
                });
                ToastUtil.toastShortMessage(e);
            }

            @Override
            public void onSuccess(SearchGroupBeanByID searchGroupBeanByID) {
                Log.e("AddMoreActivity", "SEARCH_GROUP.setOnClickListener---------" + searchGroupBeanByID);
                if (searchGroupBeanByID.getCode() == Contants.GET_DATA_SUCCESS) {
                    startActivity(new Intent(_mActivity, SearchGroupInfoActivity.class)
                            .addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                            .putExtra(SearchGroupInfoActivity.GROUP_NAME, searchGroupBeanByID.getData().getName())
                            .putExtra(SearchGroupInfoActivity.GROUP_ID, searchGroupBeanByID.getData().getGroupId())
                            .putExtra(SearchGroupInfoActivity.GROUP_NUM, searchGroupBeanByID.getData().getGroupNum())
                            .putExtra(SearchGroupInfoActivity.GROUP_IMG, searchGroupBeanByID.getData().getFaceUrl())
                            .putExtra(SearchGroupInfoActivity.GROUP_PROJECT_NAME, searchGroupBeanByID.getData().getCurrency())
                            .putExtra(SearchGroupInfoActivity.GROUP_QZ_NAME, searchGroupBeanByID.getData().getOwnerName())
                            .putExtra(SearchGroupInfoActivity.GROUP_QZ_IMG, searchGroupBeanByID.getData().getOwnerAvatar())
                            .putExtra(SearchGroupInfoActivity.IS_KOL, searchGroupBeanByID.getData().getKol())
                            .putExtra(SearchGroupInfoActivity.IS_HERE, searchGroupBeanByID.getData().getIsHere())
                            .putExtra(SearchGroupInfoActivity.GROUP_QZ_ID, searchGroupBeanByID.getData().getOwnerId())
                    );
                } else {
                    ToastUtil.toastShortMessage(searchGroupBeanByID.getMsg());
                    _mActivity.runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            mFragmentScanZxing.startSpot();
                        }
                    });
                }
            }
        });
    }
}