package com.example.demo.dao;

import com.example.demo.entity.DO.DriverPickUpDO;
import com.example.demo.entity.DTO.DriverPickUp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DriverPickUpDAO extends JpaRepository<DriverPickUpDO,Integer> {

    public DriverPickUpDO queryDriverPickUpDOByUserJourneyID(int userJourneyID);

    public List<DriverPickUpDO>  queryDriverPickUpDOSByDriverID(int driverID);

    @Query(value = "select * from driverpickup limit ?1,?2",nativeQuery = true)
    public List<DriverPickUpDO> queryForPageItems(int begin, int pageSize);
}
