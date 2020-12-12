package com.example.demo.dao;

import com.example.demo.entity.DO.ConferenceJourneyDO;
import com.example.demo.entity.DO.UserDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ConferenceJourneyDAO extends JpaRepository<ConferenceJourneyDO,Integer> {
    public ConferenceJourneyDO queryConferenceJourneyDOByID(int ID);
    public List<ConferenceJourneyDO> queryConferenceJourneyDOSByConferenceID(int conferenceID);
    public List<ConferenceJourneyDO> queryConferenceJourneyDOSByJourneyID(int JourneyID);
    @Query(value = "select * from conferencejourney limit ?1,?2",nativeQuery = true)
    public List<ConferenceJourneyDO> queryForPageItems(int begin, int pageSize);
}
