package com.sy.biquan.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.sy.biquan.R;
import com.sy.biquan.bean.DakaDetailBean;

public class DaKarDetailAdapter extends RecyclerView.Adapter<DaKarDetailAdapter.MyViewHolder> {

    private Context context;
    private DakaDetailBean dakaDetailBean;
    public DaKarDetailAdapter(Context context, DakaDetailBean dakaDetailBean){
        this.context = context;
        this.dakaDetailBean = dakaDetailBean;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_daka_detail, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        if(dakaDetailBean.getData().getCurrentOrderVos().get(position).getCurrentRise()>0){
            holder.success.setText("+"+dakaDetailBean.getData().getCurrentOrderVos().get(position).getCurrentRise()+"%");
        }else {
            holder.success.setText(dakaDetailBean.getData().getCurrentOrderVos().get(position).getCurrentRise()+"%");
        }

        holder.title.setText(dakaDetailBean.getData().getCurrentOrderVos().get(position).getTitle());
        holder.time.setText(dakaDetailBean.getData().getCurrentOrderVos().get(position).getStartTime());
    }

    @Override
    public int getItemCount() {
        return dakaDetailBean.getData().getCurrentOrderVos().size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView title,success,time;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            success = itemView.findViewById(R.id.tv_success);
            time = itemView.findViewById(R.id.tv_time);
            title = itemView.findViewById(R.id.tv_title);

        }
    }

}
