package com.sy.biquan.bean;

public class LoginBean {

    /**
     * msg : 成功
     * code : 200
     * data : {"userSig":"eJw1jk0LgkAURf-LrMOeH895CG0cpEVSSGG4jGaqhymDigrRf8*0lvfec*C*xCk9Oma03BgRuYjoAcBqbnvTiEh4Doglt7q8WMt64gIAD-2JXhbWpu74xrPgko-kAkkK-iLfv32xTrAox7HPKsr63eOp6m0wpLkkpXIYrvvwcFaxbpNs8xM7ruZXIZFEn-D9AcxZMUM_","user":{"id":"1174573168161980417","userPhone":"18358108784","userImCode":"fd4b7482224f4a7ca324367d570e11ab","password":"123456","userAlias":"币友儿_rn50q7","userAvatar":"https://landscape-test.oss-cn-hangzhou.aliyuncs.com/default_avatar/%E6%9D%A8%E9%A2%96.jpeg","slogan":"","userCode":"rn50q7","inviteCode":"","loginIp":"192.168.126.2","loginAddress":"定位失败","lastLoginTime":"2019-09-19 06:36:18","status":1,"isReal":1,"createTime":"2019-09-19 06:36:18","updateTime":"2019-09-19 06:36:18","remainScore":0,"taskScore":0,"allScore":0,"transactionPassword":"","userType":1,"client":"","followCount":0,"peak":0,"dealPassword":" d4 ","token":"DM4Ed1M73Trvc30Ln8w6_1568875384151_1174573168161980417","tokenTimeOut":"n","tokenTime":"2019-09-19 14:43:04","checked":0,"jpushId":""},"token":"DM4Ed1M73Trvc30Ln8w6_1568875384151_1174573168161980417"}
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
         * userSig : eJw1jk0LgkAURf-LrMOeH895CG0cpEVSSGG4jGaqhymDigrRf8*0lvfec*C*xCk9Oma03BgRuYjoAcBqbnvTiEh4Doglt7q8WMt64gIAD-2JXhbWpu74xrPgko-kAkkK-iLfv32xTrAox7HPKsr63eOp6m0wpLkkpXIYrvvwcFaxbpNs8xM7ruZXIZFEn-D9AcxZMUM_
         * user : {"id":"1174573168161980417","userPhone":"18358108784","userImCode":"fd4b7482224f4a7ca324367d570e11ab","password":"123456","userAlias":"币友儿_rn50q7","userAvatar":"https://landscape-test.oss-cn-hangzhou.aliyuncs.com/default_avatar/%E6%9D%A8%E9%A2%96.jpeg","slogan":"","userCode":"rn50q7","inviteCode":"","loginIp":"192.168.126.2","loginAddress":"定位失败","lastLoginTime":"2019-09-19 06:36:18","status":1,"isReal":1,"createTime":"2019-09-19 06:36:18","updateTime":"2019-09-19 06:36:18","remainScore":0,"taskScore":0,"allScore":0,"transactionPassword":"","userType":1,"client":"","followCount":0,"peak":0,"dealPassword":" d4 ","token":"DM4Ed1M73Trvc30Ln8w6_1568875384151_1174573168161980417","tokenTimeOut":"n","tokenTime":"2019-09-19 14:43:04","checked":0,"jpushId":""}
         * token : DM4Ed1M73Trvc30Ln8w6_1568875384151_1174573168161980417
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
             * id : 1174573168161980417
             * userPhone : 18358108784
             * userImCode : fd4b7482224f4a7ca324367d570e11ab
             * password : 123456
             * userAlias : 币友儿_rn50q7
             * userAvatar : https://landscape-test.oss-cn-hangzhou.aliyuncs.com/default_avatar/%E6%9D%A8%E9%A2%96.jpeg
             * slogan :
             * userCode : rn50q7
             * inviteCode :
             * loginIp : 192.168.126.2
             * loginAddress : 定位失败
             * lastLoginTime : 2019-09-19 06:36:18
             * status : 1
             * isReal : 1
             * createTime : 2019-09-19 06:36:18
             * updateTime : 2019-09-19 06:36:18
             * remainScore : 0.0
             * taskScore : 0.0
             * allScore : 0.0
             * transactionPassword :
             * userType : 1
             * client :
             * followCount : 0
             * peak : 0
             * dealPassword :  d4
             * token : DM4Ed1M73Trvc30Ln8w6_1568875384151_1174573168161980417
             * tokenTimeOut : n
             * tokenTime : 2019-09-19 14:43:04
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
