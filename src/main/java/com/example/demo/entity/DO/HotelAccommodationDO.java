package com.example.demo.entity.DO;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Objects;
@DynamicInsert
@Entity(name = "hotelaccommodation")
public class HotelAccommodationDO {
    /**
     * @author 李嘉旭
     * 基本Do类:酒店住宿类 用来对应数据库中的酒店住宿表
     * @param ID 住宿ID
     * @param conferenceUserID 参会人员ID
     * @param hotelOrderID 酒店订单ID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO,generator = "generator")
    @GenericGenerator(name = "generator",strategy = "com.example.demo.utils.GeneratedInsertGenerator")
    private int ID;
    private int conferenceUserID;
    private int hotelOrderID;

    public HotelAccommodationDO() {
    }

    public HotelAccommodationDO(int ID, int conferenceUserID, int hotelOrderID) {
        this.ID = ID;
        this.conferenceUserID = conferenceUserID;
        this.hotelOrderID = hotelOrderID;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getConferenceUserID() {
        return conferenceUserID;
    }

    public void setConferenceUserID(int conferenceUserID) {
        this.conferenceUserID = conferenceUserID;
    }

    public int getHotelOrderID() {
        return hotelOrderID;
    }

    public void setHotelOrderID(int hotelOrderID) {
        this.hotelOrderID = hotelOrderID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HotelAccommodationDO that = (HotelAccommodationDO) o;
        return ID == that.ID &&
                conferenceUserID == that.conferenceUserID &&
                hotelOrderID == that.hotelOrderID;
    }

    @Override
    public int hashCode() {
        return Objects.hash(ID, conferenceUserID, hotelOrderID);
    }

    @Override
    public String toString() {
        return "HotoAccommodation{" +
                "ID=" + ID +
                ", conferenceUserID=" + conferenceUserID +
                ", hotelOrderID=" + hotelOrderID +
                '}';
    }
}
