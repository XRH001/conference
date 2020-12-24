package com.example.demo.entity.VO;

import com.example.demo.entity.Hotel;

public class HotelDetails {
    private int id;
    private String name;
    private String phone;
    private String address;
    private String username;
    private String email;
    private String imgPath;

    public HotelDetails(Hotel hotel){
        this.id=hotel.getID();
        this.name=hotel.getName();
        this.phone=hotel.getPhone();
        this.address=hotel.getAddress();
        this.username=hotel.getUsername();
        this.email=hotel.getEmail();
        this.imgPath=hotel.getImgPath();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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

    public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }
}
