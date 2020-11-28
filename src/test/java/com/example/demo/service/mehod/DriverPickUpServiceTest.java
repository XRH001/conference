package com.example.demo.service.mehod;

import com.example.demo.entity.DO.DriverPickUpDO;
import com.example.demo.entity.DTO.DriverPickUp;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class DriverPickUpServiceTest {
    DriverPickUpDO driverPickUpDO=new DriverPickUpDO(3,3,1,0);
    @Autowired
    DriverPickUpService driverPickUpService;

    @Test
    public void saveDriverPickUp() {
        driverPickUpService.saveDriverPickUp(driverPickUpService.toDriverPickUp(driverPickUpDO));
    }

    @Test
    public void deleteDriverPickUp() {
        driverPickUpService.deleteDriverPickUpByID(3);
    }

    @Test
    public void queryDriverPickUpByID() {
        System.out.println(driverPickUpService.queryDriverPickUpByID(1));
    }

    @Test
    public void queryDriverPickUps() {
        System.out.println(driverPickUpService.queryDriverPickUps());
    }

    @Test
    public void queryForCountTotal() {
        System.out.println(driverPickUpService.queryForCountTotal());
    }

    @Test
    public void queryForPageItems() {
        System.out.println(driverPickUpService.queryForPageItems(0,3));
    }

    @Test
    public void toDriverPickUp() {
    }

    @Test
    public void toDriverPickUpDO() {
    }
}