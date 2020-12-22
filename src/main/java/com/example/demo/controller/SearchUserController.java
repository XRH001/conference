package com.example.demo.controller;

import com.example.demo.entity.VO.Person;
import com.example.demo.service.mehod.UserService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

@Controller
public class SearchUserController {

    @Autowired
    UserService userService;

    @ResponseBody
    @RequestMapping("/SearchUser")
    public String SearchUser(HttpServletRequest request) throws JsonProcessingException {
        int userID=Integer.parseInt(request.getParameter("id"));

        Person person=new Person(userService.queryUserByID(userID));
        HashMap<String,Object> information=new HashMap<>(2);
        information.put("person",person);

        ObjectMapper mapper = new ObjectMapper();
        String userJson = mapper.writeValueAsString(information);
        return userJson;
    }

}
