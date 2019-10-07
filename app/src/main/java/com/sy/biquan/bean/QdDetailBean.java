package com.sy.biquan.bean;

import java.util.List;

public class QdDetailBean {

    /**
     * msg : ok
     * code : 200
     * data : [{"remark":"购买荐币","id":"13212","time":"2019-09-28T00:42:42.000+0000","value":30},{"remark":"gkkgkj","id":"3a312438-46ff-48f1-97b8-7c06862194ad","time":"2019-09-28T14:18:10.000+0000","value":31},{"remark":"gkkgkj","id":"54809dbc-efe6-4706-9d15-e985eb2dd25e","time":"2019-09-28T14:18:11.000+0000","value":32},{"remark":"gkkgkj","id":"5ca6aacc-3f21-4303-a817-89ff45c85773","time":"2019-09-28T14:17:20.000+0000","value":33},{"remark":"gkkgkj","id":"76f14af3-99a4-4884-8c59-83353a4e1d99","time":"2019-09-28T14:17:26.000+0000","value":34},{"remark":"gkkgkj","id":"9cfaa795-02eb-431c-ab00-b438361d243e","time":"2019-09-28T14:10:02.000+0000","value":35},{"remark":"gkkgkj","id":"da9350c3-665f-4c06-95b2-f3d226ec1d64","time":"2019-09-28T14:27:15.000+0000","value":36}]
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
         * remark : 购买荐币
         * id : 13212
         * time : 2019-09-28T00:42:42.000+0000
         * value : 30
         */

        private String remark;
        private String id;
        private String time;
        private double value;

        public String getRemark() {
            return remark;
        }

        public void setRemark(String remark) {
            this.remark = remark;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getTime() {
            return time;
        }

        public void setTime(String time) {
            this.time = time;
        }

        public double getValue() {
            return value;
        }

        public void setValue(double value) {
            this.value = value;
        }
    }
}
