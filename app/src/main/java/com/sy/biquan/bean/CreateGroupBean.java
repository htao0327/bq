package com.sy.biquan.bean;

public class CreateGroupBean {


    /**
     * code : 200
     * message : ok
     * data : {"ActionStatus":"OK","ErrorCode":0,"ErrorInfo":"","GroupId":"4841273753"}
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
         * ActionStatus : OK
         * ErrorCode : 0
         * ErrorInfo :
         * GroupId : 4841273753
         */

        private String ActionStatus;
        private int ErrorCode;
        private String ErrorInfo;
        private String GroupId;

        public String getActionStatus() {
            return ActionStatus;
        }

        public void setActionStatus(String ActionStatus) {
            this.ActionStatus = ActionStatus;
        }

        public int getErrorCode() {
            return ErrorCode;
        }

        public void setErrorCode(int ErrorCode) {
            this.ErrorCode = ErrorCode;
        }

        public String getErrorInfo() {
            return ErrorInfo;
        }

        public void setErrorInfo(String ErrorInfo) {
            this.ErrorInfo = ErrorInfo;
        }

        public String getGroupId() {
            return GroupId;
        }

        public void setGroupId(String GroupId) {
            this.GroupId = GroupId;
        }
    }
}
