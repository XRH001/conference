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
public class InviteAdminController {
    @Autowired
    UserService userService;
    @Autowired
    ConferenceService conferenceService;
    @Autowired
    ConferenceUserService conferenceUserService;
    @RequestMapping("/inviteAdmin")
    public String InviteAdminSelvet(UserAddConfence userAddConfence){
        // 找到该用户
        if(userService.queryUserByID(Integer.valueOf(userAddConfence.getMemberId()))==null){
            return "fail";
        }
        User user = userService.queryUserByID(Integer.valueOf(userAddConfence.getMemberId()));
        // 根据会议ID查询
        if(conferenceService.queryConferenceByID(Integer.valueOf(userAddConfence.getMeetingId()))==null){
            return "fail";
        }
        // 找到该会议
        Conference conference = conferenceService.queryConferenceByID(Integer.valueOf(userAddConfence.getMeetingId()));
        if(conferenceUserService.queryConferenceUsersByConference(conference)==null){
            // 找到会议的所有用户
            return "fail";
        }
        List<ConferenceUser> conferenceUsers = conferenceUserService.queryConferenceUsersByConference(conference);
        // 遍历conferenceUsers
        for(int i=0;i<conferenceUsers.size();i++){
            if(conferenceUsers.get(i).getConference().getID()==Integer.valueOf(userAddConfence.getMemberId())){ // 该用户已经存在在该会议中
                if(conferenceUsers.get(i).getPosition()==Position.ordinary){// 普通成员
                    conferenceUsers.get(i).setPosition(Position.administrator);
                    if(conferenceUserService.saveConferenceUser(conferenceUsers.get(i))==null){
                        return "fail";
                    }
                    return "success";
                }
            }
        }
        // 该用户不在该会议上 则新增一个conferenceUser
        ConferenceUser conferenceUser = new ConferenceUser();
        conferenceUser.setUser(user);
        conferenceUser.setConference(conference);
        conferenceUser.setPosition(Position.administrator);
        conferenceUser.setOrderStatus(conferenceUsers.get(0).getOrderStatus());
        conferenceUser.setInvitationStatus(conferenceUsers.get(0).getInvitationStatus());
        if(conferenceUserService.saveConferenceUser(conferenceUser)==null){
            return "fail";
        }
        return "success";
    }
}


