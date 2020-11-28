package com.example.demo.dao;

import com.example.demo.entity.Driver;
import com.example.demo.entity.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HotelDAO extends JpaRepository<Hotel,Integer> {

    public Hotel queryHotelByName(String name);

    public Hotel queryHotelByPhone(String phone);

    public List<Hotel> queryHotelsByAddress(String address);

    @Query(value = "select * from hotel limit ?1,?2",nativeQuery = true)
    public List<Hotel> queryForPageItems(int begin, int pageSize);

}
