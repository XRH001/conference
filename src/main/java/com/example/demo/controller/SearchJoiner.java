package com.example.demo.controller;

import com.example.demo.entity.DTO.Conference;
import com.example.demo.entity.DTO.ConferenceUser;
import com.example.demo.entity.DTO.User;
import com.example.demo.entity.VO.User_SearchUser;
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

@Controller
public class SearchJoiner {
    @Autowired
    UserService userService;

    @Autowired
    ConferenceUserService conferenceUserService;

    @Autowired
    ConferenceService conferenceService;

    @ResponseBody
    @RequestMapping("/SearchJoiner")
    public String SearchJoiner(HttpServletRequest request) throws JsonProcessingException {

        int meetingID = Integer.parseInt(request.getParameter("meetingId"));
        Conference conference=conferenceService.queryConferenceByID(meetingID);
        List<ConferenceUser> conferenceUsers=conferenceUserService.queryConferenceUsersByConference(conference);
        ObjectMapper mapper = new ObjectMapper();

        try {
            int search = Integer.parseInt(request.getParameter("search"));
            if(userService.queryUserByID(search)==null)
                return "error";
            User user = userService.queryUserByID(search);
            List<User_SearchUser> information=new ArrayList<>();
            User_SearchUser user_searchUser = null;
            for(ConferenceUser item:conferenceUsers)
                if(item.getUser().equals(user)){
                    user_searchUser=new User_SearchUser(item.getUser());
                    user_searchUser.setHaveJoin(true);
                    information.add(user_searchUser);
                }
            if(information.size()==0) {
                user_searchUser = new User_SearchUser(user);
                user_searchUser.setHaveJoin(false);
                information.add(user_searchUser);
            }
            String userJson = mapper.writeValueAsString(information);
            return userJson;
        }catch(Exception e){
            String search = request.getParameter("search");
            if(userService.queryUserByEmail(search) == null)
                return "error";
            User user = userService.queryUserByEmail(search);
            List<User_SearchUser> information=new ArrayList<>();
            User_SearchUser user_searchUser = null;
            for(ConferenceUser item:conferenceUsers)
                if(item.getUser().equals(user)){
                    user_searchUser=new User_SearchUser(item.getUser());
                    user_searchUser.setHaveJoin(true);
                    information.add(user_searchUser);
                }
            if(information.size()==0) {
                user_searchUser = new User_SearchUser(user);
                user_searchUser.setHaveJoin(false);
                information.add(user_searchUser);
            }
            String userJson = mapper.writeValueAsString(information);
            return userJson;
        }
    }
}
