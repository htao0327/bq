package com.sy.biquan.bean;

public class MineDataBean {

    /**
     * msg : ok
     * code : 200
     * data : {"userImCode":"a340849523a247ada3cfffcb08304f7d","fansCount":0,"followCount":1,"userAlias":"币友儿_qijmrn","userAvatar":"https://landscape-test.oss-cn-hangzhou.aliyuncs.com/default_avatar/%E6%9D%A8%E9%A2%96.jpeg","id":"1174882402065584130","slogan":"一枚默默无闻的币友儿22334","qbNumber":1114,"userPhone":"17376580796","authStatus":"","deal_password":"","hasInviteCode":"","inviteUserId":"","inviteUserAlias":"","token":"","userType":""}
     */

    private String msg;
    private int code;
    private DataBean data;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * userImCode : a340849523a247ada3cfffcb08304f7d
         * fansCount : 0
         * followCount : 1
         * userAlias : 币友儿_qijmrn
         * userAvatar : https://landscape-test.oss-cn-hangzhou.aliyuncs.com/default_avatar/%E6%9D%A8%E9%A2%96.jpeg
         * id : 1174882402065584130
         * slogan : 一枚默默无闻的币友儿22334
         * qbNumber : 1114
         * userPhone : 17376580796
         * authStatus :
         * deal_password :
         * hasInviteCode :
         * inviteUserId :
         * inviteUserAlias :
         * token :
         * userType :
         */

        private String userImCode;
        private int fansCount;
        private int followCount;
        private String userAlias;
        private String userAvatar;
        private String id;
        private String slogan;
        private int qbNumber;
        private String userPhone;
        private String authStatus;
        private String deal_password;
        private String hasInviteCode;
        private String inviteUserId;
        private String inviteUserAlias;
        private String token;
        private String userType;

        public String getUserImCode() {
            return userImCode;
        }

        public void setUserImCode(String userImCode) {
            this.userImCode = userImCode;
        }

        public int getFansCount() {
            return fansCount;
        }

        public void setFansCount(int fansCount) {
            this.fansCount = fansCount;
        }

        public int getFollowCount() {
            return followCount;
        }

        public void setFollowCount(int followCount) {
            this.followCount = followCount;
        }

        public String getUserAlias() {
            return userAlias;
        }

        public void setUserAlias(String userAlias) {
            this.userAlias = userAlias;
        }

        public String getUserAvatar() {
            return userAvatar;
        }

        public void setUserAvatar(String userAvatar) {
            this.userAvatar = userAvatar;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getSlogan() {
            return slogan;
        }

        public void setSlogan(String slogan) {
            this.slogan = slogan;
        }

        public int getQbNumber() {
            return qbNumber;
        }

        public void setQbNumber(int qbNumber) {
            this.qbNumber = qbNumber;
        }

        public String getUserPhone() {
            return userPhone;
        }

        public void setUserPhone(String userPhone) {
            this.userPhone = userPhone;
        }

        public String getAuthStatus() {
            return authStatus;
        }

        public void setAuthStatus(String authStatus) {
            this.authStatus = authStatus;
        }

        public String getDeal_password() {
            return deal_password;
        }

        public void setDeal_password(String deal_password) {
            this.deal_password = deal_password;
        }

        public String getHasInviteCode() {
            return hasInviteCode;
        }

        public void setHasInviteCode(String hasInviteCode) {
            this.hasInviteCode = hasInviteCode;
        }

        public String getInviteUserId() {
            return inviteUserId;
        }

        public void setInviteUserId(String inviteUserId) {
            this.inviteUserId = inviteUserId;
        }

        public String getInviteUserAlias() {
            return inviteUserAlias;
        }

        public void setInviteUserAlias(String inviteUserAlias) {
            this.inviteUserAlias = inviteUserAlias;
        }

        public String getToken() {
            return token;
        }

        public void setToken(String token) {
            this.token = token;
        }

        public String getUserType() {
            return userType;
        }

        public void setUserType(String userType) {
            this.userType = userType;
        }
    }
}
