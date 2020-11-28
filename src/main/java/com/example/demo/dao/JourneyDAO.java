package com.example.demo.dao;

import com.example.demo.entity.DO.JourneyDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface JourneyDAO extends JpaRepository<JourneyDO,Integer> {

    public List<JourneyDO> queryJourneyDOSByTimeBetween(Date beginTime,Date endTime);

    public List<JourneyDO> queryJourneyDOSByOrigin(String origin);

    public List<JourneyDO> queryJourneyDOSByTarget(String target);

    public List<JourneyDO> queryJourneyDOSByOriginAndTarget(String origin,String target);

    @Query(value = "select * from journey limit ?1,?2",nativeQuery = true)
    public List<JourneyDO> queryForPageItems(int begin, int pageSize);
}
