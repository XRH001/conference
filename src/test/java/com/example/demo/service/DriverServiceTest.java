package com.example.demo.service;

import com.example.demo.entity.Driver;
import com.example.demo.service.mehod.DriverService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DriverServiceTest {
    @Autowired
    DriverService driverService;
    Driver driver=new Driver("周五","123456789","中巴",20,"a415151","driver1","driver1","driver1@qq.com","driver1imgPath");
    @Test
    public void saveDriver() {
        for (int i=1;i<21;i++){
            driver.setID(i);
            driver.setName("user"+i);
            driver.setPhone(i+1000+"");
            driver.setCarNum(i+1000+"");
            driver.setUsername("user"+i);
            driver.setPassword("user"+i);
            driver.setEmail("user"+i+"@qq.com");
            driver.setImgPath("user"+i+"imgPath");
            driverService.saveDriver(driver);
        }

    }

    @Test
    public void deleteDriver() {
        driverService.deleteDriver(4);
    }

    @Test
    public void queryDriverByID() {
        System.out.println(driverService.queryDriverByID(3));
    }

    @Test
    public void queryDriverByName() {
        System.out.println(driverService.queryDriversByName("李四"));
    }

    @Test
    public void queryDriverByCarNum() {
        System.out.println(driverService.queryDriverByCarNum("789456"));
    }

    @Test
    public void queryDriversByType() {
        System.out.println(driverService.queryDriversByType("中巴"));
    }

    @Test
    public void queryDriversByMaxNumLessThanEqual() {
        System.out.println(driverService.queryDriversByMaxNumLessThanEqual(10));
    }

    @Test
    public void queryForPageCountTotal() {
        System.out.println(driverService.queryForPageCountTotal());
    }

    @Test
    public void queryForPageItems() {
        System.out.println(driverService.queryForPageItems(0,3));
    }

    @Test public void queryDriverByNameContainingOrCarNumContaining(){
        System.out.println(driverService.queryDriversByNameContainingOrCarNumContainingOrPhoneContainingOrEmailContaining("415"));
    }
}