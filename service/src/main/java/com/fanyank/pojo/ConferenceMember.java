package com.fanyank.pojo;

public class ConferenceMember {
    private Integer id;
    private Integer conferenceId;
    private Integer memberId;

    public ConferenceMember() {
    }

    public ConferenceMember(Integer conferenceId, Integer memberId) {
        this.conferenceId = conferenceId;
        this.memberId = memberId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getConferenceId() {
        return conferenceId;
    }

    public void setConferenceId(Integer conferenceId) {
        this.conferenceId = conferenceId;
    }

    public Integer getMemberId() {
        return memberId;
    }

    public void setMemberId(Integer memberId) {
        this.memberId = memberId;
    }

    @Override
    public String toString() {
        return "ConferenceMember{" +
                "id=" + id +
                ", conferenceId=" + conferenceId +
                ", memberId=" + memberId +
                '}';
    }
}
