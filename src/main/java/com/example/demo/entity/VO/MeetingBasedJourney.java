package com.example.demo.entity.VO;

import com.example.demo.entity.DTO.Journey;
import com.example.demo.entity.DTO.UserJourney;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class MeetingBasedJourney{
    private int id;
    private String name;
    private String address;
    private LocalDateTime beginTime;
    private Journey journey;
    private List<Passenger> passenger;

    public MeetingBasedJourney(int id, String name, String address, LocalDateTime beginTime, Journey journey, List<Passenger> passenger) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.beginTime = beginTime;
        this.journey = journey;
        this.passenger = passenger;
    }

    public MeetingBasedJourney() {
        this.passenger=new ArrayList<>();
    }

    public int getid() {
        return id;
    }

    public void setid(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public LocalDateTime getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(LocalDateTime beginTime) {
        this.beginTime = beginTime;
    }

    public Journey getJourney() {
        return journey;
    }

    public void setJourney(Journey journey) {
        this.journey = journey;
    }

    public List<Passenger> getPassenger() {
        return passenger;
    }

    public void setPassenger(List<Passenger> passenger) {
        this.passenger = passenger;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MeetingBasedJourney that = (MeetingBasedJourney) o;
        return id == that.id &&
                Objects.equals(name, that.name) &&
                Objects.equals(address, that.address) &&
                Objects.equals(beginTime, that.beginTime) &&
                Objects.equals(journey, that.journey) &&
                Objects.equals(passenger, that.passenger);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, address, beginTime, journey, passenger);
    }

    @Override
    public String toString() {
        return "MeetingBasedJourney{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", beginTime=" + beginTime +
                ", journey=" + journey +
                ", passenger=" + passenger +
                '}';
    }
}
