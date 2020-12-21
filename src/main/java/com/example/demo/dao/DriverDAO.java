package com.example.demo.dao;

import com.example.demo.entity.Driver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DriverDAO extends JpaRepository<Driver,Integer> {
    /**
     * 根据driverID查询司机
     * @param driverID
     * @return
     */
    public Driver queryDriverByID(int driverID);

    /**
     * 根据车牌号查询司机
     * @param carNum
     * @return
     */
    public Driver queryDriverByCarNum(String carNum);

    /**
     * 根据名字查询司机
     * @param name
     * @return
     */
    public List<Driver> queryDriversByName(String name);

    /**
     * 根据车的类型查询司机列表
     * @param type
     * @return
     */
    public List<Driver> queryDriversByType(String type);

    /**
     * 查询所有小于等于给出的最大承载数量的司机列表
     * @param maxNum
     * @return
     */
    public List<Driver> queryDriversByMaxNumLessThanEqual(int maxNum);

    public Driver queryDriverByUsername(String username);

    public Driver queryDriverByEmail(String email);

    public Driver queryDriverByPhone(String phone);

    public List<Driver> queryDriversByNameContainingOrCarNumContainingOrPhoneContainingOrEmailContaining(String name,String carNum,String phone,String email);

    /**
     * 查询从begin开始,长度为pageSize的司机列表
     * @param begin
     * @param pageSize
     * @return
     */
    @Query(value = "select * from driver limit ?1,?2",nativeQuery = true)
    public List<Driver> queryForPageItems(int begin,int pageSize);
}
