package com.example.demo.entity.VO;

import com.example.demo.entity.DTO.Conference;
import com.example.demo.entity.DTO.Journey;
import com.example.demo.entity.DTO.User;
import com.example.demo.entity.DTO.UserJourney;

import java.util.ArrayList;
import java.util.List;

public class ConferenceJourneyAndUserList extends ConferenceJourney{
    private List<User> userList;

    public ConferenceJourneyAndUserList() {
    }

    public ConferenceJourneyAndUserList(List<User> userList) {
        this.userList = userList;
    }

    public ConferenceJourneyAndUserList(Conference conference, Journey journey) {
        super(conference, journey);
        userList=new ArrayList<>();
    }

    public ConferenceJourneyAndUserList(int ID, Conference conference, Journey journey, List<User> userList) {
        super(ID, conference, journey);
        this.userList = userList;
    }

    public ConferenceJourneyAndUserList(Conference conference, Journey journey, List<User> userList) {
        super(conference, journey);
        this.userList = userList;
    }

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }
}
