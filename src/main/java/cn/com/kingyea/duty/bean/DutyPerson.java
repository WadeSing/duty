package cn.com.kingyea.duty.bean;

public class DutyPerson {

    private String watchMen;//名称
    private String watchMenMobilePhone;//电话
    private String watchMenRegistNum;//警号

    public String getWatchMenMobilePhone() {
        return watchMenMobilePhone;
    }

    public String getWatchMen() {
        return watchMen;
    }

    public String getWatchMenRegistNum() {
        return watchMenRegistNum;
    }

    public void setWatchMen(String watchMen) {
        this.watchMen = watchMen;
    }

    public void setWatchMenMobilePhone(String watchMenMobilePhone) {
        this.watchMenMobilePhone = watchMenMobilePhone;
    }

    public void setWatchMenRegistNum(String watchMenRegistNum) {
        this.watchMenRegistNum = watchMenRegistNum;
    }

    public DutyPerson() {
    }


}

