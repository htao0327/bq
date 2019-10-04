package com.sy.biquan.bean;

import java.util.List;

public class MyJb1Bean {


    /**
     * msg : ok
     * code : 200
     * data : [{"bourse":"抹茶","nowRise":3,"expectedRise":0,"orderId":null,"currency":"BTC","startTime":"2019-09-24T10:08:18.000+0000","endTime":"2019-09-30T07:46:48.000+0000","currencyId":null,"title":"","qbNumber":0},{"bourse":"抹茶","nowRise":4,"expectedRise":1,"orderId":null,"currency":"BTC","startTime":"2019-09-24T10:11:07.000+0000","endTime":"2019-09-30T07:46:48.000+0000","currencyId":null,"title":"","qbNumber":1},{"bourse":"抹茶","nowRise":5,"expectedRise":2,"orderId":null,"currency":"BTC","startTime":"2019-09-24T10:11:47.000+0000","endTime":"2019-09-30T07:46:48.000+0000","currencyId":null,"title":"1","qbNumber":2},{"bourse":"鹿晗,鹿晗2","nowRise":6,"expectedRise":3,"orderId":null,"currency":"btc","startTime":"2019-09-27T02:14:58.000+0000","endTime":"2019-09-30T02:14:58.000+0000","currencyId":"1","title":"测试","qbNumber":3},{"bourse":"抹茶","nowRise":7,"expectedRise":4,"orderId":null,"currency":"BTC","startTime":"2019-08-05T07:46:00.000+0000","endTime":"2019-09-30T07:46:48.000+0000","currencyId":"","title":"币圈美羊羊","qbNumber":4},{"bourse":"抹茶","nowRise":8,"expectedRise":5,"orderId":null,"currency":"BTC","startTime":"2019-09-05T09:28:17.000+0000","endTime":"2019-09-30T07:46:48.000+0000","currencyId":"","title":"币圈巴菲特49","qbNumber":5}]
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
         * nowRise : 3
         * expectedRise : 0
         * orderId : null
         * currency : BTC
         * startTime : 2019-09-24T10:08:18.000+0000
         * endTime : 2019-09-30T07:46:48.000+0000
         * currencyId : null
         * title :
         * qbNumber : 0
         */

        private List<String> bourse;
        private int nowRise;
        private int expectedRise;
        private Object orderId;
        private String currency;
        private String startTime;
        private String endTime;
        private Object currencyId;
        private String title;
        private int qbNumber;

        public List<String> getBourse() {
            return bourse;
        }

        public void setBourse(List<String> bourse) {
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

        public Object getCurrencyId() {
            return currencyId;
        }

        public void setCurrencyId(Object currencyId) {
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
