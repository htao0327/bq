package com.sy.biquan.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.sy.biquan.R;
import com.sy.biquan.bean.XMDetailBean;
import com.sy.biquan.viewutil.CircleImageView;

public class XMDetailGroupListAdapter extends RecyclerView.Adapter<XMDetailGroupListAdapter.MyViewHolder> {

    private Context context;
    private XMDetailBean data;
    public XMDetailGroupListAdapter(Context context, XMDetailBean data){
        this.context = context;
        this.data = data;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.xm_detail_item, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.groupName.setText(data.getData().get(position).getGroupName());
        holder.peopleCount.setText("("+data.getData().get(position).getGroupNum()+"+)");
        Glide.with(context)
                .load(data.getData().get(position).getGroup_face_url())
                .into(holder.groupImg);
    }

    @Override
    public int getItemCount() {
        return data.getData().size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView groupName,peopleCount;
        private CircleImageView groupImg;
        private Button inGroup;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            groupName = itemView.findViewById(R.id.tv_xm_group_list_name);
            peopleCount = itemView.findViewById(R.id.tv_xm_group_list_people_count);
            groupImg = itemView.findViewById(R.id.civ_xm_detail_group_img);
            inGroup = itemView.findViewById(R.id.btn_xm_group);
        }
    }
}
