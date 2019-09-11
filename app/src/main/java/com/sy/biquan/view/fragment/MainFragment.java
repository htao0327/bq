package com.sy.biquan.view.fragment;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.backends.pipeline.PipelineDraweeController;
import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.common.ResizeOptions;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import com.google.android.material.tabs.TabLayout;
import com.sy.biquan.Contants;
import com.sy.biquan.R;
import com.sy.biquan.activity.CFMMActivity;
import com.sy.biquan.activity.RemenActivity;
import com.sy.biquan.activity.SearchActivity;
import com.sy.biquan.bean.MainBean;
import com.sy.biquan.proxy.HttpCallback;
import com.sy.biquan.proxy.HttpProxy;
import com.sy.biquan.viewutil.ImageCarousel;
import com.sy.biquan.viewutil.ImageInfo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainFragment extends Fragment {

    private EditText etSearch;
    private View rootView;

    private TabLayout tabLayout;
    private ViewPager titleViewPager;

    private TextView tv_cfmm,tv_jb,tv_kt,tv_xm,tv_rm;
    private LinearLayout ll_cfmm,jb,kt,xm,remen;
//    private ImageView

    // 图片轮播控件
    private ViewPager mViewPager;
    private LinearLayout mLineLayoutDot;
    private ImageCarousel imageCarousel;
    private List<View> dots = new ArrayList<>();//小点

    // 图片数据，包括图片标题、图片链接、数据、点击要打开的网站（点击打开的网页或一些提示指令）
    private List<ImageInfo> imageInfoList;
    private MainBean allData;
    List<MainBean.DataBean.ChannelListBean> channelListBeanList;//大模块列表 财富密码等
    List<MainBean.DataBean.BannerListBean> bannerList;//轮播图列表
    List<MainBean.DataBean.OrderCategoryListBean> orderCategoryListBeanList;//标题列表  最热等
    List<MainBean.DataBean.OrderListBean> orderListBeanList;//最下方默认列表

    private static final String TAG = "MainActivity";
    private Map<String,Object> params = new HashMap<>();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return rootView = inflater.inflate(R.layout.fragment_main, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView();
        etSearch.setFocusable(false);
        etSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), SearchActivity.class));
            }
        });

        remen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), RemenActivity.class));
            }
        });
        ll_cfmm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), CFMMActivity.class));
            }
        });

//        getData();
//        initView();
        initEvent();
        imageStart();
    }

    private void initView(){
        etSearch = rootView.findViewById(R.id.et_search);

        mViewPager = rootView.findViewById(R.id.viewPager);
//        mTvPagerTitle = rootView.findViewById(R.id.tv_pager_title);
        mLineLayoutDot = rootView.findViewById(R.id.lineLayout_dot);
        tabLayout = rootView.findViewById(R.id.tab_layout);
        titleViewPager = rootView.findViewById(R.id.title_view_pager);
        ll_cfmm = rootView.findViewById(R.id.ll_cfmm);
        jb = rootView.findViewById(R.id.ll_jb);
        kt = rootView.findViewById(R.id.ll_kt);
        xm = rootView.findViewById(R.id.ll_xm);
        remen = rootView.findViewById(R.id.ll_remen);
    }


    private void imageStart() {
        //设置图片轮播
        int[] imgaeIds = new int[]{R.id.pager_image1, R.id.pager_image2, R.id.pager_image3, R.id.pager_image4,
                R.id.pager_image5, R.id.pager_image6, R.id.pager_image7, R.id.pager_image8};
        String[] titles = new String[imageInfoList.size()];
        List<SimpleDraweeView> simpleDraweeViewList = new ArrayList<>();

        for (int i = 0; i < imageInfoList.size(); i++) {
            titles[i] = imageInfoList.get(i).getTitle();
            SimpleDraweeView simpleDraweeView = new SimpleDraweeView(getActivity());
            simpleDraweeView.setAspectRatio(1.78f);
            // 设置一张默认的图片
            GenericDraweeHierarchy hierarchy = new GenericDraweeHierarchyBuilder(getActivity().getResources())
                    .setPlaceholderImage(ContextCompat.getDrawable(getActivity(), R.drawable.defult), ScalingUtils.ScaleType.CENTER_CROP).build();
            simpleDraweeView.setHierarchy(hierarchy);
            simpleDraweeView.setLayoutParams(new AbsListView.LayoutParams(AbsListView.LayoutParams.MATCH_PARENT, AbsListView.LayoutParams.WRAP_CONTENT));

            //加载高分辨率图片;
            ImageRequest imageRequest = ImageRequestBuilder.newBuilderWithSource(Uri.parse(imageInfoList.get(i).getImage()))
                    .setResizeOptions(new ResizeOptions(1280, 720))
                    .build();
            PipelineDraweeController controller = (PipelineDraweeController) Fresco.newDraweeControllerBuilder()
                    //.setLowResImageRequest(ImageRequest.fromUri(Uri.parse(listItemBean.test_pic_low))) //在加载高分辨率图片之前加载低分辨率图片
                    .setImageRequest(imageRequest)
                    .setOldController(simpleDraweeView.getController())
                    .build();
            simpleDraweeView.setController(controller);

            simpleDraweeView.setId(imgaeIds[i]);//给view设置id
            simpleDraweeView.setTag(imageInfoList.get(i));
            simpleDraweeView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                }
            });
            titles[i] = imageInfoList.get(i).getTitle();
            simpleDraweeViewList.add(simpleDraweeView);

        }

        dots = addDots(mLineLayoutDot, fromResToDrawable(getActivity(), R.drawable.ic_dot_focused), simpleDraweeViewList.size());
//        dots = addDots(mLineLayoutDot, fromResToDrawable(this, R.drawable.index_bg), simpleDraweeViewList.size());
        imageCarousel = new ImageCarousel(getActivity(), mViewPager,  dots, 5000);
        imageCarousel.init(simpleDraweeViewList, titles)
                .startAutoPlay();
        imageCarousel.start();

    }

    /**
     * 动态添加一个点
     *
     * @param linearLayout 添加到LinearLayout布局
     * @param backgount    设置
     * @return 小点的Id
     */
    private int addDot(final LinearLayout linearLayout, Drawable backgount) {
        final View dot = new View(getActivity());
        LinearLayout.LayoutParams dotParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);
        dotParams.width = 16;
        dotParams.height = 16;
        dotParams.setMargins(4, 0, 4, 0);
        dot.setLayoutParams(dotParams);
        dot.setBackground(backgount);
        dot.setId(View.generateViewId());
        (getActivity()).runOnUiThread(new Runnable() {
            @Override
            public void run() {
                linearLayout.addView(dot);
            }
        });

        return dot.getId();
    }


    /**
     * 资源图片转Drawable
     *
     * @param context 上下文
     * @param resId   资源ID
     * @return 返回Drawable图像
     */
    public static Drawable fromResToDrawable(Context context, int resId) {
        return ContextCompat.getDrawable(context, resId);
        //return context.getResources().getDrawable(resId);
    }

    /**
     * 添加多个轮播小点到横向线性布局
     *
     * @param linearLayout 线性横向布局
     * @param backgount    小点资源图标
     * @param number       数量
     * @return 返回小点View集合
     */
    private List<View> addDots(final LinearLayout linearLayout, Drawable backgount, int number) {
        List<View> dots = new ArrayList<>();
        for (int i = 0; i < number; i++) {
            int dotId = addDot(linearLayout, backgount);
            dots.add(rootView.findViewById(dotId));
            Log.e(TAG,"addDot-->"+i);
        }
        return dots;
    }

    private void getData(){
        HttpProxy.obtain().get(Contants.URL+Contants.HOME_DATA, params, new HttpCallback<MainBean>() {
            @Override
            public void onFailure(String e) {
                Log.e(TAG, "onFailure: " + e);
                loadNetImg();
            }
            @Override
            public void onSuccess(MainBean result) {
//                initBubble(mounth, result.getDesc());
                Log.e(TAG, "Network result：" + result.toString() );
                allData = result;
                if(allData.getCode() == 200){//数据正常
                    setData();
                    loadNetImg();
                }else {//数据异常
                    Log.e(TAG, "Network result：" + "连接服务器失败" );
                }


            }
        });
    }
    private void setData(){
        bannerList = allData.getData().getBannerList();
        channelListBeanList = allData.getData().getChannelList();
        orderCategoryListBeanList = allData.getData().getOrderCategoryList();
        orderListBeanList = allData.getData().getOrderList();
    }

    private void loadNetImg(){
        if(bannerList == null || bannerList.size() == 0){//没有轮播图，就随便加载一点
            Log.e(TAG, "MainActivity：--------->" + "连接服务器失败，没有轮播图，就随便加载一点" );
            initEvent();
        } else {
            imageInfoList = new ArrayList<>();
            Log.e(TAG, "MainActivity ----------->" + "连接服务器成功" );
            for (MainBean.DataBean.BannerListBean bannerListBean : bannerList){
                imageInfoList.add(new ImageInfo(1, "图片1，", "",bannerListBean.getThumbnail() , bannerListBean.getHref()));
            }
        }
        imageStart();
    }

    /**
     * 初始化事件
     */
    private void initEvent() {
        imageInfoList = new ArrayList<>();
        imageInfoList.clear();
        imageInfoList.add(new ImageInfo(1, "图片1，", "", "http://d.hiphotos.baidu.com/image/pic/item/6159252dd42a2834a75bb01156b5c9ea15cebf2f.jpg", "http://www.cnblogs.com/luhuan/"));
        imageInfoList.add(new ImageInfo(1, "图片2，", "", "http://c.hiphotos.baidu.com/image/h%3D300/sign=cfce96dfa251f3dedcb2bf64a4eff0ec/4610b912c8fcc3ce912597269f45d688d43f2039.jpg", "http://www.cnblogs.com/luhuan/"));
        imageInfoList.add(new ImageInfo(1, "图片3，", "", "http://e.hiphotos.baidu.com/image/pic/item/6a600c338744ebf85ed0ab2bd4f9d72a6059a705.jpg", "http://www.cnblogs.com/luhuan/"));
        imageInfoList.add(new ImageInfo(1, "图片4，", "仅展示", "http://b.hiphotos.baidu.com/image/h%3D300/sign=8ad802f3801001e9513c120f880e7b06/a71ea8d3fd1f4134be1e4e64281f95cad1c85efa.jpg", ""));
        imageInfoList.add(new ImageInfo(1, "图片5，", "仅展示", "http://e.hiphotos.baidu.com/image/h%3D300/sign=73443062281f95cab9f594b6f9177fc5/72f082025aafa40fafb5fbc1a664034f78f019be.jpg", ""));
    }

}
