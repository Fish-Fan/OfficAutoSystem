package com.fanyank.pojo;

import java.io.Serializable;

/**
 * Created by lenovo on 2018/3/12.
 */
public class Department implements Serializable {
    private int id;
    private String department;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", department='" + department + '\'' +
                '}';
    }
}
