package com.sy.biquan.bean;

import java.util.List;

public class MyWalletBean {

    /**
     * msg : ok
     * code : 200
     * data : [{"currencyEnglish":"ETH","createTime":"2019-09-24T01:06:09.000+0000","hasWallet":1,"walletAddress":"123","allowChange":"预留字段10月1后再做","currencyLogo":"","id":"1176422553602826241"},{"currencyEnglish":"BTC","createTime":"2019-09-24T01:06:09.000+0000","hasWallet":2,"walletAddress":"","allowChange":"预留字段10月1后再做","currencyLogo":"","id":"1176422553602826241"},{"currencyEnglish":"EOS","createTime":"2019-09-24T01:06:09.000+0000","hasWallet":3,"walletAddress":"","allowChange":"预留字段10月1后再做","currencyLogo":"","id":"1176422553602826241"},{"currencyEnglish":"TRX","createTime":"2019-09-24T01:06:09.000+0000","hasWallet":4,"walletAddress":"","allowChange":"预留字段10月1后再做","currencyLogo":"","id":"1176422553602826241"},{"currencyEnglish":"BNB","createTime":"2019-09-24T01:06:09.000+0000","hasWallet":5,"walletAddress":"","allowChange":"预留字段10月1后再做","currencyLogo":"","id":"1176422553602826241"},{"currencyEnglish":"NEO","createTime":"2019-09-24T01:06:09.000+0000","hasWallet":6,"walletAddress":"","allowChange":"预留字段10月1后再做","currencyLogo":"","id":"1176422553602826241"},{"currencyEnglish":"ONT","createTime":"2019-09-24T01:06:09.000+0000","hasWallet":7,"walletAddress":"","allowChange":"预留字段10月1后再做","currencyLogo":"","id":"1176422553602826241"}]
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
         * currencyEnglish : ETH
         * createTime : 2019-09-24T01:06:09.000+0000
         * hasWallet : 1
         * walletAddress : 123
         * allowChange : 预留字段10月1后再做
         * currencyLogo :
         * id : 1176422553602826241
         */

        private String currencyEnglish;
        private String createTime;
        private int hasWallet;
        private String walletAddress;
        private String allowChange;
        private String currencyLogo;
        private String id;

        public String getCurrencyEnglish() {
            return currencyEnglish;
        }

        public void setCurrencyEnglish(String currencyEnglish) {
            this.currencyEnglish = currencyEnglish;
        }

        public String getCreateTime() {
            return createTime;
        }

        public void setCreateTime(String createTime) {
            this.createTime = createTime;
        }

        public int getHasWallet() {
            return hasWallet;
        }

        public void setHasWallet(int hasWallet) {
            this.hasWallet = hasWallet;
        }

        public String getWalletAddress() {
            return walletAddress;
        }

        public void setWalletAddress(String walletAddress) {
            this.walletAddress = walletAddress;
        }

        public String getAllowChange() {
            return allowChange;
        }

        public void setAllowChange(String allowChange) {
            this.allowChange = allowChange;
        }

        public String getCurrencyLogo() {
            return currencyLogo;
        }

        public void setCurrencyLogo(String currencyLogo) {
            this.currencyLogo = currencyLogo;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }
    }
}
