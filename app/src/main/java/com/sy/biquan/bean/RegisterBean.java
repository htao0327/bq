package com.sy.biquan.bean;

public class RegisterBean {


    /**
     * code : 200
     * message : 注册成功
     * data : {"id":"1174924081204256770","token":"mHXqyOFYxtc3fArwPEnw_1568958704684_1174924081204256770","userSig":"eJw1jk0LgkAYhP-LnsNeddd2hQ4dIgwJwrCP27rvWouZ5loY0X9PtI4z88wwb7KLE0d3tWk0CV3GmAcAk8F96oaExHOAjNpiIevaYM9RAI-5PT0mBvWtNbkZCjrnbiYQJUWgMqCcZQoDUExrhYrL-5o597CtrHpt4pSl8poU3F-sxTS6REsXDpUtvcdxtY6E7O542s5-xdaUw9WAC8ZnQD9fw485QQ__","userType":null,"userPhone":"18358108782","userCode":"yumbg8","inviteCode":"","userAvatar":"https://landscape-test.oss-cn-hangzhou.aliyuncs.com/default_avatar/%E6%9D%A8%E9%A2%96.jpeg","userAlias":"币友儿_yumbg8","isReal":null,"followCount":0,"fansCount":0,"peak":null,"taskScore":null,"remainScore":null,"allScore":null,"userImCode":"ef81b9dda4d04a6485bcd60c5eecdc8a","slogan":null}
     */

    private int code;
    private String message;
    private DataBean data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * id : 1174924081204256770
         * token : mHXqyOFYxtc3fArwPEnw_1568958704684_1174924081204256770
         * userSig : eJw1jk0LgkAYhP-LnsNeddd2hQ4dIgwJwrCP27rvWouZ5loY0X9PtI4z88wwb7KLE0d3tWk0CV3GmAcAk8F96oaExHOAjNpiIevaYM9RAI-5PT0mBvWtNbkZCjrnbiYQJUWgMqCcZQoDUExrhYrL-5o597CtrHpt4pSl8poU3F-sxTS6REsXDpUtvcdxtY6E7O542s5-xdaUw9WAC8ZnQD9fw485QQ__
         * userType : null
         * userPhone : 18358108782
         * userCode : yumbg8
         * inviteCode :
         * userAvatar : https://landscape-test.oss-cn-hangzhou.aliyuncs.com/default_avatar/%E6%9D%A8%E9%A2%96.jpeg
         * userAlias : 币友儿_yumbg8
         * isReal : null
         * followCount : 0
         * fansCount : 0
         * peak : null
         * taskScore : null
         * remainScore : null
         * allScore : null
         * userImCode : ef81b9dda4d04a6485bcd60c5eecdc8a
         * slogan : null
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
        private Object isReal;
        private int followCount;
        private int fansCount;
        private Object peak;
        private Object taskScore;
        private Object remainScore;
        private Object allScore;
        private String userImCode;
        private Object slogan;

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

        public Object getIsReal() {
            return isReal;
        }

        public void setIsReal(Object isReal) {
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

        public Object getPeak() {
            return peak;
        }

        public void setPeak(Object peak) {
            this.peak = peak;
        }

        public Object getTaskScore() {
            return taskScore;
        }

        public void setTaskScore(Object taskScore) {
            this.taskScore = taskScore;
        }

        public Object getRemainScore() {
            return remainScore;
        }

        public void setRemainScore(Object remainScore) {
            this.remainScore = remainScore;
        }

        public Object getAllScore() {
            return allScore;
        }

        public void setAllScore(Object allScore) {
            this.allScore = allScore;
        }

        public String getUserImCode() {
            return userImCode;
        }

        public void setUserImCode(String userImCode) {
            this.userImCode = userImCode;
        }

        public Object getSlogan() {
            return slogan;
        }

        public void setSlogan(Object slogan) {
            this.slogan = slogan;
        }
    }
}
