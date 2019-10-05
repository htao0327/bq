package com.sy.biquan.bean;

public class UserInfo {

    private String userAlias;//用户昵称
    private String userImCode;//用户imCode
    private String userAvatar;//用户头像url
    private String userId;//用户ID
    private String slogan;//个性签名
    private String userPhone;//电话号码
    private String authStatus;//是否实名认证 0-未认证 1-审核中 2-认证成功 3-认证失败
    private String dealPassword;//是否设置了交易密码，1-是，0-否
    private String hasInviteCode;//是否填写过邀请码,1-是，0-否
    private String inviteUserId;//邀请人用户ID
    private String inviteUserAlias;//邀请人用户昵称
    private String token;//
    private String userType;//用户类型：1. 普通用户 2.KOL 3 项目方
    private int fansCount;//粉丝数
    private int followCount;//关注数
    private int qbNumber;//Q豆数

    public String getUserAlias() {
        return userAlias;
    }

    public void setUserAlias(String userAlias) {
        this.userAlias = userAlias;
    }

    public String getUserImCode() {
        return userImCode;
    }

    public void setUserImCode(String userImCode) {
        this.userImCode = userImCode;
    }

    public String getUserAvatar() {
        return userAvatar;
    }

    public void setUserAvatar(String userAvatar) {
        this.userAvatar = userAvatar;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getSlogan() {
        return slogan;
    }

    public void setSlogan(String slogan) {
        this.slogan = slogan;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public String getAuthStatus() {
        return authStatus;
    }

    public void setAuthStatus(String authStatus) {
        this.authStatus = authStatus;
    }

    public String getDealPassword() {
        return dealPassword;
    }

    public void setDealPassword(String dealPassword) {
        this.dealPassword = dealPassword;
    }

    public String getHasInviteCode() {
        return hasInviteCode;
    }

    public void setHasInviteCode(String hasInviteCode) {
        this.hasInviteCode = hasInviteCode;
    }

    public String getInviteUserId() {
        return inviteUserId;
    }

    public void setInviteUserId(String inviteUserId) {
        this.inviteUserId = inviteUserId;
    }

    public String getInviteUserAlias() {
        return inviteUserAlias;
    }

    public void setInviteUserAlias(String inviteUserAlias) {
        this.inviteUserAlias = inviteUserAlias;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public int getFansCount() {
        return fansCount;
    }

    public void setFansCount(int fansCount) {
        this.fansCount = fansCount;
    }

    public int getFollowCount() {
        return followCount;
    }

    public void setFollowCount(int followCount) {
        this.followCount = followCount;
    }

    public int getQbNumber() {
        return qbNumber;
    }

    public void setQbNumber(int qbNumber) {
        this.qbNumber = qbNumber;
    }
}
