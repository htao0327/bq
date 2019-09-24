package com.sy.biquan.bean;

import java.util.List;

public class HotWordBean {

    /**
     * msg : 成功
     * code : 200
     * data : [{"id":"10","keyWord":"币圈大神","status":1,"createTime":"2019-08-26 06:22:15","sort":1},{"id":"1167622768250888194","keyWord":"圈币无敌","status":1,"createTime":"2019-08-31 00:00:00","sort":51},{"id":"1167623132266143745","keyWord":"圈币无敌","status":1,"createTime":"2019-08-31 00:00:00","sort":15},{"id":"15","keyWord":"国庆节","status":1,"createTime":"2019-08-30 00:00:00","sort":2},{"id":"87c6b9e7-baa9-4b0a-8a22-a10f4b43bd03","keyWord":"测试","status":1,"createTime":"2019-09-04 13:55:53","sort":45}]
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
         * id : 10
         * keyWord : 币圈大神
         * status : 1
         * createTime : 2019-08-26 06:22:15
         * sort : 1
         */

        private String id;
        private String keyWord;
        private int status;
        private String createTime;
        private int sort;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getKeyWord() {
            return keyWord;
        }

        public void setKeyWord(String keyWord) {
            this.keyWord = keyWord;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public String getCreateTime() {
            return createTime;
        }

        public void setCreateTime(String createTime) {
            this.createTime = createTime;
        }

        public int getSort() {
            return sort;
        }

        public void setSort(int sort) {
            this.sort = sort;
        }
    }
}
