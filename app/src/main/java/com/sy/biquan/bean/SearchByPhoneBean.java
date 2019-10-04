package com.sy.biquan.bean;

public class SearchByPhoneBean {

    /**
     * code : 200
     * message :
     * data : {"userId":"1174875499021385729","userAvatar":"https://landscape-test.oss-cn-hangzhou.aliyuncs.com/default_avatar/%E6%9D%A8%E9%A2%96.jpeg","userAlias":"币友儿_3yj5k0","slogan":null,"userImCode":"ffa6b683174b4fab837ac6eea66abf3d"}
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
         * userId : 1174875499021385729
         * userAvatar : https://landscape-test.oss-cn-hangzhou.aliyuncs.com/default_avatar/%E6%9D%A8%E9%A2%96.jpeg
         * userAlias : 币友儿_3yj5k0
         * slogan : null
         * userImCode : ffa6b683174b4fab837ac6eea66abf3d
         */

        private String userId;
        private String userAvatar;
        private String userAlias;
        private String slogan;
        private String userImCode;

        public String getUserId() {
            return userId;
        }

        public void setUserId(String userId) {
            this.userId = userId;
        }

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

        public String getSlogan() {
            return slogan;
        }

        public void setSlogan(String slogan) {
            this.slogan = slogan;
        }

        public String getUserImCode() {
            return userImCode;
        }

        public void setUserImCode(String userImCode) {
            this.userImCode = userImCode;
        }
    }
}
