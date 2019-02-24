package com.littlepig.pojo;

import org.joda.time.DateTime;

public class Notify {
    enum Type {
        success,info,warning,error
    }

    private Integer id;
    private Integer userId;
    private String title;
    private String content;
    private String jumpToUrl;
    private String notifyTime;
    private Type type;
    private Integer isRead;

    private Object object;

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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getNotifyTime() {
        return notifyTime;
    }

    public void setNotifyTime(String notifyTime) {
        this.notifyTime = notifyTime;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Integer getIsRead() {
        return isRead;
    }

    public void setIsRead(Integer isRead) {
        this.isRead = isRead;
    }

    public String getJumpToUrl() {
        return jumpToUrl;
    }

    public void setJumpToUrl(String jumpToUrl) {
        this.jumpToUrl = jumpToUrl;
    }

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }

    public static Notify conferenceApplyRequest(Integer targetId) {
        Notify notify = new Notify();
        notify.setUserId(targetId);
        notify.setType(Type.warning);
        notify.setTitle("会议申请");
        notify.setContent("您有新的会议申请通知，请点击查看");
        notify.setJumpToUrl("/conference/manager");
        notify.setNotifyTime(DateTime.now().toString("yyyy-MM-dd HH:mm:ss"));
        return notify;
    }

    public static Notify notifyMemberAttendConference(Integer targetId,Conference conference) {
        Notify notify = new Notify();
        notify.setUserId(targetId);
        notify.setType(Type.warning);
        notify.setTitle("开会通知");
        notify.setContent(conference.getType() + ": 请于" + conference.getStartTime() + "到" + conference.getSite() + "开会,点击查看会议详情");
        notify.setNotifyTime(DateTime.now().toString("yyyy-MM-dd HH:mm:ss"));
        return notify;
    }

    public static Notify positionApplyRequest(Integer targetId,String jumpToUrl) {
        Notify notify = new Notify();
        notify.setUserId(targetId);
        notify.setType(Type.success);
        notify.setTitle("职位申请");
        notify.setContent("又有人申请职位了，点击查看吧^_^");
        notify.setJumpToUrl(jumpToUrl);
        notify.setNotifyTime(DateTime.now().toString("yyyy-MM-dd HH:mm:ss"));
        return notify;
    }

    public static Notify positionApplyResponse(Integer targetId,String url) {
        Notify notify = new Notify();
        notify.setUserId(targetId);
        notify.setType(Type.success);
        notify.setTitle("职位申请");
        notify.setContent("您的职位申请状态已变更，请及时查看");
        notify.setJumpToUrl(url);
        notify.setNotifyTime(DateTime.now().toString("yyyy-MM-dd HH:mm:ss"));
        return notify;
    }

    public static Notify conferenceApplyResponse(Integer targetId,String url) {
        Notify notify = new Notify();
        notify.setUserId(targetId);
        notify.setType(Type.success);
        notify.setTitle("会议申请");
        notify.setContent("您的会议申请状态已变更，请及时变更");
        notify.setJumpToUrl(url);
        notify.setNotifyTime(DateTime.now().toString("yyyy-MM-dd HH:mm:ss"));
        return notify;
    }

    public static Notify positionAdjustByManagerResponse(Integer targetId,String url) {
        Notify notify = new Notify();
        notify.setUserId(targetId);
        notify.setType(Type.success);
        notify.setTitle("职位变动");
        notify.setContent("经理和主管对您的职位做出了调整，点击前往个人信息页面进行查看");
        notify.setJumpToUrl(url);
        notify.setNotifyTime(DateTime.now().toString("yyyy-MM-dd HH:mm:ss"));
        return notify;
    }

    //请假通知
    public static Notify leaveApplyRequest(Integer targetId) {
        Notify notify = new Notify();
        notify.setUserId(targetId);
        notify.setType(Type.warning);
        notify.setTitle("请假申请");
        notify.setContent("您有新的请假申请通知，请点击查看");
        notify.setJumpToUrl("/leaveapproval");
        notify.setNotifyTime(DateTime.now().toString("yyyy-MM-dd HH:mm:ss"));
        return notify;
    }
    //请假审核通知
    public static Notify leaveApplyResponse(Integer targetId) {
        Notify notify = new Notify();
        notify.setUserId(targetId);
        notify.setType(Type.warning);
        notify.setTitle("请假状态更新");
        notify.setContent("您有新的请假申请有新状态了，请点击查看");
        notify.setJumpToUrl("/selectLeave");
        notify.setNotifyTime(DateTime.now().toString("yyyy-MM-dd HH:mm:ss"));
        return notify;
    }

    @Override
    public String toString() {
        return "Notify{" +
                "id=" + id +
                ", userId=" + userId +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", jumpToUrl='" + jumpToUrl + '\'' +
                ", notifyTime='" + notifyTime + '\'' +
                ", type='" + type + '\'' +
                ", isRead=" + isRead +
                '}';
    }
}
