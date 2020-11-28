package com.example.demo.service;

import com.example.demo.entity.Admin;
import com.example.demo.service.mehod.AdminService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AdminServiceTest {
    @Autowired
    AdminService adminService;
    Admin admin=new Admin("user5","735560800");

    @Test
    public void saveAdmin() {
        System.out.println(adminService.saveAdmin(admin));
    }

    @Test
    public void delete(){
        adminService.deleteAdmin(7);
    }

    @Test
    public void query(){
        System.out.println(adminService.queryAdmins());
        System.out.println(adminService.queryAdminByUsername("user2"));

    }

    @Test
    public void test(){
        System.out.println(adminService.queryForPageCountTotal());
    }

    @Test
    public void queryForPageItems(){
        System.out.println(adminService.queryForPageItems(0,3));
    }

}