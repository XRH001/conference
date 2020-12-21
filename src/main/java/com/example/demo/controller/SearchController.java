package com.example.demo.controller;

import com.example.demo.entity.DTO.Conference;
import com.example.demo.entity.VO.Meeting;
import com.example.demo.service.mehod.ConferenceService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Controller
public class SearchController {

    @Autowired
    ConferenceService conferenceService;

    @ResponseBody
    @RequestMapping("/SearchMeeting")

    public String SearchMeeting(HttpServletRequest request) throws JsonProcessingException {

        ObjectMapper mapper=new ObjectMapper();

        HashMap<String,String> empty=new HashMap<>(2);
        empty.put("msg","empty");

        String Null = mapper.writeValueAsString(empty);

        HashMap<String,Object> meeting=new HashMap<>(2);
        meeting.put("msg","success");

        try {
            int ID = Integer.parseInt(request.getParameter("search"));       //获取欲查询的会议ID
            Conference conference=conferenceService.queryConferenceByID(ID);//获取查询到的会议对象

            if(conference==null)
                return Null;           //返回查询失败，没有该会议

            List<Meeting> IDMeeting=new ArrayList<>();
            IDMeeting.add(new Meeting(conference));

            meeting.put("searchMeetings",IDMeeting);
            String Meeting = mapper.writeValueAsString(meeting);
            return Meeting;

        }catch(Exception e){
            String name=request.getParameter("search");
            List<Conference> conferences=conferenceService.queryConferencesByName(name);

            if(conferences==null)
                return Null;                                    //返回查询失败，没有该会议

            List<Meeting> searchMeeting=new ArrayList<>();
            for(int i=0;i<conferences.size();i++){
                searchMeeting.add(new Meeting(conferences.get(i)));
            }
            meeting.put("searchMeetings",searchMeeting);
            String Meeting = mapper.writeValueAsString(meeting);
            return Meeting;
        }
    }
}
