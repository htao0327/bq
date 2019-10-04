package com.sy.biquan.bean;

public class GroupInfoBean {

    /**
     * msg : ok
     * code : 200
     * data : {"groupName":"PUTONGQUN","isKol":0,"isOwner":0,"groupId":"1179329323324870657","currency":"","currencyId":"","projectName":"","gongLianName":"","projectId":""}
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
         * groupName : PUTONGQUN
         * isKol : 0
         * isOwner : 0
         * groupId : 1179329323324870657
         * currency :
         * currencyId :
         * projectName :
         * gongLianName :
         * projectId :
         */

        private String groupName;
        private int isKol;
        private int isOwner;
        private String groupId;
        private String currency;
        private String currencyId;
        private String projectName;
        private String gongLianName;
        private String projectId;

        public String getGroupName() {
            return groupName;
        }

        public void setGroupName(String groupName) {
            this.groupName = groupName;
        }

        public int getIsKol() {
            return isKol;
        }

        public void setIsKol(int isKol) {
            this.isKol = isKol;
        }

        public int getIsOwner() {
            return isOwner;
        }

        public void setIsOwner(int isOwner) {
            this.isOwner = isOwner;
        }

        public String getGroupId() {
            return groupId;
        }

        public void setGroupId(String groupId) {
            this.groupId = groupId;
        }

        public String getCurrency() {
            return currency;
        }

        public void setCurrency(String currency) {
            this.currency = currency;
        }

        public String getCurrencyId() {
            return currencyId;
        }

        public void setCurrencyId(String currencyId) {
            this.currencyId = currencyId;
        }

        public String getProjectName() {
            return projectName;
        }

        public void setProjectName(String projectName) {
            this.projectName = projectName;
        }

        public String getGongLianName() {
            return gongLianName;
        }

        public void setGongLianName(String gongLianName) {
            this.gongLianName = gongLianName;
        }

        public String getProjectId() {
            return projectId;
        }

        public void setProjectId(String projectId) {
            this.projectId = projectId;
        }
    }
}
