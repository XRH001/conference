package com.example.demo.controller;

import com.example.demo.entity.DTO.User;
import com.example.demo.service.mehod.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.Timestamp;
import java.time.LocalDateTime;

/**
 * @author 李嘉旭
 * 文件上传的controller
 */
@RestController
@RequestMapping("/file")
public class UploadFileController {
    @Autowired
    UserService userService;

    @PostMapping("/images")
    public String singleFileUpload(@RequestParam("file") MultipartFile file, HttpServletRequest request) {
        String email=request.getParameter("email");
        if (file.isEmpty()) {
            return "请选择上传文件";
        }
        try {
            byte[] bytes = file.getBytes();
            User user=userService.queryUserByEmail(email);
            Path path = Paths.get("src/main/resources/static/"+user.getEmail() +".jpg");
            user.setImgPath(user.getEmail() +".jpg");
            userService.saveUser(user);
            Files.write(path, bytes);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "上传成功";
    }
}