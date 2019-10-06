package com.sy.biquan.bean;

public class GetRedC2CBean {

    /**
     * msg : 领取成功
     * code : 200
     * data : {"remainNum":null,"groupId":null,"senderAvatar":"https://landscape-test.oss-cn-hangzhou.aliyuncs.com/ios_image/ios_20191003161835_2610650_image.jpg","receiveUserName":"币友儿_1lsmqy","receiveTime":"2019-10-04T01:51:02.681+0000","receiveUserId":"1179666709531500546","redPacketNum":null,"senderId":"1179362832836255746","senderName":"币友儿_1lsmqy","redPacketRemark":"1对1","redPacketMoney":10,"receiveUserAvatar":"https://landscape-test.oss-cn-hangzhou.aliyuncs.com/ios_image/ios_20191003161835_2610650_image.jpg","redPacketId":null,"receiveMoney":10}
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
         * remainNum : null
         * groupId : null
         * senderAvatar : https://landscape-test.oss-cn-hangzhou.aliyuncs.com/ios_image/ios_20191003161835_2610650_image.jpg
         * receiveUserName : 币友儿_1lsmqy
         * receiveTime : 2019-10-04T01:51:02.681+0000
         * receiveUserId : 1179666709531500546
         * redPacketNum : null
         * senderId : 1179362832836255746
         * senderName : 币友儿_1lsmqy
         * redPacketRemark : 1对1
         * redPacketMoney : 10
         * receiveUserAvatar : https://landscape-test.oss-cn-hangzhou.aliyuncs.com/ios_image/ios_20191003161835_2610650_image.jpg
         * redPacketId : null
         * receiveMoney : 10
         */

        private Object remainNum;
        private Object groupId;
        private String senderAvatar;
        private String receiveUserName;
        private String receiveTime;
        private String receiveUserId;
        private Object redPacketNum;
        private String senderId;
        private String senderName;
        private String redPacketRemark;
        private int redPacketMoney;
        private String receiveUserAvatar;
        private Object redPacketId;
        private int receiveMoney;

        public Object getRemainNum() {
            return remainNum;
        }

        public void setRemainNum(Object remainNum) {
            this.remainNum = remainNum;
        }

        public Object getGroupId() {
            return groupId;
        }

        public void setGroupId(Object groupId) {
            this.groupId = groupId;
        }

        public String getSenderAvatar() {
            return senderAvatar;
        }

        public void setSenderAvatar(String senderAvatar) {
            this.senderAvatar = senderAvatar;
        }

        public String getReceiveUserName() {
            return receiveUserName;
        }

        public void setReceiveUserName(String receiveUserName) {
            this.receiveUserName = receiveUserName;
        }

        public String getReceiveTime() {
            return receiveTime;
        }

        public void setReceiveTime(String receiveTime) {
            this.receiveTime = receiveTime;
        }

        public String getReceiveUserId() {
            return receiveUserId;
        }

        public void setReceiveUserId(String receiveUserId) {
            this.receiveUserId = receiveUserId;
        }

        public Object getRedPacketNum() {
            return redPacketNum;
        }

        public void setRedPacketNum(Object redPacketNum) {
            this.redPacketNum = redPacketNum;
        }

        public String getSenderId() {
            return senderId;
        }

        public void setSenderId(String senderId) {
            this.senderId = senderId;
        }

        public String getSenderName() {
            return senderName;
        }

        public void setSenderName(String senderName) {
            this.senderName = senderName;
        }

        public String getRedPacketRemark() {
            return redPacketRemark;
        }

        public void setRedPacketRemark(String redPacketRemark) {
            this.redPacketRemark = redPacketRemark;
        }

        public int getRedPacketMoney() {
            return redPacketMoney;
        }

        public void setRedPacketMoney(int redPacketMoney) {
            this.redPacketMoney = redPacketMoney;
        }

        public String getReceiveUserAvatar() {
            return receiveUserAvatar;
        }

        public void setReceiveUserAvatar(String receiveUserAvatar) {
            this.receiveUserAvatar = receiveUserAvatar;
        }

        public Object getRedPacketId() {
            return redPacketId;
        }

        public void setRedPacketId(Object redPacketId) {
            this.redPacketId = redPacketId;
        }

        public int getReceiveMoney() {
            return receiveMoney;
        }

        public void setReceiveMoney(int receiveMoney) {
            this.receiveMoney = receiveMoney;
        }
    }
}
