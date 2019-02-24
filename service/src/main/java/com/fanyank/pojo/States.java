package com.littlepig.pojo;

public class States
{
    int id;
    String states;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStates() {
        return states;
    }

    public void setStates(String states) {
        this.states = states;
    }

    @Override
    public String toString() {
        return "States{" +
                "id=" + id +
                ", states='" + states + '\'' +
                '}';
    }
}
