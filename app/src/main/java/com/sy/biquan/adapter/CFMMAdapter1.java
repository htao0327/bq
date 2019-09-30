package com.sy.biquan.adapter;

import android.content.Context;
import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.sy.biquan.MyApplication;
import com.sy.biquan.R;
import com.sy.biquan.bean.TopBean;
import com.sy.biquan.viewutil.CircleImageView;

public class CFMMAdapter1 extends RecyclerView.Adapter<CFMMAdapter1.MyViewHolder> {

    private Context context;
    private TopBean data;

    public CFMMAdapter1(Context context,TopBean data){
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
    public CFMMAdapter1.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_dfb, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {
        //实现点击效果
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onItemClickListener != null) {
                    onItemClickListener.onItemClick(v,position);
                }
            }
        });
        holder.success.setText(data.getData().get(position).getSuccessRate()+"%");
        holder.name.setText(data.getData().get(position).getAlias());
        if(data.getData().get(position).getIsFollow() == 1){
            holder.gz.setText("已关注");

        }
        Glide.with(MyApplication.instance())
                .load(data.getData().get(position).getAvatar())
                .into(holder.userImg);



    }

    @Override
    public int getItemCount() {
        return data.getData().size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView name,success;
        private CircleImageView userImg;
        private Button gz;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.tv_user_name);
            success = itemView.findViewById(R.id.tv_success);
            userImg = itemView.findViewById(R.id.civ_user_img);
            gz = itemView.findViewById(R.id.btn_gz);

        }
    }

}
