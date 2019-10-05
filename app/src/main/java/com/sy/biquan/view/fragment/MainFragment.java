package com.sy.biquan.view.fragment;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.core.content.ContextCompat;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
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
import com.sy.biquan.MainActivity;
import com.sy.biquan.R;
import com.sy.biquan.activity.CFMMActivity;
import com.sy.biquan.activity.JBActivity;
import com.sy.biquan.activity.KTActivity;
import com.sy.biquan.activity.LoginActivity;
import com.sy.biquan.activity.RemenActivity;
import com.sy.biquan.activity.SearchActivity;
import com.sy.biquan.activity.SendJbActivity;
import com.sy.biquan.activity.WebSitActivity;
import com.sy.biquan.activity.XMActivity;
import com.sy.biquan.adapter.JBAdapter;
import com.sy.biquan.adapter.MainMenuAdapter;
import com.sy.biquan.adapter.MainViewPagerAdapter;
import com.sy.biquan.bean.BannerBean;
import com.sy.biquan.bean.MainListData;
import com.sy.biquan.bean.RegisterBean;
import com.sy.biquan.proxy.HttpCallback;
import com.sy.biquan.proxy.HttpProxy;
import com.sy.biquan.util.SharedPreferencesUtil;
import com.sy.biquan.viewutil.ImageCarousel;
import com.sy.biquan.viewutil.ImageInfo;
import com.sy.biquan.viewutil.TabLayoutUtil;
import com.sy.biquan.viewutil.ViewPagerForScrollView;
import com.tencent.qcloud.tim.uikit.base.BaseFragment;
import com.tencent.qcloud.tim.uikit.utils.ToastUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainFragment extends Fragment implements View.OnClickListener {

    private EditText etSearch;
    private View rootView;
    private NestedScrollView mSv;
    private LinearLayout ll_tab_layout,ll_tab_layout2;

    private TabLayout mTabLayout,mTabLayout2;
    private ViewPagerForScrollView titleViewPager;
    private List<String> mTabTitles = new ArrayList(){};//{"全部","最新","最热","当前涨幅","预期涨幅"}
    private List<Fragment> mFragments = new ArrayList<>();
//    private MainViewPagerAdapter mAdapter;
//    private LayoutInflater mInflater;
//    private View view1;
//    private View view2;
//    private View view3;
//    private View view4;
//    private View view5;
//    private List<View> mViewList = new ArrayList<>();

    private MainMenuAdapter mainMenuAdapter;


//    private String imCode = "";

    private TextView tv_cfmm,tv_jb,tv_kt,tv_xm,tv_rm;
    private LinearLayout ll_cfmm,jb,kt,xm,remen;
//    private ImageView

    // 图片轮播控件
    private ViewPager mViewPager;
    private LinearLayout mLineLayoutDot;
    private ImageCarousel imageCarousel;
    private List<View> dots = new ArrayList<>();//小点

    private ImageView iv_more;

    private List<BannerBean.DataBean> bannerLists;

    // 图片数据，包括图片标题、图片链接、数据、点击要打开的网站（点击打开的网页或一些提示指令）
    private List<ImageInfo> imageInfoList;


//    private MainBean allData;
//    List<MainBean.DataBean.ChannelListBean> channelListBeanList;//大模块列表 财富密码等
//    List<MainBean.DataBean.BannerListBean> bannerList;//轮播图列表
//    List<MainBean.DataBean.OrderCategoryListBean> orderCategoryListBeanList;//标题列表  最热等
//    List<MainBean.DataBean.OrderListBean> orderListBeanList;//最下方默认列表



    int scrollY;

    private static final String TAG = "MainActivity";
    private Map<String,String> params = new HashMap<>();

    public MainFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return rootView = inflater.inflate(R.layout.fragment_main, container, false);
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView();
//        RegisterBean registerBean = SharedPreferencesUtil.getUserInfo();
//        if(registerBean != null && !"".equals(registerBean.toString())) {
//            imCode = registerBean.getData().getUserImCode();
//        }
        mTabTitles.add("全新");
        mTabTitles.add("最新");
        mTabTitles.add("最热");
        mTabTitles.add("当前涨幅");
        mTabTitles.add("预期涨幅");
        JBFragment jbFragment = new JBFragment();
        MainNewFragment newFragment = new MainNewFragment();
        MainHotFragment hotFragment = new MainHotFragment();
        MainDqzfFragment dqzfFragment = new MainDqzfFragment();
        MainYqzfFragment mainYqzfFragment = new MainYqzfFragment();
        mFragments.add(jbFragment);
        mFragments.add(newFragment);
        mFragments.add(hotFragment);
        mFragments.add(dqzfFragment);
        mFragments.add(mainYqzfFragment);
        titleViewPager.setAdapter(new JBAdapter(getActivity().getSupportFragmentManager(),mFragments,mTabTitles));
        TabLayoutUtil.setTabLayoutIndicator(mTabLayout);
        TabLayoutUtil.setTabLayoutIndicator(mTabLayout2);
        mTabLayout.setupWithViewPager(titleViewPager);
        mTabLayout2.setupWithViewPager(titleViewPager);
        etSearch.setFocusable(false);
        getScrollY();
        iv_more.setOnClickListener(this);
        etSearch.setOnClickListener(this);

        remen.setOnClickListener(this);
        ll_cfmm.setOnClickListener(this);
        xm.setOnClickListener(this);
        kt.setOnClickListener(this);
        jb.setOnClickListener(this);

        mSv.setOnScrollChangeListener(new View.OnScrollChangeListener() {
            @Override
            public void onScrollChange(View view, int i, int i1, int i2, int i3) {
                if(getTabLayoutY() >= scrollY){
                    Log.e(TAG,"隐藏"+ll_tab_layout2.getVisibility()+"--scrollY--"+scrollY);
                    if(ll_tab_layout2.getVisibility() == View.VISIBLE){
                        ll_tab_layout2.setVisibility(View.GONE);
                    }
                }
                if(getTabLayoutY() < scrollY){
                    Log.e(TAG,"可以显示了"+ll_tab_layout2.getVisibility()+"--scrollY--"+scrollY);
                    if (!(ll_tab_layout2.getVisibility() == View.VISIBLE)){
                        ll_tab_layout2.setVisibility(View.VISIBLE);
                    }
                }
            }
        });
        getImageData();
//        initEvent();
//        imageStart();
//        getData();
    }

    private void getScrollY(){
        final int[] y = new int[1];
        final int[] y2 = new int[1];
        mSv.post(new Runnable() {
            @Override
            public void run() {
                int []location=new int[2];
                int[] location2 = new int[2];
                mSv.getLocationOnScreen(location);
                mSv.getLocationInWindow(location2);
                int x=location[0];//获取当前位置的横坐标
                y[0] =location[1];//获取当前位置的纵坐标
                y2[0] = location2[1];
                Log.e(TAG,"scrollview-OnScreen-Y-->"+ y[0]);
                Log.e(TAG,"scrollview-InWindow-Y-->"+ y2[0]);
                scrollY = y[0];
            }
        });
    }
    private int getTabLayoutY(){
        int[] location=new int[2];
        int[] location2 = new int[2];
        ll_tab_layout.getLocationOnScreen(location);
        ll_tab_layout.getLocationInWindow(location2);
        int y2 = location2[1];
        int x=location[0];//获取当前位置的横坐标
        int y=location[1];//获取当前位置的纵坐标
        Log.e(TAG,"TabLayout--Y-->"+y);
        Log.e(TAG,"TabLayout-InWindow-Y-->"+y2);
        return y;
    }

    @Override
    public void onClick(View view) {
        if(!SharedPreferencesUtil.isLogin()){
            startActivity(new Intent(getActivity(), LoginActivity.class));
            return;
        }
        switch (view.getId()){
            case R.id.iv_more:
//                startActivity(new Intent(getActivity(), SendJbActivity.class));
                startActivity(new Intent(getActivity(), WebSitActivity.class));
                break;
            case R.id.et_search:
                startActivity(new Intent(getActivity(), SearchActivity.class));
                break;
            case R.id.ll_remen:
                startActivity(new Intent(getActivity(), RemenActivity.class));
                break;
            case R.id.ll_cfmm:
                startActivity(new Intent(getActivity(), CFMMActivity.class));
                break;
            case R.id.ll_xm:
                startActivity(new Intent(getActivity(), XMActivity.class));
                break;
            case R.id.ll_kt:
                startActivity(new Intent(getActivity(), KTActivity.class));
                break;
            case R.id.ll_jb:
                startActivity(new Intent(getActivity(), JBActivity.class));
                break;
        }
    }

    private void initView(){
        etSearch = rootView.findViewById(R.id.et_search);
        mSv = rootView.findViewById(R.id.sv_main);
        mViewPager = rootView.findViewById(R.id.viewPager);
//        mTvPagerTitle = rootView.findViewById(R.id.tv_pager_title);
        mLineLayoutDot = rootView.findViewById(R.id.lineLayout_dot);
        mTabLayout = rootView.findViewById(R.id.tab_layout);
        mTabLayout2 = rootView.findViewById(R.id.tab_layout_disable);
        titleViewPager = rootView.findViewById(R.id.title_view_pager);
        ll_cfmm = rootView.findViewById(R.id.ll_cfmm);
        jb = rootView.findViewById(R.id.ll_jb);
        kt = rootView.findViewById(R.id.ll_kt);
        xm = rootView.findViewById(R.id.ll_xm);
        remen = rootView.findViewById(R.id.ll_remen);
        ll_tab_layout = rootView.findViewById(R.id.ll_tab_layout);
        ll_tab_layout2 = rootView.findViewById(R.id.ll_tab_layout_disable);
        iv_more = rootView.findViewById(R.id.iv_more);

//        mainMenuAdapter = new MainMenuAdapter();
    }

    private void imageStart() {
        //设置图片轮播
        int[] imgaeIds = new int[]{R.id.pager_image1, R.id.pager_image2, R.id.pager_image3, R.id.pager_image4,
                R.id.pager_image5, R.id.pager_image6, R.id.pager_image7, R.id.pager_image8,R.id.pager_image9, R.id.pager_image10, R.id.pager_image11,
                R.id.pager_image12,
                R.id.pager_image13, R.id.pager_image14, R.id.pager_image15, R.id.pager_image16};
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

    private void getImageData(){
        Map<String,String> params = new HashMap<>();
        HttpProxy.obtain().post(Contants.URL + Contants.HOME_BANNER, params, new HttpCallback<BannerBean>() {
            @Override
            public void onFailure(String e) {

            }

            @Override
            public void onSuccess(BannerBean bannerBean) {
                bannerLists = bannerBean.getData();
                imageInfoList = new ArrayList<>();
                for (BannerBean.DataBean banner : bannerLists){
                    imageInfoList.add(new ImageInfo(1, "图片1，", "",banner.getThumbnail() , banner.getHref()));
                }
                imageStart();

            }
        });
    }


}
