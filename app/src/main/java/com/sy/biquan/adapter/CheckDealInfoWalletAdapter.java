package com.sy.biquan.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.sy.biquan.R;
import com.sy.biquan.bean.MyWalletBean;

import java.util.List;

public class CheckDealInfoWalletAdapter extends RecyclerView.Adapter<CheckDealInfoWalletAdapter.MyViewHolder> {

    private Context context;
    private List<MyWalletBean.DataBean> dataBeans;

    public CheckDealInfoWalletAdapter(Context context, List<MyWalletBean.DataBean> dataBeans){
        this.context = context;
        this.dataBeans = dataBeans;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_checkdealinfo_wallet, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.name.setText(dataBeans.get(position).getCurrencyEnglish());
    }

    @Override
    public int getItemCount() {
        return dataBeans.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView name;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.tv_coin_name);
        }
    }
}
