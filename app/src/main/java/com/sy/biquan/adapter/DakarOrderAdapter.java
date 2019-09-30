package com.sy.biquan.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.sy.biquan.R;
import com.sy.biquan.bean.DakaOrderBean;

public class DakarOrderAdapter extends RecyclerView.Adapter<DakarOrderAdapter.MyViewHolder> {

    private Context context;
    private DakaOrderBean data;

    public DakarOrderAdapter(Context context,DakaOrderBean data){
        this.context = context;
        this.data = data;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_daka_order, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.t1.setText(data.getData().get(position).getTitle());
        holder.t2.setText(data.getData().get(position).getStartTime());
        holder.dqzf.setText(String.valueOf(data.getData().get(position).getNowRise())+"%");
        holder.jys.setText("交易所:"+data.getData().get(position).getBourse());
        holder.yqzf.setText(String.valueOf(data.getData().get(position).getExpectedRise())+"%");
        holder.ddCount.setText(String.valueOf(data.getData().get(position).getQbNumber()));
        holder.startTime.setText(data.getData().get(position).getStartTime()+"-");
        holder.endTime.setText(data.getData().get(position).getEndTime());

    }

    @Override
    public int getItemCount() {
        return data.getData().size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView t1,t2,dqzf,jys,yqzf,ddCount,startTime,endTime;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            t1 = itemView.findViewById(R.id.tv_item_main_t1);
            t2 = itemView.findViewById(R.id.tv_item_main_t2);
            dqzf = itemView.findViewById(R.id.tv_dqzf);
            jys = itemView.findViewById(R.id.tv_jys);
            yqzf = itemView.findViewById(R.id.tv_yqzf);
            ddCount = itemView.findViewById(R.id.tv_dd_count);
            startTime = itemView.findViewById(R.id.tv_start_time);
            endTime = itemView.findViewById(R.id.tv_end_time);
        }
    }

}
