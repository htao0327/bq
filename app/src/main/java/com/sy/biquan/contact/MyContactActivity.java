package com.sy.biquan.contact;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.sy.biquan.R;

public class MyContactActivity extends AppCompatActivity {

    private ContactFragment contactFragment;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chat_activity);
        contactFragment = new ContactFragment();
        getFragmentManager().beginTransaction().replace(R.id.empty_view, contactFragment).commitAllowingStateLoss();
    }
}
