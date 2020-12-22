package com.example.demo.controller;

import com.example.demo.entity.DTO.Conference;
import com.example.demo.entity.DTO.ConferenceUser;
import com.example.demo.entity.DTO.User;
import com.example.demo.entity.VO.RegisterUser;

import com.example.demo.enumValue.InvitationStatus;
import com.example.demo.enumValue.OrderStatus;
import com.example.demo.enumValue.Position;
import com.example.demo.service.mehod.ConferenceService;
import com.example.demo.service.mehod.ConferenceUserService;
import com.example.demo.service.mehod.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.demo.enumValue.Sex;
import org.springframework.web.bind.annotation.*;
import com.example.demo.entity.VO.UserAddConfence;

import java.util.List;

@RestController
public class InviteNewMemberController {
    @Autowired
    UserService userService;
    @Autowired
    ConferenceService conferenceService;
    @Autowired
    ConferenceUserService conferenceUserService;
    @RequestMapping("/inviteNewMember")
    public String InviteNewMemberSelvet(UserAddConfence userAddConfence){
        // 找到该用户
        if(userService.queryUserByID(Integer.valueOf(userAddConfence.getMemberId()))==null){
            return "fail";
        }
        // 已经找到该用户
        User user = userService.queryUserByID(Integer.valueOf(userAddConfence.getMemberId()));
        // 查找该会议
        if(conferenceService.queryConferenceByID(Integer.valueOf(userAddConfence.getMeetingId()))==null){
            return "fail";
        }
        Conference conference = conferenceService.queryConferenceByID(Integer.valueOf(userAddConfence.getMeetingId()));
        // 已找到用户跟会议
        // 查找该会议的所有用户
        if(conferenceUserService.queryConferenceUsersByConference(conference)==null){
            return "fail";
        }
        List<ConferenceUser> conferenceUsers = conferenceUserService.queryConferenceUsersByConference(conference);
        // 遍历用户ID
        for(int i=0;i<conferenceUsers.size();i++){
            if(conferenceUsers.get(i).getUser().equals(user)){ // 该用户已经存在在该会议中
                return "fail";
            }
        }
        // 说明会议中不存在该用户
        // 将邀请用户为此会议的成员
        ConferenceUser conferenceUser = new ConferenceUser();

        conferenceUser.setUser(user);
        conferenceUser.setInvitationStatus(InvitationStatus.Checking);
        conferenceUser.setPosition(Position.ordinary);
        conferenceUser.setOrderStatus(OrderStatus.Checking);
        conferenceUser.setConference(conference);
        if(conferenceUserService.saveConferenceUser(conferenceUser)==null){
            return "fail";
        };
        return "success";

    }
}



