package com.fanyank.pojo;

import java.io.Serializable;

public class Conference implements Serializable {
    private Integer id;
    private Integer userId;
    private Integer respondentId;
    private String startTime;
    private String deadlineTime;
    private String site;
    private String type;
    private String reason;
    private Integer statusId;
    private String content;
    private String persons;
    private String date;
    private String rejectReason;
    private String createTime;
    private String resultTime;

    private User user;
    private User respondUser;

    public Conference() {
    }

    public Conference(Integer id, Integer respondentId, Integer statusId) {
        this.id = id;
        this.respondentId = respondentId;
        this.statusId = statusId;
    }

    public Conference(Integer id, Integer respondentId, Integer statusId, String rejectReason) {
        this.id = id;
        this.respondentId = respondentId;
        this.statusId = statusId;
        this.rejectReason = rejectReason;
    }

    private String createUsername;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getRespondentId() {
        return respondentId;
    }

    public void setRespondentId(Integer respondentId) {
        this.respondentId = respondentId;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getDeadlineTime() {
        return deadlineTime;
    }

    public void setDeadlineTime(String deadlineTime) {
        this.deadlineTime = deadlineTime;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public Integer getStatusId() {
        return statusId;
    }

    public void setStatusId(Integer statusId) {
        this.statusId = statusId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getPersons() {
        return persons;
    }

    public void setPersons(String persons) {
        this.persons = persons;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getCreateUsername() {
        return createUsername;
    }

    public void setCreateUsername(String createUsername) {
        this.createUsername = createUsername;
    }

    public String getRejectReason() {
        return rejectReason;
    }

    public void setRejectReason(String rejectReason) {
        this.rejectReason = rejectReason;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getResultTime() {
        return resultTime;
    }

    public void setResultTime(String resultTime) {
        this.resultTime = resultTime;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public User getRespondUser() {
        return respondUser;
    }

    public void setRespondUser(User respondUser) {
        this.respondUser = respondUser;
    }

    @Override
    public String toString() {
        return "Conference{" +
                "id=" + id +
                ", userId=" + userId +
                ", respondentId=" + respondentId +
                ", startTime='" + startTime + '\'' +
                ", deadlineTime='" + deadlineTime + '\'' +
                ", site='" + site + '\'' +
                ", type='" + type + '\'' +
                ", reason='" + reason + '\'' +
                ", statusId=" + statusId +
                ", content='" + content + '\'' +
                ", persons='" + persons + '\'' +
                ", date='" + date + '\'' +
                ", rejectReason='" + rejectReason + '\'' +
                ", createTime='" + createTime + '\'' +
                ", resultTime='" + resultTime + '\'' +
                ", user=" + user +
                ", respondUser=" + respondUser +
                ", createUsername='" + createUsername + '\'' +
                '}';
    }
}
