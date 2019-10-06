package com.sy.biquan.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.sy.biquan.R;
import com.sy.biquan.bean.GetRedCheck;
import com.sy.biquan.viewutil.CircleImageView;

public class RedAdapter extends RecyclerView.Adapter<RedAdapter.MyViewHolder> {


    private Context context;
    private GetRedCheck getRedCheck;
    public RedAdapter(Context context,GetRedCheck getRedCheck){
        this.context = context;
        this.getRedCheck = getRedCheck;
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
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
