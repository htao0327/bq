package com.sy.biquan.bean;

public class RedEnvelopeBean {

    /**
     * code : 200
     * message : ok
     * data : {"id":"1173879529991614466","userId":"1","groupId":"1","money":100,"congratulations":"每日一赏","number":10,"createTime":"2019-09-17 16:41:04","expire":0,"type":1}
     *
     *
     * {"code":200
     * ,"message":"ok"
     * ,"data":{"id":"1174987434899439618","userId":"1174940561761329154","receiverId":"","userName":null,"groupId":"","money":5.00,"congratulations":"","number":5,"remainNumber":5,"createTime":"2019-09-20 18:03:29","expire":0,"type":1}}
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
         * id : 1173879529991614466
         * userId : 1
         * groupId : 1
         * money : 100
         * congratulations : 每日一赏
         * number : 10
         * createTime : 2019-09-17 16:41:04
         * expire : 0
         * type : 1
         */

        private String id;
        private String userId;
        private String groupId;
        private int money;
        private String congratulations;
        private int number;
        private String createTime;
        private int expire;
        private int type;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getUserId() {
            return userId;
        }

        public void setUserId(String userId) {
            this.userId = userId;
        }

        public String getGroupId() {
            return groupId;
        }

        public void setGroupId(String groupId) {
            this.groupId = groupId;
        }

        public int getMoney() {
            return money;
        }

        public void setMoney(int money) {
            this.money = money;
        }

        public String getCongratulations() {
            return congratulations;
        }

        public void setCongratulations(String congratulations) {
            this.congratulations = congratulations;
        }

        public int getNumber() {
            return number;
        }

        public void setNumber(int number) {
            this.number = number;
        }

        public String getCreateTime() {
            return createTime;
        }

        public void setCreateTime(String createTime) {
            this.createTime = createTime;
        }

        public int getExpire() {
            return expire;
        }

        public void setExpire(int expire) {
            this.expire = expire;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }
    }
}
