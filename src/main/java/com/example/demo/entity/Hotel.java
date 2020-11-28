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
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO,generator = "generator")
    @GenericGenerator(name = "generator",strategy = "com.example.demo.utils.GeneratedInsertGenerator")
    private int ID;
    private String name;
    private String phone;
    private String address;

    public Hotel() {
    }

    public Hotel(int ID, String name, String phone, String address) {
        this.ID = ID;
        this.name = name;
        this.phone = phone;
        this.address = address;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Hotel hotel = (Hotel) o;
        return ID == hotel.ID &&
                Objects.equals(name, hotel.name) &&
                Objects.equals(phone, hotel.phone) &&
                Objects.equals(address, hotel.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ID, name, phone, address);
    }

    @Override
    public String toString() {
        return "Hotel{" +
                "ID=" + ID +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
