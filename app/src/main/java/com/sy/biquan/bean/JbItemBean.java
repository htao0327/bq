package com.sy.biquan.bean;

import java.util.List;

public class JbItemBean {

    /**
     * code : 200
     * message : 查询成功
     * data : [{"id":"2","title":"币圈李嘉诚","currency":"BTC","description":"快上车","period":"3","currentRise":"1","expectedRise":"1","publisher":"1","buyerNumber":0,"status":1,"createTime":"2019-08-27 15:46:48","top":0,"view":8,"qbeanNumber":0},{"id":"1","title":"币圈巴菲特","currency":"BTC","description":"快上车","period":"3","currentRise":"1","expectedRise":"1","publisher":"1","buyerNumber":0,"status":1,"createTime":"2019-08-27 15:46:48","top":0,"view":9,"qbeanNumber":0}]
     */

    private int code;
    private String message;
    private List<DataBean> data;

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

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * id : 2
         * title : 币圈李嘉诚        t1
         * currency : BTC
         * description : 快上车
         * period : 3
         * currentRise : 1          当前涨幅
         * expectedRise : 1         预期涨幅
         * publisher : 1
         * buyerNumber : 0
         * status : 1
         * createTime : 2019-08-27 15:46:48
         * top : 0
         * view : 8
         * qbeanNumber : 0
         */

        private String id;
        private String title;
        private String currency;
        private String description;
        private String period;
        private String currentRise;
        private String expectedRise;
        private String publisher;
        private int buyerNumber;
        private int status;
        private String createTime;
        private int top;
        private int view;
        private int qbeanNumber;

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

        public String getCurrency() {
            return currency;
        }

        public void setCurrency(String currency) {
            this.currency = currency;
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

        public String getCurrentRise() {
            return currentRise;
        }

        public void setCurrentRise(String currentRise) {
            this.currentRise = currentRise;
        }

        public String getExpectedRise() {
            return expectedRise;
        }

        public void setExpectedRise(String expectedRise) {
            this.expectedRise = expectedRise;
        }

        public String getPublisher() {
            return publisher;
        }

        public void setPublisher(String publisher) {
            this.publisher = publisher;
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

        public int getQbeanNumber() {
            return qbeanNumber;
        }

        public void setQbeanNumber(int qbeanNumber) {
            this.qbeanNumber = qbeanNumber;
        }
    }
}
