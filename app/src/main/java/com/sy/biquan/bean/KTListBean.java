package com.sy.biquan.bean;

import java.util.List;

public class KTListBean {

    /**
     * msg : ok
     * code : 200
     * data : [{"groupFaceUrl":"http://hbimg.b0.upaiyun.com/828e72e2855b51a005732f4e007c58c92417a61e1bcb1-61VzNc_fw658","remainNumber":10,"groupId":"4841273753","id":"11744e06-9c0c-42dd-882b-bae04d6f9cb2","title":"测试1","groupNumber":1},{"groupFaceUrl":"http://hbimg.b0.upaiyun.com/828e72e2855b51a005732f4e007c58c92417a61e1bcb1-61VzNc_fw658","remainNumber":10,"groupId":"4841273753","id":"b2db79fc-4444-414d-a3e5-9073387436c0","title":"测试2","groupNumber":1}]
     */

    private String msg;
    private int code;
    private List<DataBean> data;

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

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * groupFaceUrl : http://hbimg.b0.upaiyun.com/828e72e2855b51a005732f4e007c58c92417a61e1bcb1-61VzNc_fw658
         * remainNumber : 10
         * groupId : 4841273753
         * id : 11744e06-9c0c-42dd-882b-bae04d6f9cb2
         * title : 测试1
         * groupNumber : 1
         */

        private String groupFaceUrl;
        private int remainNumber;
        private String groupId;
        private String id;
        private String title;
        private int groupNumber;

        public String getGroupFaceUrl() {
            return groupFaceUrl;
        }

        public void setGroupFaceUrl(String groupFaceUrl) {
            this.groupFaceUrl = groupFaceUrl;
        }

        public int getRemainNumber() {
            return remainNumber;
        }

        public void setRemainNumber(int remainNumber) {
            this.remainNumber = remainNumber;
        }

        public String getGroupId() {
            return groupId;
        }

        public void setGroupId(String groupId) {
            this.groupId = groupId;
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

        public int getGroupNumber() {
            return groupNumber;
        }

        public void setGroupNumber(int groupNumber) {
            this.groupNumber = groupNumber;
        }
    }
}
