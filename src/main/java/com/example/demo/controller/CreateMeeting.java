package com.example.demo.controller;

import com.example.demo.entity.DTO.User;
import com.example.demo.enumValue.*;
import com.example.demo.service.mehod.ConferenceService;
import com.example.demo.service.mehod.ConferenceUserService;
import com.example.demo.service.mehod.UserService;
import org.springframework.beans.factory.annotation.Autowired;
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
    @Autowired
    ConferenceUserService conferenceUserService;
    @Autowired
    UserService userService;
    @RequestMapping("/createMeeting")
    public String CreateMeetingServlet(CenterMeeting centerMeeting){
        System.out.println(centerMeeting);
        // 先查询该用户是否存在
        if((userService.queryUserByEmail(centerMeeting.getEmail()))==null){
            // 不存在直接return
            return "{\"msg\":\"fail\"}";
        }
        // 创建一个会议存储信息
        Conference conference = new Conference();
        conference.setName(centerMeeting.getName());
        conference.setAddress(centerMeeting.getPosition());

        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        LocalDateTime beginTime = LocalDateTime.parse(centerMeeting.getBeginTime(),df);
        LocalDateTime endTime = LocalDateTime.parse(centerMeeting.getEndTime(),df);

        conference.setBeginTime(beginTime);
        conference.setEndTime(endTime);
        conference.setOrderStatus(OrderStatus.Checking);
        conference.setCreateTime(LocalDateTime.now());
        // 存储会议
        try{
            conference = conferenceService.saveConference(conference);
             // 将用户跟会议联系
            ConferenceUser conferenceUser = new ConferenceUser();
             // 设置身份为创建者
            conferenceUser.setPosition(Position.creator);
            conferenceUser.setUser(userService.queryUserByEmail(centerMeeting.getEmail()));
            conferenceUser.setConference(conference);
            conferenceUser.setInvitationStatus(InvitationStatus.Checking);
            conferenceUser.setOrderStatus(OrderStatus.Checking);
            conferenceUserService.saveConferenceUser(conferenceUser);
            return "{\"msg\":\"success\",\"meetingid\""+":"+"\""+conference.getID()+"\""+","+"\"orderStatus\""+":"+"\""+conference.getOrderStatus()+"\""+"}";
        }catch(Exception e){
            return "{\"msg\":\"fail\"}";
        }
    }
}

