package com.sy.biquan.bean;

import java.util.List;

public class DealListBean {

    /**
     * code : 200
     * message :
     * data : [{"currency_name":"ETH","user_id":{"user_name":"币友儿_3yj5k0","id":"1174875499021385729","user_header":"https://landscape-test.oss-cn-hangzhou.aliyuncs.com/default_avatar/%E6%9D%A8%E9%A2%96.jpeg"},"transaction_number":8.00000012,"transaction_usdt":1.00000002,"currency":"XDD","id":"1000000755120284","currency_id":"1","type":"1"}]
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
         * currency_name : ETH
         * user_id : {"user_name":"币友儿_3yj5k0","id":"1174875499021385729","user_header":"https://landscape-test.oss-cn-hangzhou.aliyuncs.com/default_avatar/%E6%9D%A8%E9%A2%96.jpeg"}
         * transaction_number : 8.00000012
         * transaction_usdt : 1.00000002
         * currency : XDD
         * id : 1000000755120284
         * currency_id : 1
         * type : 1
         */

        private String currency_name;
        private UserIdBean user_id;
        private double transaction_number;
        private double transaction_usdt;
        private String currency;
        private String id;
        private String currency_id;
        private String type;

        public String getCurrency_name() {
            return currency_name;
        }

        public void setCurrency_name(String currency_name) {
            this.currency_name = currency_name;
        }

        public UserIdBean getUser_id() {
            return user_id;
        }

        public void setUser_id(UserIdBean user_id) {
            this.user_id = user_id;
        }

        public double getTransaction_number() {
            return transaction_number;
        }

        public void setTransaction_number(double transaction_number) {
            this.transaction_number = transaction_number;
        }

        public double getTransaction_usdt() {
            return transaction_usdt;
        }

        public void setTransaction_usdt(double transaction_usdt) {
            this.transaction_usdt = transaction_usdt;
        }

        public String getCurrency() {
            return currency;
        }

        public void setCurrency(String currency) {
            this.currency = currency;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getCurrency_id() {
            return currency_id;
        }

        public void setCurrency_id(String currency_id) {
            this.currency_id = currency_id;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public static class UserIdBean {
            /**
             * user_name : 币友儿_3yj5k0
             * id : 1174875499021385729
             * user_header : https://landscape-test.oss-cn-hangzhou.aliyuncs.com/default_avatar/%E6%9D%A8%E9%A2%96.jpeg
             */

            private String user_name;
            private String id;
            private String user_header;

            public String getUser_name() {
                return user_name;
            }

            public void setUser_name(String user_name) {
                this.user_name = user_name;
            }

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getUser_header() {
                return user_header;
            }

            public void setUser_header(String user_header) {
                this.user_header = user_header;
            }
        }
    }
}
