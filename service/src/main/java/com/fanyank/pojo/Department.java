package com.fanyank.pojo;

import java.io.Serializable;
import java.util.List;

/**
 * Created by lenovo on 2018/3/12.
 */
public class Department implements Serializable {
    private int id;
    private String department;
    private String groupname;
    private List<User> list;

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

    public List<User> getList() {
        return list;
    }

    public void setList(List<User> list) {
        this.list = list;
    }

    public String getGroupname() {
        return groupname;
    }

    public void setGroupname(String groupname) {
        this.groupname = groupname;
    }

    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", department='" + department + '\'' +
                ", groupname='" + groupname + '\'' +
                ", list=" + list +
                '}';
    }
}
