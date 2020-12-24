package com.example.demo.dao;


import com.example.demo.entity.Admin;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


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

    @Test
    public void test3(){
        System.out.println(LocalDateTime.of(2020,12,23,1,1,0));
    }

    @Test
    public void test4(){
        List<Integer> list1=new ArrayList<>();
        list1.add(1);
        List<Integer> list2=new ArrayList<>();
        list1.add(2);
        list1.addAll(list2);
        System.out.println(list1);
    }

}