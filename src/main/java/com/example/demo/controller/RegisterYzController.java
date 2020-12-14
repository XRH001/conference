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
        System.out.println(email);
        // 根据邮箱查找
        try{
            userService.queryUserByEmail(email);
        }catch(NullPointerException e){
            // 如果查询不存在的邮箱将会报错 返回加密后验证码给前端
            try{
                String emailCode = MailSendUtil.mail(email);
                return passwordCode(emailCode);
            }catch(Exception err){
                return "error";
            }
        }
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
