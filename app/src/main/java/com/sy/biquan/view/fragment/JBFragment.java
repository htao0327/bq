package com.sy.biquan.view.fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.sy.biquan.R;
import com.sy.biquan.adapter.JBFragmentAdapter;
import com.sy.biquan.adapter.RemenAdapter;

public class JBFragment extends Fragment {
    private static final String TAG ="TestFragment";
    private  int mIndex;
//    @BindView(R.id.tv_content)
//    TextView mContentTv;
    private View mTestView;
    private RecyclerView recyclerView;
    private JBFragmentAdapter adapter;

    public JBFragment(){}

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mTestView = inflater.inflate(R.layout.main_menu_fragment, container, false);
//        ButterKnife.bind(this, mTestView);
        recyclerView = mTestView.findViewById(R.id.main_menu_rec);
        return mTestView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
//        mContentTv.setText("TestFragment" + mIndex);
        adapter = new JBFragmentAdapter(getActivity());
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mIndex = getArguments().getInt("index");//根据不同的额index显示不同的内容

    }

    @Override
    public void onStart() {
        super.onStart();
        Log.d(TAG,"onStart()" + mIndex);
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d(TAG,"onPause()" + mIndex);
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d(TAG,"onResume()" + mIndex);
    }
}
