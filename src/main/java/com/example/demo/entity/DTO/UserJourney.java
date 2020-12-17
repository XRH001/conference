package com.example.demo.entity.DTO;

import java.util.Objects;

public class UserJourney {
    /**
     * @author 李嘉旭
     * 基本DO类:用户出行,对应数据库中的用户出行表
     * @param ID 用户出行ID
     * @param user 用户;
     * @param journey 行程基本信息
     */
    private int ID;
    private User user;
    private Journey journey;
    private Conference conference;

    public UserJourney() {
    }

    public UserJourney(int ID, User user, Journey journey, Conference conference) {
        this.ID = ID;
        this.user = user;
        this.journey = journey;
        this.conference = conference;
    }

    public UserJourney(User user, Journey journey, Conference conference) {
        this.user = user;
        this.journey = journey;
        this.conference = conference;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Journey getJourney() {
        return journey;
    }

    public void setJourney(Journey journey) {
        this.journey = journey;
    }

    public Conference getConference() {
        return conference;
    }

    public void setConference(Conference conference) {
        this.conference = conference;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserJourney that = (UserJourney) o;
        return ID == that.ID &&
                Objects.equals(user, that.user) &&
                Objects.equals(journey, that.journey) &&
                Objects.equals(conference, that.conference);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ID, user, journey, conference);
    }

    @Override
    public String toString() {
        return "UserJourney{" +
                "ID=" + ID +
                ", user=" + user +
                ", journey=" + journey +
                ", conference=" + conference +
                '}';
    }
}
