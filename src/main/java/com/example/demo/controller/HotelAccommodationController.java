package com.example.demo.controller;

import com.example.demo.entity.DTO.ConferenceUser;
import com.example.demo.entity.DTO.HotelAccommodation;
import com.example.demo.entity.DTO.UserJourney;
import com.example.demo.entity.Driver;
import com.example.demo.entity.Hotel;
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
public class HotelAccommodationController {
    @Autowired
    HotelOrderService hotelOrderService;
    @Autowired
    HotelService hotelService;
    @Autowired
    ConferenceService conferenceService;
    @Autowired
    ConferenceUserService conferenceUserService;

    @ResponseBody
    @RequestMapping("/loadHotels")
    public Map load(HttpServletRequest request){//加载酒店信息
        Map<String,Object> msg=new HashMap<>(3);
        try {
            int pageNum=Integer.parseInt(request.getParameter("pageNum"))-1;
            int lineNum=Integer.parseInt(request.getParameter("lineNum"));
            List<Hotel> list=hotelService.queryForPageItems(pageNum*lineNum,lineNum);
            msg.put("msg","success");
            msg.put("newHotelList",list);
            msg.put("pageTotal",hotelService.queryForPageCountTotal()/lineNum+1);
        }catch (NumberFormatException | NullPointerException e){
            msg.put("msg","fail");
        }
        return msg;
        }

    @ResponseBody
    @RequestMapping("/queryHotels")
    public Map queryHotels(HttpServletRequest request){//搜索酒店
        Map<String,Object> msg=new HashMap<>(2);
        try{
            String input=request.getParameter("input");
            List<Hotel> list=hotelService.queryHotelsByNameContainingOrAddressContaining(input);
            msg.put("msg","success");
            msg.put("hotelList",list);
        }catch (NullPointerException e){
            msg.put("msg","fail");
        }
        return msg;
        }
}
