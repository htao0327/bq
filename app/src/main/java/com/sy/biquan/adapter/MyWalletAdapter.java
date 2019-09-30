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
import com.sy.biquan.bean.MyWalletBean;

import java.util.List;

public class MyWalletAdapter extends RecyclerView.Adapter<MyWalletAdapter.MyViewHolder> {

    private Context context;
    private List<MyWalletBean.DataBean> dataBeans;

    public MyWalletAdapter(Context context, List<MyWalletBean.DataBean> dataBeans){
        this.context = context;
        this.dataBeans = dataBeans;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_my_wallet, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onItemClickListener.onItemClick(view,position);
            }
        });
        holder.name.setText(dataBeans.get(position).getCurrencyEnglish());
        if(dataBeans.get(position).getHasWallet() == 1){
            Log.e("MyWalletAdapter","===已添加==="+dataBeans.get(position).getCurrencyEnglish());
            holder.type.setText("已添加");
        }else {

        }
    }

    @Override
    public int getItemCount() {
        return dataBeans.size();
    }

    //私有属性
    private OnItemClickListener onItemClickListener = null;

    //setter方法
    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    //回调接口
    public interface OnItemClickListener {
        void onItemClick(View v, int position);
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView name,type;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.tv_coin_name);
            type = itemView.findViewById(R.id.tv_address_type);
        }
    }
}
