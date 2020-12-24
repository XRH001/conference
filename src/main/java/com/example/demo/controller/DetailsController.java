package com.example.demo.controller;

import com.example.demo.entity.DTO.*;
import com.example.demo.entity.Driver;
import com.example.demo.entity.VO.DriverBasedJourney;
import com.example.demo.entity.VO.Meeting;
import com.example.demo.entity.VO.MeetingJoiner;
import com.example.demo.service.mehod.*;
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
import java.util.Map;

import static com.example.demo.enumValue.Position.ordinary;

@Controller
public class DetailsController {

    @Autowired
    UserService userService;

    @Autowired
    ConferenceService conferenceService;

    @Autowired
    ConferenceUserService conferenceUserService;

    @Autowired
    UserJourneyService userJourneyService;
    @Autowired
    DriverPickUpService driverPickUpService;

    @ResponseBody
    @RequestMapping("/Details")
    public String Details(HttpServletRequest request) throws JsonProcessingException {
        int MeetingID = Integer.parseInt(request.getParameter("meetingId"));//这里有问题
        int UserID = Integer.parseInt(request.getParameter("userId"));

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

        if (conferenceService.queryConferenceByID(MeetingID) == null)
            return "error";
        if (userService.queryUserByID(UserID) == null)
            return "error";

        Journey journey=new Journey();
        List<UserJourney> userJourney = userJourneyService.queryUserJourneysByUser(user);
        for (UserJourney item : userJourney)//这里有问题
            if (item.getConference().equals(conference))
                journey=item.getJourney();

        if (conferenceUserService.queryConferenceUserByID(UserID) == null) {
            MeetingUser.put("ifJoin", "NO");
            information.put("meeting", conference);
            information.put("meetingUser", MeetingUser);
            String userJson = mapper.writeValueAsString(information);
            return userJson;
        } else {
            MeetingUser.put("ifJoin", "YES");
            MeetingUser.put("journey", journey);
            information.put("meeting", conference);
            information.put("meetingUser", MeetingUser);
            String userJson = mapper.writeValueAsString(information);
            return userJson;
        }
    }

    @ResponseBody
    @RequestMapping("/remarks")
    public Map remarks(HttpServletRequest request){
        Map<Object,Object> msg=new HashMap<>();
        try {
            int userId=Integer.valueOf(request.getParameter("userId"));
            int meetingId=Integer.valueOf(request.getParameter("meetingId"));
            String info=request.getParameter("remark");
            Conference conference=conferenceService.queryConferenceByID(meetingId);
            msg.put("msg","fail");
            if (conference!=null){
                List<ConferenceUser> conferenceUserList=conferenceUserService.queryConferenceUsersByConference(conference);
                for (ConferenceUser conferenceUser:conferenceUserList){
                    if (conferenceUser.getUser().getID()==userId){
                        msg.put("msg","success");
                        conferenceUser.setInfo(info);
                        conferenceUserService.saveConferenceUser(conferenceUser);
                        break;
                    }
                }
            }
        }catch (NumberFormatException|NullPointerException e){
            msg.put("msg","fail");
        }
            return msg;
    }

    @ResponseBody
    @RequestMapping("/getRelateToMe")
    public Map getRelateToMe(HttpServletRequest request){
        Map<Object,Object> msg=new HashMap<>(2);
        try {
            int userId=Integer.valueOf(request.getParameter("userId"));
            int meetingId=Integer.valueOf(request.getParameter("meetingId"));
            UserJourney userJourney=null;
            Conference conference=conferenceService.queryConferenceByID(meetingId);
            User user=userService.queryUserByID(userId);
            List<UserJourney> userJourneyList=userJourneyService.queryUserJourneysByUser(user);

            msg.put("msg","fail");
            msg.put("driver",null);
            msg.put("info",null);
            if (userJourneyList!=null) {
                for (UserJourney u : userJourneyList) {
                    if (u.getConference().getID() == meetingId) {
                        userJourney = u;
                        break;
                    }
                }
                DriverPickUp driverPickUp = driverPickUpService.queryDriverPickUpByUserJourney(userJourney);
                if (driverPickUp != null) {
                    Driver driver = driverPickUp.getDriver();
                    Journey journey = userJourney.getJourney();
                    DriverBasedJourney driverBasedJourney = new DriverBasedJourney(driver.getName(), driver.getID(), driver.getCarNum(), driver.getPhone(), journey);
                    msg.put("driver", driverBasedJourney);
                }
            }
            if (conference!=null){
                List<ConferenceUser> conferenceUserList=conferenceUserService.queryConferenceUsersByConference(conference);

                for (ConferenceUser conferenceUser:conferenceUserList){
                    if (conferenceUser.getUser().getID()==userId){

                        msg.put("msg","success");
                        String info=conferenceUser.getInfo();
                        msg.put("info",info);
                        break;
                    }
                }
            }
        }catch (NumberFormatException|NullPointerException e){
            e.printStackTrace();
            msg.put("msg","fail");
        }
        return msg;
    }
}