package com.example.demo.controller;

import com.example.demo.entity.DTO.*;
import com.example.demo.entity.VO.MeetingJoiner;
import com.example.demo.service.mehod.ConferenceService;
import com.example.demo.service.mehod.ConferenceUserService;
import com.example.demo.service.mehod.UserJourneyService;
import com.example.demo.service.mehod.UserService;
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

import static com.example.demo.enumValue.Position.creator;
import static com.example.demo.enumValue.Position.ordinary;

@Controller
public class LoadingController {

    @Autowired
    UserService userService;

    @Autowired
    ConferenceService conferenceService;

    @Autowired
    ConferenceUserService conferenceUserService;

    @Autowired
    UserJourneyService userJourneyService;

    @ResponseBody
    @RequestMapping("/Loading")
    public String Details(HttpServletRequest request) throws JsonProcessingException {

        int MeetingID = Integer.parseInt(request.getParameter("meetingId"));
        int UserID = Integer.parseInt(request.getParameter("userId"));

        if (conferenceService.queryConferenceByID(MeetingID) == null)
            return "error";

        Conference conference = conferenceService.queryConferenceByID(MeetingID);
        List<ConferenceUser> conferenceUser=conferenceUserService.queryConferenceUsersByConference(conference);
        List<ConferenceUser> manager=new ArrayList<>();
        List<ConferenceUser> member=new ArrayList<>();

        for(ConferenceUser item:conferenceUser)
            if(item.getPosition()==ordinary)
                member.add(item);
            else manager.add(item);

        ArrayList<MeetingJoiner> memberInfo=new ArrayList<>();
        for(int i=0;i< member.size();i++) {
            memberInfo.add(new MeetingJoiner(member.get(i)));
        }

        ArrayList<MeetingJoiner> managerInfo=new ArrayList<>();
        for(int i=0;i<manager.size();i++){
            managerInfo.add(new MeetingJoiner(manager.get(i)));
        }

        User user = userService.queryUserByID(UserID);
        ObjectMapper mapper = new ObjectMapper();

        HashMap<String, Object> information = new HashMap<>(2);
        HashMap<String, Object> MeetingUser = new HashMap<>(2);

        information.put("managerInfo",managerInfo);
        information.put("memberInfo",memberInfo);

        if (UserID == 0) {
            try {
                information.put("meeting",conference);
                String userJson = mapper.writeValueAsString(information);
                return userJson;
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
        }

        if (userService.queryUserByID(UserID) == null)
            return "error";

        Journey journey=new Journey();
        List<UserJourney> userJourney = userJourneyService.queryUserJourneysByUser(user);
        for (UserJourney item : userJourney)
            if (item.getConference().equals(conference))
                journey=item.getJourney();

        if (conferenceUserService.queryConferenceUserByID(UserID).getPosition() == creator) {
            MeetingUser.put("ifJoin", "NO");
            MeetingUser.put("ifCreator","YES");
            information.put("meeting", conference);
            information.put("meetingUser", MeetingUser);
            String userJson = mapper.writeValueAsString(information);
            return userJson;
        } else {
            MeetingUser.put("ifJoin", "NO");
            MeetingUser.put("ifCreator","NO");
            MeetingUser.put("journey", journey);
            information.put("meeting", conference);
            information.put("meetingUser", MeetingUser);
            String userJson = mapper.writeValueAsString(information);
            return userJson;
        }
    }
}
