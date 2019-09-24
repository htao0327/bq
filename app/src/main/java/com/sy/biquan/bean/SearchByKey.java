package com.sy.biquan.bean;

import java.util.List;

public class SearchByKey {

    /**
     * msg : 成功
     * code : 200
     * data : {"userList":[{"userId":"1175675562144837633","userAvatar":"http://pic16.nipic.com/20111006/6239936_092702973000_2.jpg","userAlias":"2413291324","slogan":"aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa","userImCode":"db10bade51b1448883d345d5e84cc51a"}],"groupList":[{"id":"1","ownerAccount":"ffa6b683174b4fab837ac6eea66abf3d","type":"Public","groupId":"2413291324","name":"开发者1群","introduction":"sopdfsodifsdj","currencyId":"1","currency":"BTC","projectId":"1","notification":"群公告","faceUrl":"/head","groupNum":null,"maxMemberCount":500,"dropCount":0,"privatePlacementCount":0,"privatePlacementTime":"2019-09-15 21:00:49","createTime":"2019-09-06 08:01:56","updateTime":"2019-09-06 08:01:56","dissolveTime":"2019-09-21 08:28:08","kol":0,"isDissolve":"n","top":0,"topTime":null,"walletId":"1","creatorId":"1","pushGroupId":null,"pushMessage":null,"userAlias":null,"userPhone":null,"groupPersonNum":null,"projectName":null}]}
     */

    private String msg;
    private int code;
    private DataBean data;

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

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        private List<UserListBean> userList;
        private List<GroupListBean> groupList;

        public List<UserListBean> getUserList() {
            return userList;
        }

        public void setUserList(List<UserListBean> userList) {
            this.userList = userList;
        }

        public List<GroupListBean> getGroupList() {
            return groupList;
        }

        public void setGroupList(List<GroupListBean> groupList) {
            this.groupList = groupList;
        }

        public static class UserListBean {
            /**
             * userId : 1175675562144837633
             * userAvatar : http://pic16.nipic.com/20111006/6239936_092702973000_2.jpg
             * userAlias : 2413291324
             * slogan : aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa
             * userImCode : db10bade51b1448883d345d5e84cc51a
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

        public static class GroupListBean {
            /**
             * id : 1
             * ownerAccount : ffa6b683174b4fab837ac6eea66abf3d
             * type : Public
             * groupId : 2413291324
             * name : 开发者1群
             * introduction : sopdfsodifsdj
             * currencyId : 1
             * currency : BTC
             * projectId : 1
             * notification : 群公告
             * faceUrl : /head
             * groupNum : null
             * maxMemberCount : 500
             * dropCount : 0
             * privatePlacementCount : 0
             * privatePlacementTime : 2019-09-15 21:00:49
             * createTime : 2019-09-06 08:01:56
             * updateTime : 2019-09-06 08:01:56
             * dissolveTime : 2019-09-21 08:28:08
             * kol : 0
             * isDissolve : n
             * top : 0
             * topTime : null
             * walletId : 1
             * creatorId : 1
             * pushGroupId : null
             * pushMessage : null
             * userAlias : null
             * userPhone : null
             * groupPersonNum : null
             * projectName : null
             */

            private String id;
            private String ownerAccount;
            private String type;
            private String groupId;
            private String name;
            private String introduction;
            private String currencyId;
            private String currency;
            private String projectId;
            private String notification;
            private String faceUrl;
            private Object groupNum;
            private int maxMemberCount;
            private int dropCount;
            private int privatePlacementCount;
            private String privatePlacementTime;
            private String createTime;
            private String updateTime;
            private String dissolveTime;
            private int kol;
            private String isDissolve;
            private int top;
            private Object topTime;
            private String walletId;
            private String creatorId;
            private Object pushGroupId;
            private Object pushMessage;
            private Object userAlias;
            private Object userPhone;
            private Object groupPersonNum;
            private Object projectName;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getOwnerAccount() {
                return ownerAccount;
            }

            public void setOwnerAccount(String ownerAccount) {
                this.ownerAccount = ownerAccount;
            }

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public String getGroupId() {
                return groupId;
            }

            public void setGroupId(String groupId) {
                this.groupId = groupId;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getIntroduction() {
                return introduction;
            }

            public void setIntroduction(String introduction) {
                this.introduction = introduction;
            }

            public String getCurrencyId() {
                return currencyId;
            }

            public void setCurrencyId(String currencyId) {
                this.currencyId = currencyId;
            }

            public String getCurrency() {
                return currency;
            }

            public void setCurrency(String currency) {
                this.currency = currency;
            }

            public String getProjectId() {
                return projectId;
            }

            public void setProjectId(String projectId) {
                this.projectId = projectId;
            }

            public String getNotification() {
                return notification;
            }

            public void setNotification(String notification) {
                this.notification = notification;
            }

            public String getFaceUrl() {
                return faceUrl;
            }

            public void setFaceUrl(String faceUrl) {
                this.faceUrl = faceUrl;
            }

            public Object getGroupNum() {
                return groupNum;
            }

            public void setGroupNum(Object groupNum) {
                this.groupNum = groupNum;
            }

            public int getMaxMemberCount() {
                return maxMemberCount;
            }

            public void setMaxMemberCount(int maxMemberCount) {
                this.maxMemberCount = maxMemberCount;
            }

            public int getDropCount() {
                return dropCount;
            }

            public void setDropCount(int dropCount) {
                this.dropCount = dropCount;
            }

            public int getPrivatePlacementCount() {
                return privatePlacementCount;
            }

            public void setPrivatePlacementCount(int privatePlacementCount) {
                this.privatePlacementCount = privatePlacementCount;
            }

            public String getPrivatePlacementTime() {
                return privatePlacementTime;
            }

            public void setPrivatePlacementTime(String privatePlacementTime) {
                this.privatePlacementTime = privatePlacementTime;
            }

            public String getCreateTime() {
                return createTime;
            }

            public void setCreateTime(String createTime) {
                this.createTime = createTime;
            }

            public String getUpdateTime() {
                return updateTime;
            }

            public void setUpdateTime(String updateTime) {
                this.updateTime = updateTime;
            }

            public String getDissolveTime() {
                return dissolveTime;
            }

            public void setDissolveTime(String dissolveTime) {
                this.dissolveTime = dissolveTime;
            }

            public int getKol() {
                return kol;
            }

            public void setKol(int kol) {
                this.kol = kol;
            }

            public String getIsDissolve() {
                return isDissolve;
            }

            public void setIsDissolve(String isDissolve) {
                this.isDissolve = isDissolve;
            }

            public int getTop() {
                return top;
            }

            public void setTop(int top) {
                this.top = top;
            }

            public Object getTopTime() {
                return topTime;
            }

            public void setTopTime(Object topTime) {
                this.topTime = topTime;
            }

            public String getWalletId() {
                return walletId;
            }

            public void setWalletId(String walletId) {
                this.walletId = walletId;
            }

            public String getCreatorId() {
                return creatorId;
            }

            public void setCreatorId(String creatorId) {
                this.creatorId = creatorId;
            }

            public Object getPushGroupId() {
                return pushGroupId;
            }

            public void setPushGroupId(Object pushGroupId) {
                this.pushGroupId = pushGroupId;
            }

            public Object getPushMessage() {
                return pushMessage;
            }

            public void setPushMessage(Object pushMessage) {
                this.pushMessage = pushMessage;
            }

            public Object getUserAlias() {
                return userAlias;
            }

            public void setUserAlias(Object userAlias) {
                this.userAlias = userAlias;
            }

            public Object getUserPhone() {
                return userPhone;
            }

            public void setUserPhone(Object userPhone) {
                this.userPhone = userPhone;
            }

            public Object getGroupPersonNum() {
                return groupPersonNum;
            }

            public void setGroupPersonNum(Object groupPersonNum) {
                this.groupPersonNum = groupPersonNum;
            }

            public Object getProjectName() {
                return projectName;
            }

            public void setProjectName(Object projectName) {
                this.projectName = projectName;
            }
        }
    }
}
