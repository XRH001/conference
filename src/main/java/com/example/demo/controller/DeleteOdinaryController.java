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
public class DeleteOdinaryController {
    @Autowired
    UserService userService;
    @Autowired
    ConferenceUserService conferenceUserService;
    @RequestMapping("/deleteOdinary")
    public String DeleteAdminSelvet(UserAddConfence userAddConfence){
        // 根据用户ID查询
        if(userService.queryUserByID(Integer.valueOf(userAddConfence.getMemberId()))==null){
            return "fail";
        }
        // 找到该用户
        User user = userService.queryUserByID(Integer.valueOf(userAddConfence.getMemberId()));
        if(conferenceUserService.queryConferenceUsersByUser(user)==null){
            // 找到该用户参与的会议
            return "fail";
        }
        List<ConferenceUser> conferenceUsers = conferenceUserService.queryConferenceUsersByUser(user);
        // 遍历conferenceUsers
        for(int i=0;i<conferenceUsers.size();i++){
            if(conferenceUsers.get(i).getConference().getID()==Integer.valueOf(userAddConfence.getMeetingId())){ // 该用户已经存在在该会议中
                if(conferenceUsers.get(i).getPosition()==Position.ordinary){// 删除普通成员
                    if(conferenceUserService.deleteConferenceUser(conferenceUsers.get(i).getID())==-1){
                        return "fail";
                    }
                    return "success";
                }
            }
        }
        return "fail";
    }
}

