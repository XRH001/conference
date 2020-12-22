package com.example.demo.service.mehod;

import com.example.demo.entity.DTO.HotelRoom;
import com.example.demo.enumValue.RoomType;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HotelRoomServiceTest {
    @Autowired
    HotelRoomService hotelRoomService;
    @Autowired
    HotelService hotelService;


    @Test
    public void saveHotelRoom() {
        HotelRoom hotelRoom=new HotelRoom(3, RoomType.Double,"803",hotelService.queryHotelByID(1),200.00,true,2);
        hotelRoomService.saveHotelRoom(hotelRoom);
    }

    @Test
    public void deleteHotelRoom() {
        hotelRoomService.deleteHotelRoom(3);
    }

    @Test
    public void queryHotelRoomByID() {
        System.out.println(hotelRoomService.queryHotelRoomByID(1));
    }

    @Test
    public void queryHotelRooms() {
        System.out.println(hotelRoomService.queryHotelRooms());
    }

    @Test
    public void queryForCountTotal() {
    }

    @Test
    public void queryForPageItems() {
    }

    @Test
    public void toHotelRoom() {
    }

    @Test
    public void toHotelRoomDO() {
    }
}