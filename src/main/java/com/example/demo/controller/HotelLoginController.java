package com.example.demo.controller;

import com.example.demo.entity.DTO.Conference;
import com.example.demo.entity.DTO.HotelAccommodation;
import com.example.demo.entity.DTO.HotelOrder;
import com.example.demo.entity.DTO.HotelRoom;
import com.example.demo.entity.Hotel;
import com.example.demo.entity.VO.HotelDetails;
import com.example.demo.entity.VO.Meeting;
import com.example.demo.entity.VO.MeetingHotel;
import com.example.demo.service.mehod.HotelAccommodationService;
import com.example.demo.service.mehod.HotelOrderService;
import com.example.demo.service.mehod.HotelRoomService;
import com.example.demo.service.mehod.HotelService;
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
public class HotelLoginController {

    @Autowired
    HotelService hotelService;

    @Autowired
    HotelRoomService hotelRoomService;

    @Autowired
    HotelOrderService hotelOrderService;

    @Autowired
    HotelAccommodationService hotelAccommodationService;

    @ResponseBody
    @RequestMapping("/HotelLogin")

    public String UserJudge(HttpServletRequest request) throws JsonProcessingException {

        int ID =  Integer.parseInt(request.getParameter("id"));
        String Password = request.getParameter("password");

        if((hotelService.queryHotelByID(ID)==null))
            return "{msg:'empty'}";
        if (!hotelService.queryHotelByID(ID).getPassword().equals(Password))
            return "{msg:'error'}";

        HashMap<String,Object> information=new HashMap<>(2);
        information.put("msg","'success'");

        HotelDetails hotel=new HotelDetails(hotelService.queryHotelByID(ID));

        Hotel hotel01=hotelService.queryHotelByID(ID);
        List<HotelRoom> hotelRooms=hotelRoomService.queryHotelRoomSByHotel(hotel01);
        List<HotelOrder> hotelOrders=new ArrayList<>();
        for(HotelRoom item:hotelRooms)
            if(hotelOrderService.queryHotelOrderSByHotelRoom(item)!=null){
            hotelOrders.addAll(hotelOrderService.queryHotelOrderSByHotelRoom(item));
            }
        List<HotelAccommodation> hotelAccommodations=new ArrayList<>();
        for(HotelOrder item:hotelOrders)
            hotelAccommodations.addAll(hotelAccommodationService.queryHotelAccommodationSByHotelOrder(item));
        List<Conference> conference=new ArrayList<>();
        for(HotelAccommodation item:hotelAccommodations)
            conference.add(item.getConferenceUser().getConference());

        List<MeetingHotel> meetingHotel=new ArrayList<>();
        for(Conference item:conference)
            meetingHotel.add(new MeetingHotel(item));

        information.put("hotel",hotel);
        information.put("meeting",meetingHotel);

        ObjectMapper mapper=new ObjectMapper();
        String userJson = mapper.writeValueAsString(information);
        return userJson;
    }
}