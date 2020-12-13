package com.example.demo.controller;

import com.example.demo.entity.DTO.Conference;
import com.example.demo.entity.DTO.ConferenceUser;
import com.example.demo.entity.DTO.User;
import com.example.demo.entity.VO.Meeting;
import com.example.demo.enumValue.OrderStatus;
import com.example.demo.service.mehod.ConferenceService;
import com.example.demo.service.mehod.ConferenceUserService;
import com.example.demo.service.mehod.UserService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

import static com.example.demo.enumValue.OrderStatus.*;
import static com.example.demo.enumValue.Position.administrator;
import static com.example.demo.enumValue.Position.creator;

@Controller
public class LoginController {
    /**
     * 人员登录系统
     */

    @Autowired
    UserService userService;

    @Autowired
    ConferenceUserService conferenceUserService;

    @ResponseBody
    @RequestMapping("/UserJudge")


    public String UserJudge(HttpServletRequest request) {

        String email = request.getParameter("email");
        String password = request.getParameter("password");//获取邮件和密码

        if(userService.queryUserByEmail(email)==null)
            return "not user";                              //判断有无该用户

        User user1=userService.queryUserByEmail(email);
        if (userService.queryUserByEmail(email)!=null)
            if(password!=user1.getPassword())
                return "password error";                    //判断密码是否正确

        ArrayList<Conference> joinAll=new ArrayList<>();
        ArrayList<Conference> manageAll=new ArrayList<>();
        ArrayList<Conference> createAll=new ArrayList<>();
        //构建三个会议类组

        List<ConferenceUser> conferenceUser1=conferenceUserService.queryConferenceUsersByUser(user1);
        for(ConferenceUser item:conferenceUser1) {
            if (item.getPosition() == administrator)
                manageAll.add(item.getConference());        //归类进入管理者
            else if(item.getPosition() == creator)createAll.add(item.getConference());  //归类进入创建者
            else joinAll.add(item.getConference());         //归类进入参加者
        }

        ArrayList<Conference> joinNewMeetings=new ArrayList<>();
        ArrayList<Conference> joinOverMeetings=new ArrayList<>();
        ArrayList<Conference> joinApplyMeetings=new ArrayList<>();
        //构建参会人的三种会议状态组

        for(Conference item:joinAll)
            if(item.getOrderStatus()==Finished)
                joinOverMeetings.add(item);                  //归类进入会议结束状态
            else if(item.getOrderStatus()==Ready)
                joinNewMeetings.add(item);                   //归类进入会议未开始状态
            else joinApplyMeetings.add(item);                //归类进入会议申请中状态

        ArrayList<Conference> manageNewMeetings=new ArrayList<>();
        ArrayList<Conference> manageOverMeetings=new ArrayList<>();
        //构建管理人的两种会议状态组

        for(Conference item:manageAll)
            if(item.getOrderStatus()==Finished)
                manageOverMeetings.add(item);                 //归类进入会议结束状态
            else manageNewMeetings.add(item);                 //归类进入会议未开始状态


        ArrayList<Meeting> joinNewMeeting=new ArrayList<>();
        for(int i=0;i<joinNewMeetings.size();i++){
            joinNewMeeting.add(new Meeting(joinNewMeetings.get(i)));
        }
        //将参会人未开始会议组转化为前端需求的meeting型组

        ArrayList<Meeting> joinOverMeeting=new ArrayList<>();
        for(int i=0;i<joinOverMeetings.size();i++){
            joinOverMeeting.add(new Meeting(joinOverMeetings.get(i)));
        }
        //将参会人已结束会议组转化为前端需求的meeting型组

        ArrayList<Meeting> joinApplyMeeting=new ArrayList<>();
        for(int i=0;i<joinApplyMeetings.size();i++){
            joinApplyMeeting.add(new Meeting(joinApplyMeetings.get(i)));
        }
        //将参会人申请中会议组转化为前端需求的meeting型组

        ArrayList<Meeting> manageNewMeeting=new ArrayList<>();
        for(int i=0;i<manageNewMeetings.size();i++){
            manageNewMeeting.add(new Meeting(manageNewMeetings.get(i)));
        }
        //将管理人未开始会议组转化为前端需求的meeting型组

        ArrayList<Meeting> manageOverMeeting=new ArrayList<>();
        for(int i=0;i<manageOverMeetings.size();i++){
            manageOverMeeting.add(new Meeting(manageOverMeetings.get(i)));
        }
        //将管理人已结束会议组转化为前端需求的meeting型组

        ArrayList<Meeting> createMeeting=new ArrayList<>();
        for(int i=0;i<createAll.size();i++){
            createMeeting.add(new Meeting(createAll.get(i)));
        }
        //将会议创建者会议组转化为前端需求的meeting型组

        HashMap<String,Object> join=new HashMap<>(2);
        join.put("newMeetings",joinNewMeeting);
        join.put("overMeetings",joinOverMeeting);
        join.put("applyMeetings",joinApplyMeeting);

        HashMap<String,Object> manage=new HashMap<>(2);
        manage.put("newMeetings",manageNewMeeting);
        manage.put("overMeetings",manageOverMeeting);

        HashMap<String,Object> meeting=new HashMap<>(2);
        meeting.put("join",join);
        meeting.put("manage",manage);

        HashMap<String,Object> information=new HashMap<>(2);
        information.put("user",user1);
        information.put("meetings",meeting);
        information.put("creator",createMeeting);
        //进行各级数据打包操作

        ObjectMapper mapper=new ObjectMapper();
        try {
            String userJson = mapper.writeValueAsString(information);
            return userJson;
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return "";
        }
        //将字符串转化为前端所需的json型数据并传回前端
    }
}