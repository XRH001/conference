package com.example.demo.controller;


import java.time.LocalDate;

public class CenterMeeting {
    /**
     * @author 刘凯
     * 中间类:会议信息
     * 这个类用来接受创建会议前端传来的数据
     * @param email 创建者邮箱
     * @param name 会议名称
     * @param address 会议地点
     * @param beginTime 会议开始时间
     * @param userID 创建者的ID
     */

    private String email;
    private String name;
    private String address;
    private String beginTime;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(String beginTime) {
        this.beginTime = beginTime;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    private int userID;
}
