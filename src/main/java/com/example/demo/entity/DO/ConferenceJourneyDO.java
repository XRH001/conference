package com.example.demo.entity.DO;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Objects;

@DynamicInsert
@Entity(name = "conferencejourney")
public class ConferenceJourneyDO {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO,generator = "generator")
    @GenericGenerator(name = "generator",strategy = "com.example.demo.utils.GeneratedInsertGenerator")
    private int ID;
    private int conferenceID;
    private int journeyID;

    public ConferenceJourneyDO() {
    }

    public ConferenceJourneyDO(int ID, int conferenceID, int journeyID) {
        this.ID = ID;
        this.conferenceID = conferenceID;
        this.journeyID = journeyID;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getConferenceID() {
        return conferenceID;
    }

    public void setConferenceID(int conferenceID) {
        this.conferenceID = conferenceID;
    }

    public int getJourneyID() {
        return journeyID;
    }

    public void setJourneyID(int journeyID) {
        this.journeyID = journeyID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ConferenceJourneyDO that = (ConferenceJourneyDO) o;
        return ID == that.ID &&
                conferenceID == that.conferenceID &&
                journeyID == that.journeyID;
    }

    @Override
    public int hashCode() {
        return Objects.hash(ID, conferenceID, journeyID);
    }

    @Override
    public String toString() {
        return "ConferenceJourneyDO{" +
                "ID=" + ID +
                ", conferenceID=" + conferenceID +
                ", journeyID=" + journeyID +
                '}';
    }
}
