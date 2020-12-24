package com.example.demo.entity.VO;

import com.example.demo.entity.DTO.Conference;
import com.example.demo.entity.DTO.ConferenceUser;
import com.example.demo.enumValue.Position;
import com.example.demo.service.mehod.ConferenceUserService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static com.example.demo.enumValue.Position.administrator;


public class MeetingHotel {

    @Autowired
    ConferenceUserService conferenceUserService;

    private int id;
    private String name;
    private String customer;
    private String contact;

    public MeetingHotel(Conference conference){
        this.id=conference.getID();
        this.name=conference.getName();
        List<ConferenceUser> conferenceUsers=conferenceUserService.queryConferenceUsersByConference(conference);
        for(ConferenceUser item:conferenceUsers)
            if(item.getPosition().equals(administrator)){
                this.customer=item.getUser().getName();
                this.contact=item.getUser().getPhone();
            }
    }
}
