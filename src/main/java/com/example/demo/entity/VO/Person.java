package com.example.demo.entity.VO;

import com.example.demo.entity.DTO.User;
import com.example.demo.enumValue.Sex;

import java.time.format.DateTimeFormatter;

public class Person {
    private String headpath;
    private String username;
    private String email;
    private Sex sex;
    private int id;
    private String phone;
    private String name;
    private String birth;

    public Person(User user){
        this.headpath=user.getImgPath();
        this.username=user.getUsername();
        this.email=user.getEmail();
        this.sex=user.getSex();
        this.id=user.getID();
        this.phone=user.getPhone();
        this.name=user.getName();
        DateTimeFormatter formatters = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        this.birth=user.getBirth().format(formatters);
    }

    public String getHeadpath() {
        return headpath;
    }

    public void setHeadpath(String headpath) {
        this.headpath = headpath;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }
}
