package com.example.demo.entity.VO;

import com.example.demo.entity.DTO.Journey;
import com.example.demo.entity.DTO.UserJourney;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class MeetingBasedJourney{
    private int conferenceID;
    private String conferenceName;
    private String address;
    private LocalDateTime beginTime;
    private Journey journey;
    private List<Passenger> passenger;

    public MeetingBasedJourney(int conferenceID, String conferenceName, String address, LocalDateTime beginTime, Journey journey, List<Passenger> passenger) {
        this.conferenceID = conferenceID;
        this.conferenceName = conferenceName;
        this.address = address;
        this.beginTime = beginTime;
        this.journey = journey;
        this.passenger = passenger;
    }

    public MeetingBasedJourney() {
        this.passenger=new ArrayList<>();
    }

    public int getConferenceID() {
        return conferenceID;
    }

    public void setConferenceID(int conferenceID) {
        this.conferenceID = conferenceID;
    }

    public String getConferenceName() {
        return conferenceName;
    }

    public void setConferenceName(String conferenceName) {
        this.conferenceName = conferenceName;
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
        return conferenceID == that.conferenceID &&
                Objects.equals(conferenceName, that.conferenceName) &&
                Objects.equals(address, that.address) &&
                Objects.equals(beginTime, that.beginTime) &&
                Objects.equals(journey, that.journey) &&
                Objects.equals(passenger, that.passenger);
    }

    @Override
    public int hashCode() {
        return Objects.hash(conferenceID, conferenceName, address, beginTime, journey, passenger);
    }

    @Override
    public String toString() {
        return "MeetingBasedJourney{" +
                "conferenceID=" + conferenceID +
                ", conferenceName='" + conferenceName + '\'' +
                ", address='" + address + '\'' +
                ", beginTime=" + beginTime +
                ", journey=" + journey +
                ", passenger=" + passenger +
                '}';
    }
}
