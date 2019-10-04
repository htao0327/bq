package com.sy.biquan.bean;

import java.util.List;

public class JbDetailBean {

    /**
     * msg : ok
     * code : 200
     * data : {"tuiJianPrice":6747,"jb_desc":"1","avgRecommendRise":9.24,"userAvatar":"https://landscape-test.oss-cn-hangzhou.aliyuncs.com/ios_image/ios_20190929162511_1383397_image.jpg","photo":"1","userName":"国庆节快乐呀","userId":"1174882402065584130","nowTime":"1569916184471","bourseList":[{"exchangeRegSite":"http://zhucedizhi","exchangeName":"抹茶","id":"1","exchangeSite":"http://guanwangdizhi"},{"exchangeRegSite":"http://zhucedizhi","exchangeName":"火币","id":"2","exchangeSite":"http://guanwangdizhi"},{"exchangeRegSite":"http://zhucedizhi","exchangeName":"币安","id":"3","exchangeSite":"http://guanwangdizhi"},{"exchangeRegSite":"http://zhucedizhi","exchangeName":"K网","id":"4","exchangeSite":"http://guanwangdizhi"}],"isLock":0,"isFollow":0,"nowPrice":18.48,"isMe":0,"nowRise":18.48,"expectedSucRise":0.5,"percentage":"1.08","currency":"btc","startTime":"1568798897000","endTime":"1569829608000","id":"1171259472178376705","expectRise":10,"isSuccess":1,"qbNumber":30,"status":0}
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
         * tuiJianPrice : 6747.0
         * jb_desc : 1
         * avgRecommendRise : 9.24
         * userAvatar : https://landscape-test.oss-cn-hangzhou.aliyuncs.com/ios_image/ios_20190929162511_1383397_image.jpg
         * photo : 1
         * userName : 国庆节快乐呀
         * userId : 1174882402065584130
         * nowTime : 1569916184471
         * bourseList : [{"exchangeRegSite":"http://zhucedizhi","exchangeName":"抹茶","id":"1","exchangeSite":"http://guanwangdizhi"},{"exchangeRegSite":"http://zhucedizhi","exchangeName":"火币","id":"2","exchangeSite":"http://guanwangdizhi"},{"exchangeRegSite":"http://zhucedizhi","exchangeName":"币安","id":"3","exchangeSite":"http://guanwangdizhi"},{"exchangeRegSite":"http://zhucedizhi","exchangeName":"K网","id":"4","exchangeSite":"http://guanwangdizhi"}]
         * isLock : 0
         * isFollow : 0
         * nowPrice : 18.48
         * isMe : 0
         * nowRise : 18.48
         * expectedSucRise : 0.5
         * percentage : 1.08
         * currency : btc
         * startTime : 1568798897000
         * endTime : 1569829608000
         * id : 1171259472178376705
         * expectRise : 10.0
         * isSuccess : 1
         * qbNumber : 30
         * status : 0
         */

        private double tuiJianPrice;
        private String jb_desc;
        private double avgRecommendRise;
        private String userAvatar;
        private String photo;
        private String userName;
        private String userId;
        private String nowTime;
        private int isLock;
        private int isFollow;
        private double nowPrice;
        private int isMe;
        private double nowRise;
        private double expectedSucRise;
        private String percentage;
        private String currency;
        private String startTime;
        private String endTime;
        private String id;
        private double expectRise;
        private int isSuccess;
        private int qbNumber;
        private int status;
        private List<BourseListBean> bourseList;

        public double getTuiJianPrice() {
            return tuiJianPrice;
        }

        public void setTuiJianPrice(double tuiJianPrice) {
            this.tuiJianPrice = tuiJianPrice;
        }

        public String getJb_desc() {
            return jb_desc;
        }

        public void setJb_desc(String jb_desc) {
            this.jb_desc = jb_desc;
        }

        public double getAvgRecommendRise() {
            return avgRecommendRise;
        }

        public void setAvgRecommendRise(double avgRecommendRise) {
            this.avgRecommendRise = avgRecommendRise;
        }

        public String getUserAvatar() {
            return userAvatar;
        }

        public void setUserAvatar(String userAvatar) {
            this.userAvatar = userAvatar;
        }

        public String getPhoto() {
            return photo;
        }

        public void setPhoto(String photo) {
            this.photo = photo;
        }

        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }

        public String getUserId() {
            return userId;
        }

        public void setUserId(String userId) {
            this.userId = userId;
        }

        public String getNowTime() {
            return nowTime;
        }

        public void setNowTime(String nowTime) {
            this.nowTime = nowTime;
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

        public double getNowPrice() {
            return nowPrice;
        }

        public void setNowPrice(double nowPrice) {
            this.nowPrice = nowPrice;
        }

        public int getIsMe() {
            return isMe;
        }

        public void setIsMe(int isMe) {
            this.isMe = isMe;
        }

        public double getNowRise() {
            return nowRise;
        }

        public void setNowRise(double nowRise) {
            this.nowRise = nowRise;
        }

        public double getExpectedSucRise() {
            return expectedSucRise;
        }

        public void setExpectedSucRise(double expectedSucRise) {
            this.expectedSucRise = expectedSucRise;
        }

        public String getPercentage() {
            return percentage;
        }

        public void setPercentage(String percentage) {
            this.percentage = percentage;
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

        public String getEndTime() {
            return endTime;
        }

        public void setEndTime(String endTime) {
            this.endTime = endTime;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public double getExpectRise() {
            return expectRise;
        }

        public void setExpectRise(double expectRise) {
            this.expectRise = expectRise;
        }

        public int getIsSuccess() {
            return isSuccess;
        }

        public void setIsSuccess(int isSuccess) {
            this.isSuccess = isSuccess;
        }

        public int getQbNumber() {
            return qbNumber;
        }

        public void setQbNumber(int qbNumber) {
            this.qbNumber = qbNumber;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public List<BourseListBean> getBourseList() {
            return bourseList;
        }

        public void setBourseList(List<BourseListBean> bourseList) {
            this.bourseList = bourseList;
        }

        public static class BourseListBean {
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
