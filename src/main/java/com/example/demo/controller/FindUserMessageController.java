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

import java.util.ArrayList;
import java.util.List;

@RestController
public class FindUserMessageController {
    @Autowired
    UserService userService;
    @Autowired
    ConferenceUserService conferenceUserService;
    @RequestMapping("/findUserMessage")
    public String FindUserMessageSelvet(@RequestBody UserAddConfence userAddConfence){
        System.out.println(userAddConfence.getMeetingIdList().size());
        if(userService.queryUserByID(Integer.valueOf(userAddConfence.getUserId()))==null){
            return "{\"msg\":\"fail\"}";
        }
        User user = userService.queryUserByID(Integer.valueOf(userAddConfence.getUserId()));
        if(conferenceUserService.queryConferenceUsersByUser(user)==null){
            return "{\"msg\":\"fail\"}";
        }
        if(userAddConfence.getMeetingIdList().size()==0){
            List<ConferenceUser> conferenceUsers = conferenceUserService.queryConferenceUsersByUser(user);
            // 遍历用户ID
            String firstStr = "{\"msg\":\"success\",\"newMsg\":[";
            String lastStr = "]}";
            String tempStr = "";
            for(int i=0;i<conferenceUsers.size();i++){
                if(conferenceUsers.get(i).getInvitationStatus()==InvitationStatus.Checking){
                    if(conferenceUsers.get(i).getPosition()==Position.administrator){
                        tempStr += "{\"id\"" +":"+"\""+conferenceUsers.get(i).getConference().getID()+"\""+ ","+"\""+"name"+"\""+":"+"\""+conferenceUsers.get(i).getConference().getName()+"\""+","+"\""+"message"+"\""+":"+"\""+"邀请你成为管理员\""+"},";
                    }else{
                        tempStr += "{\"id\"" +":"+"\""+conferenceUsers.get(i).getConference().getID()+"\""+ ","+"\""+"name"+"\""+":"+"\""+conferenceUsers.get(i).getConference().getName()+"\""+","+"\""+"message"+"\""+":"+"\""+"邀请你加入会议\""+"},";
                    }
                }
            }
            String result = firstStr+tempStr+lastStr;
            // 去掉多余的逗号
            for(int i=result.length()-1;i>=0;i--){
                if(result.charAt(i)==','){
                    result = result.substring(0,i)+result.substring(i+1,result.length());
                    break;
                }
            }
            return result;
        }else{
            List<ConferenceUser> conferenceUsers = conferenceUserService.queryConferenceUsersByUser(user);
            // 遍历用户ID
            String firstStr = "{\"msg\":\"success\",\"newMsg\":[";
            String lastStr = "]}";
            String tempStr = "";
            for(int i=0;i<conferenceUsers.size();i++){
                boolean isTrue = true;
                // 判断是否不在前端传的会议中
                for(int j=0;j<userAddConfence.getMeetingIdList().size();j++){
                    if(conferenceUsers.get(i).getConference().getID() == userAddConfence.getMeetingIdList().get(j)){
                        isTrue = false;
                        break;
                    }
                }
                if(isTrue){
                    // 会议为审核中
                    if(conferenceUsers.get(i).getInvitationStatus()==InvitationStatus.Checking){
                        if(conferenceUsers.get(i).getPosition()==Position.administrator){
                            tempStr += "{\"id\"" +":"+"\""+conferenceUsers.get(i).getConference().getID()+"\""+ ","+"\""+"name"+"\""+":"+"\""+conferenceUsers.get(i).getConference().getName()+"\""+","+"\""+"message"+"\""+":"+"\""+"邀请你成为管理员\""+"},";
                        }else{
                            tempStr += "{\"id\"" +":"+"\""+conferenceUsers.get(i).getConference().getID()+"\""+ ","+"\""+"name"+"\""+":"+"\""+conferenceUsers.get(i).getConference().getName()+"\""+","+"\""+"message"+"\""+":"+"\""+"邀请你加入会议\""+"},";
                        }
                    }
                }
            }
            String result = firstStr+tempStr+lastStr;
            // 去掉多余的逗号
            for(int i=result.length()-1;i>=0;i--){
                if(result.charAt(i)==','){
                    result = result.substring(0,i)+result.substring(i+1,result.length());
                    break;
                }
            }
            return result;
        }
    }
}

