package com.sy.biquan.bean;

import java.util.List;

public class JbDetailBean {

    /**
     * msg : ok
     * code : 200
     * data : {"tuiJianPrice":8000,"avgRecommendRise":0,"userAvatar":"https://landscape-test.oss-cn-hangzhou.aliyuncs.com/default_avatar/%E6%9D%A8%E9%A2%96.jpeg","userName":"昵称","userId":"1175339087532007425","nowTime":"1569489125526","isLock":0,"isFollow":0,"nowPrice":8408.4,"bourseList":[{"id":"1","exchangeSite":"https://ssss","exchangeName":"鹿晗","exchangeRegSite":"12123"}],"isMe":0,"nowRise":0,"expectedSucRise":0,"percentage":"0.84","startTime":"1567675697000","endTime":"1569829608000","id":"26c7a63c-0d0e-4611-b95c-6d3f1b47aac144","expectRise":null,"qbNumber":30,"status":0,"jb_desc":"","photo":""}
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
         * tuiJianPrice : 8000
         * avgRecommendRise : 0
         * userAvatar : https://landscape-test.oss-cn-hangzhou.aliyuncs.com/default_avatar/%E6%9D%A8%E9%A2%96.jpeg
         * userName : 昵称
         * userId : 1175339087532007425
         * nowTime : 1569489125526
         * isLock : 0
         * isFollow : 0
         * nowPrice : 8408.4
         * bourseList : [{"id":"1","exchangeSite":"https://ssss","exchangeName":"鹿晗","exchangeRegSite":"12123"}]
         * isMe : 0
         * nowRise : 0
         * expectedSucRise : 0
         * percentage : 0.84
         * startTime : 1567675697000
         * endTime : 1569829608000
         * id : 26c7a63c-0d0e-4611-b95c-6d3f1b47aac144
         * expectRise : null
         * qbNumber : 30
         * status : 0
         * jb_desc :
         * photo :
         */

        private double tuiJianPrice;
        private double avgRecommendRise;
        private String userAvatar;
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
        private String startTime;
        private String endTime;
        private String id;
        private Object expectRise;
        private double qbNumber;
        private int status;
        private String jb_desc;
        private String photo;
        private List<BourseListBean> bourseList;

        public double getTuiJianPrice() {
            return tuiJianPrice;
        }

        public void setTuiJianPrice(double tuiJianPrice) {
            this.tuiJianPrice = tuiJianPrice;
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

        public Object getExpectRise() {
            return expectRise;
        }

        public void setExpectRise(Object expectRise) {
            this.expectRise = expectRise;
        }

        public double getQbNumber() {
            return qbNumber;
        }

        public void setQbNumber(double qbNumber) {
            this.qbNumber = qbNumber;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public String getJb_desc() {
            return jb_desc;
        }

        public void setJb_desc(String jb_desc) {
            this.jb_desc = jb_desc;
        }

        public String getPhoto() {
            return photo;
        }

        public void setPhoto(String photo) {
            this.photo = photo;
        }

        public List<BourseListBean> getBourseList() {
            return bourseList;
        }

        public void setBourseList(List<BourseListBean> bourseList) {
            this.bourseList = bourseList;
        }

        public static class BourseListBean {
            /**
             * id : 1
             * exchangeSite : https://ssss
             * exchangeName : 鹿晗
             * exchangeRegSite : 12123
             */

            private String id;
            private String exchangeSite;
            private String exchangeName;
            private String exchangeRegSite;

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

            public String getExchangeName() {
                return exchangeName;
            }

            public void setExchangeName(String exchangeName) {
                this.exchangeName = exchangeName;
            }

            public String getExchangeRegSite() {
                return exchangeRegSite;
            }

            public void setExchangeRegSite(String exchangeRegSite) {
                this.exchangeRegSite = exchangeRegSite;
            }
        }
    }
}
