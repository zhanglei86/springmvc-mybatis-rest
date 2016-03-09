package com.zl.model;

import java.util.Date;

public class TUsermx {
    private Integer userId;

    private String userName;

    private Integer userSex;

    private Date userBirthday;

    private Double userSalary;

    private byte[] userOther;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public Integer getUserSex() {
        return userSex;
    }

    public void setUserSex(Integer userSex) {
        this.userSex = userSex;
    }

    public Date getUserBirthday() {
        return userBirthday;
    }

    public void setUserBirthday(Date userBirthday) {
        this.userBirthday = userBirthday;
    }

    public Double getUserSalary() {
        return userSalary;
    }

    public void setUserSalary(Double userSalary) {
        this.userSalary = userSalary;
    }

    public byte[] getUserOther() {
        return userOther;
    }

    public void setUserOther(byte[] userOther) {
        this.userOther = userOther;
    }
}