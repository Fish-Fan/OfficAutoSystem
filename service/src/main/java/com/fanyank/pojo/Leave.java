package com.littlepig.pojo;

import org.apache.ibatis.type.Alias;

public class Leave {
	private int id;
	private int userId;
	private String startTime;
	private String deadlineTime;
	private String type;
	private String reason;
	private String respondentTime;
	private int respondentId;
    private int departmentId;
    private int statesId;
    private States states;
    private User user;
    @Override
    public String toString() {
        return "Leave{" +
                "id=" + id +
                ", userId=" + userId +
                ", startTime='" + startTime + '\'' +
                ", deadlineTime='" + deadlineTime + '\'' +
                ", type='" + type + '\'' +
                ", reason='" + reason + '\'' +
                ", respondentTime='" + respondentTime + '\'' +
                ", respondentId='" + respondentId + '\'' +
                ", statesId=" + statesId +
                ", states=" + states +
                ", user=" + user +
                '}';
    }
    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }
    public int getStatesId() {
        return statesId;
    }

    public void setStatesId(int statesId) {
        this.statesId = statesId;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
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

    public String getRespondentTime() {
        return respondentTime;
    }

    public void setRespondentTime(String respondentTime) {
        this.respondentTime = respondentTime;
    }

    public int getRespondentId() {
        return respondentId;
    }

    public void setRespondentId(int respondentId) {
        this.respondentId = respondentId;
    }

    public States getStates() {
        return states;
    }

    public void setStates(States states) {
        this.states = states;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
