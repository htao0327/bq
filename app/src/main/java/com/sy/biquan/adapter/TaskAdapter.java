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
import com.sy.biquan.bean.MyTaskBean;

public class TaskAdapter extends RecyclerView.Adapter<TaskAdapter.MyViewHolder> {
    private MyTaskBean data;
    private Context context;
    public TaskAdapter(MyTaskBean data,Context context){
        this.data = data;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.my_task_item, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.t1.setText(data.getData().getTaskList().get(position).getTaskName());
        holder.t2.setText("Q豆+"+String.valueOf(data.getData().getTaskList().get(position).getTaskReward()));
        if(data.getData().getTaskList().get(position).getState() == 1){
            holder.btn.setFocusable(false);
            holder.btn.setBackground(null);
            holder.btn.setTextColor(context.getResources().getColor(R.color.colorLoginOtherText));
            holder.btn.setText("已完成");
        }
    }

    @Override
    public int getItemCount() {
        return data.getData().getTaskList().size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView t1,t2;
        private Button btn;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            t1 = itemView.findViewById(R.id.tv_task_name);
            t2 = itemView.findViewById(R.id.tv_qd);
            btn = itemView.findViewById(R.id.btn);
        }
    }
}
