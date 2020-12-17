package com.example.demo.entity.DO;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Objects;
@DynamicInsert
@Entity(name = "userjourney")
public class UserJourneyDO {
    /**
     * @author 李嘉旭
     * 基本DO类:用户出行,对应数据库中的用户出行表
     * @param ID 用户出行ID
     * @param userID 用户ID;
     * @param journeyID 行程基本信息ID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO,generator = "generator")
    @GenericGenerator(name = "generator",strategy = "com.example.demo.utils.GeneratedInsertGenerator")
    private int ID;
    private int userID;
    private int journeyID;
    private int conferenceID;

    public UserJourneyDO() {
    }

    public UserJourneyDO(int userID, int journeyID, int conferenceID) {
        this.userID = userID;
        this.journeyID = journeyID;
        this.conferenceID = conferenceID;
    }

    public UserJourneyDO(int ID, int userID, int journeyID, int conferenceID) {
        this.ID = ID;
        this.userID = userID;
        this.journeyID = journeyID;
        this.conferenceID = conferenceID;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public int getJourneyID() {
        return journeyID;
    }

    public void setJourneyID(int journeyID) {
        this.journeyID = journeyID;
    }

    public int getConferenceID() {
        return conferenceID;
    }

    public void setConferenceID(int conferenceID) {
        this.conferenceID = conferenceID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserJourneyDO that = (UserJourneyDO) o;
        return ID == that.ID &&
                userID == that.userID &&
                journeyID == that.journeyID &&
                conferenceID == that.conferenceID;
    }

    @Override
    public int hashCode() {
        return Objects.hash(ID, userID, journeyID, conferenceID);
    }

    @Override
    public String toString() {
        return "UserJourneyDO{" +
                "ID=" + ID +
                ", userID=" + userID +
                ", journeyID=" + journeyID +
                ", conferenceID=" + conferenceID +
                '}';
    }
}
