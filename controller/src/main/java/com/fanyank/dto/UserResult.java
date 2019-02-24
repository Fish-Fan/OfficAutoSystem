package com.littlepig.dto;

import com.littlepig.pojo.User;

import java.util.List;

public class UserResult {
    private int totalCount;
    private List<User> items;

    public UserResult() {
    }

    public UserResult(int totalCount, List<User> items) {
        this.totalCount = totalCount;
        this.items = items;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public List<User> getItems() {
        return items;
    }

    public void setItems(List<User> items) {
        this.items = items;
    }
}
