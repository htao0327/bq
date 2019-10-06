package com.sy.biquan.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.sy.biquan.R;
import com.sy.biquan.bean.MyJb1Bean;
import com.sy.biquan.viewutil.CircleImageView;

import java.util.List;

public class MyJbAdapter extends RecyclerView.Adapter<MyJbAdapter.MyViewHolder> {

    private Context context;
    private MyJb1Bean data;
    public MyJbAdapter(Context context, MyJb1Bean data){
        this.context = context;
        this.data = data;
    }


    //私有属性
    private OnItemClickListener onItemClickListener = null;

    //setter方法
    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
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
                .inflate(R.layout.item_daka_order, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {
        holder.t1.setText(data.getData().get(position).getTitle());
        holder.t2.setText(data.getData().get(position).getEndTime());
        holder.dqzf.setText(String.valueOf(data.getData().get(position).getNowRise()));
        holder.yqzf.setText(String.valueOf(data.getData().get(position).getExpectedRise()));
        holder.jys.setText(data.getData().get(position).getBourse());
        holder.ddCount.setText(data.getData().get(position).getQbNumber()+"");
        holder.time1.setText(data.getData().get(position).getStartTime());
        holder.time2.setText(data.getData().get(position).getEndTime());

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
        private TextView t1,t2,dqzf,jys,yqzf,ddCount,time1,time2;
        private ImageView lock;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            t1 = itemView.findViewById(R.id.tv_item_main_t1);
            t2 = itemView.findViewById(R.id.tv_item_main_t2);
            dqzf = itemView.findViewById(R.id.tv_dqzf);
            jys = itemView.findViewById(R.id.tv_jys);
            yqzf = itemView.findViewById(R.id.tv_yqzf);
            ddCount = itemView.findViewById(R.id.tv_dd_count);
            lock = itemView.findViewById(R.id.iv_clock);
            time1 = itemView.findViewById(R.id.tv_start_time);
            time2 = itemView.findViewById(R.id.tv_end_time);


        }
    }
}
