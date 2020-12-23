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

import java.time.LocalDateTime;
import java.util.List;

@RestController
public class AgreeConfenceInviteController {
    @Autowired
    UserService userService;
    @Autowired
    ConferenceService conferenceService;
    @Autowired
    ConferenceUserService conferenceUserService;
    @RequestMapping("/agreeConferenceInvite")
    public String AcceptOrdinarySelvet(@RequestBody UserAddConfence userAddConfence){
        // 根据用户ID查询
        if(userService.queryUserByID(Integer.valueOf(userAddConfence.getMemberId()))==null){
            return "{\"msg\":\"fail\"}";
        }
        // 找到该用户
        User user = userService.queryUserByID(Integer.valueOf(userAddConfence.getMemberId()));
        if(conferenceUserService.queryConferenceUsersByUser(user)==null){
            // 找到该用户参与的会议
            return "{\"msg\":\"fail\"}";
        }
        List<ConferenceUser> conferenceUsers = conferenceUserService.queryConferenceUsersByUser(user);
        if(conferenceUsers.size()==0){
            return "{\"msg\":\"fail\"}";
        }else{
            // 遍历conferenceUsers
            for(int i=0;i<conferenceUsers.size();i++){
                if(conferenceUsers.get(i).getConference().getID()==Integer.valueOf(userAddConfence.getMeetingId())){ // 该用户已经存在在该会议中
                    if(conferenceUsers.get(i).getInvitationStatus()==InvitationStatus.Checking){
                        conferenceUsers.get(i).setInvitationStatus(InvitationStatus.Accepted); // 将用户在会状态由邀请中改为已接受
                        if(conferenceUserService.saveConferenceUser(conferenceUsers.get(i))==null){
                            return "{\"msg\":\"fail\"}";
                        }
                        ConferenceUser conferenceUser =  conferenceUserService.saveConferenceUser(conferenceUsers.get(i));
                        //找到该会议 返回相关信息
                        if(conferenceService.queryConferenceByID(Integer.valueOf(userAddConfence.getMeetingId()))==null){
                            return "{\"msg\":\"fail\"}";
                        }
                        Conference conference = conferenceService.queryConferenceByID(Integer.valueOf(userAddConfence.getMeetingId()));
                        String beginTime = conference.getBeginTime().toString();
                        // 传给前端的会议id
                        String id = String.valueOf(conference.getID());
                        // 传给前端的username
                        String name = conference.getName();
                        // 传给前端的beginTime
                        beginTime = beginTime.replace('T',' ');
                        // 传给前端的orderStatus
                        String orderStatus = conferenceUser.getOrderStatus().getStatusInfo();
                        // 传给前端的address
                        String address = conference.getAddress();
                        // 判断该用户是不是管理员
                        String isTrue = conferenceUser.getPosition()==Position.administrator?"true":"false";
                        return "{\"msg\":\"success\",\"newMeeting\":{\"id\":"+"\""+id+"\""+","+"\""+"name"+"\""+":"+"\""+name+"\""+","+"\""+"beginTime"+"\""+":"+"\""+beginTime+"\""+","+"\""+"orderStatus"+"\""+":"+"\""+orderStatus+"\""+","+"\""+"address"+"\""+":"+"\""+address+"\""+"},"+"\""+"ifManager"+"\""+":"+"\""+isTrue+"\""+"}";

                    }
                    return "{\"msg\":\"fail\"}";
                }
            }
        }

        return "{\"msg\":\"fail\"}";
    }
}
