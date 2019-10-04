package com.sy.biquan.bean;

import java.util.List;

public class XMListBean {

    /**
     * msg : ok
     * code : 200
     * data : [{"webSite":"www.baidu.com","groups":18,"projectDesc":"币圈儿是一款数字金融投资者的移动端入口。币圈儿致力于打造一个多元、丰富又实用的数字资产投资生态和区块链世界的社交平台，帮助数字资产投资圈新用户迅速融入圈子，拓展朋友圈，提高交易技能，获得更多财富。","currency":"","currencyId":"1","projectName":"开发测试项目2","projectId":"2","projectImg":"https://landscape-test.oss-cn-hangzhou.aliyuncs.com/default_avatar/%E6%9D%A8%E9%A2%96.jpeg"},{"webSite":"www.baidu.com","groups":8,"projectDesc":"币圈儿是一款数字金融投资者的移动端入口。币圈儿致力于打造一个多元、丰富又实用的数字资产投资生态和区块链世界的社交平台，帮助数字资产投资圈新用户迅速融入圈子，拓展朋友圈，提高交易技能，获得更多财富。","currency":"","currencyId":"1","projectName":"开发测试项目3","projectId":"3","projectImg":"https://landscape-test.oss-cn-hangzhou.aliyuncs.com/default_avatar/%E6%9D%A8%E9%A2%96.jpeg"},{"webSite":"www.baidu.com","groups":8,"projectDesc":"币圈儿是一款数字金融投资者的移动端入口。币圈儿致力于打造一个多元、丰富又实用的数字资产投资生态和区块链世界的社交平台，帮助数字资产投资圈新用户迅速融入圈子，拓展朋友圈，提高交易技能，获得更多财富。","currency":"","currencyId":"1","projectName":"开发测试项目4","projectId":"4","projectImg":"https://landscape-test.oss-cn-hangzhou.aliyuncs.com/default_avatar/%E6%9D%A8%E9%A2%96.jpeg"},{"webSite":"www.baidu.com","groups":8,"projectDesc":"币圈儿是一款数字金融投资者的移动端入口。币圈儿致力于打造一个多元、丰富又实用的数字资产投资生态和区块链世界的社交平台，帮助数字资产投资圈新用户迅速融入圈子，拓展朋友圈，提高交易技能，获得更多财富。","currency":"","currencyId":"1","projectName":"开发测试项目5","projectId":"5","projectImg":"https://landscape-test.oss-cn-hangzhou.aliyuncs.com/default_avatar/%E6%9D%A8%E9%A2%96.jpeg"},{"webSite":"www.baidu.com","groups":5,"projectDesc":"币圈儿是一款数字金融投资者的移动端入口。币圈儿致力于打造一个多元、丰富又实用的数字资产投资生态和区块链世界的社交平台，帮助数字资产投资圈新用户迅速融入圈子，拓展朋友圈，提高交易技能，获得更多财富。","currency":"","currencyId":"3","projectName":"开发测试项目6","projectId":"6","projectImg":"https://landscape-test.oss-cn-hangzhou.aliyuncs.com/default_avatar/%E6%9D%A8%E9%A2%96.jpeg"},{"webSite":"www.baidu.com","groups":8,"projectDesc":"币圈儿是一款数字金融投资者的移动端入口。币圈儿致力于打造一个多元、丰富又实用的数字资产投资生态和区块链世界的社交平台，帮助数字资产投资圈新用户迅速融入圈子，拓展朋友圈，提高交易技能，获得更多财富。","currency":"","currencyId":"1","projectName":"开发测试项目7","projectId":"7","projectImg":"https://landscape-test.oss-cn-hangzhou.aliyuncs.com/default_avatar/%E6%9D%A8%E9%A2%96.jpeg"}]
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
         * webSite : www.baidu.com
         * groups : 18
         * projectDesc : 币圈儿是一款数字金融投资者的移动端入口。币圈儿致力于打造一个多元、丰富又实用的数字资产投资生态和区块链世界的社交平台，帮助数字资产投资圈新用户迅速融入圈子，拓展朋友圈，提高交易技能，获得更多财富。
         * currency :
         * currencyId : 1
         * projectName : 开发测试项目2
         * projectId : 2
         * projectImg : https://landscape-test.oss-cn-hangzhou.aliyuncs.com/default_avatar/%E6%9D%A8%E9%A2%96.jpeg
         */

        private String webSite;
        private int groups;
        private String projectDesc;
        private String currency;
        private String currencyId;
        private String projectName;
        private String projectId;
        private String projectImg;

        public String getWebSite() {
            return webSite;
        }

        public void setWebSite(String webSite) {
            this.webSite = webSite;
        }

        public int getGroups() {
            return groups;
        }

        public void setGroups(int groups) {
            this.groups = groups;
        }

        public String getProjectDesc() {
            return projectDesc;
        }

        public void setProjectDesc(String projectDesc) {
            this.projectDesc = projectDesc;
        }

        public String getCurrency() {
            return currency;
        }

        public void setCurrency(String currency) {
            this.currency = currency;
        }

        public String getCurrencyId() {
            return currencyId;
        }

        public void setCurrencyId(String currencyId) {
            this.currencyId = currencyId;
        }

        public String getProjectName() {
            return projectName;
        }

        public void setProjectName(String projectName) {
            this.projectName = projectName;
        }

        public String getProjectId() {
            return projectId;
        }

        public void setProjectId(String projectId) {
            this.projectId = projectId;
        }

        public String getProjectImg() {
            return projectImg;
        }

        public void setProjectImg(String projectImg) {
            this.projectImg = projectImg;
        }
    }
}
