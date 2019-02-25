package com.fanyank.pojo;

import java.io.Serializable;

public class ConferenceRoom implements Serializable {
    private Integer id;
    private String room;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }
}
