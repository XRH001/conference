package com.example.demo.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserDAOTest {
    @Autowired
    UserDAO userDAO;

    @Test
    public void test1(){
        System.out.println(userDAO==null);
        System.out.println(userDAO.findById(1).get());
    }

    @Test
    public void test2(){
        System.out.println();
    }
}