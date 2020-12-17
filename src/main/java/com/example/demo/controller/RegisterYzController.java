package com.example.demo.controller;

import com.example.demo.utils.MailSendUtil;
import com.example.demo.service.mehod.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegisterYzController {
    @Autowired
    UserService userService;
    @RequestMapping("/registerYz")
    public String registerYz(String email) {
        // 根据邮箱查找
        if(userService.queryUserByEmail(email)==null){
            try{
                String emailCode = MailSendUtil.mail(email);
                return passwordCode(emailCode);
            }catch(Exception err){
                return "error";
            }
        };
        return "already";
    }

    public String passwordCode(String emailCode){
        String str = "";
        for(int i=0;i<emailCode.length();i++){
            int asciiNum = (int)emailCode.charAt(i);
            str += Integer.toHexString(asciiNum);
        }
        return str;
    }
}
