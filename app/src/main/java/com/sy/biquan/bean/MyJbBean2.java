package com.sy.biquan.bean;

import java.util.List;

public class MyJbBean2 {

    /**
     * msg : ok
     * code : 200
     * data : [{"bourse":"抹茶","nowRise":2,"expectedRise":10,"orderId":null,"currency":"BTC","startTime":"2019-09-10T03:09:53.000+0000","endTime":"2019-09-30T07:46:48.000+0000","currencyId":"","title":"1","qbNumber":30}]
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
         * bourse : 抹茶
         * nowRise : 2
         * expectedRise : 10
         * orderId : null
         * currency : BTC
         * startTime : 2019-09-10T03:09:53.000+0000
         * endTime : 2019-09-30T07:46:48.000+0000
         * currencyId :
         * title : 1
         * qbNumber : 30
         */

        private String bourse;
        private int nowRise;
        private int expectedRise;
        private Object orderId;
        private String currency;
        private String startTime;
        private String endTime;
        private String currencyId;
        private String title;
        private int qbNumber;

        public String getBourse() {
            return bourse;
        }

        public void setBourse(String bourse) {
            this.bourse = bourse;
        }

        public int getNowRise() {
            return nowRise;
        }

        public void setNowRise(int nowRise) {
            this.nowRise = nowRise;
        }

        public int getExpectedRise() {
            return expectedRise;
        }

        public void setExpectedRise(int expectedRise) {
            this.expectedRise = expectedRise;
        }

        public Object getOrderId() {
            return orderId;
        }

        public void setOrderId(Object orderId) {
            this.orderId = orderId;
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

        public String getCurrencyId() {
            return currencyId;
        }

        public void setCurrencyId(String currencyId) {
            this.currencyId = currencyId;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public int getQbNumber() {
            return qbNumber;
        }

        public void setQbNumber(int qbNumber) {
            this.qbNumber = qbNumber;
        }
    }
}
