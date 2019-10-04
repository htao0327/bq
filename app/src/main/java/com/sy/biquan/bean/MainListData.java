package com.sy.biquan.bean;

import java.util.List;

public class MainListData {

    /**
     * msg : ok
     * code : 200
     * data : [{"income":30,"userAvatar":"http://pic16.nipic.com/20111006/6239936_092702973000_2.jpg","fanNum":1,"title":"结束订单","userName":"管理员","expectedSucRate":0,"userID":"1","isLock":0,"isFollow":0,"bourse":[{"exchangeRegSite":"http://zhucedizhi","exchangeName":"抹茶","id":"1","exchangeSite":"http://guanwangdizhi"},{"exchangeRegSite":"http://zhucedizhi","exchangeName":"火币","id":"2","exchangeSite":"http://guanwangdizhi"},{"exchangeRegSite":"http://zhucedizhi","exchangeName":"币安","id":"3","exchangeSite":"http://guanwangdizhi"}],"nowRise":-0.82,"expectedRise":10,"avgIncomeRate":0,"currency":"ETH","startTime":"0天22小时15分钟前","id":"1178963595820138491","slogan":"","qbNumer":30},{"income":30,"userAvatar":"http://pic16.nipic.com/20111006/6239936_092702973000_2.jpg","fanNum":1,"title":"测试订单","userName":"管理员","expectedSucRate":0,"userID":"1","isLock":0,"isFollow":0,"bourse":[{"exchangeRegSite":"http://zhucedizhi","exchangeName":"抹茶","id":"1","exchangeSite":"http://guanwangdizhi"},{"exchangeRegSite":"http://zhucedizhi","exchangeName":"火币","id":"2","exchangeSite":"http://guanwangdizhi"},{"exchangeRegSite":"http://zhucedizhi","exchangeName":"币安","id":"3","exchangeSite":"http://guanwangdizhi"}],"nowRise":-1.59,"expectedRise":10,"avgIncomeRate":0,"currency":"ETH","startTime":"0天22小时15分钟前","id":"1178963595820138498","slogan":"","qbNumer":30}]
     */

    private String msg;
    private int code;
    private List<DataBean> data;

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

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * income : 30.0
         * userAvatar : http://pic16.nipic.com/20111006/6239936_092702973000_2.jpg
         * fanNum : 1
         * title : 结束订单
         * userName : 管理员
         * expectedSucRate : 0.0
         * userID : 1
         * isLock : 0
         * isFollow : 0
         * bourse : [{"exchangeRegSite":"http://zhucedizhi","exchangeName":"抹茶","id":"1","exchangeSite":"http://guanwangdizhi"},{"exchangeRegSite":"http://zhucedizhi","exchangeName":"火币","id":"2","exchangeSite":"http://guanwangdizhi"},{"exchangeRegSite":"http://zhucedizhi","exchangeName":"币安","id":"3","exchangeSite":"http://guanwangdizhi"}]
         * nowRise : -0.82
         * expectedRise : 10.0
         * avgIncomeRate : 0.0
         * currency : ETH
         * startTime : 0天22小时15分钟前
         * id : 1178963595820138491
         * slogan :
         * qbNumer : 30
         */

        private double income;
        private String userAvatar;
        private int fanNum;
        private String title;
        private String userName;
        private double expectedSucRate;
        private String userID;
        private int isLock;
        private int isFollow;
        private double nowRise;
        private double expectedRise;
        private double avgIncomeRate;
        private String currency;
        private String startTime;
        private String id;
        private String slogan;
        private int qbNumer;
        private List<BourseBean> bourse;

        public double getIncome() {
            return income;
        }

        public void setIncome(double income) {
            this.income = income;
        }

        public String getUserAvatar() {
            return userAvatar;
        }

        public void setUserAvatar(String userAvatar) {
            this.userAvatar = userAvatar;
        }

        public int getFanNum() {
            return fanNum;
        }

        public void setFanNum(int fanNum) {
            this.fanNum = fanNum;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }

        public double getExpectedSucRate() {
            return expectedSucRate;
        }

        public void setExpectedSucRate(double expectedSucRate) {
            this.expectedSucRate = expectedSucRate;
        }

        public String getUserID() {
            return userID;
        }

        public void setUserID(String userID) {
            this.userID = userID;
        }

        public int getIsLock() {
            return isLock;
        }

        public void setIsLock(int isLock) {
            this.isLock = isLock;
        }

        public int getIsFollow() {
            return isFollow;
        }

        public void setIsFollow(int isFollow) {
            this.isFollow = isFollow;
        }

        public double getNowRise() {
            return nowRise;
        }

        public void setNowRise(double nowRise) {
            this.nowRise = nowRise;
        }

        public double getExpectedRise() {
            return expectedRise;
        }

        public void setExpectedRise(double expectedRise) {
            this.expectedRise = expectedRise;
        }

        public double getAvgIncomeRate() {
            return avgIncomeRate;
        }

        public void setAvgIncomeRate(double avgIncomeRate) {
            this.avgIncomeRate = avgIncomeRate;
        }

        public String getCurrency() {
            return currency;
        }

        public void setCurrency(String currency) {
            this.currency = currency;
        }

        public String getStartTime() {
            return startTime;
        }

        public void setStartTime(String startTime) {
            this.startTime = startTime;
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

        public int getQbNumer() {
            return qbNumer;
        }

        public void setQbNumer(int qbNumer) {
            this.qbNumer = qbNumer;
        }

        public List<BourseBean> getBourse() {
            return bourse;
        }

        public void setBourse(List<BourseBean> bourse) {
            this.bourse = bourse;
        }

        public static class BourseBean {
            /**
             * exchangeRegSite : http://zhucedizhi
             * exchangeName : 抹茶
             * id : 1
             * exchangeSite : http://guanwangdizhi
             */

            private String exchangeRegSite;
            private String exchangeName;
            private String id;
            private String exchangeSite;

            public String getExchangeRegSite() {
                return exchangeRegSite;
            }

            public void setExchangeRegSite(String exchangeRegSite) {
                this.exchangeRegSite = exchangeRegSite;
            }

            public String getExchangeName() {
                return exchangeName;
            }

            public void setExchangeName(String exchangeName) {
                this.exchangeName = exchangeName;
            }

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getExchangeSite() {
                return exchangeSite;
            }

            public void setExchangeSite(String exchangeSite) {
                this.exchangeSite = exchangeSite;
            }
        }
    }
}
