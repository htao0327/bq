package com.sy.biquan.activity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.sy.biquan.R;

public class SetIDCard extends AppCompatActivity {

    private EditText et_name,et_id;
    private ImageView img1,img2,img3;
    private Button commit;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_idcard);
    }
}
