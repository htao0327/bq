package com.sy.biquan.bean;

import java.util.List;

public class MainBean {

    /**
     * code : 200
     * message : ok
     * data : {"orderCategoryList":[{"id":"1","categoryName":"全部","categoryCode":"ALL"},{"id":"2","categoryName":"最新","categoryCode":"NEWEST"},{"id":"3","categoryName":"最热","categoryCode":"HOT"},{"id":"4","categoryName":"当前涨幅","categoryCode":"CURRENT"},{"id":"5","categoryName":"预期涨幅","categoryCode":"EXPECT"}],"channelList":[{"id":"1","channelName":"财富密码","channelType":1,"createTime":"2019-08-27 12:44:41","updateTime":"2019-08-27 12:44:41","channelImg":""},{"id":"2","channelName":"荐币","channelType":1,"createTime":"2019-08-27 12:44:41","updateTime":"2019-08-27 12:44:41","channelImg":""},{"id":"3","channelName":"空投","channelType":1,"createTime":"2019-08-27 12:44:41","updateTime":"2019-08-27 12:44:41","channelImg":""},{"id":"4","channelName":"项目","channelType":1,"createTime":"2019-08-27 12:44:41","updateTime":"2019-08-27 12:44:41","channelImg":""},{"id":"5","channelName":"热门","channelType":1,"createTime":"2019-08-27 12:44:41","updateTime":"2019-08-27 12:44:41","channelImg":""}],"bannerList":[{"id":"1166155572460421121","title":"六爻吧","startTime":"2019-08-28 08:43:54","endTime":"2019-08-28 08:44:17","createTime":null,"sort":1,"thumbnail":"ddd111","href":"111","status":1,"type":2},{"id":"7","title":"没钱过年","startTime":"2019-08-31 00:00:00","endTime":"2019-08-31 00:00:00","createTime":"2019-08-31 00:00:00","sort":2,"thumbnail":"www.baidu.com","href":"/img","status":1,"type":2},{"id":"9","title":"没钱过年","startTime":"2019-08-31 00:00:00","endTime":"2019-08-31 00:00:00","createTime":"2019-08-31 00:00:00","sort":3,"thumbnail":"www.baidu.com","href":"/img","status":1,"type":2},{"id":"25","title":"没钱过年","startTime":"2019-08-31 00:00:00","endTime":"2019-08-31 00:00:00","createTime":"2019-08-31 00:00:00","sort":4,"thumbnail":"www.baidu.com","href":"/img","status":1,"type":2},{"id":"28","title":"没钱过年","startTime":"2019-08-31 09:19:36","endTime":"2019-08-31 18:19:36","createTime":"2019-08-31 10:01:19","sort":5,"thumbnail":"www.baidu.com","href":"/img","status":1,"type":2},{"id":"2","title":"国庆大阅兵","startTime":"2019-08-30 00:00:00","endTime":"2019-08-30 00:00:00","createTime":"2019-08-30 00:00:00","sort":6,"thumbnail":"www.111.com","href":"/href/img","status":1,"type":2}],"orderList":[{"id":"9","userID":"1","title":"币圈小呆呆","coinAvatar":"%3D360%2C280%2C50/sign=b38e1e09e8cd7b89e93969c369197191/5fdf8db1cb1349546eaaf6a7584e9258d0094ab8.jpg","currency":"BTC","bourse":"NYBOT","bourseHref":"","description":"来不急了，快上车","period":"3","currentRise":16,"expectedRise":1,"buyerNumber":0,"status":0,"createTime":"2019-08-27 15:46:00","endTime":"2019-08-30 15:46:00","top":0,"view":6,"locked":0,"qbeanNumber":0},{"id":"8","userID":"8","title":"币圈郭富城","coinAvatar":"%3D360%2C280%2C50/sign=b38e1e09e8cd7b89e93969c369197191/5fdf8db1cb1349546eaaf6a7584e9258d0094ab8.jpg","currency":"BTC","bourse":"NYBOT","bourseHref":"","description":"来不急了，快上车","period":"3","currentRise":17,"expectedRise":2,"buyerNumber":0,"status":1,"createTime":"2019-08-26 15:46:48","endTime":"2019-08-29 15:46:48","top":1,"view":7,"locked":0,"qbeanNumber":0},{"id":"7","userID":"8","title":"币圈黎明","coinAvatar":"%3D360%2C280%2C50/sign=b38e1e09e8cd7b89e93969c369197191/5fdf8db1cb1349546eaaf6a7584e9258d0094ab8.jpg","currency":"BTC","bourse":"NYBOT","bourseHref":"","description":"来不急了，快上车","period":"3","currentRise":18,"expectedRise":3,"buyerNumber":0,"status":2,"createTime":"2019-08-25 15:46:48","endTime":"2019-08-28 15:46:48","top":2,"view":8,"locked":0,"qbeanNumber":0},{"id":"6","userID":"1","title":"币圈刘德华","coinAvatar":"%3D360%2C280%2C50/sign=b38e1e09e8cd7b89e93969c369197191/5fdf8db1cb1349546eaaf6a7584e9258d0094ab8.jpg","currency":"BTC","bourse":"NYBOT","bourseHref":"","description":"来不及了，快上车","period":"3","currentRise":19,"expectedRise":4,"buyerNumber":0,"status":3,"createTime":"2019-08-23 15:46:48","endTime":"2019-08-26 15:46:48","top":3,"view":9,"locked":0,"qbeanNumber":0},{"id":"5","userID":"1","title":"币圈小绵羊","coinAvatar":"%3D360%2C280%2C50/sign=b38e1e09e8cd7b89e93969c369197191/5fdf8db1cb1349546eaaf6a7584e9258d0094ab8.jpg","currency":"BTC","bourse":"NYBOT","bourseHref":"","description":"来不急了，快上车","period":"3","currentRise":20,"expectedRise":5,"buyerNumber":0,"status":4,"createTime":"2019-08-22 15:46:00","endTime":"2019-08-25 15:46:00","top":4,"view":10,"locked":0,"qbeanNumber":0},{"id":"4","userID":"1","title":"币圈吴亦凡","coinAvatar":"%3D360%2C280%2C50/sign=b38e1e09e8cd7b89e93969c369197191/5fdf8db1cb1349546eaaf6a7584e9258d0094ab8.jpg","currency":"BTC","bourse":"NYBOT","bourseHref":"","description":"来不急了，快上车","period":"3","currentRise":21,"expectedRise":6,"buyerNumber":0,"status":5,"createTime":"2019-08-20 15:46:00","endTime":"2019-08-23 15:46:00","top":5,"view":11,"locked":0,"qbeanNumber":0},{"id":"3","userID":"2","title":"币圈梁朝伟","coinAvatar":"%3D360%2C280%2C50/sign=b38e1e09e8cd7b89e93969c369197191/5fdf8db1cb1349546eaaf6a7584e9258d0094ab8.jpg","currency":"BTC","bourse":"NYBOT","bourseHref":"","description":"来不急了，快上车","period":"3","currentRise":22,"expectedRise":7,"buyerNumber":0,"status":6,"createTime":"2019-08-15 15:46:48","endTime":"2019-08-18 15:46:48","top":6,"view":12,"locked":0,"qbeanNumber":0},{"id":"2","userID":"2","title":"币圈李嘉诚","coinAvatar":"%3D360%2C280%2C50/sign=b38e1e09e8cd7b89e93969c369197191/5fdf8db1cb1349546eaaf6a7584e9258d0094ab8.jpg","currency":"BTC","bourse":"NYBOT","bourseHref":"","description":"来不及了，快上车","period":"3","currentRise":23,"expectedRise":8,"buyerNumber":0,"status":7,"createTime":"2019-08-11 15:46:48","endTime":"2019-08-14 15:46:48","top":7,"view":13,"locked":0,"qbeanNumber":0},{"id":"17","userID":"1","title":"币圈小呆呆","coinAvatar":"%3D360%2C280%2C50/sign=b38e1e09e8cd7b89e93969c369197191/5fdf8db1cb1349546eaaf6a7584e9258d0094ab8.jpg","currency":"BTC","bourse":"NYBOT","bourseHref":"","description":"来不急了，快上车","period":"3","currentRise":24,"expectedRise":9,"buyerNumber":0,"status":8,"createTime":"2019-08-27 15:46:00","endTime":"2019-08-30 15:46:00","top":8,"view":14,"locked":0,"qbeanNumber":0},{"id":"16","userID":"1","title":"币圈小呆呆","coinAvatar":"%3D360%2C280%2C50/sign=b38e1e09e8cd7b89e93969c369197191/5fdf8db1cb1349546eaaf6a7584e9258d0094ab8.jpg","currency":"BTC","bourse":"NYBOT","bourseHref":"","description":"来不急了，快上车","period":"3","currentRise":25,"expectedRise":10,"buyerNumber":0,"status":9,"createTime":"2019-08-27 15:46:00","endTime":"2019-08-30 15:46:00","top":9,"view":15,"locked":0,"qbeanNumber":0}]}
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
        private List<OrderCategoryListBean> orderCategoryList;
        private List<ChannelListBean> channelList;
        private List<BannerListBean> bannerList;
        private List<OrderListBean> orderList;

        public List<OrderCategoryListBean> getOrderCategoryList() {
            return orderCategoryList;
        }

        public void setOrderCategoryList(List<OrderCategoryListBean> orderCategoryList) {
            this.orderCategoryList = orderCategoryList;
        }

        public List<ChannelListBean> getChannelList() {
            return channelList;
        }

        public void setChannelList(List<ChannelListBean> channelList) {
            this.channelList = channelList;
        }

        public List<BannerListBean> getBannerList() {
            return bannerList;
        }

        public void setBannerList(List<BannerListBean> bannerList) {
            this.bannerList = bannerList;
        }

        public List<OrderListBean> getOrderList() {
            return orderList;
        }

        public void setOrderList(List<OrderListBean> orderList) {
            this.orderList = orderList;
        }

        public static class OrderCategoryListBean {
            /**
             * id : 1
             * categoryName : 全部
             * categoryCode : ALL
             */

            private String id;
            private String categoryName;
            private String categoryCode;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getCategoryName() {
                return categoryName;
            }

            public void setCategoryName(String categoryName) {
                this.categoryName = categoryName;
            }

            public String getCategoryCode() {
                return categoryCode;
            }

            public void setCategoryCode(String categoryCode) {
                this.categoryCode = categoryCode;
            }
        }

        public static class ChannelListBean {
            /**
             * id : 1
             * channelName : 财富密码
             * channelType : 1
             * createTime : 2019-08-27 12:44:41
             * updateTime : 2019-08-27 12:44:41
             * channelImg :
             */

            private String id;
            private String channelName;
            private int channelType;
            private String createTime;
            private String updateTime;
            private String channelImg;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getChannelName() {
                return channelName;
            }

            public void setChannelName(String channelName) {
                this.channelName = channelName;
            }

            public int getChannelType() {
                return channelType;
            }

            public void setChannelType(int channelType) {
                this.channelType = channelType;
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

            public String getChannelImg() {
                return channelImg;
            }

            public void setChannelImg(String channelImg) {
                this.channelImg = channelImg;
            }
        }

        public static class BannerListBean {
            /**
             * id : 1166155572460421121
             * title : 六爻吧
             * startTime : 2019-08-28 08:43:54
             * endTime : 2019-08-28 08:44:17
             * createTime : null
             * sort : 1
             * thumbnail : ddd111
             * href : 111
             * status : 1
             * type : 2
             */

            private String id;
            private String title;
            private String startTime;
            private String endTime;
            private Object createTime;
            private int sort;
            private String thumbnail;
            private String href;
            private int status;
            private int type;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
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

            public Object getCreateTime() {
                return createTime;
            }

            public void setCreateTime(Object createTime) {
                this.createTime = createTime;
            }

            public int getSort() {
                return sort;
            }

            public void setSort(int sort) {
                this.sort = sort;
            }

            public String getThumbnail() {
                return thumbnail;
            }

            public void setThumbnail(String thumbnail) {
                this.thumbnail = thumbnail;
            }

            public String getHref() {
                return href;
            }

            public void setHref(String href) {
                this.href = href;
            }

            public int getStatus() {
                return status;
            }

            public void setStatus(int status) {
                this.status = status;
            }

            public int getType() {
                return type;
            }

            public void setType(int type) {
                this.type = type;
            }
        }

        public static class OrderListBean {
            /**
             * id : 9
             * userID : 1
             * title : 币圈小呆呆
             * coinAvatar : %3D360%2C280%2C50/sign=b38e1e09e8cd7b89e93969c369197191/5fdf8db1cb1349546eaaf6a7584e9258d0094ab8.jpg
             * currency : BTC
             * bourse : NYBOT
             * bourseHref :
             * description : 来不急了，快上车
             * period : 3
             * currentRise : 16
             * expectedRise : 1
             * buyerNumber : 0
             * status : 0
             * createTime : 2019-08-27 15:46:00
             * endTime : 2019-08-30 15:46:00
             * top : 0
             * view : 6
             * locked : 0
             * qbeanNumber : 0
             */

            private String id;
            private String userID;
            private String title;
            private String coinAvatar;
            private String currency;
            private String bourse;
            private String bourseHref;
            private String description;
            private String period;
            private int currentRise;
            private int expectedRise;
            private int buyerNumber;
            private int status;
            private String createTime;
            private String endTime;
            private int top;
            private int view;
            private int locked;
            private int qbeanNumber;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getUserID() {
                return userID;
            }

            public void setUserID(String userID) {
                this.userID = userID;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getCoinAvatar() {
                return coinAvatar;
            }

            public void setCoinAvatar(String coinAvatar) {
                this.coinAvatar = coinAvatar;
            }

            public String getCurrency() {
                return currency;
            }

            public void setCurrency(String currency) {
                this.currency = currency;
            }

            public String getBourse() {
                return bourse;
            }

            public void setBourse(String bourse) {
                this.bourse = bourse;
            }

            public String getBourseHref() {
                return bourseHref;
            }

            public void setBourseHref(String bourseHref) {
                this.bourseHref = bourseHref;
            }

            public String getDescription() {
                return description;
            }

            public void setDescription(String description) {
                this.description = description;
            }

            public String getPeriod() {
                return period;
            }

            public void setPeriod(String period) {
                this.period = period;
            }

            public int getCurrentRise() {
                return currentRise;
            }

            public void setCurrentRise(int currentRise) {
                this.currentRise = currentRise;
            }

            public int getExpectedRise() {
                return expectedRise;
            }

            public void setExpectedRise(int expectedRise) {
                this.expectedRise = expectedRise;
            }

            public int getBuyerNumber() {
                return buyerNumber;
            }

            public void setBuyerNumber(int buyerNumber) {
                this.buyerNumber = buyerNumber;
            }

            public int getStatus() {
                return status;
            }

            public void setStatus(int status) {
                this.status = status;
            }

            public String getCreateTime() {
                return createTime;
            }

            public void setCreateTime(String createTime) {
                this.createTime = createTime;
            }

            public String getEndTime() {
                return endTime;
            }

            public void setEndTime(String endTime) {
                this.endTime = endTime;
            }

            public int getTop() {
                return top;
            }

            public void setTop(int top) {
                this.top = top;
            }

            public int getView() {
                return view;
            }

            public void setView(int view) {
                this.view = view;
            }

            public int getLocked() {
                return locked;
            }

            public void setLocked(int locked) {
                this.locked = locked;
            }

            public int getQbeanNumber() {
                return qbeanNumber;
            }

            public void setQbeanNumber(int qbeanNumber) {
                this.qbeanNumber = qbeanNumber;
            }
        }
    }
}
