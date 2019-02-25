package com.fanyank.pojo;

import java.io.Serializable;
import java.util.Arrays;

public class GroupUser implements Serializable {
    private String uid;
    private Double[] scores;
    private String group_id;
    private String user_info;

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public Double[] getScores() {
        return scores;
    }

    public void setScores(Double[] scores) {
        this.scores = scores;
    }

    public String getGroup_id() {
        return group_id;
    }

    public void setGroup_id(String group_id) {
        this.group_id = group_id;
    }

    public String getUser_info() {
        return user_info;
    }

    public void setUser_info(String user_info) {
        this.user_info = user_info;
    }

    @Override
    public String toString() {
        return "GroupUser{" +
                "uid='" + uid + '\'' +
                ", scores=" + Arrays.toString(scores) +
                ", group_id='" + group_id + '\'' +
                ", user_info='" + user_info + '\'' +
                '}';
    }
}
