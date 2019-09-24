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

    // 存储
    public static final String USERINFO = "userInfo";
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
    public final static String URL = "http://192.168.1.19:9000";
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

}
