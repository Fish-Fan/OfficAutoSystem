package com.fanyank.pojo;

import java.io.Serializable;

/**
 * Created by lenovo on 2018/3/7.
 */
public class User implements Serializable {
    private Integer id;
    private String username;
    private String password;
    private String phoneNumber;
    private String email;
    private String officalNumber;
    private String postcode;
    private String officalAddress;
    private String remark;
    private Integer positionId;
    private Integer departmentId;
    private Position position;
    private Department department;
    private String sign;
    private String avatar;
    private String   desc;
    private Integer currentConferenceApplyId;
    private Integer currentPositionApplyId;
    private String status;
    /**
     * chatMessage使用
     */
    private String type;
    private String content;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getPositionId() {
        return positionId;
    }

    public void setPositionId(Integer positionId) {
        this.positionId = positionId;
    }

    public Integer getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getOfficalNumber() {
        return officalNumber;
    }

    public void setOfficalNumber(String officalNumber) {
        this.officalNumber = officalNumber;
    }

    public String getOfficalAddress() {
        return officalAddress;
    }

    public void setOfficalAddress(String officalAddress) {
        this.officalAddress = officalAddress;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }


    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }


    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Integer getCurrentConferenceApplyId() {
        return currentConferenceApplyId;
    }

    public void setCurrentConferenceApplyId(Integer currentConferenceApplyId) {
        this.currentConferenceApplyId = currentConferenceApplyId;
    }

    public Integer getCurrentPositionApplyId() {
        return currentPositionApplyId;
    }

    public void setCurrentPositionApplyId(Integer currentPositionApplyId) {
        this.currentPositionApplyId = currentPositionApplyId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                ", officalNumber='" + officalNumber + '\'' +
                ", postcode='" + postcode + '\'' +
                ", officalAddress='" + officalAddress + '\'' +
                ", remark='" + remark + '\'' +
                ", positionId=" + positionId +
                ", departmentId=" + departmentId +
                ", position=" + position +
                ", department=" + department +
                ", sign='" + sign + '\'' +
                ", avatar='" + avatar + '\'' +
                ", desc='" + desc + '\'' +
                ", currentConferenceApplyId=" + currentConferenceApplyId +
                ", currentPositionApplyId=" + currentPositionApplyId +
                ", status='" + status + '\'' +
                ", type='" + type + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
