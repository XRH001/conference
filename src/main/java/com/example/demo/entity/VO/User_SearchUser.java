package com.example.demo.entity.VO;

import com.example.demo.entity.DTO.User;

public class User_SearchUser {
    private int id;
    private String email;
    private String name;
    private boolean haveJoin;

    public User_SearchUser(User user){
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

    public boolean isHaveJoin() {
        return haveJoin;
    }

    public void setHaveJoin(boolean haveJoin) {
        this.haveJoin = haveJoin;
    }
}
