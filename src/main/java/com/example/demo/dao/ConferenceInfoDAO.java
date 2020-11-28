package com.example.demo.dao;

import com.example.demo.entity.Admin;
import com.example.demo.entity.DO.ConferenceInfoDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ConferenceInfoDAO extends JpaRepository<ConferenceInfoDO,Integer> {
    @Query(value = "select * from conferenceinfo limit ?1,?2",nativeQuery = true)
    public List<ConferenceInfoDO> queryForPageItems(int begin, int pageSize);
}
