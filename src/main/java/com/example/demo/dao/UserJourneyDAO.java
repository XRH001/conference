package com.example.demo.dao;

import com.example.demo.entity.DO.DriverPickUpDO;
import com.example.demo.entity.DO.UserJourneyDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserJourneyDAO extends JpaRepository<UserJourneyDO,Integer> {
    @Query(value = "select * from userjourney limit ?1,?2",nativeQuery = true)
    public List<UserJourneyDO> queryForPageItems(int begin, int pageSize);
}
