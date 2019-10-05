package com.sy.biquan.bean;

import java.util.List;

public class GetRedCheck {

    /**
     * msg : ok
     * code : 200
     * data : {"isMe":1,"packetList":[{"remainNum":null,"groupId":null,"senderAvatar":"https://landscape-test.oss-cn-hangzhou.aliyuncs.com/ios_image/ios_20191003162052_2520840_image.jpg","receiveUserName":"国庆节快乐","receiveTime":"2019-10-04T01:45:04.000+0000","receiveUserId":"1179362832836255746","redPacketNum":null,"senderId":"1179362832836255746","senderName":"国庆节快乐","redPacketRemark":"1对1","redPacketMoney":10,"receiveUserAvatar":"https://landscape-test.oss-cn-hangzhou.aliyuncs.com/ios_image/ios_20191003162052_2520840_image.jpg","redPacketId":null,"receiveMoney":10}],"hasReceived":1,"isExpire":0,"redPacketId":"1179730777970106369"}
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
         * isMe : 1
         * packetList : [{"remainNum":null,"groupId":null,"senderAvatar":"https://landscape-test.oss-cn-hangzhou.aliyuncs.com/ios_image/ios_20191003162052_2520840_image.jpg","receiveUserName":"国庆节快乐","receiveTime":"2019-10-04T01:45:04.000+0000","receiveUserId":"1179362832836255746","redPacketNum":null,"senderId":"1179362832836255746","senderName":"国庆节快乐","redPacketRemark":"1对1","redPacketMoney":10,"receiveUserAvatar":"https://landscape-test.oss-cn-hangzhou.aliyuncs.com/ios_image/ios_20191003162052_2520840_image.jpg","redPacketId":null,"receiveMoney":10}]
         * hasReceived : 1
         * isExpire : 0
         * redPacketId : 1179730777970106369
         */

        private int isMe;
        private int hasReceived;
        private int isExpire;
        private String redPacketId;
        private List<PacketListBean> packetList;

        public int getIsMe() {
            return isMe;
        }

        public void setIsMe(int isMe) {
            this.isMe = isMe;
        }

        public int getHasReceived() {
            return hasReceived;
        }

        public void setHasReceived(int hasReceived) {
            this.hasReceived = hasReceived;
        }

        public int getIsExpire() {
            return isExpire;
        }

        public void setIsExpire(int isExpire) {
            this.isExpire = isExpire;
        }

        public String getRedPacketId() {
            return redPacketId;
        }

        public void setRedPacketId(String redPacketId) {
            this.redPacketId = redPacketId;
        }

        public List<PacketListBean> getPacketList() {
            return packetList;
        }

        public void setPacketList(List<PacketListBean> packetList) {
            this.packetList = packetList;
        }

        public static class PacketListBean {
            /**
             * remainNum : null
             * groupId : null
             * senderAvatar : https://landscape-test.oss-cn-hangzhou.aliyuncs.com/ios_image/ios_20191003162052_2520840_image.jpg
             * receiveUserName : 国庆节快乐
             * receiveTime : 2019-10-04T01:45:04.000+0000
             * receiveUserId : 1179362832836255746
             * redPacketNum : null
             * senderId : 1179362832836255746
             * senderName : 国庆节快乐
             * redPacketRemark : 1对1
             * redPacketMoney : 10
             * receiveUserAvatar : https://landscape-test.oss-cn-hangzhou.aliyuncs.com/ios_image/ios_20191003162052_2520840_image.jpg
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
}
