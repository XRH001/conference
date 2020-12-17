package com.example.demo.controller;

import com.example.demo.entity.DTO.User;
import com.example.demo.enumValue.Identity;
import com.example.demo.enumValue.OrderStatus;
import com.example.demo.service.mehod.ConferenceService;
import com.example.demo.service.mehod.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.demo.enumValue.Sex;
import com.example.demo.enumValue.Position;
import org.springframework.web.bind.annotation.*;
import com.example.demo.controller.CenterMeeting;
import com.example.demo.entity.DTO.Conference;
import com.example.demo.entity.DTO.ConferenceUser;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
@RestController
public class CreateMeeting {
    @Autowired
    ConferenceService conferenceService;
    @RequestMapping("/createMeetingEmail")
    public String CreateMeetingServlet(CenterMeeting centerMeeting){
        // 创建一个会议存储信息
        Conference conference = new Conference();
        conference.setName(centerMeeting.getName());
        conference.setAddress(centerMeeting.getAddress());
        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime beginTime = LocalDateTime.parse(centerMeeting.getBeginTime(),df);
        conference.setBeginTime(beginTime);
        conference.setOrderStatus(OrderStatus.NoStatus);
        conference.setCreateTime(LocalDateTime.now());
        conference.setEndTime(LocalDateTime.now());
        // 存储会议
        conferenceService.saveConference(conference);
        return "{\"msg\":\"success\",\"meetingid\""+":"+"\""+conference.getID()+"\""+","+"\"orderStatus\""+":"+"\""+conference.getOrderStatus()+"\""+"}";

        // 将用户跟会议联系
        //ConferenceUser conferenceUser = new ConferenceUser();
        // 设置身份为创建者
        //conferenceUser.setPosition(Position.creator);

        //return "111";
    }
}

