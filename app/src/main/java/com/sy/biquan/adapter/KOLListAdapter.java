package com.sy.biquan.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.sy.biquan.R;
import com.sy.biquan.bean.KOLListBean;

import java.util.List;

public class KOLListAdapter extends RecyclerView.Adapter<KOLListAdapter.MyViewHolder> {

    List<KOLListBean.DataBean> dataBeans;
    Context context;

    public KOLListAdapter(Context context, List<KOLListBean.DataBean> dataBeans){
        this.context = context;
        this.dataBeans = dataBeans;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_kol_list, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return dataBeans.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView kol_name,kol_content,time;
        private ImageView user;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            kol_content = itemView.findViewById(R.id.tv_kol_content);
            kol_name = itemView.findViewById(R.id.tv_kol_name);
            time = itemView.findViewById(R.id.time);
            user = itemView.findViewById(R.id.civ_kol_img);
        }
    }
}
