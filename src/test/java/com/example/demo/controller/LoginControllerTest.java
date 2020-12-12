package com.example.demo.controller;

import com.example.demo.service.mehod.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import static org.junit.jupiter.api.Assertions.*;

@Controller
class LoginControllerTest {

    @ResponseBody
    @RequestMapping("/AAA")
    public String AAA(){
        return "Hello";
    }
}