package com.sy.biquan.activity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.sy.biquan.Contants;
import com.sy.biquan.R;
import com.sy.biquan.adapter.SearchAdapter;
import com.sy.biquan.bean.HotWordBean;
import com.sy.biquan.bean.SearchByKey;
import com.sy.biquan.proxy.HttpCallback;
import com.sy.biquan.proxy.HttpProxy;
import com.sy.biquan.viewutil.MyViewGroup;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SearchActivity extends AppCompatActivity {

    private MyViewGroup mVg;
    private RelativeLayout rlBack;
    private EditText etSearch;
    private String[] mTexts = new String[]{"BatteryView.txt", "为自定义View",
            " 参考attrs.xml", " 定义自定义View属性", " 参考fragment_04.xml",
            " 使用自定义view，并传入属性值", " 两张图片为资源", "一张为view背景（白圈）",
            "一张为一个圆形图片", "用于遮盖XFerMode","形成圆形波浪效果"};

    private RecyclerView personRec;

    private LinearLayout llHot,llSearchList;
    private TextView search;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        initView();
//        initData();
        setText();
        etSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
//                if("".equals(etSearch.getText().toString())){
//                    llHot.setVisibility(View.VISIBLE);
//                    llSearchList.setVisibility(View.GONE);
//                }
            }
        });

        SearchAdapter adapter = new SearchAdapter(this);
        personRec.setLayoutManager(new LinearLayoutManager(this));
        personRec.setNestedScrollingEnabled(false);
        personRec.setAdapter(adapter);
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                llHot.setVisibility(View.GONE);
//                llSearchList.setVisibility(View.VISIBLE);
                Map<String,String> params = new HashMap<>();
                params.put("keyword",etSearch.getText().toString());
                HttpProxy.obtain().post(Contants.URL + Contants.SEARCH_BY_KEY, params, new HttpCallback<SearchByKey>() {
                    @Override
                    public void onFailure(String e) {
                        Log.e("TAG",""+e);
                    }

                    @Override
                    public void onSuccess(SearchByKey searchByKey) {

                    }
                });
            }
        });
        rlBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    private void initView(){
        mVg = findViewById(R.id.vg_search_hot);
        rlBack = findViewById(R.id.back);
        etSearch = findViewById(R.id.et_search);
        personRec = findViewById(R.id.person_recycler);
        llHot = findViewById(R.id.ll_search_hot);
        llSearchList = findViewById(R.id.ll_search_list);
        search = findViewById(R.id.tv_search);
    }

    private void initData(){
////        final List<String> textList = new ArrayList<>();
//        Map<String,String> params = new HashMap<>();
//        HttpProxy.obtain().get(Contants.URL + Contants.HOT_WORD_SEARCH, params, new HttpCallback<HotWordBean>() {
//            @Override
//            public void onFailure(String e) {
//                Log.e("SearchActivity","error:"+e);
//            }
//
//            @Override
//            public void onSuccess(HotWordBean hotWordBean) {
//                Log.e("SearchActivity","onSuccess:"+hotWordBean);
//                if(hotWordBean.getCode() == Contants.GET_DATA_SUCCESS){
//                   if(hotWordBean.getData().size()>0){
//                       List<String> textList = new ArrayList<>();
//                       for (int i=0;i<hotWordBean.getData().size();i++){
//                           textList.add(hotWordBean.getData().get(i).getKeyWord());
//                       }
//                       setText(textList);
//                   }
//                }
//            }
//        });

    }
    private void setText(){
        TextView tv;
//        for (int i=0;i<textList.size();i++){
//            tv= (TextView) LayoutInflater.from(this).inflate(R.layout.item_my_viewgroup,mVg,false);
//            tv.setText(textList.get(i));
//            tv.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    Log.e("SearchActivity","onClick:"+((TextView)v).getText());
//                    Toast.makeText(SearchActivity.this,""+((TextView)v).getText(),Toast.LENGTH_SHORT).show();
//                }
//            });
//            mVg.addView(tv);
//        }
        for (int i=0;i<mTexts.length;i++){
            tv= (TextView) LayoutInflater.from(this).inflate(R.layout.item_my_viewgroup,mVg,false);
            tv.setText(mTexts[i]);
            tv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.e("SearchActivity","onClick:"+((TextView)v).getText());
                    Toast.makeText(SearchActivity.this,""+((TextView)v).getText(),Toast.LENGTH_SHORT).show();
                }
            });
            mVg.addView(tv);
        }

        llHot.setVisibility(View.VISIBLE);
        llSearchList.setVisibility(View.GONE);
    }













}
