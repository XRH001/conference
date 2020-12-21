package com.example.demo.controller;

import com.example.demo.entity.DTO.*;
import com.example.demo.entity.Driver;
import com.example.demo.service.mehod.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
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
//    @ResponseBody
//    @RequestMapping("/queryDriversByConference")
//    public Map queryDriversByConference(HttpServletRequest request){
//        Map<String,Object> msg=new HashMap<>(2);
//        try {
//            int meetingId=Integer.valueOf(request.getParameter("meetingId"));
//            List<UserJourney> userJourneyList=userJourneyService.queryUserJourneysByConference(conferenceService.queryConferenceByID(meetingId));
//            List<DriverPickUp> driverPickUpList=new ArrayList<>();
//            for(UserJourney userJourney:userJourneyList){
//
//            }
//            List<Driver> list=driverService.queryDriversByNameContainingOrCarNumContainingOrPhoneContainingOrEmailContaining(input);
//            msg.put("msg","success");
//            msg.put("driverList",list);
//        }catch (NullPointerException|NumberFormatException e){
//            msg.put("msg","fail");
//        }
//        return msg;
//    }

}
