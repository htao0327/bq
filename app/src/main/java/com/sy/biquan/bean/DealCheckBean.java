package com.sy.biquan.bean;

public class DealCheckBean {

    /**
     * code : 200
     * message :
     * data : {"bullet_box":"n","checked_type":"y","operate_address":"0xf3dbB77AE2894a39e3d2EdD8Aa53314C348DA5E3","eth_address_type":"y","eth_address":"0xf3dbB77AE2894a39e3d2EdD8Aa53314C348DA5E3"}
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
         * bullet_box : n// 是否弹实名认证、添加钱包地址、不再服务期间的页面
         * checked_type : y// y：实名认证。 n： 未实名认证
         * operate_address : 0xf3dbB77AE2894a39e3d2EdD8Aa53314C348DA5E3 // 平台指定收币地址
         * eth_address_type : y // 是否添加ERC20 打USDT地址。y ： 已添加。n： 未添加
         * eth_address : 0xf3dbB77AE2894a39e3d2EdD8Aa53314C348DA5E3 // 打币地址
         */

        private String bullet_box;
        private String checked_type;
        private String operate_address;
        private String eth_address_type;
        private String eth_address;

        public String getBullet_box() {
            return bullet_box;
        }

        public void setBullet_box(String bullet_box) {
            this.bullet_box = bullet_box;
        }

        public String getChecked_type() {
            return checked_type;
        }

        public void setChecked_type(String checked_type) {
            this.checked_type = checked_type;
        }

        public String getOperate_address() {
            return operate_address;
        }

        public void setOperate_address(String operate_address) {
            this.operate_address = operate_address;
        }

        public String getEth_address_type() {
            return eth_address_type;
        }

        public void setEth_address_type(String eth_address_type) {
            this.eth_address_type = eth_address_type;
        }

        public String getEth_address() {
            return eth_address;
        }

        public void setEth_address(String eth_address) {
            this.eth_address = eth_address;
        }
    }
}
