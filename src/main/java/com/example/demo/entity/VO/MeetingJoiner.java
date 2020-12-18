package com.example.demo.entity.VO;

import com.example.demo.entity.DTO.ConferenceUser;
import com.example.demo.enumValue.InvitationStatus;

public class MeetingJoiner {

    private int id;
    private String name;
    private String email;
    private InvitationStatus invitationStatus;

    public MeetingJoiner(ConferenceUser conferenceUser){
        this.id=conferenceUser.getID();
        this.name=conferenceUser.getUser().getName();
        this.email=conferenceUser.getUser().getEmail();
        this.invitationStatus=conferenceUser.getInvitationStatus();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public InvitationStatus getInvitationStatus() {
        return invitationStatus;
    }

    public void setInvitationStatus(InvitationStatus invitationStatus) {
        this.invitationStatus = invitationStatus;
    }
}
