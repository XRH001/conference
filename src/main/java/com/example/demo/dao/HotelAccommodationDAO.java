package com.example.demo.dao;

import com.example.demo.entity.DO.HotelAccommodationDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HotelAccommodationDAO extends JpaRepository<HotelAccommodationDO,Integer> {
}
