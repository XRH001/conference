package com.example.demo.service;

import com.example.demo.entity.Hotel;
import com.example.demo.service.mehod.HotelService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HotelServiceTest {
    @Autowired
    HotelService hotelService;
    Hotel hotel=new Hotel(4,"7天连锁酒店","963852741","学府大道");

    @Test
    public void saveHotel() {
        System.out.println(hotelService.saveHotel(hotel));
    }

    @Test
    public void deleteHotel() {
        hotelService.deleteHotel(4);
    }

    @Test
    public void queryHotelByID() {
        System.out.println(hotelService.queryHotelByID(4));
    }

    @Test
    public void queryHotelByName() {
        System.out.println(hotelService.queryHotelByName("7天连锁酒店"));
    }

    @Test
    public void queryHotelByPhone() {
        System.out.println(hotelService.queryHotelByPhone("963852741"));
    }

    @Test
    public void queryHotelByAddress() {
        System.out.println(hotelService.queryHotelByAddress("学府大道"));
    }

    @Test
    public void queryHotels() {
        System.out.println(hotelService.queryHotels());
    }

    @Test
    public void queryForPageCountTotal() {
        System.out.println(hotelService.queryForPageCountTotal());
    }

    @Test
    public void queryForPageItems() {
        System.out.println(hotelService.queryForPageItems(0,3));
    }
}