package com.example.demo.controller;

import com.example.demo.entity.DTO.Conference;
import com.example.demo.entity.DTO.ConferenceUser;
import com.example.demo.entity.DTO.User;
import com.example.demo.entity.VO.Alter;
import com.example.demo.entity.VO.RegisterUser;

import com.example.demo.enumValue.InvitationStatus;
import com.example.demo.enumValue.OrderStatus;
import com.example.demo.enumValue.Position;
import com.example.demo.service.mehod.ConferenceService;
import com.example.demo.service.mehod.ConferenceUserService;
import com.example.demo.service.mehod.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.demo.enumValue.Sex;
import org.springframework.web.bind.annotation.*;
import com.example.demo.entity.VO.UserAddConfence;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RestController
public class UpdatePersonInfoController {
    @Autowired
    UserService userService;
    @Autowired
    ConferenceService conferenceService;
    @Autowired
    ConferenceUserService conferenceUserService;
    @RequestMapping("/updatePersonInfo")
    public String UpdatePersonInfoSelvet(@RequestBody UserAddConfence userAddConfence ){
        if(userService.queryUserByID(Integer.valueOf(userAddConfence.getUserId()))==null){
            return "fail";
        }
        User user = userService.queryUserByID(Integer.valueOf(userAddConfence.getUserId()));
        user.setUsername(userAddConfence.getAlter().getUsername());
        user.setName(userAddConfence.getAlter().getName());
        user.setPhone(userAddConfence.getAlter().getPhone());

        if(userAddConfence.getAlter().getSex()=="male"){
            user.setSex(Sex.Male);
        }else if(userAddConfence.getAlter().getSex()=="female"){
            user.setSex(Sex.Female);
        }

        DateTimeFormatter timeDtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        LocalDate birthday = LocalDate.parse(userAddConfence.getAlter().getBirthday(), timeDtf);
        user.setBirth(birthday);
        if(userService.saveUser(user)==null){
            return "fail";
        }
        return "success";
    }
}
