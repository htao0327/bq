package com.sy.biquan.bean;

public class LaunchDealBean {

    /**
     * code : 200
     * message :
     * data : {"transcation_id":"1000000755120284"}
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
         * transcation_id : 1000000755120284
         */

        private String transcation_id;

        public String getTranscation_id() {
            return transcation_id;
        }

        public void setTranscation_id(String transcation_id) {
            this.transcation_id = transcation_id;
        }
    }
}
