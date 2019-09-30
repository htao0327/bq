package com.sy.biquan.bean;

import java.util.List;

public class DakaOrderBean {

    /**
     * msg : ok
     * code : 200
     * data : [{"isLock":0,"bourse":"NYBOT","nowRise":0,"expectedRise":10,"startTime":"2019-09-05T09:28:17.000+0000","endTime":"2019-09-05T09:28:17.000+0000","id":"123456","title":"币圈巴菲特49","isSuccess":0,"qbNumber":30}]
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
         * isLock : 0
         * bourse : NYBOT
         * nowRise : 0
         * expectedRise : 10
         * startTime : 2019-09-05T09:28:17.000+0000
         * endTime : 2019-09-05T09:28:17.000+0000
         * id : 123456
         * title : 币圈巴菲特49
         * isSuccess : 0
         * qbNumber : 30
         */

        private int isLock;
        private String bourse;
        private double nowRise;
        private double expectedRise;
        private String startTime;
        private String endTime;
        private String id;
        private String title;
        private int isSuccess;
        private double qbNumber;

        public int getIsLock() {
            return isLock;
        }

        public void setIsLock(int isLock) {
            this.isLock = isLock;
        }

        public String getBourse() {
            return bourse;
        }

        public void setBourse(String bourse) {
            this.bourse = bourse;
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

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public int getIsSuccess() {
            return isSuccess;
        }

        public void setIsSuccess(int isSuccess) {
            this.isSuccess = isSuccess;
        }

        public double getQbNumber() {
            return qbNumber;
        }

        public void setQbNumber(double qbNumber) {
            this.qbNumber = qbNumber;
        }
    }
}
