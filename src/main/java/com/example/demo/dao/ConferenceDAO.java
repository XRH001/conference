package com.example.demo.dao;

import com.example.demo.entity.DO.ConferenceDO;
import com.example.demo.entity.DTO.Conference;
import com.example.demo.entity.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface ConferenceDAO extends JpaRepository<ConferenceDO,Integer> {

    public List<ConferenceDO> queryConferenceDOSByName(String name);

    public List<ConferenceDO> queryConferenceDOSByAddress(String address);

    public List<ConferenceDO> queryConferenceDOSByOrderStatus(int orderStatus);

    public List<ConferenceDO> queryConferenceDOSByCreateTimeBetween(Date beginTime,Date endTime);

    public List<ConferenceDO> queryConferenceDOSByBeginTimeBetween(Date beginTime,Date endTime);

    public List<ConferenceDO> queryConferenceDOSByEndTimeBetween(Date beginTime,Date endTime);

    public List<ConferenceDO> queryConferenceDOSByNameContaining(String name);

    @Query(value = "select * from conference limit ?1,?2",nativeQuery = true)
    public List<ConferenceDO> queryForPageItems(int begin, int pageSize);
}
