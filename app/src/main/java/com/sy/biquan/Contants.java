package com.sy.biquan;

public class Contants {

    public static final String ACCESS_KEY_ID = "LTAI4FuYVSZUTu9EkmNVdBbf";
    public static final String ACCESS_KEY_SECRET = "Lo9ZihFQiWhnp5tlRnJQtN8cUqGpT8";
    public static final String BUCKET = "landscape-test";
    public static final String END_POINT = "oss-cn-hangzhou.aliyuncs.com";
    public static final String BUCKET_DOMAIN = "landscape-test.oss-cn-hangzhou.aliyuncs.com";
    public static final String UPLOAD_PATH = "https://landscape-test.oss-cn-hangzhou.aliyuncs.com";

    //用户类型
    public static final int USER_TYPE_NORMAL = 1;//普通用户
    public static final int USER_TYPE_KOL = 2;//KOL
    public static final int USER_TYPE_PROJECT = 3;//项目方

    public static final int GET_DATA_SUCCESS = 200;
    public static final int GET_DATA_FAIL = 300;
    public static final String GET_YZM_REGISTER = "1";
    public static final String GET_YZM_FIND_PWD = "2";
    public static final String GET_YZM_REPLACE_PWD = "3";
    public static final String GET_YZM_MODIFY_PHONE = "4";
    public static final String GET_YZM_SET_DEAL_PWD = "5";
    public static final String GET_YZM_SET_LOGIN_PWD = "6";

    // 存储
    public static final String USERINFO = "userInfo";
    public static final String USERINFO2 = "userInfo2";
    public static final String JSONUSERINFO = "userInfo";
    public static final String ACCOUNT = "account";
    public static final String PWD = "password";
    public static final String ROOM = "room";
    public static final String AUTO_LOGIN = "auto_login";
    public static final String LOGOUT = "logout";
    public static final String ICON_URL = "icon_url";

    public static final String CHAT_INFO = "chatInfo";

    public static int PHONE_NUM_INPUT_ERROR = 1;
    public static int YZM_NUM_INPUT_ERROR = 2;
    public static int PASSWORD_INPUT_ERROR = 3;
    public static int CHECK_OK = 0;

    public final static int SDKAppID = 1400253555;
    public final static String SECRETKEY = "bc042dfa5db7c057d7d2baf1d3e06514e3ab13e6af5486a111e27c86cb4a84d4";
    public final static String MYURL = "http://192.168.1.17:9000";
//    public final static String URL = "http://121.40.245.108:9000";
    public final static String URL = "http://192.168.1.36:9000";
    public final static String HOME_DATA = "/landscape-service-provider-content/home";//首页
    public final static String LOGIN = "/landscape-service-user/user/login";//登录
    public final static String REGISTER = "/landscape-service-user/user/reg/register";//注册
    public final static String GETYZM = "/landscape-commons-service/api/sms/sendSms";//获取验证码
    public final static String SENDREDENVELOPE = "/landscape-service-im/red_packet/distribute";//发送红包
    public final static String GETREDENVELOPESNATCH = "/landscape-service-im/red_packet/snatch";//点击红包信息获取红包状态
    public final static String GETREDENVELOPE = "/landscape-service-im/red_packet/validate";//点击抢红包
    public final static String SEARCH_IMCODE_BY_PHONE = "/landscape-service-user/user/phone/";//精确搜索 通过电话号码搜索IMCODE
    public final static String CREATE_GROUP = "/landscape-service-im/im/group/create";//创建群
    public final static String GROUP_REMAIN = "/landscape-service-im/im/group/remain_number";//查询剩余可创建群数量
    public final static String ADD_WALLET = "/landscape-service-provider-content/wallet/add";//添加钱包地址
    public final static String SEARCH_GROUP = "/landscape-service-im/im/group/searchByGroupId";//精确搜索群
    public final static String SEARCH_BY_KEY = "/landscape-service-search/search/key";
    public final static String HOT_WORD_SEARCH = "/landscape-service-search/search/hot_word/list";
    public final static String MY_WALLET_LIST = "/landscape-service-provider-content/wallet/list";
    public final static String DEAL_CHECK = "/landscape-service-im/im/transaction/getTransactionTable";//交易验证
    public final static String DEAL_LAUNCH = "/landscape-service-im/im/transaction/insertTransactionTable";//交易发起
    public final static String MY_DEAL_LIST = "/landscape-service-im/im/transaction/transcationList";//我的交易列表
    public final static String DELETE_WALLET = "/landscape-service-provider-content/wallet/delete";//删除钱包地址
    public final static String KOL_LIST = "/landscape-service-kol/kol/push";//KOL推送列表
    public final static String MINE_INFO = "/landscape-service-user/user/center";//我的信息
    public final static String SET_NAME = "/landscape-service-user/user/set";//设置昵称
    public final static String HOME_BANNER = "/landscape-service-provider-content/banner/home";//首页-banner
    public final static String HOME_LIST = "/landscape-service-provider-content/wealth/home-two";//首页-列表
    public final static String HOME_TOP = "/landscape-service-provider-content/wealth/top";//巅峰榜
    public final static String KOL_ORDER = "/landscape-service-provider-content/wealth/kolOrder";//大咖荐币
    public final static String DAKA_DETAIL = "/landscape-service-provider-content/wealth/dakar/detail";//大咖详情
    public final static String DAKA_ORDER = "/landscape-service-provider-content/wealth/dakar/order";//大咖历史荐币
    public final static String JB_DETIAL = "/landscape-service-provider-content/order/detail/user";//荐币详情
    public final static String FOLLOW = "/landscape-service-provider-content/follow";//关注
    public final static String UNFOLLOW = "/landscape-service-provider-content/unFollow";//取消关注
    public final static String BUY = "/landscape-service-provider-content/order/buy";//购买荐币
    public final static String TUIJIANJB = "/landscape-service-provider-content/order/tuijian";//推荐荐币
    public final static String HOME_JB_LIST = "/landscape-service-provider-content/wealth/categoryCode";//财富密码5个列表
    public final static String KT_LIST = "/landscape-service-provider-content/airdrop/list";//空投列表
    public final static String XM_LIST = "/landscape-service-provider-content/project/list";//项目列表
    public final static String XM_DETAIL = "/landscape-service-provider-content/project/id/2";//项目详情
    public final static String XM_DETAIL_GROUP_LIST = "/landscape-service-im/im/group/project/recommend-group";//项目推荐群聊
    public final static String MODIFY_GROUP_INFO = "/landscape-service-im/im/group/update-group-info";//修改群资料
    public final static String GET_GROUP_INFO = "/landscape-service-im/im/group/info";//获取群资料
    public final static String RED_PAC_C2C = "/landscape-service-im/red_packet/distribute";//1:1红包
    public final static String RED_PAC_C2C_CLICK = "/landscape-service-im/red_packet/o2o-info";//1:1红包点击
    public final static String RED_PAC_C2C_GET = "/landscape-service-im/im/red_packet/o2o-receive";//1:1红包领取
    public final static String MY_JB_1 = "/landscape-service-provider-content/order/publish/user";//我的发布
    public final static String MY_JB_2 = "/landscape-service-provider-content/order/purchase/user";//我的购买
    public final static String MY_JB_3 = "/landscape-service-provider-content/order/follow/user";//我的关注
    public final static String BIND_USER = "/landscape-service-user/user//bind-user";//设置邀请人
    public final static String RESET = "/landscape-service-user/user/reset";//重置密码
    public final static String DEAL_PWD = "/landscape-service-user/user/set-trans-password";//设置交易密码
    public final static String GET_RED_C2C = "/landscape-service-im/red_packet/o2o-receive";//1:1抢红包
    public final static String TASK_LIST = "/landscape-service-provider-content/task/list";//任务列表
    public final static String QD_DETAIL = "/landscape-service-provider-content/order/detail/money";//Q豆明细
    public final static String DEAL_LSIT = "/landscape-service-im/im/transaction/transcationList";//交易列表

}
