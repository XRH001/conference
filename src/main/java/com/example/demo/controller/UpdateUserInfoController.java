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
public class UpdateUserInfoController {
    @Autowired
    UserService userService;
    @Autowired
    ConferenceUserService conferenceUserService;
    @RequestMapping("/updateUserInfo")
    public String UpdateUserInfoSelvet(UserAddConfence userAddConfence){
        // 根据用户ID查询
        if(userService.queryUserByID(Integer.valueOf(userAddConfence.getUserId()))==null){
            return "fail";
        }
        User user = userService.queryUserByID(Integer.valueOf(userAddConfence.getUserId()));
        if(conferenceUserService.queryConferenceUsersByUser(user)==null){
            return "fail";
        }
        List<ConferenceUser> conferenceUsers = conferenceUserService.queryConferenceUsersByUser(user);
        // 遍历用户ID
        for(int i=0;i<conferenceUsers.size();i++){
            if(conferenceUsers.get(i).getConference().getID()==Integer.valueOf(userAddConfence.getMeetingId())){ // 该用户已经存在在该会议中
                conferenceUsers.get(i).setInfo(userAddConfence.getRemark());
                if(conferenceUserService.saveConferenceUser(conferenceUsers.get(i))==null){
                    return "fail";
                }
                return "success";
            }
        }
        return "fail";
    }
}

