package com.sy.biquan.dealfragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.sy.biquan.R;
import com.sy.biquan.adapter.JBFragmentAdapter;

public class DealFragmentAll extends Fragment {
    private static final String TAG ="TestFragment";
    private  int mIndex;
    //    @BindView(R.id.tv_content)
//    TextView mContentTv;
    private View mTestView;
    private RecyclerView recyclerView;
    private JBFragmentAdapter adapter;


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
        recyclerView.setNestedScrollingEnabled(false);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mIndex = getArguments().getInt("index");//根据不同的额index显示不同的内容

    }

}
