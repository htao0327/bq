package com.sy.biquan.bean;

public class RegisterBean {

    /**
     * msg : 成功
     * code : 200
     * data : {"id":"1178163237804019713","token":"34zAeawQcowYtMjARE4U_1569730979797_1178163237804019713","userSig":"eJw1jssOgjAQRf*la2OGPmhL4kI3KhASg6Db0lZsDAaRKNH47zagu7lzz5nMG*3TfG6H1nUWRQFjDAPAbNw*bIcihOeApnw3F9W2zniOAmBGPD01zthr705uFKipNFdWEUaIn7HkwIgNmdBKCE3E-5qrPZxtkrA3WqerpsheW1rFRcl4cCh3yZqX9HlUg7gtz7HO68VP7F0zvhpKTkBy*fkCR*o3xg__","userType":null,"userPhone":"18358108782","userCode":"qk3m7h","inviteCode":"123456","userAvatar":"https://landscape-test.oss-cn-hangzhou.aliyuncs.com/default_avatar/%E6%9D%A8%E9%A2%96.jpeg","userAlias":"币友儿_qk3m7h","isReal":1,"followCount":0,"fansCount":0,"peak":0,"taskScore":0,"remainScore":0,"allScore":0,"userImCode":"4dbc7aea35334db297053e658ca88c38","slogan":"一枚默默无闻的币友儿","deal_password":0}
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
         * id : 1178163237804019713
         * token : 34zAeawQcowYtMjARE4U_1569730979797_1178163237804019713
         * userSig : eJw1jssOgjAQRf*la2OGPmhL4kI3KhASg6Db0lZsDAaRKNH47zagu7lzz5nMG*3TfG6H1nUWRQFjDAPAbNw*bIcihOeApnw3F9W2zniOAmBGPD01zthr705uFKipNFdWEUaIn7HkwIgNmdBKCE3E-5qrPZxtkrA3WqerpsheW1rFRcl4cCh3yZqX9HlUg7gtz7HO68VP7F0zvhpKTkBy*fkCR*o3xg__
         * userType : null
         * userPhone : 18358108782
         * userCode : qk3m7h
         * inviteCode : 123456
         * userAvatar : https://landscape-test.oss-cn-hangzhou.aliyuncs.com/default_avatar/%E6%9D%A8%E9%A2%96.jpeg
         * userAlias : 币友儿_qk3m7h
         * isReal : 1
         * followCount : 0
         * fansCount : 0
         * peak : 0
         * taskScore : 0
         * remainScore : 0
         * allScore : 0
         * userImCode : 4dbc7aea35334db297053e658ca88c38
         * slogan : 一枚默默无闻的币友儿
         * deal_password : 0
         */

        private String id;
        private String token;
        private String userSig;
        private int userType;
        private String userPhone;
        private String userCode;
        private String inviteCode;
        private String userAvatar;
        private String userAlias;
        private int isReal;
        private int followCount;
        private int fansCount;
        private int peak;
        private double taskScore;
        private double remainScore;
        private double allScore;
        private String userImCode;
        private String slogan;
        private int deal_password;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getToken() {
            return token;
        }

        public void setToken(String token) {
            this.token = token;
        }

        public String getUserSig() {
            return userSig;
        }

        public void setUserSig(String userSig) {
            this.userSig = userSig;
        }

        public int getUserType() {
            return userType;
        }

        public void setUserType(int userType) {
            this.userType = userType;
        }

        public String getUserPhone() {
            return userPhone;
        }

        public void setUserPhone(String userPhone) {
            this.userPhone = userPhone;
        }

        public String getUserCode() {
            return userCode;
        }

        public void setUserCode(String userCode) {
            this.userCode = userCode;
        }

        public String getInviteCode() {
            return inviteCode;
        }

        public void setInviteCode(String inviteCode) {
            this.inviteCode = inviteCode;
        }

        public String getUserAvatar() {
            return userAvatar;
        }

        public void setUserAvatar(String userAvatar) {
            this.userAvatar = userAvatar;
        }

        public String getUserAlias() {
            return userAlias;
        }

        public void setUserAlias(String userAlias) {
            this.userAlias = userAlias;
        }

        public int getIsReal() {
            return isReal;
        }

        public void setIsReal(int isReal) {
            this.isReal = isReal;
        }

        public int getFollowCount() {
            return followCount;
        }

        public void setFollowCount(int followCount) {
            this.followCount = followCount;
        }

        public int getFansCount() {
            return fansCount;
        }

        public void setFansCount(int fansCount) {
            this.fansCount = fansCount;
        }

        public int getPeak() {
            return peak;
        }

        public void setPeak(int peak) {
            this.peak = peak;
        }

        public double getTaskScore() {
            return taskScore;
        }

        public void setTaskScore(double taskScore) {
            this.taskScore = taskScore;
        }

        public double getRemainScore() {
            return remainScore;
        }

        public void setRemainScore(double remainScore) {
            this.remainScore = remainScore;
        }

        public double getAllScore() {
            return allScore;
        }

        public void setAllScore(double allScore) {
            this.allScore = allScore;
        }

        public String getUserImCode() {
            return userImCode;
        }

        public void setUserImCode(String userImCode) {
            this.userImCode = userImCode;
        }

        public String getSlogan() {
            return slogan;
        }

        public void setSlogan(String slogan) {
            this.slogan = slogan;
        }

        public int getDeal_password() {
            return deal_password;
        }

        public void setDeal_password(int deal_password) {
            this.deal_password = deal_password;
        }
    }
}
