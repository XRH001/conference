package com.example.demo.entity.DTO;

import com.example.demo.entity.Hotel;
import com.example.demo.enumValue.OrderStatus;

import java.util.Objects;

public class HotelRoom {
    /**
     * @author 李嘉旭
     * 基本类:酒店房间
     * 这个类用来说明酒店有哪些房间
     * @param ID 房间编号
     * @param type 用来说明房间类型,例如单人间和双人间
     * @param roomID 房间号
     * @param price 价格
     * @param hotelID 房间所属的酒店编号
     * @param status 房间是否已经被使用
     * @param maxNum 房间最大人数限制
     */
    private int ID;
    private String type;
    private String roomID;
    private Hotel hotel;
    private double price;
    private boolean isUsed;
    private int maxNum;

    public HotelRoom() {
    }

    public HotelRoom(int ID, String type, String roomID, Hotel hotel, double price, boolean isUsed, int maxNum) {
        this.ID = ID;
        this.type = type;
        this.roomID = roomID;
        this.hotel = hotel;
        this.price = price;
        this.isUsed = isUsed;
        this.maxNum = maxNum;
    }

    public HotelRoom(String type, String roomID, Hotel hotel, double price, boolean isUsed, int maxNum) {
        this.type = type;
        this.roomID = roomID;
        this.hotel = hotel;
        this.price = price;
        this.isUsed = isUsed;
        this.maxNum = maxNum;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getRoomID() {
        return roomID;
    }

    public void setRoomID(String roomID) {
        this.roomID = roomID;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean getIsUsed() {
        return isUsed;
    }

    public void setIsUsed(boolean isUsed) {
        this.isUsed = isUsed;
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
        HotelRoom hotelRoom = (HotelRoom) o;
        return ID == hotelRoom.ID &&
                Double.compare(hotelRoom.price, price) == 0 &&
                maxNum == hotelRoom.maxNum &&
                Objects.equals(type, hotelRoom.type) &&
                Objects.equals(roomID, hotelRoom.roomID) &&
                Objects.equals(hotel, hotelRoom.hotel) &&
                isUsed == hotelRoom.isUsed;
    }

    @Override
    public int hashCode() {
        return Objects.hash(ID, type, roomID, hotel, price, isUsed, maxNum);
    }

    @Override
    public String toString() {
        return "HotelRoom{" +
                "ID=" + ID +
                ", type='" + type + '\'' +
                ", roomID='" + roomID + '\'' +
                ", hotel=" + hotel +
                ", price=" + price +
                ", isUsed=" + isUsed +
                ", maxNum=" + maxNum +
                '}';
    }
}
