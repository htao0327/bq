package com.sy.biquan.bean;

import java.util.List;

public class TopBean {

    /**
     * code : 200
     * message : ok
     * data : [{"avatar":"https://landscape-test.oss-cn-hangzhou.aliyuncs.com/ios_image/ios_20190929162511_1383397_image.jpg","alias":"国庆节快乐","slogan":"生命中有许多你不想做却不能不做的事，这就是责任;生命中有许多你想做却不能做的事，这就是命运。hhh ","successRate":17,"income":1000,"fansNum":4,"avgRecommendedRate":73,"isFollow":0,"isMe":0,"userID":"1174882402065584130"},{"avatar":"http://pic16.nipic.com/20111006/6239936_092702973000_2.jpg","alias":"昵称","slogan":"生命中有许多你不想做却不能不做的事，这就是责任;生命中有许多你想做却不能做的事，这就是命运。","successRate":0,"income":0,"fansNum":4,"avgRecommendedRate":0,"isFollow":0,"isMe":0,"userID":"1175675562144837633"},{"avatar":"https://landscape-test.oss-cn-hangzhou.aliyuncs.com/ios_image/ios_20190923105756_4636018_image.jpg","alias":"周家稳","slogan":"生命中有许多你不想做却不能不做的事，这就是责任;生命中有许多你想做却不能做的事，这就是命运。","successRate":0,"income":0,"fansNum":4,"avgRecommendedRate":0,"isFollow":0,"isMe":0,"userID":"1175963275095638017"},{"avatar":"https://landscape-test.oss-cn-hangzhou.aliyuncs.com/default_avatar/%E6%9D%A8%E9%A2%96.jpeg","alias":"ahahaha","slogan":"ttttttttttttttttttttt6666666666666666666622222222222222222222222222222222222222222222222222222222222","successRate":0,"income":0,"fansNum":4,"avgRecommendedRate":0,"isFollow":0,"isMe":1,"userID":"1174940561761329154"}]
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
         * avatar : https://landscape-test.oss-cn-hangzhou.aliyuncs.com/ios_image/ios_20190929162511_1383397_image.jpg
         * alias : 国庆节快乐
         * slogan : 生命中有许多你不想做却不能不做的事，这就是责任;生命中有许多你想做却不能做的事，这就是命运。hhh
         * successRate : 17.0
         * income : 1000.0
         * fansNum : 4
         * avgRecommendedRate : 73.0
         * isFollow : 0
         * isMe : 0
         * userID : 1174882402065584130
         */

        private String avatar;
        private String alias;
        private String slogan;
        private double successRate;
        private double income;
        private int fansNum;
        private double avgRecommendedRate;
        private int isFollow;
        private int isMe;
        private String userID;

        public String getAvatar() {
            return avatar;
        }

        public void setAvatar(String avatar) {
            this.avatar = avatar;
        }

        public String getAlias() {
            return alias;
        }

        public void setAlias(String alias) {
            this.alias = alias;
        }

        public String getSlogan() {
            return slogan;
        }

        public void setSlogan(String slogan) {
            this.slogan = slogan;
        }

        public double getSuccessRate() {
            return successRate;
        }

        public void setSuccessRate(double successRate) {
            this.successRate = successRate;
        }

        public double getIncome() {
            return income;
        }

        public void setIncome(double income) {
            this.income = income;
        }

        public int getFansNum() {
            return fansNum;
        }

        public void setFansNum(int fansNum) {
            this.fansNum = fansNum;
        }

        public double getAvgRecommendedRate() {
            return avgRecommendedRate;
        }

        public void setAvgRecommendedRate(double avgRecommendedRate) {
            this.avgRecommendedRate = avgRecommendedRate;
        }

        public int getIsFollow() {
            return isFollow;
        }

        public void setIsFollow(int isFollow) {
            this.isFollow = isFollow;
        }

        public int getIsMe() {
            return isMe;
        }

        public void setIsMe(int isMe) {
            this.isMe = isMe;
        }

        public String getUserID() {
            return userID;
        }

        public void setUserID(String userID) {
            this.userID = userID;
        }
    }
}
