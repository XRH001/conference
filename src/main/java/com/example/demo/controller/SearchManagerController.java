package com.example.demo.controller;

import com.example.demo.entity.DTO.Conference;
import com.example.demo.entity.DTO.ConferenceUser;
import com.example.demo.entity.DTO.User;
import com.example.demo.entity.VO.User_SearchManage;
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
import java.util.ArrayList;
import java.util.List;

import static com.example.demo.enumValue.Position.administrator;

@Controller
public class SearchManagerController {
    @Autowired
    UserService userService;

    @Autowired
    ConferenceUserService conferenceUserService;

    @Autowired
    ConferenceService conferenceService;

    @ResponseBody
    @RequestMapping("/SearchManager")
    public String SearchManager(HttpServletRequest request) throws JsonProcessingException {

        int meetingID = Integer.parseInt(request.getParameter("meetingId"));
        Conference conference=conferenceService.queryConferenceByID(meetingID);
        List<ConferenceUser> conferenceUsers=conferenceUserService.queryConferenceUsersByConference(conference);
        ObjectMapper mapper = new ObjectMapper();

        try {
            int search = Integer.parseInt(request.getParameter("search"));
            if(userService.queryUserByID(search)==null)
                return "error";
            User user = userService.queryUserByID(search);
            List<User_SearchManage> information=new ArrayList<>();
            User_SearchManage user_searchManage = null;
            for(ConferenceUser item:conferenceUsers)
                if(item.getPosition().equals(administrator)){
                    user_searchManage=new User_SearchManage(item.getUser());
                    user_searchManage.setIfManager(true);
                    information.add(user_searchManage);
                }
            if(information.size()==0) {
                user_searchManage = new User_SearchManage(user);
                user_searchManage.setIfManager(false);
                information.add(user_searchManage);
            }
            String userJson = mapper.writeValueAsString(information);
            return userJson;
        }catch(Exception e){
            String search = request.getParameter("search");
            if(userService.queryUserByEmail(search) == null)
                return "error";
            User user = userService.queryUserByEmail(search);
            List<User_SearchManage> information=new ArrayList<>();
            User_SearchManage user_searchManage = null;
            for(ConferenceUser item:conferenceUsers)
                if(item.getPosition().equals(administrator)){
                    user_searchManage=new User_SearchManage(item.getUser());
                    user_searchManage.setIfManager(true);
                    information.add(user_searchManage);
                }
            if(information.size()==0) {
                user_searchManage = new User_SearchManage(user);
                user_searchManage.setIfManager(false);
                information.add(user_searchManage);
            }
            String userJson = mapper.writeValueAsString(information);
            return userJson;
        }
    }
}
