package com.example.demo.service.mehod;

import com.example.demo.entity.DTO.HotelOrder;
import com.example.demo.enumValue.OrderStatus;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.swing.*;

import java.time.LocalDateTime;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HotelOrderServiceTest {
    @Autowired
    HotelRoomService hotelRoomService;
    @Autowired
    HotelOrderService hotelOrderService;
    HotelOrder hotelOrder=new HotelOrder(1,hotelRoomService.queryHotelRoomByID(1), LocalDateTime.now(),2,
                                            OrderStatus.Running,LocalDateTime.now(),LocalDateTime.now());

    @Test
    public void saveHotelOrder() {
        hotelOrderService.saveHotelOrder(hotelOrder);
    }

    @Test
    public void deleteHotelOrder() {
    }

    @Test
    public void queryHotelOrderByID() {
    }

    @Test
    public void queryHotelOrders() {
    }

    @Test
    public void queryForCountTotal() {
    }

    @Test
    public void queryForPageItems() {
    }

    @Test
    public void toHotelOrder() {
    }

    @Test
    public void toHotelOrderDO() {
    }
}