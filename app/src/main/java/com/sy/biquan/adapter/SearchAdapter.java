package com.sy.biquan.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.sy.biquan.R;
import com.sy.biquan.activity.SearchActivity;

public class SearchAdapter extends RecyclerView.Adapter<SearchAdapter.MyViewHolder> {

    private Context context;

//    @NonNull
//    @Override
//    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        return null;
//    }
private String[] mTexts = new String[]{"BatteryView.txt", "为自定义View",
        " 参考attrs.xml", " 定义自定义View属性", " 参考fragment_04.xml",
        " 使用自定义view，并传入属性值", " 两张图片为资源", "一张为view背景（白圈）",
        "一张为一个圆形图片", "用于遮盖XFerMode","形成圆形波浪效果","BatteryView.txt", "为自定义View","BatteryView.txt", "为自定义View","BatteryView.txt", "为自定义View"};

    public SearchAdapter(Context context){
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_search_person, null, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.userName.setText(position+mTexts[position]);
        holder.content.setText("个人详情介绍：潇潇社区是集数字货币分析优质 项目推广广，资产风控….");
        Log.e("SearchAdapter","position------>"+position);
    }

    @Override
    public int getItemCount() {
        Log.e("SearchAdapter","mTexts.length--->"+mTexts.length);
        return mTexts.length;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView userName,content;
        private ImageView user;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            userName = itemView.findViewById(R.id.tv_user_name);
            content = itemView.findViewById(R.id.tv_search_content);

        }
    }
}
