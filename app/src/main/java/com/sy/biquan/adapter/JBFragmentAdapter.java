package com.sy.biquan.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.sy.biquan.MyApplication;
import com.sy.biquan.R;
import com.sy.biquan.bean.MainListData;
import com.sy.biquan.viewutil.CircleImageView;

public class JBFragmentAdapter extends RecyclerView.Adapter<JBFragmentAdapter.MyViewHolder> {

    private MainListData data;
    private Context context;
    public JBFragmentAdapter(Context context,MainListData data){
        this.context = context;
        this.data = data;
    }

    public JBFragmentAdapter(Context context){

    }


    //私有属性
    private CFMMAdapter1.OnItemClickListener onItemClickListener = null;

    //setter方法
    public void setOnItemClickListener(CFMMAdapter1.OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    //回调接口
    public interface OnItemClickListener {
        void onItemClick(View v,  int position);
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_main, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder,final int position) {
        holder.t1.setText(data.getData().get(position).getTitle());
        holder.t2.setText(data.getData().get(position).getStartTime());
        holder.dqzf.setText(String.valueOf(data.getData().get(position).getNowRise())+"%");
        holder.jys.setText("交易所:"+data.getData().get(position).getBourse());
        holder.yqzf.setText(String.valueOf(data.getData().get(position).getExpectedRise())+"%");
        holder.ddCount.setText(String.valueOf(data.getData().get(position).getQbeanNumber()));
        holder.userName.setText(data.getData().get(position).getUserName());
        holder.yqzfSuccess.setText(String.valueOf(data.getData().get(position).getExpectedSucRate()));
        holder.sy.setText(String.valueOf(data.getData().get(position).getAvgIncome()));
        Glide.with(MyApplication.instance())
                .load(data.getData().get(position).getUserAvatar())
                .into(holder.user);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onItemClickListener != null) {
                    onItemClickListener.onItemClick(v,position);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return data.getData().size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView t1,t2,dqzf,jys,yqzf,ddCount,userName,yqzfSuccess,sy;
        private CircleImageView user;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            t1 = itemView.findViewById(R.id.tv_item_main_t1);
            t2 = itemView.findViewById(R.id.tv_item_main_t2);
            dqzf = itemView.findViewById(R.id.tv_dqzf);
            jys = itemView.findViewById(R.id.tv_jys);
            yqzf = itemView.findViewById(R.id.tv_yqzf);
            ddCount = itemView.findViewById(R.id.tv_dd_count);
            userName = itemView.findViewById(R.id.tv_user_name);
            yqzfSuccess = itemView.findViewById(R.id.tv_yqzf_success);
            sy = itemView.findViewById(R.id.tv_sy);
            user = itemView.findViewById(R.id.iv_user);
        }
    }

}
