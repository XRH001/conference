package com.example.demo.entity.DTO;

import java.util.Objects;

public class HotelAccommodation {
    /**
     * @author 李嘉旭
     * 基本类:酒店住宿类
     * @param ID 住宿ID
     * @param conferenceUser 参会人员
     * @param hotelOrder 酒店订单
     */
    private int ID;
    private ConferenceUser conferenceUser;
    private HotelOrder hotelOrder;

    public HotelAccommodation() {
    }

    public HotelAccommodation(int ID, ConferenceUser conferenceUser, HotelOrder hotelOrder) {
        this.ID = ID;
        this.conferenceUser = conferenceUser;
        this.hotelOrder = hotelOrder;
    }

    public HotelAccommodation(ConferenceUser conferenceUser, HotelOrder hotelOrder) {
        this.conferenceUser = conferenceUser;
        this.hotelOrder = hotelOrder;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public ConferenceUser getConferenceUser() {
        return conferenceUser;
    }

    public void setConferenceUser(ConferenceUser conferenceUser) {
        this.conferenceUser = conferenceUser;
    }

    public HotelOrder getHotelOrder() {
        return hotelOrder;
    }

    public void setHotelOrder(HotelOrder hotelOrder) {
        this.hotelOrder = hotelOrder;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HotelAccommodation that = (HotelAccommodation) o;
        return ID == that.ID &&
                Objects.equals(conferenceUser, that.conferenceUser) &&
                Objects.equals(hotelOrder, that.hotelOrder);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ID, conferenceUser, hotelOrder);
    }

    @Override
    public String toString() {
        return "HotelAccommodation{" +
                "ID=" + ID +
                ", conferenceUser=" + conferenceUser +
                ", hotelOrder=" + hotelOrder +
                '}';
    }
}
