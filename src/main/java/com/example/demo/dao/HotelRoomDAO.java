package com.example.demo.dao;

import com.example.demo.entity.DO.HotelRoomDO;
import com.example.demo.entity.DO.UserDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HotelRoomDAO extends JpaRepository<HotelRoomDO,Integer> {
    @Query(value = "select * from hotelroom limit ?1,?2",nativeQuery = true)
    public List<HotelRoomDO> queryForPageItems(int begin, int pageSize);
}
