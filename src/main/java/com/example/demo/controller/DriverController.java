package com.example.demo.controller;

import com.example.demo.entity.DTO.*;
import com.example.demo.entity.Driver;
import com.example.demo.entity.VO.*;
import com.example.demo.enumValue.OrderStatus;
import com.example.demo.service.mehod.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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
            int pageNum=Integer.valueOf(request.getParameter("pageNum"))-1;
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
            //System.err.println("meetingId:"+meetingId);
            List<UserJourney> userJourneyList=userJourneyService.queryUserJourneysByConference(conferenceService.queryConferenceByID(meetingId));
            //System.err.println("userJourneyList:"+userJourneyList);
            List<DriverAndState> list=new ArrayList<>();
            for(UserJourney userJourney:userJourneyList){
                DriverPickUp driverPickUp=driverPickUpService.queryDriverPickUpByUserJourney(userJourney);
                if (driverPickUp!=null){
                    list.add(new DriverAndState(driverPickUp.getDriver(),driverPickUp.getOrderStatus()));
                }
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
            //System.err.println(journey);
            List<UserJourney> userJourneyList=userJourneyService.queryUserJourneysByConference(conferenceService.queryConferenceByID(meetingId));
            for (UserJourney userJourney:userJourneyList){
                DriverPickUp driverPickUp=driverPickUpService.queryDriverPickUpByUserJourney(userJourney);
                if (driverPickUp!=null&&driverPickUp.getDriver().getID()==driverId){
                    journey.setID(driverPickUp.getUserJourney().getJourney().getID());
                    journeyService.saveJourney(journey);
                    msg.put("msg","success");
                    return msg;
                }
            }
            Journey queryJourney=journeyService.queryJourneyDOByOriginAndTargetAndTime(origin,target,time);
            if (queryJourney!=null&&queryJourney.equals(journey)){
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
        DateTimeFormatter dtf= DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        try {
            int meetingId=Integer.valueOf(request.getParameter("meetingId"));
            int driverId=Integer.valueOf(request.getParameter("driverId"));
            //System.err.println(meetingId);
            //System.err.println(driverId);
            Journey journey=new Journey();
            List<DriverPickUp> driverPickUpList=driverPickUpService.queryDriverPickUpSByDriver(driverService.queryDriverByID(driverId));
            for (DriverPickUp driverPickUp:driverPickUpList){
                if(driverPickUp.getUserJourney().getConference().getID()==meetingId){
                    journey=driverPickUp.getUserJourney().getJourney();
                   // LocalDateTime time=journey.getTime();
                   // journey.setTime(LocalDateTime.of(time.getYear(),time.getMonthValue(),time.getDayOfMonth(),time.getHour(),time.getMinute(),1));
                }
            }
            msg.put("msg","success");
            msg.put("origin",journey.getorigin());
            msg.put("target",journey.getTarget());
            msg.put("time",journey.getTime().format(dtf).replace("T"," "));
            //System.err.println(journey.getTime());

        }catch (NullPointerException|NumberFormatException e){
            e.printStackTrace();
            msg.put("msg","fail");
        }
        return msg;
    }
    @ResponseBody
    @RequestMapping("/driverLogin")
    public Map driverLogin(HttpServletRequest request){
        Map<String,Object> msg=new HashMap<>(4);

        try {
            String email=request.getParameter("email");
            String password=request.getParameter("password");

            Driver driver=driverService.queryDriverByEmail(email);
            if (driver==null){
                msg.put("msg","empty");
            }else {
                msg.put("driver",driver);
                List<DriverPickUp> driverPickUpList=driverPickUpService.queryDriverPickUpSByDriver(driver);

                List<UserJourney> acceptedUserJourney=new ArrayList<>();
                List<UserJourney> alreadyUserJourney=new ArrayList<>();
                List<UserJourney> needUserJourney=new ArrayList<>();

                for (DriverPickUp driverPickUp:driverPickUpList){
                    switch (driverPickUp.getOrderStatus()){
                        case Ready:acceptedUserJourney.add(driverPickUp.getUserJourney());break;//1
                        case Finished:alreadyUserJourney.add(driverPickUp.getUserJourney());break;//3
                        case Checking:needUserJourney.add(driverPickUp.getUserJourney());break;//0
                        default:
                            msg.put("msg","fail");
                            return msg;
                    }
                }
                //List<UserJourney> userJourneyList=new ArrayList<>();
                List<MeetingBasedJourney> accepted=generateMeetingBasedJourneyList(acceptedUserJourney);
                List<MeetingBasedJourney> already=generateMeetingBasedJourneyList(alreadyUserJourney);
                List<MeetingBasedJourney> need=generateMeetingBasedJourneyList(needUserJourney);

                Map<String,List> meetings=new HashMap<>();
                meetings.put("accepted",accepted);
                meetings.put("already",already);
                meetings.put("need",need);

                msg.put("meetings",meetings);
                return msg;
            }

        }catch (NullPointerException|NumberFormatException e){
            e.printStackTrace();
            msg.put("msg","fail");
        }
        return msg;

    }

    @ResponseBody
    @RequestMapping("/driverAccept")
    public Map acceptInvitation(HttpServletRequest request){
        Map<String,Object> msg=new HashMap<>(2);
        try {
            int meetingId=Integer.valueOf(request.getParameter("meetingId"));
            int driverId=Integer.valueOf(request.getParameter("driverId"));
            msg.put("msg","fail");

            List<DriverPickUp> driverPickUpList=driverPickUpService.queryDriverPickUpSByDriver(driverService.queryDriverByID(driverId));
            for (DriverPickUp driverPickUp:driverPickUpList){
                if (driverPickUp.getUserJourney().getConference().getID()==meetingId&&driverPickUp.getOrderStatus()==OrderStatus.Checking){
                    driverPickUp.setOrderStatus(OrderStatus.Ready);
                    driverPickUpService.saveDriverPickUp(driverPickUp);
                    msg.put("msg","success");
                    break;
                }
            }

        }catch (NullPointerException e){
            msg.put("msg","fail");
        }
        return msg;
    }

    @ResponseBody
    @RequestMapping("/driverReject")
    public Map refuseInvitation(HttpServletRequest request){
        Map<String,Object> msg=new HashMap<>(2);
        try {
            int meetingId=Integer.valueOf(request.getParameter("meetingId"));
            int driverId=Integer.valueOf(request.getParameter("driverId"));
            msg.put("msg","fail");

            List<DriverPickUp> driverPickUpList=driverPickUpService.queryDriverPickUpSByDriver(driverService.queryDriverByID(driverId));
            for (DriverPickUp driverPickUp:driverPickUpList){
                if (driverPickUp.getUserJourney().getConference().getID()==meetingId&&driverPickUp.getOrderStatus()==OrderStatus.Ready){
                    driverPickUp.setOrderStatus(OrderStatus.Checking);
                    driverPickUpService.saveDriverPickUp(driverPickUp);
                    msg.put("msg","success");
                    break;
                }
            }

        }catch (NullPointerException e){
            msg.put("msg","fail");
        }
        return msg;
    }

    @ResponseBody
    @RequestMapping("/driverFinish")
    public Map finishInvitation(HttpServletRequest request){
        Map<String,Object> msg=new HashMap<>(2);
        try {
            int meetingId=Integer.valueOf(request.getParameter("meetingId"));
            int driverId=Integer.valueOf(request.getParameter("driverId"));
            msg.put("msg","fail");

            List<DriverPickUp> driverPickUpList=driverPickUpService.queryDriverPickUpSByDriver(driverService.queryDriverByID(driverId));
            for (DriverPickUp driverPickUp:driverPickUpList){
                if (driverPickUp.getUserJourney().getConference().getID()==meetingId&&driverPickUp.getOrderStatus()==OrderStatus.Ready){
                    driverPickUp.setOrderStatus(OrderStatus.Finished);
                    driverPickUpService.saveDriverPickUp(driverPickUp);
                    msg.put("msg","success");
                    break;
                }
            }
        }catch (NullPointerException e){
            msg.put("msg","fail");
        }
        return msg;
    }

    public List<MeetingBasedJourney> generateMeetingBasedJourneyList(List<UserJourney> userJourneyList){
        List<ConferenceJourney> conferenceJourneyList=new ArrayList<>();
        List<ConferenceJourneyAndUserList> conferenceJourneyAndUserList=new ArrayList<>();

        for (UserJourney userJourney:userJourneyList){
            ConferenceJourney conferenceJourney=new ConferenceJourney(userJourney.getConference(),userJourney.getJourney());
            if (!conferenceJourneyList.contains(conferenceJourney)) {
                conferenceJourneyList.add(conferenceJourney);
            }
        }

        for (ConferenceJourney conferenceJourney:conferenceJourneyList){
            conferenceJourneyAndUserList.add(new ConferenceJourneyAndUserList(conferenceJourney.getConference(),conferenceJourney.getJourney()));
        }

        for (UserJourney userJourney:userJourneyList){
            ConferenceJourney conferenceJourney=new ConferenceJourney(userJourney.getConference(),userJourney.getJourney());
            int index=conferenceJourneyList.indexOf(conferenceJourney);
            conferenceJourneyAndUserList.get(index).getUserList().add(userJourney.getUser());
        }

        List<MeetingBasedJourney> list=new ArrayList<>();

        for (ConferenceJourneyAndUserList conferenceJourneyAndUserList1:conferenceJourneyAndUserList){
            list.add(toMeetingBasedJourney(conferenceJourneyAndUserList1.getUserList(),conferenceJourneyAndUserList1.getConference(),conferenceJourneyAndUserList1.getJourney()));
        }

        return list;
    }

    public MeetingBasedJourney toMeetingBasedJourney(List<User> userList,Conference conference,Journey journey){
        MeetingBasedJourney meetingBasedJourney=new MeetingBasedJourney();
        Passenger passenger;

        meetingBasedJourney.setJourney(journey);
        meetingBasedJourney.setConferenceName(conference.getName());
        meetingBasedJourney.setBeginTime(conference.getBeginTime());
        meetingBasedJourney.setAddress(conference.getAddress());
        meetingBasedJourney.setConferenceID(conference.getID());
        for (User user:userList){
            passenger=new Passenger(user.getUsername(),user.getID(),user.getPhone());
            meetingBasedJourney.getPassenger().add(passenger);
        }

        return meetingBasedJourney;
    }


}
