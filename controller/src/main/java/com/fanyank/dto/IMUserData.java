package com.fanyank.dto;

import com.fanyank.pojo.Department;
import com.fanyank.pojo.User;

import java.io.Serializable;
import java.util.List;

public class IMUserData implements Serializable {
    public IMUserData () {
        this.data = new Data();
    }

    private Integer code;
    private String message;
    private Data data;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "IMUserData{" +
                "code=" + code +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }

    public class Data {
        private User mine;
        private List<Department> friend;

        public User getMine() {
            return mine;
        }

        public void setMine(User mine) {
            this.mine = mine;
        }

        public List<Department> getFriend() {
            return friend;
        }

        public void setFriend(List<Department> friend) {
            this.friend = friend;
        }

        @Override
        public String toString() {
            return "Data{" +
                    "mine=" + mine +
                    ", friend=" + friend +
                    '}';
        }
    }
}
