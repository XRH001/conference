package com.example.demo.entity;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Objects;

@DynamicInsert
@Entity(name = "driver")
public class Driver {
    /**
     * @author 李嘉旭
     * 基本类:司机和车辆
     * 在本工程中,每个司机对应唯一一个汽车
     * @param ID 编号
     * @param name 姓名
     * @param phone 电话
     * @param type 车的类型
     * @param maxNum 车承载的最大人数
     * @param carNum 车牌号
     * @param username 用户名
     * @param password 密码
     * @param email 电子邮箱
     * @param imgPath 头像图片存放路径
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO,generator = "generator")
    @GenericGenerator(name = "generator",strategy = "com.example.demo.utils.GeneratedInsertGenerator")
    private int ID;
    private String name;
    private String phone;
    private String type;
    private int maxNum;
    private String carNum;
    private String username;
    private String password;
    private String email;
    private String imgPath;

    public Driver() {
    }

    public Driver(int ID, String name, String phone, String type, int maxNum, String carNum, String username, String password, String email, String imgPath) {
        this.ID = ID;
        this.name = name;
        this.phone = phone;
        this.type = type;
        this.maxNum = maxNum;
        this.carNum = carNum;
        this.username = username;
        this.password = password;
        this.email = email;
        this.imgPath = imgPath;
    }

    public Driver(String name, String phone, String type, int maxNum, String carNum, String username, String password, String email, String imgPath) {
        this.name = name;
        this.phone = phone;
        this.type = type;
        this.maxNum = maxNum;
        this.carNum = carNum;
        this.username = username;
        this.password = password;
        this.email = email;
        this.imgPath = imgPath;
    }

    public Driver(Driver driver){
        this.name = driver.getName();
        this.phone = driver.getPhone();
        this.type = driver.getType();
        this.maxNum = driver.getMaxNum();
        this.carNum = driver.getCarNum();
        this.username = driver.getUsername();
        this.password = driver.getPassword();
        this.email = driver.getEmail();
        this.imgPath = driver.getImgPath();
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getMaxNum() {
        return maxNum;
    }

    public void setMaxNum(int maxNum) {
        this.maxNum = maxNum;
    }

    public String getCarNum() {
        return carNum;
    }

    public void setCarNum(String carNum) {
        this.carNum = carNum;
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
        Driver driver = (Driver) o;
        return ID == driver.ID &&
                maxNum == driver.maxNum &&
                Objects.equals(name, driver.name) &&
                Objects.equals(phone, driver.phone) &&
                Objects.equals(type, driver.type) &&
                Objects.equals(carNum, driver.carNum) &&
                Objects.equals(username, driver.username) &&
                Objects.equals(password, driver.password) &&
                Objects.equals(email, driver.email) &&
                Objects.equals(imgPath, driver.imgPath);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ID, name, phone, type, maxNum, carNum, username, password, email, imgPath);
    }

    @Override
    public String toString() {
        return "Driver{" +
                "ID=" + ID +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", type='" + type + '\'' +
                ", maxNum=" + maxNum +
                ", carNum='" + carNum + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", imgPath='" + imgPath + '\'' +
                '}';
    }
}
