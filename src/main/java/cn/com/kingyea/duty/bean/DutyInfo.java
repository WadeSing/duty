package cn.com.kingyea.duty.bean;

import java.util.List;

public class DutyInfo {

    private String director;//姓名(值班主任)
    private String directorPoliceAffair;//电话(值班主任)
    private String directorRegistNum;//警号(值班主任)
    private String masterName;//姓名(值班领导)
    private String masterPoliceAffair;//电话(值班领导)
    private String masterRegistNum;//警号(值班领导)
    private List<DutyPerson> leaderMen;//值班警员集合
    private String watchDate;//当前时间


    public String getDirector() {
        return director;
    }

    public String getDirectorPoliceAffair() {
        return directorPoliceAffair;
    }

    public String getDirectorRegistNum() {
        return directorRegistNum;
    }

    public String getMasterName() {
        return masterName;
    }

    public String getMasterPoliceAffair() {
        return masterPoliceAffair;
    }

    public String getMasterRegistNum() {
        return masterRegistNum;
    }

    public List<DutyPerson> getLeaderMen() {
        return leaderMen;
    }

    public String getWatchDate() {
        return watchDate;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public void setDirectorPoliceAffair(String directorPoliceAffair) {
        this.directorPoliceAffair = directorPoliceAffair;
    }

    public void setDirectorRegistNum(String directorRegistNum) {
        this.directorRegistNum = directorRegistNum;
    }

    public void setMasterName(String masterName) {
        this.masterName = masterName;
    }

    public void setMasterPoliceAffair(String masterPoliceAffair) {
        this.masterPoliceAffair = masterPoliceAffair;
    }

    public void setMasterRegistNum(String masterRegistNum) {
        this.masterRegistNum = masterRegistNum;
    }

    public void setLeaderMen(List<DutyPerson> leaderMen) {
        this.leaderMen = leaderMen;
    }

    public void setWatchDate(String watchDate) {
        this.watchDate = watchDate;
    }

    public DutyInfo() {
    }

}

