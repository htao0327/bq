package com.sy.biquan.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.sy.biquan.R;
import com.sy.biquan.bean.KTListBean;
import com.sy.biquan.viewutil.CircleImageView;

public class KTAdapter extends RecyclerView.Adapter<KTAdapter.MyViewHolder> {
    private Context context;
    private KTListBean data;

    public KTAdapter(Context context, KTListBean data) {
        this.context = context;
        this.data = data;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_kt, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.content.setText(data.getData().get(position).getTitle());
        holder.peopleCounts.setText(data.getData().get(position).getGroupNumber() + "人");
        holder.redText.setText(data.getData().get(position).getRemainNumber() + "人");
        Glide.with(context)
                .load(data.getData().get(position).getGroupFaceUrl())
                .into(holder.userImg);

    }

    @Override
    public int getItemCount() {
        return data == null || data.getData() == null ? 0 : data.getData().size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView peopleCounts, content, redText;
        private CircleImageView userImg;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            peopleCounts = itemView.findViewById(R.id.tv_people_count);
            content = itemView.findViewById(R.id.tv_group_content);
            redText = itemView.findViewById(R.id.tv_red_text);
            userImg = itemView.findViewById(R.id.civ_group_img);
        }
    }

}
