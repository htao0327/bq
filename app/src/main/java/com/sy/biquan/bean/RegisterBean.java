package com.sy.biquan.bean;

public class RegisterBean {


    /**
     * code : 200
     * message : 登录成功
     * data : {"userSig":"eJw1jlELgjAUhf-LnkOumzen0IMSDlYQVOBztBU304YuK6L-nmg9nnO*D86b7de7wD4dtZalISJyAJiNbW9bljIeAJtyZ6qDc2QGLgLgKAZ6WsjYxtOJRiGUAmUIkmPyF*k89Fufdy9lFC-65W11UVCXmdKVqM3RlboprvfsoYXd5ACLn*ipHl-NpYzjKBGfL*FpMZ8_","user":{"id":"1174583453337419777","userPhone":"18358108259","userImCode":"e6e7ad49eb2b4591bc6a26bd0f070303","password":"123456","userAlias":"币友儿_pzjcfz","userAvatar":"https://landscape-test.oss-cn-hangzhou.aliyuncs.com/default_avatar/%E6%9D%A8%E9%A2%96.jpeg","slogan":"","userCode":"pzjcfz","inviteCode":"","loginIp":"","loginAddress":"","lastLoginTime":"2019-09-19 07:18:15","status":1,"isReal":1,"createTime":"2019-09-19 07:18:15","updateTime":"2019-09-19 07:18:15","remainScore":0,"taskScore":0,"allScore":0,"transactionPassword":"","userType":1,"client":"电脑","followCount":0,"peak":0,"dealPassword":"","token":"","tokenTimeOut":"y","tokenTime":"2019-09-19 07:18:15","checked":0,"jpushId":""},"token":"AIafrE3nMnBrznmY/Va0dCbmFcv5KYImYjw2foWRdAKFMxVwQNWOLdaAuOChURXqVKcWewY/p1rNdlKGjbVxFX5T1iqEwh2XGsf3uNiel+OZGMP1lMTQEy1PWKbOUAu5VPdW/wUW0nmqsew2SdHWDynQ9eept90xzit0IkZL1fc="}
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
         * userSig : eJw1jlELgjAUhf-LnkOumzen0IMSDlYQVOBztBU304YuK6L-nmg9nnO*D86b7de7wD4dtZalISJyAJiNbW9bljIeAJtyZ6qDc2QGLgLgKAZ6WsjYxtOJRiGUAmUIkmPyF*k89Fufdy9lFC-65W11UVCXmdKVqM3RlboprvfsoYXd5ACLn*ipHl-NpYzjKBGfL*FpMZ8_
         * user : {"id":"1174583453337419777","userPhone":"18358108259","userImCode":"e6e7ad49eb2b4591bc6a26bd0f070303","password":"123456","userAlias":"币友儿_pzjcfz","userAvatar":"https://landscape-test.oss-cn-hangzhou.aliyuncs.com/default_avatar/%E6%9D%A8%E9%A2%96.jpeg","slogan":"","userCode":"pzjcfz","inviteCode":"","loginIp":"","loginAddress":"","lastLoginTime":"2019-09-19 07:18:15","status":1,"isReal":1,"createTime":"2019-09-19 07:18:15","updateTime":"2019-09-19 07:18:15","remainScore":0,"taskScore":0,"allScore":0,"transactionPassword":"","userType":1,"client":"电脑","followCount":0,"peak":0,"dealPassword":"","token":"","tokenTimeOut":"y","tokenTime":"2019-09-19 07:18:15","checked":0,"jpushId":""}
         * token : AIafrE3nMnBrznmY/Va0dCbmFcv5KYImYjw2foWRdAKFMxVwQNWOLdaAuOChURXqVKcWewY/p1rNdlKGjbVxFX5T1iqEwh2XGsf3uNiel+OZGMP1lMTQEy1PWKbOUAu5VPdW/wUW0nmqsew2SdHWDynQ9eept90xzit0IkZL1fc=
         */

        private String userSig;
        private UserBean user;
        private String token;

        public String getUserSig() {
            return userSig;
        }

        public void setUserSig(String userSig) {
            this.userSig = userSig;
        }

        public UserBean getUser() {
            return user;
        }

        public void setUser(UserBean user) {
            this.user = user;
        }

        public String getToken() {
            return token;
        }

        public void setToken(String token) {
            this.token = token;
        }

        public static class UserBean {
            /**
             * id : 1174583453337419777
             * userPhone : 18358108259
             * userImCode : e6e7ad49eb2b4591bc6a26bd0f070303
             * password : 123456
             * userAlias : 币友儿_pzjcfz
             * userAvatar : https://landscape-test.oss-cn-hangzhou.aliyuncs.com/default_avatar/%E6%9D%A8%E9%A2%96.jpeg
             * slogan :
             * userCode : pzjcfz
             * inviteCode :
             * loginIp :
             * loginAddress :
             * lastLoginTime : 2019-09-19 07:18:15
             * status : 1
             * isReal : 1
             * createTime : 2019-09-19 07:18:15
             * updateTime : 2019-09-19 07:18:15
             * remainScore : 0.0
             * taskScore : 0.0
             * allScore : 0.0
             * transactionPassword :
             * userType : 1
             * client : 电脑
             * followCount : 0
             * peak : 0
             * dealPassword :
             * token :
             * tokenTimeOut : y
             * tokenTime : 2019-09-19 07:18:15
             * checked : 0
             * jpushId :
             */

            private String id;
            private String userPhone;
            private String userImCode;
            private String password;
            private String userAlias;
            private String userAvatar;
            private String slogan;
            private String userCode;
            private String inviteCode;
            private String loginIp;
            private String loginAddress;
            private String lastLoginTime;
            private int status;
            private int isReal;
            private String createTime;
            private String updateTime;
            private double remainScore;
            private double taskScore;
            private double allScore;
            private String transactionPassword;
            private int userType;
            private String client;
            private int followCount;
            private int peak;
            private String dealPassword;
            private String token;
            private String tokenTimeOut;
            private String tokenTime;
            private int checked;
            private String jpushId;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getUserPhone() {
                return userPhone;
            }

            public void setUserPhone(String userPhone) {
                this.userPhone = userPhone;
            }

            public String getUserImCode() {
                return userImCode;
            }

            public void setUserImCode(String userImCode) {
                this.userImCode = userImCode;
            }

            public String getPassword() {
                return password;
            }

            public void setPassword(String password) {
                this.password = password;
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

            public String getSlogan() {
                return slogan;
            }

            public void setSlogan(String slogan) {
                this.slogan = slogan;
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

            public String getLoginIp() {
                return loginIp;
            }

            public void setLoginIp(String loginIp) {
                this.loginIp = loginIp;
            }

            public String getLoginAddress() {
                return loginAddress;
            }

            public void setLoginAddress(String loginAddress) {
                this.loginAddress = loginAddress;
            }

            public String getLastLoginTime() {
                return lastLoginTime;
            }

            public void setLastLoginTime(String lastLoginTime) {
                this.lastLoginTime = lastLoginTime;
            }

            public int getStatus() {
                return status;
            }

            public void setStatus(int status) {
                this.status = status;
            }

            public int getIsReal() {
                return isReal;
            }

            public void setIsReal(int isReal) {
                this.isReal = isReal;
            }

            public String getCreateTime() {
                return createTime;
            }

            public void setCreateTime(String createTime) {
                this.createTime = createTime;
            }

            public String getUpdateTime() {
                return updateTime;
            }

            public void setUpdateTime(String updateTime) {
                this.updateTime = updateTime;
            }

            public double getRemainScore() {
                return remainScore;
            }

            public void setRemainScore(double remainScore) {
                this.remainScore = remainScore;
            }

            public double getTaskScore() {
                return taskScore;
            }

            public void setTaskScore(double taskScore) {
                this.taskScore = taskScore;
            }

            public double getAllScore() {
                return allScore;
            }

            public void setAllScore(double allScore) {
                this.allScore = allScore;
            }

            public String getTransactionPassword() {
                return transactionPassword;
            }

            public void setTransactionPassword(String transactionPassword) {
                this.transactionPassword = transactionPassword;
            }

            public int getUserType() {
                return userType;
            }

            public void setUserType(int userType) {
                this.userType = userType;
            }

            public String getClient() {
                return client;
            }

            public void setClient(String client) {
                this.client = client;
            }

            public int getFollowCount() {
                return followCount;
            }

            public void setFollowCount(int followCount) {
                this.followCount = followCount;
            }

            public int getPeak() {
                return peak;
            }

            public void setPeak(int peak) {
                this.peak = peak;
            }

            public String getDealPassword() {
                return dealPassword;
            }

            public void setDealPassword(String dealPassword) {
                this.dealPassword = dealPassword;
            }

            public String getToken() {
                return token;
            }

            public void setToken(String token) {
                this.token = token;
            }

            public String getTokenTimeOut() {
                return tokenTimeOut;
            }

            public void setTokenTimeOut(String tokenTimeOut) {
                this.tokenTimeOut = tokenTimeOut;
            }

            public String getTokenTime() {
                return tokenTime;
            }

            public void setTokenTime(String tokenTime) {
                this.tokenTime = tokenTime;
            }

            public int getChecked() {
                return checked;
            }

            public void setChecked(int checked) {
                this.checked = checked;
            }

            public String getJpushId() {
                return jpushId;
            }

            public void setJpushId(String jpushId) {
                this.jpushId = jpushId;
            }
        }
    }
}
