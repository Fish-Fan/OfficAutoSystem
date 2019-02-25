package com.fanyank.pojo;

import java.io.Serializable;

public class ConferenceType implements Serializable {
    private Integer id;
    private String conferenceType;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getConferenceType() {
        return conferenceType;
    }

    public void setConferenceType(String conferenceType) {
        this.conferenceType = conferenceType;
    }
}
