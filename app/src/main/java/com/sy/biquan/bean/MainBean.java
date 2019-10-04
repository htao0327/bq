package com.sy.biquan.bean;

import java.util.List;

public class MainBean {

    /**
     * msg : 成功
     * code : 200
     * data : [{"id":"1178562407408820225","userId":"1175675562144837633","title":"测试","startTime":"0天19小时48分钟前","nowRise":0,"expectedRise":10,"bourse":[{"id":"1","bourseName":"抹茶","bourseHref":"http://guanwangdizhi","status":1,"registeredAddress":"http://zhucedizhi","sort":1,"createTime":"2019-09-18T03:39:51.000+0000"},{"id":"2","bourseName":"火币","bourseHref":"http://guanwangdizhi","status":1,"registeredAddress":"http://zhucedizhi","sort":5,"createTime":"2019-09-18T03:39:51.000+0000"},{"id":"3","bourseName":"币安","bourseHref":"http://guanwangdizhi","status":1,"registeredAddress":"http://zhucedizhi","sort":6,"createTime":"2019-09-18T03:39:51.000+0000"},{"id":"4","bourseName":"K网","bourseHref":"http://guanwangdizhi","status":1,"registeredAddress":"http://zhucedizhi","sort":8,"createTime":"2019-09-18T03:39:51.000+0000"}],"isLock":1,"expectedSucRate":8,"avgIncome":8.14,"userAvatar":"http://pic16.nipic.com/20111006/6239936_092702973000_2.jpg","userName":"昵称","qbeanNumber":12},{"id":"1178577099254644737","userId":"1175963275095638017","title":"22222","startTime":"0天18小时49分钟前","nowRise":0,"expectedRise":0,"bourse":[{"id":"1","bourseName":"抹茶","bourseHref":"http://guanwangdizhi","status":1,"registeredAddress":"http://zhucedizhi","sort":1,"createTime":"2019-09-18T03:39:51.000+0000"},{"id":"2","bourseName":"火币","bourseHref":"http://guanwangdizhi","status":1,"registeredAddress":"http://zhucedizhi","sort":5,"createTime":"2019-09-18T03:39:51.000+0000"},{"id":"3","bourseName":"币安","bourseHref":"http://guanwangdizhi","status":1,"registeredAddress":"http://zhucedizhi","sort":6,"createTime":"2019-09-18T03:39:51.000+0000"},{"id":"4","bourseName":"K网","bourseHref":"http://guanwangdizhi","status":1,"registeredAddress":"http://zhucedizhi","sort":8,"createTime":"2019-09-18T03:39:51.000+0000"}],"isLock":1,"expectedSucRate":0,"avgIncome":0,"userAvatar":"https://landscape-test.oss-cn-hangzhou.aliyuncs.com/ios_image/ios_20190923105756_4636018_image.jpg","userName":"周家稳","qbeanNumber":0},{"id":"1178591088994922497","userId":"1174882402065584130","title":"我在这里","startTime":"0天17小时54分钟前","nowRise":0,"expectedRise":0,"bourse":[{"id":"1","bourseName":"抹茶","bourseHref":"http://guanwangdizhi","status":1,"registeredAddress":"http://zhucedizhi","sort":1,"createTime":"2019-09-18T03:39:51.000+0000"},{"id":"2","bourseName":"火币","bourseHref":"http://guanwangdizhi","status":1,"registeredAddress":"http://zhucedizhi","sort":5,"createTime":"2019-09-18T03:39:51.000+0000"},{"id":"3","bourseName":"币安","bourseHref":"http://guanwangdizhi","status":1,"registeredAddress":"http://zhucedizhi","sort":6,"createTime":"2019-09-18T03:39:51.000+0000"},{"id":"4","bourseName":"K网","bourseHref":"http://guanwangdizhi","status":1,"registeredAddress":"http://zhucedizhi","sort":8,"createTime":"2019-09-18T03:39:51.000+0000"}],"isLock":1,"expectedSucRate":2,"avgIncome":9.24,"userAvatar":"https://landscape-test.oss-cn-hangzhou.aliyuncs.com/ios_image/ios_20190929162511_1383397_image.jpg","userName":"国庆节快乐呀","qbeanNumber":0}]
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
         * id : 1178562407408820225
         * userId : 1175675562144837633
         * title : 测试
         * startTime : 0天19小时48分钟前
         * nowRise : 0.0
         * expectedRise : 10.0
         * bourse : [{"id":"1","bourseName":"抹茶","bourseHref":"http://guanwangdizhi","status":1,"registeredAddress":"http://zhucedizhi","sort":1,"createTime":"2019-09-18T03:39:51.000+0000"},{"id":"2","bourseName":"火币","bourseHref":"http://guanwangdizhi","status":1,"registeredAddress":"http://zhucedizhi","sort":5,"createTime":"2019-09-18T03:39:51.000+0000"},{"id":"3","bourseName":"币安","bourseHref":"http://guanwangdizhi","status":1,"registeredAddress":"http://zhucedizhi","sort":6,"createTime":"2019-09-18T03:39:51.000+0000"},{"id":"4","bourseName":"K网","bourseHref":"http://guanwangdizhi","status":1,"registeredAddress":"http://zhucedizhi","sort":8,"createTime":"2019-09-18T03:39:51.000+0000"}]
         * isLock : 1
         * expectedSucRate : 8.0
         * avgIncome : 8.14
         * userAvatar : http://pic16.nipic.com/20111006/6239936_092702973000_2.jpg
         * userName : 昵称
         * qbeanNumber : 12
         */
        private String id;
        private String userId;
        private String title;
        private String startTime;
        private double nowRise;
        private double expectedRise;
        private int isLock;
        private double expectedSucRate;
        private double avgIncome;
        private String userAvatar;
        private String userName;
        private int qbeanNumber;
        private List<BourseBean> bourse;

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

        public List<BourseBean> getBourse() {
            return bourse;
        }

        public void setBourse(List<BourseBean> bourse) {
            this.bourse = bourse;
        }

        public static class BourseBean {
            /**
             * id : 1
             * bourseName : 抹茶
             * bourseHref : http://guanwangdizhi
             * status : 1
             * registeredAddress : http://zhucedizhi
             * sort : 1
             * createTime : 2019-09-18T03:39:51.000+0000
             */

            private String id;
            private String bourseName;
            private String bourseHref;
            private int status;
            private String registeredAddress;
            private int sort;
            private String createTime;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getBourseName() {
                return bourseName;
            }

            public void setBourseName(String bourseName) {
                this.bourseName = bourseName;
            }

            public String getBourseHref() {
                return bourseHref;
            }

            public void setBourseHref(String bourseHref) {
                this.bourseHref = bourseHref;
            }

            public int getStatus() {
                return status;
            }

            public void setStatus(int status) {
                this.status = status;
            }

            public String getRegisteredAddress() {
                return registeredAddress;
            }

            public void setRegisteredAddress(String registeredAddress) {
                this.registeredAddress = registeredAddress;
            }

            public int getSort() {
                return sort;
            }

            public void setSort(int sort) {
                this.sort = sort;
            }

            public String getCreateTime() {
                return createTime;
            }

            public void setCreateTime(String createTime) {
                this.createTime = createTime;
            }
        }
    }
}
