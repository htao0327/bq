package com.sy.biquan.bean;

import java.util.List;

public class MainListData {

    /**
     * msg : 成功
     * code : 200
     * data : [{"id":"8cef6cc3-a8ba-4fc1-826d-c012b6295d2d38","userId":"1175339087532007425","title":"开发测试荐币订单","startTime":"11天4小时22分钟前","nowRise":554.15,"expectedRise":10,"bourse":"抹茶","isLock":0,"expectedSucRate":0,"avgIncome":0,"userAvatar":"https://landscape-test.oss-cn-hangzhou.aliyuncs.com/default_avatar/%E6%9D%A8%E9%A2%96.jpeg","userName":"昵称","qbeanNumber":30},{"id":"10","userId":"1","title":"开发测试荐币订单","startTime":"11天4小时22分钟前","nowRise":142.94,"expectedRise":10,"bourse":"抹茶","isLock":0,"expectedSucRate":0,"avgIncome":0,"userAvatar":"http://pic16.nipic.com/20111006/6239936_092702973000_2.jpg","userName":"管理员","qbeanNumber":30},{"id":"1176438909910052866","userId":"1174882402065584130","title":"开发测试荐币订单","startTime":"11天4小时22分钟前","nowRise":76.77,"expectedRise":10,"bourse":"抹茶","isLock":0,"expectedSucRate":17,"avgIncome":73,"userAvatar":"https://landscape-test.oss-cn-hangzhou.aliyuncs.com/ios_image/ios_20190929162511_1383397_image.jpg","userName":"国庆节快乐","qbeanNumber":0},{"id":"1176439073777315841","userId":"1174882402065584130","title":"开发测试荐币订单","startTime":"11天4小时22分钟前","nowRise":73.65,"expectedRise":10,"bourse":"抹茶","isLock":0,"expectedSucRate":17,"avgIncome":73,"userAvatar":"https://landscape-test.oss-cn-hangzhou.aliyuncs.com/ios_image/ios_20190929162511_1383397_image.jpg","userName":"国庆节快乐","qbeanNumber":0},{"id":"1172087687447003137","userId":"1174882402065584130","title":"开发测试荐币订单","startTime":"11天4小时22分钟前","nowRise":72.83,"expectedRise":10,"bourse":"抹茶","isLock":0,"expectedSucRate":17,"avgIncome":73,"userAvatar":"https://landscape-test.oss-cn-hangzhou.aliyuncs.com/ios_image/ios_20190929162511_1383397_image.jpg","userName":"国庆节快乐","qbeanNumber":30},{"id":"1176438198103109634","userId":"1174882402065584130","title":"开发测试荐币订单","startTime":"11天4小时22分钟前","nowRise":72.61,"expectedRise":10,"bourse":"抹茶","isLock":0,"expectedSucRate":17,"avgIncome":73,"userAvatar":"https://landscape-test.oss-cn-hangzhou.aliyuncs.com/ios_image/ios_20190929162511_1383397_image.jpg","userName":"国庆节快乐","qbeanNumber":0},{"id":"4c4b2b0a-4f05-4daf-8d52-df105f5a0ad058","userId":"1","title":"开发测试荐币订单","startTime":"11天4小时22分钟前","nowRise":58.74,"expectedRise":10,"bourse":"抹茶","isLock":0,"expectedSucRate":0,"avgIncome":0,"userAvatar":"http://pic16.nipic.com/20111006/6239936_092702973000_2.jpg","userName":"管理员","qbeanNumber":30},{"id":"14","userId":"1174882402065584130","title":"开发测试荐币订单","startTime":"11天4小时22分钟前","nowRise":42.1,"expectedRise":10,"bourse":"抹茶","isLock":0,"expectedSucRate":17,"avgIncome":73,"userAvatar":"https://landscape-test.oss-cn-hangzhou.aliyuncs.com/ios_image/ios_20190929162511_1383397_image.jpg","userName":"国庆节快乐","qbeanNumber":30},{"id":"6906a26f-83f1-4756-b679-d362adb93cd147","userId":"1175339087532007425","title":"开发测试荐币订单","startTime":"11天4小时22分钟前","nowRise":24.99,"expectedRise":10,"bourse":"抹茶","isLock":0,"expectedSucRate":0,"avgIncome":0,"userAvatar":"https://landscape-test.oss-cn-hangzhou.aliyuncs.com/default_avatar/%E6%9D%A8%E9%A2%96.jpeg","userName":"昵称","qbeanNumber":30},{"id":"6","userId":"1175339087532007425","title":"开发测试荐币订单","startTime":"11天4小时22分钟前","nowRise":20.99,"expectedRise":10,"bourse":"抹茶","isLock":0,"expectedSucRate":0,"avgIncome":0,"userAvatar":"https://landscape-test.oss-cn-hangzhou.aliyuncs.com/default_avatar/%E6%9D%A8%E9%A2%96.jpeg","userName":"昵称","qbeanNumber":30}]
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
         * id : 8cef6cc3-a8ba-4fc1-826d-c012b6295d2d38
         * userId : 1175339087532007425
         * title : 开发测试荐币订单
         * startTime : 11天4小时22分钟前
         * nowRise : 554.15
         * expectedRise : 10.0
         * bourse : 抹茶
         * isLock : 0
         * expectedSucRate : 0
         * avgIncome : 0
         * userAvatar : https://landscape-test.oss-cn-hangzhou.aliyuncs.com/default_avatar/%E6%9D%A8%E9%A2%96.jpeg
         * userName : 昵称
         * qbeanNumber : 30
         */

        private String id;
        private String userId;
        private String title;
        private String startTime;
        private double nowRise;
        private double expectedRise;
        private String bourse;
        private int isLock;
        private double expectedSucRate;
        private double avgIncome;
        private String userAvatar;
        private String userName;
        private int qbeanNumber;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getUserId() {
            return userId;
        }

        public void setUserId(String userId) {
            this.userId = userId;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getStartTime() {
            return startTime;
        }

        public void setStartTime(String startTime) {
            this.startTime = startTime;
        }

        public double getNowRise() {
            return nowRise;
        }

        public void setNowRise(double nowRise) {
            this.nowRise = nowRise;
        }

        public double getExpectedRise() {
            return expectedRise;
        }

        public void setExpectedRise(double expectedRise) {
            this.expectedRise = expectedRise;
        }

        public String getBourse() {
            return bourse;
        }

        public void setBourse(String bourse) {
            this.bourse = bourse;
        }

        public int getIsLock() {
            return isLock;
        }

        public void setIsLock(int isLock) {
            this.isLock = isLock;
        }

        public double getExpectedSucRate() {
            return expectedSucRate;
        }

        public void setExpectedSucRate(double expectedSucRate) {
            this.expectedSucRate = expectedSucRate;
        }

        public double getAvgIncome() {
            return avgIncome;
        }

        public void setAvgIncome(double avgIncome) {
            this.avgIncome = avgIncome;
        }

        public String getUserAvatar() {
            return userAvatar;
        }

        public void setUserAvatar(String userAvatar) {
            this.userAvatar = userAvatar;
        }

        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }

        public int getQbeanNumber() {
            return qbeanNumber;
        }

        public void setQbeanNumber(int qbeanNumber) {
            this.qbeanNumber = qbeanNumber;
        }
    }
}
