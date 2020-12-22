package com.example.demo.controller;

import com.example.demo.entity.DTO.*;
import com.example.demo.entity.Driver;
import com.example.demo.entity.VO.DriverAndState;
import com.example.demo.enumValue.OrderStatus;
import com.example.demo.service.mehod.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.util.*;

@Controller
public class DriverController {
    @Autowired
    DriverService driverService;
    @Autowired
    UserJourneyService userJourneyService;
    @Autowired
    ConferenceService conferenceService;
    @Autowired
    DriverPickUpService driverPickUpService;
    @Autowired
    JourneyService journeyService;
    @Autowired
    UserService userService;

    @ResponseBody
    @RequestMapping("/loadDrivers")
    public Map load(HttpServletRequest request){
        Map<String,Object> msg=new HashMap<>(3);
        try {
            int pageNum=Integer.valueOf(request.getParameter("pageNum"));
            int lineNum=Integer.valueOf(request.getParameter("lineNum"));
            List<Driver> list=driverService.queryForPageItems(pageNum*lineNum,lineNum);
            msg.put("msg","success");
            msg.put("newDriverList",list);
            msg.put("pageTotal",driverService.queryForPageCountTotal()/lineNum+1);

        }catch (NumberFormatException | NullPointerException e){
            msg.put("msg","fail");
        }
        return msg;
    }
    @ResponseBody
    @RequestMapping("/queryDrivers")
    public Map queryDrivers(HttpServletRequest request){
        Map<String,Object> msg=new HashMap<>(2);
        try {
            String input=request.getParameter("input");
            List<Driver> list=driverService.queryDriversByNameContainingOrCarNumContainingOrPhoneContainingOrEmailContaining(input);
            msg.put("msg","success");
            msg.put("driverList",list);
        }catch (NullPointerException e){
            msg.put("msg","fail");
        }
        return msg;
    }
    @ResponseBody
    @RequestMapping("/queryDriversByConference")
    public Map queryDriversByConference(HttpServletRequest request){
        Map<String,Object> msg=new HashMap<>(2);
        try {
            int meetingId=Integer.valueOf(request.getParameter("meetingId"));
            List<UserJourney> userJourneyList=userJourneyService.queryUserJourneysByConference(conferenceService.queryConferenceByID(meetingId));
            //System.err.println(userJourneyList);
            List<DriverAndState> list=new ArrayList<>();
            for(UserJourney userJourney:userJourneyList){
                DriverPickUp driverPickUp=driverPickUpService.queryDriverPickUpByUserJourney(userJourney);
                list.add(new DriverAndState(driverPickUp.getDriver(),driverPickUp.getOrderStatus()));
            }
            msg.put("msg","success");
            msg.put("driverList",list);
            //System.err.println(msg);
            return msg;
        }catch (NullPointerException|NumberFormatException e){
            e.printStackTrace();
            msg.put("msg","fail");
            return msg;
        }

    }
    @ResponseBody
    @RequestMapping("/orderDriver")
    public Map orderDriver(HttpServletRequest request){
        Map<String,Object> msg=new HashMap<>(1);
        try {
            int meetingId=Integer.valueOf(request.getParameter("meetingId"));
            int driverId=Integer.valueOf(request.getParameter("driverId"));
            int userId=Integer.valueOf(request.getParameter("userId"));

            String origin=request.getParameter("origin");
            String target=request.getParameter("target");
            String timeStr =request.getParameter("time");

            String[] s1=timeStr.split(" ");
            String[] s2=s1[0].split("-");
            String[] s3=s1[1].split(":");

            LocalDateTime time=LocalDateTime.of(Integer.valueOf(s2[0]),Integer.valueOf(s2[1]),Integer.valueOf(s2[2]),Integer.valueOf(s3[0]),Integer.valueOf(s3[1]),Integer.valueOf(s3[2]));

            Journey journey=new Journey(driverId,time,origin,target);
            System.err.println(journey);
            List<UserJourney> userJourneyList=userJourneyService.queryUserJourneysByConference(conferenceService.queryConferenceByID(meetingId));
            for (UserJourney userJourney:userJourneyList){
                DriverPickUp driverPickUp=driverPickUpService.queryDriverPickUpByUserJourney(userJourney);
                if (driverPickUp.getDriver().getID()==driverId){
                    journey.setID(driverPickUp.getUserJourney().getJourney().getID());
                    journeyService.saveJourney(journey);
                    msg.put("msg","success");
                    return msg;
                }
            }
            if (journeyService.queryJourneyDOByOriginAndTargetAndTime(origin,target,time).equals(journey)){
                journey.setID(journeyService.queryJourneyDOByOriginAndTargetAndTime(origin,target,time).getID());
            }
            journeyService.saveJourney(journey);
            UserJourney userJourney=userJourneyService.saveUserJourney(new UserJourney(userService.queryUserByID(userId),journey,conferenceService.queryConferenceByID(meetingId)));
            driverPickUpService.saveDriverPickUp(new DriverPickUp(driverService.queryDriverByID(driverId),userJourney, OrderStatus.Checking));
            msg.put("msg","success");
            return msg;


        }catch (NullPointerException|NumberFormatException e){
            e.printStackTrace();
            msg.put("msg","fail");
            return msg;
        }
    }
    @ResponseBody
    @RequestMapping("/queryJourney")
    public Map queryJourney(HttpServletRequest request){
        Map<String,Object> msg=new HashMap<>(4);
        try {
            int meetingId=Integer.valueOf(request.getParameter("meetingId"));
            int driverId=Integer.valueOf(request.getParameter("driverId"));
            System.err.println(meetingId);
            System.err.println(driverId);
            Journey journey=new Journey();
            List<DriverPickUp> driverPickUpList=driverPickUpService.queryDriverPickUpSByDriver(driverService.queryDriverByID(driverId));
            for (DriverPickUp driverPickUp:driverPickUpList){
                if(driverPickUp.getUserJourney().getConference().getID()==meetingId){
                    journey=driverPickUp.getUserJourney().getJourney();
                }
            }
            msg.put("msg","success");
            msg.put("origin",journey.getorigin());
            msg.put("target",journey.getTarget());
            msg.put("time",journey.getTime());

        }catch (NullPointerException|NumberFormatException e){
            e.printStackTrace();
            msg.put("msg","fail");
        }
        return msg;
    }


}
