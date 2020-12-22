package com.example.demo.service.mehod;

import com.example.demo.dao.DriverDAO;
import com.example.demo.entity.Admin;
import com.example.demo.entity.Driver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

/**
 * @author 李嘉旭
 * 司机Service
 * 负责调用司机的信息
 */
@Service
public class DriverService {
    @Autowired
    DriverDAO driverDAO;
    List<Driver> list;

    /**
     * 增加或修改一个driver
     * 根据ID
     * 有则修改,无则增加
     * @param driver
     * @return
     */
    public Driver saveDriver(Driver driver){
        if (driver!=null){
            return driverDAO.save(driver);
        }else {
            return null;
        }
    }

    /**
     * 删除一个driver
     * 根据ID
     * @param driverID
     */
    public int deleteDriver(int driverID){
        try {
            driverDAO.deleteById(driverID);
            return 1;
        }catch (EmptyResultDataAccessException e){
            return -1;
        }
    }

    /**
     * 查询一个driver
     * 根据ID
     * @param driverID
     * @return
     */
    public Driver queryDriverByID(int driverID){
        try {
            return driverDAO.queryDriverByID(driverID);
        }catch (NoSuchElementException|NullPointerException e){
            return null;
        }
    }

    /**
     * 查询driver集合
     * 根据名字
     * @param name
     * @return
     */
    public List<Driver> queryDriversByName(String name){
        list=driverDAO.queryDriversByName(name);
        if (list.size()!=0){
            return list;
        }else {
            return null;
        }
    }

    /**
     * 查询一个driver
     * 根据车牌号
     * @param carNum
     * @return
     */
    public Driver queryDriverByCarNum(String carNum){
        try {
            return driverDAO.queryDriverByCarNum(carNum);
        }catch (NoSuchElementException|NullPointerException e){
            return null;
        }
    }

    /**
     * 查询driver集合
     * 根据车的类型
     * @param type
     * @return
     */
    public List<Driver> queryDriversByType(String type){
        list=driverDAO.queryDriversByType(type);
        if (list.size()!=0){
            return list;
        }else {
            return null;
        }

    }

    /**
     * 查询driver集合
     * 根据车的最大承载量
     * 返回少于等于的给定最大承载量的司机
     * @param maxNum
     * @return
     */
    public List<Driver> queryDriversByMaxNumLessThanEqual(int maxNum){
        list=driverDAO.queryDriversByMaxNumLessThanEqual(maxNum);
        if (list.size()!=0){
            return list;
        }else{
            return null;
        }
    }

    public Driver queryDriverByEmail(String email){
        try {
            return driverDAO.queryDriverByEmail(email);
        }catch (NoSuchElementException|NullPointerException e){
            return null;
        }
    }

    public Driver queryDriverByUsername(String username){
        try {
            return driverDAO.queryDriverByUsername(username);
        }catch (NoSuchElementException|NullPointerException e){
            return null;
        }
    }

    public Driver queryDriverByPhone(String phone){
        try {
            return driverDAO.queryDriverByPhone(phone);
        }catch (NoSuchElementException|NullPointerException e){
            return null;
        }
    }

    public List<Driver> queryDriversByNameContainingOrCarNumContainingOrPhoneContainingOrEmailContaining(String key){
        list=driverDAO.queryDriversByNameContainingOrCarNumContainingOrPhoneContainingOrEmailContaining(key,key,key,key);
        if (list.size()!=0){
            return list;
        }else {
            return null;
        }
    }

    /**
     * 查询记录的数量
     * @return 总共有多少条记录
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
        list=driverDAO.queryForPageItems(begin,pageSize);
        if (list.size()!=0){
            return list;
        }else {
            return null;
        }
    }
}
