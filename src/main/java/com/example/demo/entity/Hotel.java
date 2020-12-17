package com.example.demo.entity;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Objects;

@DynamicInsert
@Entity(name = "hotel")
public class Hotel {
    /**
     * @author 李嘉旭
     * 基本类:酒店,对应数据库的酒店表
     * 这个类用来说明酒店信息
     * @param ID 酒店编号
     * @param name 酒店名字
     * @param phone 练习电话
     * @param address 详细地址
     * @param username
     * @param password
     * @param email
     * @param imgPath
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO,generator = "generator")
    @GenericGenerator(name = "generator",strategy = "com.example.demo.utils.GeneratedInsertGenerator")
    private int ID;
    private String name;
    private String phone;
    private String address;
    private String username;
    private String password;
    private String email;
    private String imgPath;

    public Hotel() {
    }

    public Hotel(int ID, String name, String phone, String address, String username, String password, String email, String imgPath) {
        this.ID = ID;
        this.name = name;
        this.phone = phone;
        this.address = address;
        this.username = username;
        this.password = password;
        this.email = email;
        this.imgPath = imgPath;
    }

    public Hotel(String name, String phone, String address, String username, String password, String email, String imgPath) {
        this.name = name;
        this.phone = phone;
        this.address = address;
        this.username = username;
        this.password = password;
        this.email = email;
        this.imgPath = imgPath;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
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

    public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Hotel hotel = (Hotel) o;
        return ID == hotel.ID &&
                Objects.equals(name, hotel.name) &&
                Objects.equals(phone, hotel.phone) &&
                Objects.equals(address, hotel.address) &&
                Objects.equals(username, hotel.username) &&
                Objects.equals(password, hotel.password) &&
                Objects.equals(email, hotel.email) &&
                Objects.equals(imgPath, hotel.imgPath);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ID, name, phone, address, username, password, email, imgPath);
    }

    @Override
    public String toString() {
        return "Hotel{" +
                "ID=" + ID +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", imgPath='" + imgPath + '\'' +
                '}';
    }
}
