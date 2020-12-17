package com.example.demo.controller;

import com.example.demo.entity.DTO.User;
import com.example.demo.controller.RegisterUser;

import com.example.demo.enumValue.Identity;
import com.example.demo.service.mehod.UserService;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.demo.enumValue.Sex;
import com.example.demo.enumValue.Position;
import org.springframework.web.bind.annotation.*;


@RestController
public class RegisterController {
    @Autowired
    UserService userService;
    @RequestMapping("/register")
    public String RegisterSelvet(RegisterUser registerUser){
        User user = new User();
        // 性别
        if(registerUser.getSex().equals("male")){
            user.setSex(Sex.Male);
        }else if(registerUser.getSex().equals("female")){
            user.setSex(Sex.Female);
        }
        user.setUsername(registerUser.getUsername());
        user.setPassword(registerUser.getPassword());
        user.setEmail(registerUser.getEmail());
        user.setBirth(registerUser.getBirth());
        user.setImgPath(registerUser.getImgPath());
        // 根据邮箱查找
        if(userService.queryUserByEmail(user.getEmail()) == null) {
            userService.saveUser(user);
            return "success";
        }
        return "";
    }
}
