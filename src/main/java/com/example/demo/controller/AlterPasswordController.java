package com.example.demo.controller;

import com.example.demo.entity.DTO.User;
import com.example.demo.service.mehod.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
public class AlterPasswordController {

    @Autowired
    UserService userService;

    @ResponseBody
    @RequestMapping("/AlterPassword")
    public String AlterPasswordController(HttpServletRequest request){
        int ID = Integer.parseInt(request.getParameter("userId"));
        String FormerPassword=request.getParameter("formerPassword");
        String NewPassword=request.getParameter("newPassword");
        User user=userService.queryUserByID(ID);
        if(user.getPassword().equals(FormerPassword)){
            user.setPassword(NewPassword);
            userService.saveUser(user);
            return "success";
        }
        else return "error";
    }
}
