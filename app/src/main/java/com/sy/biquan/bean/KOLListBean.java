package com.sy.biquan.bean;

import java.util.List;

public class KOLListBean {

    /**
     * code : 200
     * message : ok
     * data : [{"id":1,"userId":"1174882402065584130","userName":"1","userImCode":"a340849523a247ada3cfffcb08304f7d","currencyId":"1","currency":"1","message":"1","groupFilePath":"1","createTime":"2019-09-23 07:32:01"}]
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
         * id : 1
         * userId : 1174882402065584130
         * userName : 1
         * userImCode : a340849523a247ada3cfffcb08304f7d
         * currencyId : 1
         * currency : 1
         * message : 1
         * groupFilePath : 1
         * createTime : 2019-09-23 07:32:01
         */

        private int id;
        private String userId;
        private String userName;
        private String userImCode;
        private String currencyId;
        private String currency;
        private String message;
        private String groupFilePath;
        private String createTime;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getUserId() {
            return userId;
        }

        public void setUserId(String userId) {
            this.userId = userId;
        }

        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }

        public String getUserImCode() {
            return userImCode;
        }

        public void setUserImCode(String userImCode) {
            this.userImCode = userImCode;
        }

        public String getCurrencyId() {
            return currencyId;
        }

        public void setCurrencyId(String currencyId) {
            this.currencyId = currencyId;
        }

        public String getCurrency() {
            return currency;
        }

        public void setCurrency(String currency) {
            this.currency = currency;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

        public String getGroupFilePath() {
            return groupFilePath;
        }

        public void setGroupFilePath(String groupFilePath) {
            this.groupFilePath = groupFilePath;
        }

        public String getCreateTime() {
            return createTime;
        }

        public void setCreateTime(String createTime) {
            this.createTime = createTime;
        }
    }
}
