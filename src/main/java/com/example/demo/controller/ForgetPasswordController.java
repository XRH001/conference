package com.example.demo.controller;

import com.example.demo.entity.DTO.User;
import com.example.demo.service.mehod.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
public class ForgetPasswordController {

    @Autowired
    UserService userService;

    @ResponseBody
    @RequestMapping("/ForgetPassword")
    public String ForgetPasswordController(HttpServletRequest request) {
        String Email=request.getParameter("email");
        String NewPassword=request.getParameter("newPassword");
        User user=userService.queryUserByEmail(Email);
        try {
            user.setPassword(NewPassword);
            userService.saveUser(user);
            return "success";
        }catch(Exception e){
            return "error";
        }
    }
}
