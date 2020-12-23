package com.example.demo.controller;

import com.example.demo.entity.DTO.*;
import com.example.demo.entity.Hotel;
import com.example.demo.enumValue.OrderStatus;
import com.example.demo.service.mehod.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class HotelController {

    @Autowired
    HotelService hotelService;
    @Autowired
    ConferenceService conferenceService;
    @Autowired
    ConferenceUserService conferenceUserService;
    @Autowired
    HotelOrderService hotelOrderService;
    @Autowired
    HotelRoomService hotelRoomService;
    @Autowired
    HotelAccommodationService hotelAccommodationService;

//    @ResponseBody
//    @RequestMapping({"/HotelJudge"})
//    public String HotelJudge(HttpServletRequest request) {
//
//        int hotelID = Integer.parseInt(request.getParameter("id"));
//        String password = request.getParameter("password");//id和密码
//
//        if (this.hotelService.queryHotelByID(hotelID) == null) {
//            return "empty";//id不存在
//        }
//
//        Hotel hotel = this.hotelService.queryHotelByID(hotelID);
//
//        if(!password.equals(hotel.getPassword())){
//            return "error";
//        }
//         else{
//             List<HotelRoom> hotelRoomList=hotelRoomService.queryHotelRoomSByHotel(hotelService.queryHotelByID(hotelID));
//
//             List<HotelOrder> hotelOrderList=new ArrayList<>();
//             for (int i=0;i<hotelRoomList.size();i++){
//                 HotelRoom hotelRoom=(HotelRoom)hotelRoomList.get(i);
//                 hotelOrderList.add(hotelOrderService.queryHotelOrderSByHotelRoom(hotelRoom).get(i));
//             }
//             //Accommodation用户行程
//             List<HotelAccommodation> resHotelAccommodationList=new ArrayList<>();
//             List<HotelAccommodation> accHotelAccommodationList=new ArrayList<>();
//             List<HotelAccommodation> comHotelAccommodationList=new ArrayList<>();
//             for (int j=0;j<hotelOrderList.size();j++){
//                 HotelOrder hotelOrder=hotelOrderList.get(j);
//                 if (hotelOrder.getOrderStatus()== OrderStatus.Ready)
//                     resHotelAccommodationList.add(hotelAccommodationService.queryHotelAccommodationSByHotelOrder(hotelOrder).get(j));
//                 else if (hotelOrder.getOrderStatus()== OrderStatus.Running)
//                     accHotelAccommodationList.add(hotelAccommodationService.queryHotelAccommodationSByHotelOrder(hotelOrder).get(j));
//                 else if (hotelOrder.getOrderStatus()== OrderStatus.Finished)
//                     comHotelAccommodationList.add(hotelAccommodationService.queryHotelAccommodationSByHotelOrder(hotelOrder).get(j));
//             }
//             List<Conference> reserve=new ArrayList<>();
//             List<Conference> Accept=new ArrayList<>();
//             List<Conference> completed=new ArrayList<>();
//             for (int k=0;k<resHotelAccommodationList.size();k++)
//
//
//            //List<HotelOrder> hotelOrderList=hotelOrderService.queryHotelOrderSByHotelRoom();
//            //for (int i=0;i<)
//
//
//        }
//    }

    @ResponseBody
    @RequestMapping({"/acceptHotelOrder"})
    public Map<String, Object> AcceptHotelOrder(HttpServletRequest request) {
        Map<String, Object> msg = new HashMap<>(1);
        try {
            int meetingId = Integer.parseInt(request.getParameter("meetingId"));
            int hotelId = Integer.parseInt(request.getParameter("hotelId"));

            List<ConferenceUser> conferenceUserList = conferenceUserService.queryConferenceUsersByConference(conferenceService.queryConferenceByID(meetingId));
            List<HotelRoom> hotelRoomList = hotelRoomService.queryHotelRoomSByHotel(hotelService.queryHotelByID(hotelId));
            List<HotelOrder> chotelOrderList = new ArrayList<>();
            //HotelAccommodation hotelAccommodation=new HotelAccommodation();
            for (ConferenceUser conferenceUser : conferenceUserList) {
                chotelOrderList.add(hotelAccommodationService.queryHotelAccommodationByConferenceUser(conferenceUser).getHotelOrder());
            }//从会议得到order

            List<HotelOrder> hhotelOrderList = new ArrayList<>();
            //List<HotelOrder> mhotelOrderList = new ArrayList<>();
            for (HotelRoom hotelRoom : hotelRoomList) {
                if (hotelOrderService.queryHotelOrderSByHotelRoom(hotelRoom) == null)
                    break;
                //mhotelOrderList = hotelOrderService.queryHotelOrderSByHotelRoom(hotelRoom);
                //System.out.println(hotelRoom);
                hhotelOrderList.addAll(hotelOrderService.queryHotelOrderSByHotelRoom(hotelRoom));
                //hhotelOrderList.addAll(mhotelOrderList);
            }
            List<HotelOrder> hotelOrderList = new ArrayList<>();
            for (HotelOrder hotelOrder : hhotelOrderList) {
                for (HotelOrder order : chotelOrderList) {
                    if (hotelOrder.getID() == order.getID()) {
                        hotelOrderList.add(order);
                    }
                }
            }
            for (HotelOrder hotelOrder : hotelOrderList) {
                if (hotelOrder.getOrderStatus() == OrderStatus.Checking)
                    hotelOrder.setOrderStatus(OrderStatus.Ready);
                hotelOrderService.saveHotelOrder(hotelOrder);
            }
            //System.out.print(hotelOrderList);
            //return "success";
            msg.put("msg","success");
        }catch (NullPointerException e){
            msg.put("msg","fail");
        }return msg;
    }

    @ResponseBody
    @RequestMapping({"/confuseHotelOrder"})
    public Map<String, Object> ConfuseHotelOrder(HttpServletRequest request) {
        Map<String, Object> msg = new HashMap<>(1);
        try {
            int meetingId = Integer.parseInt(request.getParameter("meetingId"));
            int hotelId = Integer.parseInt(request.getParameter("hotelId"));

            List<ConferenceUser> conferenceUserList = conferenceUserService.queryConferenceUsersByConference(conferenceService.queryConferenceByID(meetingId));
            List<HotelRoom> hotelRoomList = hotelRoomService.queryHotelRoomSByHotel(hotelService.queryHotelByID(hotelId));
            List<HotelOrder> chotelOrderList = new ArrayList<>();
            //HotelAccommodation hotelAccommodation=new HotelAccommodation();
            for (ConferenceUser conferenceUser : conferenceUserList) {
                chotelOrderList.add(hotelAccommodationService.queryHotelAccommodationByConferenceUser(conferenceUser).getHotelOrder());
            }//从会议得到order

            List<HotelOrder> hhotelOrderList = new ArrayList<>();
            //List<HotelOrder> mhotelOrderList = new ArrayList<>();
            for (HotelRoom hotelRoom : hotelRoomList) {
                if (hotelOrderService.queryHotelOrderSByHotelRoom(hotelRoom) == null)
                    break;
                //mhotelOrderList = hotelOrderService.queryHotelOrderSByHotelRoom(hotelRoom);
                //System.out.println(hotelRoom);
                hhotelOrderList.addAll(hotelOrderService.queryHotelOrderSByHotelRoom(hotelRoom));
                //hhotelOrderList.addAll(mhotelOrderList);
            }
            List<HotelOrder> hotelOrderList = new ArrayList<>();
            for (HotelOrder hotelOrder : hhotelOrderList) {
                for (HotelOrder order : chotelOrderList) {
                    if (hotelOrder.getID() == order.getID()) {
                        hotelOrderList.add(order);
                    }
                }
            }
            for (HotelOrder hotelOrder : hotelOrderList) {
                if (hotelOrder.getOrderStatus() == OrderStatus.Checking)
                    hotelOrder.setOrderStatus(OrderStatus.Block);
                hotelOrderService.saveHotelOrder(hotelOrder);
            }
            //System.out.print(hotelOrderList);
            //return "success";
            msg.put("msg","success");
        }catch (NullPointerException e){
            msg.put("msg","fail");
        }return msg;
    }

    @ResponseBody
    @RequestMapping({"/completeHotelOrder"})
    public Map<String, Object> CompleteHotelOrder(HttpServletRequest request) {
        Map<String, Object> msg = new HashMap<>(1);
        try {
            int meetingId = Integer.parseInt(request.getParameter("meetingId"));
            int hotelId = Integer.parseInt(request.getParameter("hotelId"));

            List<ConferenceUser> conferenceUserList = conferenceUserService.queryConferenceUsersByConference(conferenceService.queryConferenceByID(meetingId));
            List<HotelRoom> hotelRoomList = hotelRoomService.queryHotelRoomSByHotel(hotelService.queryHotelByID(hotelId));
            List<HotelOrder> chotelOrderList = new ArrayList<>();
            //HotelAccommodation hotelAccommodation=new HotelAccommodation();
            for (ConferenceUser conferenceUser : conferenceUserList) {
                chotelOrderList.add(hotelAccommodationService.queryHotelAccommodationByConferenceUser(conferenceUser).getHotelOrder());
            }//从会议得到order

            List<HotelOrder> hhotelOrderList = new ArrayList<>();
            //List<HotelOrder> mhotelOrderList = new ArrayList<>();
            for (HotelRoom hotelRoom : hotelRoomList) {
                if (hotelOrderService.queryHotelOrderSByHotelRoom(hotelRoom) == null)
                    break;
                //mhotelOrderList = hotelOrderService.queryHotelOrderSByHotelRoom(hotelRoom);
                //System.out.println(hotelRoom);
                hhotelOrderList.addAll(hotelOrderService.queryHotelOrderSByHotelRoom(hotelRoom));
                //hhotelOrderList.addAll(mhotelOrderList);
            }
            List<HotelOrder> hotelOrderList = new ArrayList<>();
            for (HotelOrder hotelOrder : hhotelOrderList) {
                for (HotelOrder order : chotelOrderList) {
                    if (hotelOrder.getID() == order.getID()) {
                        hotelOrderList.add(order);
                    }
                }
            }
            for (HotelOrder hotelOrder : hotelOrderList) {
                if (hotelOrder.getOrderStatus() == OrderStatus.Ready)
                    hotelOrder.setOrderStatus(OrderStatus.Finished);
                hotelOrderService.saveHotelOrder(hotelOrder);
            }
            //System.out.print(hotelOrderList);
            //return "success";
            msg.put("msg","success");
        }catch (NullPointerException e){
            msg.put("msg","fail");
        }return msg;
    }

}
