package com.sy.biquan.bean;

import java.util.List;

public class DakaDetailBean {

    /**
     * msg : ok
     * code : 200
     * data : {"income":null,"isFollow":0,"fansNum":2,"isMe":0,"currentOrderVos":[{"isLock":0,"currentRise":-0.45,"startTime":"11天18小时21分钟前","id":"2","title":"开发测试荐币订单"},{"isLock":0,"currentRise":-0.45,"startTime":"11天18小时21分钟前","id":"2b71c076-8afa-4249-b9c9-a2226712a26f48","title":"开发测试荐币订单"},{"isLock":0,"currentRise":-0.45,"startTime":"11天18小时21分钟前","id":"45482479-74ee-4ea1-b6bf-b97a82b6c1b457","title":"开发测试荐币订单"}],"userAvatar":"http://pic16.nipic.com/20111006/6239936_092702973000_2.jpg","avgIncomeRate":0,"jb_num":3,"userName":"昵称","expectedSucRate":8,"slogan":"生命中有许多你不想做却不能不做的事，这就是责任;生命中有许多你想做却不能做的事，这就是命运。","userId":"1175675562144837633"}
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
         * income : null
         * isFollow : 0
         * fansNum : 2
         * isMe : 0
         * currentOrderVos : [{"isLock":0,"currentRise":-0.45,"startTime":"11天18小时21分钟前","id":"2","title":"开发测试荐币订单"},{"isLock":0,"currentRise":-0.45,"startTime":"11天18小时21分钟前","id":"2b71c076-8afa-4249-b9c9-a2226712a26f48","title":"开发测试荐币订单"},{"isLock":0,"currentRise":-0.45,"startTime":"11天18小时21分钟前","id":"45482479-74ee-4ea1-b6bf-b97a82b6c1b457","title":"开发测试荐币订单"}]
         * userAvatar : http://pic16.nipic.com/20111006/6239936_092702973000_2.jpg
         * avgIncomeRate : 0.0
         * jb_num : 3
         * userName : 昵称
         * expectedSucRate : 8.0
         * slogan : 生命中有许多你不想做却不能不做的事，这就是责任;生命中有许多你想做却不能做的事，这就是命运。
         * userId : 1175675562144837633
         */

        private Object income;
        private int isFollow;
        private int fansNum;
        private int isMe;
        private String userAvatar;
        private double avgIncomeRate;
        private int jb_num;
        private String userName;
        private double expectedSucRate;
        private String slogan;
        private String userId;
        private List<CurrentOrderVosBean> currentOrderVos;

        public Object getIncome() {
            return income;
        }

        public void setIncome(Object income) {
            this.income = income;
        }

        public int getIsFollow() {
            return isFollow;
        }

        public void setIsFollow(int isFollow) {
            this.isFollow = isFollow;
        }

        public int getFansNum() {
            return fansNum;
        }

        public void setFansNum(int fansNum) {
            this.fansNum = fansNum;
        }

        public int getIsMe() {
            return isMe;
        }

        public void setIsMe(int isMe) {
            this.isMe = isMe;
        }

        public String getUserAvatar() {
            return userAvatar;
        }

        public void setUserAvatar(String userAvatar) {
            this.userAvatar = userAvatar;
        }

        public double getAvgIncomeRate() {
            return avgIncomeRate;
        }

        public void setAvgIncomeRate(double avgIncomeRate) {
            this.avgIncomeRate = avgIncomeRate;
        }

        public int getJb_num() {
            return jb_num;
        }

        public void setJb_num(int jb_num) {
            this.jb_num = jb_num;
        }

        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }

        public double getExpectedSucRate() {
            return expectedSucRate;
        }

        public void setExpectedSucRate(double expectedSucRate) {
            this.expectedSucRate = expectedSucRate;
        }

        public String getSlogan() {
            return slogan;
        }

        public void setSlogan(String slogan) {
            this.slogan = slogan;
        }

        public String getUserId() {
            return userId;
        }

        public void setUserId(String userId) {
            this.userId = userId;
        }

        public List<CurrentOrderVosBean> getCurrentOrderVos() {
            return currentOrderVos;
        }

        public void setCurrentOrderVos(List<CurrentOrderVosBean> currentOrderVos) {
            this.currentOrderVos = currentOrderVos;
        }

        public static class CurrentOrderVosBean {
            /**
             * isLock : 0
             * currentRise : -0.45
             * startTime : 11天18小时21分钟前
             * id : 2
             * title : 开发测试荐币订单
             */

            private int isLock;
            private double currentRise;
            private String startTime;
            private String id;
            private String title;

            public int getIsLock() {
                return isLock;
            }

            public void setIsLock(int isLock) {
                this.isLock = isLock;
            }

            public double getCurrentRise() {
                return currentRise;
            }

            public void setCurrentRise(double currentRise) {
                this.currentRise = currentRise;
            }

            public String getStartTime() {
                return startTime;
            }

            public void setStartTime(String startTime) {
                this.startTime = startTime;
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
        }
    }
}
