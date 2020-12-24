package com.example.demo.service.mehod;

import com.example.demo.dao.HotelInfoDAO;
import com.example.demo.entity.DO.HotelInfoDO;
import com.example.demo.entity.DTO.HotelInfo;
import com.example.demo.entity.Hotel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class HotelInfoService {
    @Autowired
    HotelInfoDAO hotelInfoDAO;
    @Autowired
    HotelService hotelService;

    public HotelInfo saveHotelInfo(HotelInfo hotelInfo){
        if (hotelInfo!=null){
            return toHotelInfo(hotelInfoDAO.save(toHotelInfoDO(hotelInfo)));
        }else {
            return null;
        }
    }

    public int deleteHotelInfo(int hotelInfoID){
        try {
            hotelInfoDAO.deleteById(hotelInfoID);
            return 1;
        }catch (EmptyResultDataAccessException e){
            return -1;
        }
    }

    public HotelInfo queryHotelInfoByID(int hotelInfoID){
        try {
            return toHotelInfo(hotelInfoDAO.findById(hotelInfoID).get());
        }catch (NoSuchElementException |NullPointerException e){
            return null;
        }
    }

    public HotelInfo queryHotelInfoByHotel(Hotel hotel){
        try {
            return toHotelInfo(hotelInfoDAO.queryHotelInfoDOByHotelID(hotel.getID()));
        }catch (NoSuchElementException |NullPointerException e){
            return null;
        }
    }

    public HotelInfoDO toHotelInfoDO(HotelInfo hotelInfo){
        HotelInfoDO hotelInfoDO=new HotelInfoDO();

        hotelInfoDO.setID(hotelInfo.getID());
        hotelInfoDO.setHotelID(hotelInfo.getHotel().getID());
        hotelInfoDO.setHotelInfo(hotelInfo.getHotelInfo());

        return hotelInfoDO;
    }

    public HotelInfo toHotelInfo(HotelInfoDO hotelInfoDO){
        HotelInfo hotelInfo=new HotelInfo();

        hotelInfo.setID(hotelInfoDO.getID());
        hotelInfo.setHotel(hotelService.queryHotelByID(hotelInfoDO.getHotelID()));
        hotelInfo.setHotelInfo(hotelInfoDO.getHotelInfo());

        return hotelInfo;
    }
}
