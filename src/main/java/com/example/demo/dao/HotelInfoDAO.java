package com.example.demo.dao;

import com.example.demo.entity.DO.HotelInfoDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HotelInfoDAO extends JpaRepository<HotelInfoDO,Integer> {

    public HotelInfoDO queryHotelInfoDOByHotelID(int hotelID);

    @Query(value = "select * from hotelInfo limit ?1,?2",nativeQuery = true)
    public List<HotelInfoDO> queryForPageItems(int begin, int pageSize);
}
