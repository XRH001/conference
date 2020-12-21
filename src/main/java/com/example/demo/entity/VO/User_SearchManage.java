package com.example.demo.entity.VO;

import com.example.demo.entity.DTO.User;

public class User_SearchManage {
    private int id;
    private String email;
    private String name;
    private boolean ifManager;

    public User_SearchManage(User user){
        this.id= user.getID();
        this.email= user.getEmail();
        this.name= user.getName();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

    public boolean isIfManager() {
        return ifManager;
    }

    public void setIfManager(boolean ifManager) {
        this.ifManager = ifManager;
    }
}
