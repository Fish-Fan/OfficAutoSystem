package com.fanyank.pojo;

import java.io.Serializable;

public class AttendanceResult implements Serializable {
    private String result;
    private String voice;
    private String scores;

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getVoice() {
        return voice;
    }

    public void setVoice(String voice) {
        this.voice = voice;
    }

    public String getScores() {
        return scores;
    }

    public void setScores(String scores) {
        this.scores = scores;
    }

    @Override
    public String toString() {
        return "AttendanceResult{" +
                "result='" + result + '\'' +
                ", voice='" + voice + '\'' +
                ", scores='" + scores + '\'' +
                '}';
    }
}
