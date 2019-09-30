package com.sy.biquan.bean;

public class DealBean {

    private int type;//type = 2 表示交易消息
    private String typeName;
    private String userLaunch;//发起方
    private String userReceive;//接收方
    private String dealID;//交易订单ID

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getUserLaunch() {
        return userLaunch;
    }

    public void setUserLaunch(String userLaunch) {
        this.userLaunch = userLaunch;
    }

    public String getUserReceive() {
        return userReceive;
    }

    public void setUserReceive(String userReceive) {
        this.userReceive = userReceive;
    }

    public String getDealID() {
        return dealID;
    }

    public void setDealID(String dealID) {
        this.dealID = dealID;
    }
}
