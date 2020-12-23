package com.example.demo.entity.DO;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Objects;

@DynamicInsert
@Entity(name = "hotelroom")
public class HotelRoomDO {
    /**
     * @author 李嘉旭
     * 基本DO类:酒店房间,用来对应数据库中的酒店房间表
     * 这个类用来说明酒店有哪些房间
     * @param ID 房间编号
     * @param type 用来说明房间类型,例如单人间和双人间
     * @param roomID 房间号
     * @param price 价格
     * @param hotelID 房间所属的酒店编号
     * @param status 房间是否已经被使用
     * @param maxNum 房间最大人数限制
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO,generator = "generator")
    @GenericGenerator(name = "generator",strategy = "com.example.demo.utils.GeneratedInsertGenerator")
    private int ID;
    private int type;
    private String roomID;
    private int hotelID;
    private double price;
    private int status;
    private int maxNum;

    public HotelRoomDO() {
    }

    public HotelRoomDO(int ID, int type, String roomID, int hotelID, double price, int status, int maxNum) {
        this.ID = ID;
        this.type = type;
        this.roomID = roomID;
        this.hotelID = hotelID;
        this.price = price;
        this.status = status;
        this.maxNum = maxNum;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getRoomID() {
        return roomID;
    }

    public void setRoomID(String roomID) {
        this.roomID = roomID;
    }

    public int getHotelID() {
        return hotelID;
    }

    public void setHotelID(int hotelID) {
        this.hotelID = hotelID;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getMaxNum() {
        return maxNum;
    }

    public void setMaxNum(int maxNum) {
        this.maxNum = maxNum;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HotelRoomDO that = (HotelRoomDO) o;
        return ID == that.ID &&
                roomID == that.roomID &&
                hotelID == that.hotelID &&
                Double.compare(that.price, price) == 0 &&
                status == that.status &&
                maxNum == that.maxNum &&
                Objects.equals(type, that.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ID, type, roomID, hotelID, price, status, maxNum);
    }

    @Override
    public String toString() {
        return "HotelRoomDo{" +
                "ID=" + ID +
                ", type='" + type + '\'' +
                ", roomID=" + roomID +
                ", hotelID=" + hotelID +
                ", price=" + price +
                ", status=" + status +
                ", maxNum=" + maxNum +
                '}';
    }
}
