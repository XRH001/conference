package com.example.demo.entity.VO;

import com.example.demo.entity.DTO.Conference;
import com.example.demo.enumValue.OrderStatus;
import com.example.demo.service.mehod.ConferenceService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class Meeting {

    private int id;
    private String name;
    private String address;
    private Object OrderStatus;
    private Object beginTime;

    public Meeting (Conference conference){
        this.id=conference.getID();
        this.name=conference.getName();
        this.address=conference.getAddress();
        this.OrderStatus=conference.getOrderStatus();
        this.beginTime=conference.getBeginTime();
    }
}
