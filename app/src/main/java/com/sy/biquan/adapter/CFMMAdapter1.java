package com.sy.biquan.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.sy.biquan.R;

public class CFMMAdapter1 extends RecyclerView.Adapter<CFMMAdapter1.MyViewHolder> {


    @NonNull
    @Override
    public CFMMAdapter1.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_dfb, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 8;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView t1,t2,dqzf,jys,yqzf,ddCount,userName,yqzfSuccess,sy;
        private ImageView user;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

        }
    }

}
