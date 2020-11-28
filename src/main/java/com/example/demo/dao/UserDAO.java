package com.example.demo.dao;

import com.example.demo.entity.Admin;
import com.example.demo.entity.DO.UserDO;
import com.example.demo.enumValue.Position;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import java.util.Date;
import java.util.List;

@Repository
public interface UserDAO extends JpaRepository<UserDO,Integer> {

    public UserDO queryUserDOByUsername(String username);

    public List<UserDO> queryUserDOSByName(String name);

    public List<UserDO> queryUserDOSBySex(int sex);

    public List<UserDO> queryUserDOSByBirth(Date time);

    public List<UserDO> queryUserDOSByPosition(String position);

    public UserDO queryUserDOByWorkID(String workID);

    public UserDO queryUserDOByEmail(String email);

    public UserDO queryUserDOByPhone(String phone);

    @Query(value = "select * from user limit ?1,?2",nativeQuery = true)
    public List<UserDO> queryForPageItems(int begin, int pageSize);
}
