package com.example.demo.entity.VO;

import com.example.demo.entity.DTO.Journey;

import java.time.LocalDateTime;
import java.util.Objects;

public class DriverBasedJourney  {
    private String name;
    private int id;
    private String carNum;
    private String phone;
    private Journey journey;

    public DriverBasedJourney(String name, int id, String carNum, String phone, Journey journey) {
        this.name = name;
        this.id = id;
        this.carNum = carNum;
        this.phone = phone;
        this.journey = journey;
    }

    public Journey getJourney() {
        return journey;
    }

    public void setJourney(Journey journey) {
        this.journey = journey;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCarNum() {
        return carNum;
    }

    public void setCarNum(String carNum) {
        this.carNum = carNum;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DriverBasedJourney that = (DriverBasedJourney) o;
        return id == that.id &&
                Objects.equals(name, that.name) &&
                Objects.equals(carNum, that.carNum) &&
                Objects.equals(phone, that.phone) &&
                Objects.equals(journey, that.journey);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, id, carNum, phone, journey);
    }

    @Override
    public String toString() {
        return "DriverBasedJourney{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", carNum='" + carNum + '\'' +
                ", phone='" + phone + '\'' +
                ", journey=" + journey +
                '}';
    }
}
