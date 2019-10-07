package com.sy.biquan.bean;

import java.util.List;

public class MyTaskBean {

    /**
     * code : 200
     * message : ok
     * data : {"userAvatar":"https://landscape-test.oss-cn-hangzhou.aliyuncs.com/default_avatar/%E6%9D%A8%E9%A2%96.jpeg","userAlias":"币友儿_qk3m7h","taskScore":0,"remainScore":0,"operateValue":0,"taskList":[{"taskId":"1","taskCategory":1,"taskName":"钱包任务:添加一个钱包地址","state":1,"taskReward":0.5},{"taskId":"2","taskCategory":1,"taskName":"群聊任务:加入一个群聊","state":1,"taskReward":0.5},{"taskId":"3","taskCategory":1,"taskName":"空投任务:领取一次空投","state":0,"taskReward":0.5},{"taskId":"4","taskCategory":1,"taskName":"好友任务:添加一个币圈好友","state":0,"taskReward":0.5},{"taskId":"5","taskCategory":1,"taskName":"荐币任务:购买一次荐币","state":1,"taskReward":0.5},{"taskId":"6","taskCategory":1,"taskName":"荐币任务:发布一次荐币","state":1,"taskReward":0.5},{"taskId":"7","taskCategory":1,"taskName":"个人中心任务:完善个人资料","state":1,"taskReward":0.5}],"qbeanNum":9.9999934E7}
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
         * userAvatar : https://landscape-test.oss-cn-hangzhou.aliyuncs.com/default_avatar/%E6%9D%A8%E9%A2%96.jpeg
         * userAlias : 币友儿_qk3m7h
         * taskScore : 0
         * remainScore : 0
         * operateValue : 0
         * taskList : [{"taskId":"1","taskCategory":1,"taskName":"钱包任务:添加一个钱包地址","state":1,"taskReward":0.5},{"taskId":"2","taskCategory":1,"taskName":"群聊任务:加入一个群聊","state":1,"taskReward":0.5},{"taskId":"3","taskCategory":1,"taskName":"空投任务:领取一次空投","state":0,"taskReward":0.5},{"taskId":"4","taskCategory":1,"taskName":"好友任务:添加一个币圈好友","state":0,"taskReward":0.5},{"taskId":"5","taskCategory":1,"taskName":"荐币任务:购买一次荐币","state":1,"taskReward":0.5},{"taskId":"6","taskCategory":1,"taskName":"荐币任务:发布一次荐币","state":1,"taskReward":0.5},{"taskId":"7","taskCategory":1,"taskName":"个人中心任务:完善个人资料","state":1,"taskReward":0.5}]
         * qbeanNum : 9.9999934E7
         */

        private String userAvatar;
        private String userAlias;
        private int taskScore;
        private int remainScore;
        private int operateValue;
        private double qbeanNum;
        private List<TaskListBean> taskList;

        public String getUserAvatar() {
            return userAvatar;
        }

        public void setUserAvatar(String userAvatar) {
            this.userAvatar = userAvatar;
        }

        public String getUserAlias() {
            return userAlias;
        }

        public void setUserAlias(String userAlias) {
            this.userAlias = userAlias;
        }

        public int getTaskScore() {
            return taskScore;
        }

        public void setTaskScore(int taskScore) {
            this.taskScore = taskScore;
        }

        public int getRemainScore() {
            return remainScore;
        }

        public void setRemainScore(int remainScore) {
            this.remainScore = remainScore;
        }

        public int getOperateValue() {
            return operateValue;
        }

        public void setOperateValue(int operateValue) {
            this.operateValue = operateValue;
        }

        public double getQbeanNum() {
            return qbeanNum;
        }

        public void setQbeanNum(double qbeanNum) {
            this.qbeanNum = qbeanNum;
        }

        public List<TaskListBean> getTaskList() {
            return taskList;
        }

        public void setTaskList(List<TaskListBean> taskList) {
            this.taskList = taskList;
        }

        public static class TaskListBean {
            /**
             * taskId : 1
             * taskCategory : 1
             * taskName : 钱包任务:添加一个钱包地址
             * state : 1
             * taskReward : 0.5
             */

            private String taskId;
            private int taskCategory;
            private String taskName;
            private int state;
            private double taskReward;

            public String getTaskId() {
                return taskId;
            }

            public void setTaskId(String taskId) {
                this.taskId = taskId;
            }

            public int getTaskCategory() {
                return taskCategory;
            }

            public void setTaskCategory(int taskCategory) {
                this.taskCategory = taskCategory;
            }

            public String getTaskName() {
                return taskName;
            }

            public void setTaskName(String taskName) {
                this.taskName = taskName;
            }

            public int getState() {
                return state;
            }

            public void setState(int state) {
                this.state = state;
            }

            public double getTaskReward() {
                return taskReward;
            }

            public void setTaskReward(double taskReward) {
                this.taskReward = taskReward;
            }
        }
    }
}
