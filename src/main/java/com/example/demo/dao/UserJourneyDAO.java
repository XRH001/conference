package com.example.demo.dao;

import com.example.demo.entity.DO.DriverPickUpDO;
import com.example.demo.entity.DO.UserJourneyDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface UserJourneyDAO extends JpaRepository<UserJourneyDO,Integer> {
    @Transactional
    @Modifying
    @Query(value = "insert into userjourney (conferenceID, journeyID) values (?1, ?2)",nativeQuery = true)
    public int insertConferenceAndJourney(int conferenceID,int journeyID);

    public List<UserJourneyDO> queryUserJourneyDOSByUserID(int userID);

    public List<UserJourneyDO> queryUserJourneyDOSByJourneyID(int journeyID);

    public List<UserJourneyDO> queryUserJourneyDOSByConferenceID(int conferenceID);

    @Query(value = "select * from userjourney limit ?1,?2",nativeQuery = true)
    public List<UserJourneyDO> queryForPageItems(int begin, int pageSize);
}
