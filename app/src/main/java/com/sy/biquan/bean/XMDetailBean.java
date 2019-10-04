package com.sy.biquan.bean;

import java.util.List;

public class XMDetailBean {

    /**
     * msg : 成功
     * code : 200
     * data : [{"projectId":"2","groupId":"5464041995","group_face_url":"http://hbimg.b0.upaiyun.com/828e72e2855b51a005732f4e007c58c92417a61e1bcb1-61VzNc_fw658","groupName":"普通群","groupNum":2}]
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
         * projectId : 2
         * groupId : 5464041995
         * group_face_url : http://hbimg.b0.upaiyun.com/828e72e2855b51a005732f4e007c58c92417a61e1bcb1-61VzNc_fw658
         * groupName : 普通群
         * groupNum : 2
         */

        private String projectId;
        private String groupId;
        private String group_face_url;
        private String groupName;
        private int groupNum;

        public String getProjectId() {
            return projectId;
        }

        public void setProjectId(String projectId) {
            this.projectId = projectId;
        }

        public String getGroupId() {
            return groupId;
        }

        public void setGroupId(String groupId) {
            this.groupId = groupId;
        }

        public String getGroup_face_url() {
            return group_face_url;
        }

        public void setGroup_face_url(String group_face_url) {
            this.group_face_url = group_face_url;
        }

        public String getGroupName() {
            return groupName;
        }

        public void setGroupName(String groupName) {
            this.groupName = groupName;
        }

        public int getGroupNum() {
            return groupNum;
        }

        public void setGroupNum(int groupNum) {
            this.groupNum = groupNum;
        }
    }
}
