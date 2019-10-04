package com.sy.biquan.bean;

public class SearchGroupBeanByID {

    /**
     * msg : 成功
     * code : 200
     * data : {"id":"1179330629942841345","dropId":"","isAirDrop":0,"ownerAccount":"cf6cdf7baf194a66892b90f00e49c473","type":"Public","groupId":"7584871024","name":"ggccbb","introduction":"","currencyId":"1176733022313693186","currency":"BNBBN","projectId":"","notification":"","faceUrl":"https://landscape-test.oss-cn-hangzhou.aliyuncs.com/default_avatar/%E6%9D%A8%E9%A2%96.jpeg","groupNum":1,"ownerName":"ahahaha","ownerAvatar":"https://landscape-test.oss-cn-hangzhou.aliyuncs.com/default_avatar/%E6%9D%A8%E9%A2%96.jpeg","isHere":0,"ownerId":"1174940561761329154","maxMemberCount":1000,"dropCount":0,"privatePlacementCount":0,"privatePlacementTime":"2019-10-02 09:41:51","createTime":"2019-10-02 17:41:48","updateTime":"2019-10-02 09:41:51","dissolveTime":null,"kol":1,"isDissolve":"","top":0,"topTime":null,"walletId":"","creatorId":"","pushGroupId":"","pushMessage":"","userAlias":null,"userPhone":null,"groupPersonNum":null,"projectName":null,"currencyName":null}
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
        /**
         * id : 1179330629942841345
         * dropId :
         * isAirDrop : 0
         * ownerAccount : cf6cdf7baf194a66892b90f00e49c473
         * type : Public
         * groupId : 7584871024
         * name : ggccbb
         * introduction :
         * currencyId : 1176733022313693186
         * currency : BNBBN
         * projectId :
         * notification :
         * faceUrl : https://landscape-test.oss-cn-hangzhou.aliyuncs.com/default_avatar/%E6%9D%A8%E9%A2%96.jpeg
         * groupNum : 1
         * ownerName : ahahaha
         * ownerAvatar : https://landscape-test.oss-cn-hangzhou.aliyuncs.com/default_avatar/%E6%9D%A8%E9%A2%96.jpeg
         * isHere : 0
         * ownerId : 1174940561761329154
         * maxMemberCount : 1000
         * dropCount : 0
         * privatePlacementCount : 0
         * privatePlacementTime : 2019-10-02 09:41:51
         * createTime : 2019-10-02 17:41:48
         * updateTime : 2019-10-02 09:41:51
         * dissolveTime : null
         * kol : 1
         * isDissolve :
         * top : 0
         * topTime : null
         * walletId :
         * creatorId :
         * pushGroupId :
         * pushMessage :
         * userAlias : null
         * userPhone : null
         * groupPersonNum : null
         * projectName : null
         * currencyName : null
         */

        private String id;
        private String dropId;
        private int isAirDrop;
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
        private int groupNum;
        private String ownerName;
        private String ownerAvatar;
        private int isHere;
        private String ownerId;
        private int maxMemberCount;
        private int dropCount;
        private int privatePlacementCount;
        private String privatePlacementTime;
        private String createTime;
        private String updateTime;
        private Object dissolveTime;
        private int kol;
        private String isDissolve;
        private int top;
        private Object topTime;
        private String walletId;
        private String creatorId;
        private String pushGroupId;
        private String pushMessage;
        private Object userAlias;
        private Object userPhone;
        private Object groupPersonNum;
        private Object projectName;
        private Object currencyName;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getDropId() {
            return dropId;
        }

        public void setDropId(String dropId) {
            this.dropId = dropId;
        }

        public int getIsAirDrop() {
            return isAirDrop;
        }

        public void setIsAirDrop(int isAirDrop) {
            this.isAirDrop = isAirDrop;
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

        public int getGroupNum() {
            return groupNum;
        }

        public void setGroupNum(int groupNum) {
            this.groupNum = groupNum;
        }

        public String getOwnerName() {
            return ownerName;
        }

        public void setOwnerName(String ownerName) {
            this.ownerName = ownerName;
        }

        public String getOwnerAvatar() {
            return ownerAvatar;
        }

        public void setOwnerAvatar(String ownerAvatar) {
            this.ownerAvatar = ownerAvatar;
        }

        public int getIsHere() {
            return isHere;
        }

        public void setIsHere(int isHere) {
            this.isHere = isHere;
        }

        public String getOwnerId() {
            return ownerId;
        }

        public void setOwnerId(String ownerId) {
            this.ownerId = ownerId;
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

        public Object getDissolveTime() {
            return dissolveTime;
        }

        public void setDissolveTime(Object dissolveTime) {
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

        public String getPushGroupId() {
            return pushGroupId;
        }

        public void setPushGroupId(String pushGroupId) {
            this.pushGroupId = pushGroupId;
        }

        public String getPushMessage() {
            return pushMessage;
        }

        public void setPushMessage(String pushMessage) {
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

        public Object getCurrencyName() {
            return currencyName;
        }

        public void setCurrencyName(Object currencyName) {
            this.currencyName = currencyName;
        }
    }
}
