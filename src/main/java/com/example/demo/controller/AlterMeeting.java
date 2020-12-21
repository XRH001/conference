package com.example.demo.controller;

import com.example.demo.entity.DTO.Conference;
import com.example.demo.entity.DTO.ConferenceInfo;
import com.example.demo.entity.VO.MeetingBase;
import com.example.demo.service.mehod.ConferenceInfoService;
import com.example.demo.service.mehod.ConferenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


@Controller
public class AlterMeeting {

    @Autowired
    ConferenceService conferenceService;

    @Autowired
    ConferenceInfoService conferenceInfoService;

    @ResponseBody
    @RequestMapping("/AlterMeeting")
    public String AlterMeeting(MeetingBase meetingBase){
        Conference conference=conferenceService.queryConferenceByID(meetingBase.getId());
        ConferenceInfo conferenceInfo=conferenceInfoService.queryConferenceInfoByID(meetingBase.getId());
        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        try{
            conference.setName(meetingBase.getName());
            conference.setBeginTime(LocalDateTime.parse(meetingBase.getBeginTime(),df));
            conference.setEndTime(LocalDateTime.parse(meetingBase.getEndTime(),df));
            conference.setAddress(meetingBase.getAddress());
            conferenceInfo.setInfo(meetingBase.getRemark());
            conferenceService.saveConference(conference);
            conferenceInfoService.saveConferenceInfo(conferenceInfo);
            return "success";
        }catch(Exception e){
            return "fail";
        }
    }
}

/*
meetingBase:{
        id:2
        name:芜湖会议
        beginTime:2020-12-21 13:09:10
        endTime:2020-12-22 13:09:10
        address:芜湖飞机场
        remark:肉蛋葱鸡
        }*/
