package com.fanyank.pojo;

import java.io.Serializable;
import java.util.Arrays;

public class ScanResult implements Serializable {
    private String error_code;
    private Integer result_num;
    private GroupUser[] result;
    private Long log_id;
    private String error_msg;

    public Integer getResult_num() {
        return result_num;
    }

    public void setResult_num(Integer result_num) {
        this.result_num = result_num;
    }

    public GroupUser[] getResult() {
        return result;
    }

    public void setResult(GroupUser[] result) {
        this.result = result;
    }

    public Long getLog_id() {
        return log_id;
    }

    public void setLog_id(Long log_id) {
        this.log_id = log_id;
    }

    public String getError_code() {
        return error_code;
    }

    public void setError_code(String error_code) {
        this.error_code = error_code;
    }

    public String getError_msg() {
        return error_msg;
    }

    public void setError_msg(String error_msg) {
        this.error_msg = error_msg;
    }

    @Override
    public String toString() {
        return "ScanResult{" +
                "error_code='" + error_code + '\'' +
                ", result_num=" + result_num +
                ", result=" + Arrays.toString(result) +
                ", log_id=" + log_id +
                ", error_msg='" + error_msg + '\'' +
                '}';
    }
}
