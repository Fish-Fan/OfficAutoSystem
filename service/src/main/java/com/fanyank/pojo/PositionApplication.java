package com.littlepig.pojo;

public class PositionApplication {
    private Integer id;
    private Integer userId;
    private Integer positionId;
    private Integer respondentId;
    private String applicationTime;
    private String reason;
    private Integer departmentManagerAdvice;
    private Integer departmentBossAdvice;
    private String conclusion;
    private String applicationReason;
    private Integer departmentId;
    private String managerResultTime;
    private String bossResultTime;

    private User user;
    private User respond;

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

    public Integer getPositionId() {
        return positionId;
    }

    public void setPositionId(Integer positionId) {
        this.positionId = positionId;
    }

    public String getApplicationTime() {
        return applicationTime;
    }

    public void setApplicationTime(String applicationTime) {
        this.applicationTime = applicationTime;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public Integer getDepartmentManagerAdvice() {
        return departmentManagerAdvice;
    }

    public void setDepartmentManagerAdvice(Integer departmentManagerAdvice) {
        this.departmentManagerAdvice = departmentManagerAdvice;
    }

    public Integer getDepartmentBossAdvice() {
        return departmentBossAdvice;
    }

    public void setDepartmentBossAdvice(Integer departmentBossAdvice) {
        this.departmentBossAdvice = departmentBossAdvice;
    }

    public String getConclusion() {
        return conclusion;
    }

    public void setConclusion(String conclusion) {
        this.conclusion = conclusion;
    }

    public String getApplicationReason() {
        return applicationReason;
    }

    public void setApplicationReason(String applicationReason) {
        this.applicationReason = applicationReason;
    }

    public Integer getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Integer getRespondentId() {
        return respondentId;
    }

    public void setRespondentId(Integer respondentId) {
        this.respondentId = respondentId;
    }

    public User getRespond() {
        return respond;
    }

    public void setRespond(User respond) {
        this.respond = respond;
    }

    public String getManagerResultTime() {
        return managerResultTime;
    }

    public void setManagerResultTime(String managerResultTime) {
        this.managerResultTime = managerResultTime;
    }

    public String getBossResultTime() {
        return bossResultTime;
    }

    public void setBossResultTime(String bossResultTime) {
        this.bossResultTime = bossResultTime;
    }

    @Override
    public String toString() {
        return "PositionApplication{" +
                "id=" + id +
                ", userId=" + userId +
                ", positionId=" + positionId +
                ", respondentId=" + respondentId +
                ", applicationTime='" + applicationTime + '\'' +
                ", reason='" + reason + '\'' +
                ", departmentManagerAdvice=" + departmentManagerAdvice +
                ", departmentBossAdvice=" + departmentBossAdvice +
                ", conclusion='" + conclusion + '\'' +
                ", applicationReason='" + applicationReason + '\'' +
                ", departmentId=" + departmentId +
                ", managerResultTime='" + managerResultTime + '\'' +
                ", bossResultTime='" + bossResultTime + '\'' +
                ", user=" + user +
                ", respond=" + respond +
                '}';
    }
}
