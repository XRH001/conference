package com.example.demo.dao;

import com.example.demo.entity.DO.ConferenceUserDO;
import com.example.demo.entity.DO.JourneyDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ConferenceUserDAO extends JpaRepository<ConferenceUserDO,Integer> {

    public List<ConferenceUserDO> queryConferenceUserDOSByUserID(int userID);

    public List<ConferenceUserDO> queryConferenceUserDOSByConferenceID(int conferenceID);

    public List<ConferenceUserDO> queryConferenceUserDOSByConferenceIDAndPosition(int conferenceID,String position);

    public List<ConferenceUserDO> queryConferenceUserDOSByConferenceIDAndInvitationStatus(int conferenceID,int invitationStatus);

    public List<ConferenceUserDO> queryConferenceUserDOSByConferenceIDAndOrderStatus(int conferenceID,int orderStatus);

    public List<ConferenceUserDO> queryConferenceUserDOSByUserIDAndPosition(int userID,String position);

    public List<ConferenceUserDO> queryConferenceUserDOSByUserIDAndInvitationStatus(int userID,int invitationStatus);

    public List<ConferenceUserDO> queryConferenceUserDOSByUserIDAndOrderStatus(int userID,int orderStatus);

    @Query(value = "select * from conferenceuser limit ?1,?2",nativeQuery = true)
    public List<ConferenceUserDO> queryForPageItems(int begin, int pageSize);
}
