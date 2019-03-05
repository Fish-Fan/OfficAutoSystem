package com.fanyank.pojo;

public class ChatMessage {
    //消息来源用户名
    private String username;
    //消息来源用户头像
    private String avatar;
    //消息来源的ID
    private Integer id;
    //消息类型
    private String type;
    //消息内容
    private String content;
    //消息ID
    private Integer cid;
    //是否是我发送的消息
    private Boolean mine;
    //消息发送者的ID
    private Integer fromid;
    //timestamp
    private long timestamp;
    //消息目标ID
    private Integer toid;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public Boolean getMine() {
        return mine;
    }

    public void setMine(Boolean mine) {
        this.mine = mine;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public Integer getFromid() {
        return fromid;
    }

    public void setFromid(Integer fromid) {
        this.fromid = fromid;
    }

    public Integer getToid() {
        return toid;
    }

    public void setToid(Integer toid) {
        this.toid = toid;
    }

    @Override
    public String toString() {
        return "ChatMessage{" +
                "username='" + username + '\'' +
                ", avatar='" + avatar + '\'' +
                ", id=" + id +
                ", type='" + type + '\'' +
                ", content='" + content + '\'' +
                ", cid=" + cid +
                ", mine=" + mine +
                ", fromid=" + fromid +
                ", timestamp=" + timestamp +
                ", toid=" + toid +
                '}';
    }
}
