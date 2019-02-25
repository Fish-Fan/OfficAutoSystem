package com.fanyank.pojo;

import java.io.Serializable;

public class DepartmentInfo implements Serializable {
    private Integer id;
    private Integer departmentId;
    private Integer departmentManagerId;
    private Integer departmentBossId;

    private User manager;
    private User boss;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
    }

    public Integer getDepartmentManagerId() {
        return departmentManagerId;
    }

    public void setDepartmentManagerId(Integer departmentManagerId) {
        this.departmentManagerId = departmentManagerId;
    }

    public Integer getDepartmentBossId() {
        return departmentBossId;
    }

    public void setDepartmentBossId(Integer departmentBossId) {
        this.departmentBossId = departmentBossId;
    }

    public User getManager() {
        return manager;
    }

    public void setManager(User manager) {
        this.manager = manager;
    }

    public User getBoss() {
        return boss;
    }

    public void setBoss(User boss) {
        this.boss = boss;
    }

    @Override
    public String toString() {
        return "DepartmentInfo{" +
                "id=" + id +
                ", departmentManagerId='" + departmentManagerId + '\'' +
                ", departmentBossId='" + departmentBossId + '\'' +
                '}';
    }
}
