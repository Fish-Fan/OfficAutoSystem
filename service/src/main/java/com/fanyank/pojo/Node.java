package com.fanyank.pojo;

import java.io.Serializable;

public class Node implements Serializable {
    private Integer id;
    private String nodeName;

    @Override
    public String toString() {
        return "Node{" +
                "id=" + id +
                ", nodeName='" + nodeName + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNodeName() {
        return nodeName;
    }

    public void setNodeName(String nodeName) {
        this.nodeName = nodeName;
    }
}
