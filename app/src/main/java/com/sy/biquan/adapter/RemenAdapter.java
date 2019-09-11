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
import com.sy.biquan.bean.JbItemBean;

import java.util.ArrayList;
import java.util.List;

public class RemenAdapter extends RecyclerView.Adapter<RemenAdapter.MyViewHolder> {

    private Context context;
    private List<JbItemBean.DataBean> datas = new ArrayList<>();

    public RemenAdapter(Context context){
        this.context  = context;
        for(int i=0;i<10;i++){
            JbItemBean.DataBean jbItemBean = new JbItemBean.DataBean();
            jbItemBean.setTitle("");
            jbItemBean.setBuyerNumber(46+i);
            jbItemBean.setCurrentRise("15");
            jbItemBean.setExpectedRise("45");
        }
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_main, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 10;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView t1,t2,dqzf,jys,yqzf,ddCount,userName,yqzfSuccess,sy;
        private ImageView user;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

        }
    }

}
