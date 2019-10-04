package com.sy.biquan.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.sy.biquan.R;
import com.sy.biquan.bean.KTListBean;
import com.sy.biquan.bean.XMListBean;
import com.sy.biquan.viewutil.CircleImageView;

public class XMAdapter extends RecyclerView.Adapter<XMAdapter.MyViewHolder> {


    private Context context;
    private XMListBean xmListBean;
    public XMAdapter(Context context, XMListBean xmListBean){
        this.context  = context;
        this.xmListBean = xmListBean;

    }


    //私有属性
    private OnRecyclerViewItemClickListener onItemClickListener = null;

    //setter方法
    public void setOnItemClickListener(OnRecyclerViewItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    //    //回调接口
    public interface OnRecyclerViewItemClickListener {
        void onClick(View view, ViewName viewName, int position);
    }

    /** item里面有多个控件可以点击 */
    public enum ViewName {
        ITEM,
        PRACTISE
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_xm, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {
        holder.bName.setText(xmListBean.getData().get(position).getCurrency());
        holder.content.setText(xmListBean.getData().get(position).getProjectDesc());
        holder.groupNum.setText(xmListBean.getData().get(position).getGroups()+"个相关群聊");
        Glide.with(context)
                .load(xmListBean.getData().get(position).getProjectImg())
                .into(holder.userImg);
//        holder.itemView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if (onItemClickListener != null) {
//                    onItemClickListener.onClick(v,position);
//                }
//            }
//        });
    }

    @Override
    public int getItemCount() {
//        return xmListBean.ge;
        return xmListBean.getData().size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView bName,content,groupNum;
        private CircleImageView userImg;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            bName = itemView.findViewById(R.id.tv_b_name);
            content = itemView.findViewById(R.id.tv_content);
            userImg = itemView.findViewById(R.id.iv_xm_img);
            groupNum = itemView.findViewById(R.id.tv_group_num);
        }
    }
}
