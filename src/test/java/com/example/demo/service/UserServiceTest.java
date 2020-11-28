package com.example.demo.service;

import com.example.demo.entity.DTO.User;
import com.example.demo.enumValue.Sex;
import com.example.demo.service.mehod.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest {
    @Autowired
    UserService userService;
    User user=new User(3,"user1","user1","user1", Sex.Female, LocalDate.of(2020,1,1),"经理","616161616",
                            "616161616@163.com","/static/img","7894561230");

    @Test
    public void saveUser() {
        System.out.println(userService.saveUser(user));
    }

    @Test
    public void deleteUser() {
        userService.deleteUser(4);
    }

    @Test
    public void queryUserByID() {
        System.out.println(userService.queryUserByID(3));
    }

    @Test
    public void queryUsers() {
        System.out.println(userService.queryUsers());
    }

    @Test
    public void queryUserDOByUsername() {
        System.out.println(userService.queryUserByUsername("user1"));
    }

    @Test
    public void queryUserDOSByName() {
        System.out.println(userService.queryUsersByName("user1"));
    }

    @Test
    public void queryUserDOSBySex() {
        System.out.println(userService.queryUsersBySex(Sex.Male));
    }

    @Test
    public void queryUserDOSByBirth() {
        System.out.println(userService.queryUsersByBirth(LocalDate.of(2020,10,10)));
    }

    @Test
    public void queryUserDOSByPosition() {
        System.out.println(userService.queryUsersByPosition("讲师"));
    }

    @Test
    public void queryUserDOByWorkID() {
        System.out.println(userService.queryUserByWorkID("616161616"));
    }

    @Test
    public void queryUserDOByEmail() {
        System.out.println(userService.queryUserByEmail("616161616@163.com"));
    }

    @Test
    public void queryUserDOByPhone() {
        System.out.println(userService.queryUserByPhone("7894561230"));
    }

    @Test
    public void queryForPageCountTotal() {
        System.out.println(userService.queryForPageCountTotal());
    }

    @Test
    public void queryForPageItems() {
        System.out.println(userService.queryForPageItems(0,3));
    }
}