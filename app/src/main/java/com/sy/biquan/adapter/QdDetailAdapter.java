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
import com.sy.biquan.bean.QdDetailBean;

public class QdDetailAdapter extends RecyclerView.Adapter<QdDetailAdapter.MyViewHolder> {

    private int type = 0;
    private Context context;
    private QdDetailBean qdDetailBean;
    public QdDetailAdapter(QdDetailBean qdDetailBean,Context context,int type){
        this.context = context;
        this.qdDetailBean = qdDetailBean;
        this.type = type;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_qd_detail, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.t1.setText(qdDetailBean.getData().get(position).getRemark());
        holder.t2.setText(qdDetailBean.getData().get(position).getTime());
        if(type == 0){
            holder.btn.setTextColor(context.getResources().getColor(R.color.red));
            holder.btn.setText("-"+String.valueOf(qdDetailBean.getData().get(position).getValue()));
        }else {
            holder.btn.setTextColor(context.getResources().getColor(R.color.colorPrimary));
            holder.btn.setText("+"+String.valueOf(qdDetailBean.getData().get(position).getValue()));
        }
    }

    @Override
    public int getItemCount() {
        return qdDetailBean.getData().size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView t1,t2;
        private TextView btn;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            t1 = itemView.findViewById(R.id.tv_name);
            t2 = itemView.findViewById(R.id.tv_time);
            btn = itemView.findViewById(R.id.btn);
        }
    }
}
