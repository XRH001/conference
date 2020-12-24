package com.example.demo.entity.DTO;

import com.example.demo.entity.Hotel;

import java.util.Objects;

public class HotelInfo {
    private int ID;
    private Hotel hotel;
    private String hotelInfo;

    public HotelInfo(int ID, Hotel hotel, String hotelInfo) {
        this.ID = ID;
        this.hotel = hotel;
        this.hotelInfo = hotelInfo;
    }

    public HotelInfo() {
    }

    public HotelInfo(Hotel hotel, String hotelInfo) {
        this.hotel = hotel;
        this.hotelInfo = hotelInfo;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    public String getHotelInfo() {
        return hotelInfo;
    }

    public void setHotelInfo(String hotelInfo) {
        this.hotelInfo = hotelInfo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HotelInfo hotelInfo1 = (HotelInfo) o;
        return ID == hotelInfo1.ID &&
                Objects.equals(hotel, hotelInfo1.hotel) &&
                Objects.equals(hotelInfo, hotelInfo1.hotelInfo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ID, hotel, hotelInfo);
    }

    @Override
    public String toString() {
        return "HotelInfo{" +
                "ID=" + ID +
                ", hotel=" + hotel +
                ", hotelInfo='" + hotelInfo + '\'' +
                '}';
    }
}
