package com.example.demo.dao;


import com.example.demo.entity.Admin;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;


@RunWith(SpringRunner.class)
@SpringBootTest
public class AdminDAOTest {
    @Autowired
    AdminDAO adminDAO;

    @Test
    public void test(){
        System.out.println(adminDAO.findAll());
    }

    @Test
    public void test1(){
        System.out.println(adminDAO.save(new Admin("user2","user2")));
    }

    @Test
    public void test2(){
        System.out.println(LocalDateTime.now());
    }

}