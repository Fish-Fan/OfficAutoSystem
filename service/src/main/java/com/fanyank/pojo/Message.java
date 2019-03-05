package com.fanyank.pojo;

import java.util.List;

public class Message {
    private String type;
    private Data data;


    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Message{" +
                "type='" + type + '\'' +
                ", data=" + data +
                '}';
    }

    public class Data {
        private User mine;
        private User to;

        public User getMine() {
            return mine;
        }

        public void setMine(User mine) {
            this.mine = mine;
        }

        public User getTo() {
            return to;
        }

        public void setTo(User to) {
            this.to = to;
        }

        @Override
        public String toString() {
            return "Data{" +
                    "mine=" + mine +
                    ", to=" + to +
                    '}';
        }
    }
}
