package com.fanyank.pojo;

public class AttendanceStandard {
    int id;
    String workTime;
    String closingTime;
    String season;
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getWorkTime() {
        return workTime;
    }
    public void setWorkTime(String workTime) {
        this.workTime = workTime;
    }
    public String getClosingTime() {
        return closingTime;
    }
    public void setClosingTime(String closingTime) {
        this.closingTime = closingTime;
    }
    public String getSeason() {
        return season;
    }
    public void setSeason(String season) {
        this.season = season;
    }

    @Override
    public String toString() {
        return "AttendanceStandard{" +
                "id=" + id +
                ", workTime='" + workTime + '\'' +
                ", closingTime='" + closingTime + '\'' +
                ", season='" + season + '\'' +
                '}';
    }
}
