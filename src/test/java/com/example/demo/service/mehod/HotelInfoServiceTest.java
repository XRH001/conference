package com.example.demo.service.mehod;

import com.example.demo.entity.DTO.HotelInfo;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
class HotelInfoServiceTest {
    @Autowired
    HotelInfoService hotelInfoService;
    @Autowired
    HotelService hotelService;

    @Test
    void saveHotelInfo() {
        HotelInfo hotelInfo=new HotelInfo(hotelService.queryHotelByID(1),"这是一个无情的备注");
        System.out.println(hotelInfoService.saveHotelInfo(hotelInfo));
    }

    @Test
    void deleteHotelInfo() {
    }

    @Test
    void queryHotelInfoByID() {
        System.out.println(hotelInfoService.queryHotelInfoByID(1));
    }

    @Test
    void queryHotelInfoByHotel() {
        System.out.println(hotelInfoService.queryHotelInfoByHotel(hotelService.queryHotelByID(1)));
    }

    @Test
    void toHotelInfoDO() {
    }

    @Test
    void toHotelInfo() {
    }
}