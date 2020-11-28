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
     * @param ID 司机编号
     * @param name 司机姓名
     * @param type 车的类型,例如中巴和小车
     * @param maxNum 车的最大承载人数
     * @param carNum 车牌号
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

    public Driver() {
    }

    public Driver(int ID, String name, String phone, String type, int maxNum, String carNum) {
        this.ID = ID;
        this.name = name;
        this.phone = phone;
        this.type = type;
        this.maxNum = maxNum;
        this.carNum = carNum;
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
                Objects.equals(carNum, driver.carNum);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ID, name, phone, type, maxNum, carNum);
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
                '}';
    }
}
