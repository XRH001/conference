package com.example.demo.controller;

import com.example.demo.entity.DTO.User;
import com.example.demo.service.mehod.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
public class LoginController {

    @Autowired
    UserService userService;

    @ResponseBody
    @RequestMapping("/Userjudge")

    public String Userjudge(HttpServletRequest request) {
        User user=new User();
        String email = request.getParameter("email");
        String password=request.getParameter("password");
        if(userService.queryUserByEmail(email)==null)
            return "not user";
        if (userService.queryUserByEmail(email)!=null)
            user.setEmail(email);
            if(password!=user.getPassword())
                return "password error";
            else
                return user.getName();
    }
}