package com.example.demo.service.mehod;

import com.example.demo.dao.DriverDAO;
import com.example.demo.entity.Admin;
import com.example.demo.entity.Driver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 李嘉旭
 * 司机Service
 * 负责调用司机的信息
 */
@Service
public class DriverService {
    @Autowired
    DriverDAO driverDAO;

    /**
     * 增加或修改一个driver
     * 根据ID
     * 有则修改,无则增加
     * @param driver
     * @return
     */
    public Driver saveDriver(Driver driver){
        return driverDAO.save(driver);
    }

    /**
     * 删除一个driver
     * 根据ID
     * @param driverID
     */
    public void deleteDriver(int driverID){
        driverDAO.deleteById(driverID);
    }

    /**
     * 查询一个driver
     * 根据ID
     * @param driverID
     * @return
     */
    public Driver queryDriverByID(int driverID){
        return driverDAO.queryDriverByID(driverID);
    }

    /**
     * 查询driver集合
     * 根据名字
     * @param name
     * @return
     */
    public List<Driver> queryDriversByName(String name){
        return driverDAO.queryDriversByName(name);
    }

    /**
     * 查询一个driver
     * 根据车牌号
     * @param carNum
     * @return
     */
    public Driver queryDriverByCarNum(String carNum){
        return driverDAO.queryDriverByCarNum(carNum);
    }

    /**
     * 查询driver集合
     * 根据车的类型
     * @param type
     * @return
     */
    public List<Driver> queryDriversByType(String type){
        return driverDAO.queryDriversByType(type);
    }

    /**
     * 查询driver集合
     * 根据车的最大承载量
     * 返回少于等于的给定最大承载量的司机
     * @param maxNum
     * @return
     */
    public List<Driver> queryDriversByMaxNumLessThanEqual(int maxNum){
        return driverDAO.queryDriversByMaxNumLessThanEqual(maxNum);
    }

    /**
     * 查询记录的数量
     * @return 总共有多少天记录
     */
    public int queryForPageCountTotal(){
        return (int) driverDAO.count();
    }

    /**
     * 查询从begin开始的,长度为pageSize的记录
     * @param begin
     * @param pageSize
     * @return
     */
    public List<Driver> queryForPageItems(int begin, int pageSize){
        return driverDAO.queryForPageItems(begin,pageSize);
    }
}
