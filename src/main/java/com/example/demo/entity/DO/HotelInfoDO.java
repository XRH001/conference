package com.example.demo.entity.DO;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Objects;

@DynamicInsert
@Entity(name = "hotelInfo")
public class HotelInfoDO {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO,generator = "generator")
    @GenericGenerator(name = "generator",strategy = "com.example.demo.utils.GeneratedInsertGenerator")
    private int ID;
    private int hotelID;
    private String hotelInfo;

    public HotelInfoDO() {
    }

    public HotelInfoDO(int ID, int hotelID, String hotelInfo) {
        this.ID = ID;
        this.hotelID = hotelID;
        this.hotelInfo = hotelInfo;
    }

    public HotelInfoDO(int hotelID, String hotelInfo) {
        this.hotelID = hotelID;
        this.hotelInfo = hotelInfo;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getHotelID() {
        return hotelID;
    }

    public void setHotelID(int hotelID) {
        this.hotelID = hotelID;
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
        HotelInfoDO that = (HotelInfoDO) o;
        return ID == that.ID &&
                hotelID == that.hotelID &&
                Objects.equals(hotelInfo, that.hotelInfo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ID, hotelID, hotelInfo);
    }

    @Override
    public String toString() {
        return "HotellInfoDO{" +
                "ID=" + ID +
                ", hotelID=" + hotelID +
                ", hotelInfo='" + hotelInfo + '\'' +
                '}';
    }
}
