package com.example.demo.dao;

import com.example.demo.entity.DO.HotelOrderDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HotelOrderDAO extends JpaRepository<HotelOrderDO,Integer> {

    public List<HotelOrderDO> queryHotelOrderDOSByHotelRoomID(int hotelRoomID);

    @Query(value = "select * from hotelorder limit ?1,?2",nativeQuery = true)
    public List<HotelOrderDO> queryForPageItems(int begin, int pageSize);
}
