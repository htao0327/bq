package com.sy.biquan.viewutil;


import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.sy.biquan.MyApplication;
import com.sy.biquan.R;
import com.sy.biquan.chat.ChatActivity;

public class DialogUtil {
    private static AlertDialog dialog;

    public static void createGroupAlertDialog(Activity activity,  String title1, String msg,
                                            String positiveText, String negativeText, boolean
                                                    cancelableTouchOut, final AlertDialogBtnClickListener
                                                    alertDialogBtnClickListener) {
        View view = LayoutInflater.from(activity).inflate(R.layout.dialog_create_group, null);
        TextView mTitle1 = view.findViewById(R.id.title);
        TextView mMessage = view.findViewById(R.id.message);
        Button positiveButton = view.findViewById(R.id.positiveButton);
        Button negativeButton = view.findViewById(R.id.negativeButton);
        LinearLayout content = view.findViewById(R.id.content);
        if(msg == null || "".equals(msg)){
            content.setVisibility(View.GONE);
        }else {
            mMessage.setText(msg);
        }
        mTitle1.setText(title1);
        positiveButton.setText(positiveText);
        negativeButton.setText(negativeText);
        positiveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                alertDialogBtnClickListener.clickPositive();
                dialog.dismiss();
            }
        });
        negativeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                alertDialogBtnClickListener.clickNegative();
                dialog.dismiss();
            }
        });

        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        builder.setView(view);

        builder.setCancelable(true);   //返回键dismiss
        //创建对话框
        dialog = builder.create();
        dialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);//去掉圆角背景背后的棱角
        dialog.setCanceledOnTouchOutside(cancelableTouchOut);   //失去焦点dismiss
        dialog.show();
    }



    /**
     * @param activity                    Context
     * @param iconRes                     提示图标
     * @param msg                         提示内容
     * @param positiveText                确认
     * @param negativeText                取消
     * @param cancelableTouchOut          点击外部是否隐藏提示框
     * @param alertDialogBtnClickListener 点击监听
     */
    public static void showTipsAlertDialog(Activity activity, int iconRes, String msg,
                                            String positiveText, String negativeText, boolean
                                                    cancelableTouchOut, final AlertDialogBtnClickListener
                                                    alertDialogBtnClickListener) {
        View view = LayoutInflater.from(activity).inflate(R.layout.tips_dialog, null);
        ImageView mIcon = view.findViewById(R.id.icon);
        TextView mMessage = view.findViewById(R.id.message);
        Button positiveButton = view.findViewById(R.id.positiveButton);
        Button negativeButton = view.findViewById(R.id.negativeButton);
        LinearLayout content = view.findViewById(R.id.content);

        if(iconRes == 0){
            mIcon.setVisibility(View.GONE);
        }else {
            mIcon.setImageResource(iconRes);
        }

        if(msg == null || "".equals(msg)){
            content.setVisibility(View.GONE);
        }else {
            mMessage.setText(msg);
        }

        positiveButton.setText(positiveText);
        negativeButton.setText(negativeText);

        positiveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                alertDialogBtnClickListener.clickPositive();
                dialog.dismiss();
            }
        });
        negativeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                alertDialogBtnClickListener.clickNegative();
                dialog.dismiss();
            }
        });

        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        builder.setView(view);

        builder.setCancelable(true);   //返回键dismiss
        //创建对话框
        dialog = builder.create();
        dialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);//去掉圆角背景背后的棱角
        dialog.setCanceledOnTouchOutside(cancelableTouchOut);   //失去焦点dismiss
        dialog.show();
    }


    /**
     * @param activity                    Context
     * @param iconRes                     提示图标
     * @param title1                       提示标题
     * @param msg                         提示内容
     * @param positiveText                确认
     * @param negativeText                取消
     * @param cancelableTouchOut          点击外部是否隐藏提示框
     * @param alertDialogBtnClickListener 点击监听
     */
    public static void showLoginAlertDialog(Activity activity, int iconRes, String title1,String title2, String msg,
                                       String positiveText, String negativeText, boolean
                                               cancelableTouchOut, final AlertDialogBtnClickListener
                                               alertDialogBtnClickListener) {
        View view = LayoutInflater.from(activity).inflate(R.layout.login_dialog, null);
        ImageView mIcon = view.findViewById(R.id.icon);
        TextView mTitle1 = view.findViewById(R.id.title);
        TextView mTitle2 = view.findViewById(R.id.title2);
        TextView mMessage = view.findViewById(R.id.message);
        Button positiveButton = view.findViewById(R.id.positiveButton);
        Button negativeButton = view.findViewById(R.id.negativeButton);
        LinearLayout content = view.findViewById(R.id.content);

        if(iconRes == 0){
            mIcon.setVisibility(View.GONE);
        }else {
            mIcon.setImageResource(iconRes);
        }

        if(msg == null || "".equals(msg)){
            content.setVisibility(View.GONE);
        }else {
            mMessage.setText(msg);
        }


        mTitle1.setText(title1);
        mTitle2.setText(title2);

        positiveButton.setText(positiveText);
        negativeButton.setText(negativeText);

        positiveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                alertDialogBtnClickListener.clickPositive();
                dialog.dismiss();
            }
        });
        negativeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                alertDialogBtnClickListener.clickNegative();
                dialog.dismiss();
            }
        });

        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        builder.setView(view);

        builder.setCancelable(true);   //返回键dismiss
        //创建对话框
        dialog = builder.create();
        dialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);//去掉圆角背景背后的棱角
        dialog.setCanceledOnTouchOutside(cancelableTouchOut);   //失去焦点dismiss
        dialog.show();
    }

    /**
     * boolean isMe = getRedCheck.getData().isIsMe();
     *                                 boolean hasRedPack = getRedCheck.getData().isHasRedPack();
     *                                 boolean isExpire = getRedCheck.getData().isIsExpire();
     *                                 boolean allowRob = getRedCheck.getData().isAllowRob();
     * @param context
     * @param alertDialogBtnClickListener
     */
    public static void showRedEnvelopesDialog(Context context,boolean isMe,boolean hasRedPack,boolean isExpire,final AlertDialogBtnClickListener
            alertDialogBtnClickListener){

        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        View view = LayoutInflater.from(MyApplication.instance()).inflate(R.layout.red_envelope_dialog, null);
        builder.setView(view);
        TextView look_more = view.findViewById(R.id.tv_look_more);
        TextView tips = view.findViewById(R.id.tv_tips);
        Button get = view.findViewById(R.id.btn_click_red_envelope);
        if(!isMe&&hasRedPack){
            look_more.setVisibility(View.GONE);
        }else {
            look_more.setVisibility(View.VISIBLE);
        }
        if(isExpire){
            get.setVisibility(View.GONE);
            tips.setVisibility(View.VISIBLE);
        }


        dialog = builder.create();
        dialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);//去掉圆角背景背后的棱角
        dialog.setCanceledOnTouchOutside(true);   //失去焦点dismiss
        dialog.show();
    }

    public static void showPersonAlertDialog(Activity activity, String iconRes, String title1,String title2, String msg,String fansCounts,String sy,String sr,
                                            String positiveText, String negativeText, boolean
                                                    cancelableTouchOut, final AlertDialogBtnClickListener
                                                    alertDialogBtnClickListener) {
        View view = LayoutInflater.from(activity).inflate(R.layout.daka_dialog, null);
        CircleImageView mIcon = view.findViewById(R.id.icon);
        TextView mTitle1 = view.findViewById(R.id.title);
        TextView mTitle2 = view.findViewById(R.id.title2);
        TextView mMessage = view.findViewById(R.id.message);
        TextView mFansCounts = view.findViewById(R.id.tv_fans_counts);
        TextView mSy = view.findViewById(R.id.tv_sy);
        TextView mSr = view.findViewById(R.id.tv_sr);

        Button positiveButton = view.findViewById(R.id.positiveButton);
        Button negativeButton = view.findViewById(R.id.negativeButton);
        LinearLayout content = view.findViewById(R.id.content);

        if(msg == null || "".equals(msg)){
            content.setVisibility(View.GONE);
        }else {
            mMessage.setText(msg);
        }

        mFansCounts.setText(fansCounts);
        mSr.setText(sr);
        mSy.setText(sy);

//        mIcon.setImageResource(iconRes);
        Glide.with(MyApplication.instance())
                .load(iconRes)
                .into(mIcon);


        mTitle1.setText(title1);
        mTitle2.setText(title2);

        positiveButton.setText(positiveText);
        negativeButton.setText(negativeText);

        positiveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                alertDialogBtnClickListener.clickPositive();
                dialog.dismiss();
            }
        });
        negativeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                alertDialogBtnClickListener.clickNegative();
                dialog.dismiss();
            }
        });

        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        builder.setView(view);

        builder.setCancelable(true);   //返回键dismiss
        //创建对话框
        dialog = builder.create();
        dialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);//去掉圆角背景背后的棱角
        dialog.setCanceledOnTouchOutside(cancelableTouchOut);   //失去焦点dismiss
        dialog.show();
    }



    public interface AlertDialogBtnClickListener {
        void clickPositive();

        void clickNegative();
    }
}
