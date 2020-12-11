package com.example.demo.entity.DTO;

import java.util.Objects;

public class ConferenceJourney {
    private int ID;
    private Conference conference;
    private Journey journey;

    public ConferenceJourney() {
    }

    public ConferenceJourney(int ID, Conference conference, Journey journey) {
        this.ID = ID;
        this.conference = conference;
        this.journey = journey;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public Conference getConference() {
        return conference;
    }

    public void setConference(Conference conference) {
        this.conference = conference;
    }

    public Journey getJourney() {
        return journey;
    }

    public void setJourney(Journey journey) {
        this.journey = journey;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ConferenceJourney that = (ConferenceJourney) o;
        return ID == that.ID &&
                Objects.equals(conference, that.conference) &&
                Objects.equals(journey, that.journey);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ID, conference, journey);
    }

    @Override
    public String toString() {
        return "ConferenceJourney{" +
                "ID=" + ID +
                ", conference=" + conference +
                ", journey=" + journey +
                '}';
    }
}
