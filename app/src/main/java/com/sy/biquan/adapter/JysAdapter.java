package com.sy.biquan.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.sy.biquan.R;
import com.sy.biquan.bean.JbDetailBean;

import java.util.List;

public class JysAdapter extends RecyclerView.Adapter<JysAdapter.MyViewHolder> {

    private Context context;
    private List<JbDetailBean.DataBean.BourseListBean> bourseList;
    public JysAdapter(Context context, List<JbDetailBean.DataBean.BourseListBean> bourseList){
        this.context= context;
        this.bourseList = bourseList;
        Log.e("JysAdapter","bourseList.size()："+bourseList.size());
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_jys, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.gw.setText("官      网："+bourseList.get(position).getExchangeSite());
        holder.link.setText("注册链接："+bourseList.get(position).getExchangeRegSite());
        holder.name.setText(bourseList.get(position).getExchangeName());
    }

    @Override
    public int getItemCount() {
        return bourseList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView name,gw,link;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.jys_name);
            gw = itemView.findViewById(R.id.tv_gw);
            link = itemView.findViewById(R.id.tv_link);
        }
    }

}
