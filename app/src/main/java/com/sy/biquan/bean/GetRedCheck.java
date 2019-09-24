package com.sy.biquan.bean;

public class GetRedCheck {

    /**
     * code : 200
     * message : ok
     * data : {"isMe":false,"hasRedPack":true,"isExpire":false,"allowRob":false}
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
         * isMe : false   是不是自己发的
         * hasRedPack : true    红包还有没有剩余
         * isExpire : false     红包有没有过期
         * allowRob : false     是不是允许抢（是否抢过）
         */

        private boolean isMe;
        private boolean hasRedPack;
        private boolean isExpire;
        private boolean allowRob;

        public boolean isIsMe() {
            return isMe;
        }

        public void setIsMe(boolean isMe) {
            this.isMe = isMe;
        }

        public boolean isHasRedPack() {
            return hasRedPack;
        }

        public void setHasRedPack(boolean hasRedPack) {
            this.hasRedPack = hasRedPack;
        }

        public boolean isIsExpire() {
            return isExpire;
        }

        public void setIsExpire(boolean isExpire) {
            this.isExpire = isExpire;
        }

        public boolean isAllowRob() {
            return allowRob;
        }

        public void setAllowRob(boolean allowRob) {
            this.allowRob = allowRob;
        }
    }
}
