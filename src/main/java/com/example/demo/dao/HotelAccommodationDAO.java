package com.example.demo.dao;

import com.example.demo.entity.DO.HotelAccommodationDO;
import com.example.demo.entity.DTO.HotelAccommodation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HotelAccommodationDAO extends JpaRepository<HotelAccommodationDO,Integer> {
    public List<HotelAccommodationDO> queryHotelAccommodationDOSByHotelOrderID(int hotelOrderID);

    public HotelAccommodationDO queryHotelAccommodationDOByConferenceUserID(int conferenceUserID);
}
