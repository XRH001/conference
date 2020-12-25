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

@RestController
@RequestMapping("/file")
public class UploadFileController {
    @Autowired
    UserService userService;

    @PostMapping("/images")
    public String singleFileUpload(@RequestParam("file") MultipartFile file, HttpServletRequest request) {
        int userId=Integer.valueOf(request.getParameter("userId"));
        if (file.isEmpty()) {
            return "请选择上传文件";
        }
        try {
            byte[] bytes = file.getBytes();
            User user=userService.queryUserByID(userId);
            Path path = Paths.get("src/main/java/com/example/demo/images/"+userId+".jpg");
            user.setImgPath(userId+".jpg");
            userService.saveUser(user);
            Files.write(path, bytes);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "上传成功";
    }
}