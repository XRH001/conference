package com.example.demo.entity.VO;

import com.example.demo.entity.DTO.Conference;
import com.example.demo.enumValue.OrderStatus;
import com.example.demo.service.mehod.ConferenceService;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Meeting {

    private int id;
    private String name;
    private String address;
    private String OrderStatus;
    private String beginTime;

    public Meeting (Conference conference){
        this.id=conference.getID();
        this.name=conference.getName();
        this.address=conference.getAddress();
        this.OrderStatus=conference.getOrderStatus().getStatusInfo();
        this.beginTime=conference.getBeginTime().format(DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss"));
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Object getOrderStatus() {
        return OrderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        OrderStatus = orderStatus;
    }

    public Object getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(String beginTime) {
        this.beginTime = beginTime;
    }
}
