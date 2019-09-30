package com.sy.biquan.bean;

import java.util.List;

public class BannerBean {

    /**
     * msg : 成功
     * code : 200
     * data : [{"id":"1","thumbnail":"http://pic27.nipic.com/20130222/10741105_154139938000_2.jpg","href":"/article/1626262","push_type":null,"project_id":null}]
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
         * id : 1
         * thumbnail : http://pic27.nipic.com/20130222/10741105_154139938000_2.jpg
         * href : /article/1626262
         * push_type : null
         * project_id : null
         */

        private String id;
        private String thumbnail;
        private String href;
        private Object push_type;
        private Object project_id;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getThumbnail() {
            return thumbnail;
        }

        public void setThumbnail(String thumbnail) {
            this.thumbnail = thumbnail;
        }

        public String getHref() {
            return href;
        }

        public void setHref(String href) {
            this.href = href;
        }

        public Object getPush_type() {
            return push_type;
        }

        public void setPush_type(Object push_type) {
            this.push_type = push_type;
        }

        public Object getProject_id() {
            return project_id;
        }

        public void setProject_id(Object project_id) {
            this.project_id = project_id;
        }
    }
}
