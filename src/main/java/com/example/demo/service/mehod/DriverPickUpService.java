package com.example.demo.service.mehod;

import com.example.demo.dao.DriverDAO;
import com.example.demo.dao.DriverPickUpDAO;
import com.example.demo.entity.DO.DriverPickUpDO;
import com.example.demo.entity.DTO.DriverPickUp;
import com.example.demo.entity.DTO.UserJourney;
import com.example.demo.enumValue.OrderStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * @author 李嘉旭
 * 用户出行Service
 * 负责driver和userJourney的多对多映射信息
 */
@Service
public class DriverPickUpService {
    @Autowired
    DriverPickUpDAO driverPickUpDAO;
    @Autowired
    UserJourneyService userJourneyService;
    @Autowired
    DriverService driverService;
    List<DriverPickUp> list=new ArrayList<>();
    List<DriverPickUpDO> driverPickUpDOList;

    /**
     * 增加或修改一个driverPickUp
     * 根据ID
     * 有则修改,无则增加
     * @param driverPickUp 要插入的driverPickUp
     * @return null表示失败,否则表示成功
     */
    public DriverPickUp saveDriverPickUp(DriverPickUp driverPickUp){
        if (driverPickUp!=null){
            return toDriverPickUp(driverPickUpDAO.save(toDriverPickUpDO(driverPickUp)));
        }else {
            return null;
        }
    }

    /**
     * 删除一个driverPickUp
     * 根据ID
     * @param driverPickUpID 要删除的driverPickUpID
     */
    public int deleteDriverPickUpByID(int driverPickUpID){
        try{
            driverPickUpDAO.deleteById(driverPickUpID);
            return 1;
        }catch (EmptyResultDataAccessException e){
            return -1;
        }
    }

    /**
     * 查询一个driverPickUp
     * 根据ID
     * @param driverPickUpID
     * @return
     */
    public DriverPickUp queryDriverPickUpByID(int driverPickUpID){
        try {
            return toDriverPickUp(driverPickUpDAO.findById(driverPickUpID).get());
        }catch (NoSuchElementException|NullPointerException e){
            return null;
        }
    }



    /**
     * 查询所有的driverPickUp记录
     * @return
     */
    public List<DriverPickUp> queryDriverPickUps(){
        list.clear();
        driverPickUpDOList=driverPickUpDAO.findAll();
        if (driverPickUpDOList.size()!=0){
            for(DriverPickUpDO d:driverPickUpDOList){
                list.add(toDriverPickUp(d));
            }
            return list;
        }else {
            return null;
        }
    }

    /**
     * 查询driverPickUp记录的总数量
     * @return
     */
    public int queryForCountTotal(){
        return (int)driverPickUpDAO.count();
    }

    /**
     * 查询从begin开始的,长度为pageSize的记录
     * @param begin 起始位置
     * @param pageSize 页面长度
     * @return 一个页面的driverPickUp集合
     */
    public List<DriverPickUp> queryForPageItems(int begin,int pageSize){
        try {
            list.clear();
            driverPickUpDOList=driverPickUpDAO.queryForPageItems(begin, pageSize);
            if (driverPickUpDOList.size()!=0){
                for(DriverPickUpDO d:driverPickUpDOList){
                    list.add(toDriverPickUp(d));
                }
                return list;
            }else {
                return null;
            }
        }catch (Exception e){
            return null;
        }
    }

    /**
     * 转换方法
     * 将driverPickUpDO转换为driverPickUp
     * @param driverPickUpDO
     * @return
     */
    public DriverPickUp toDriverPickUp(DriverPickUpDO driverPickUpDO){
        DriverPickUp driverPickUp=new DriverPickUp();

        driverPickUp.setID(driverPickUpDO.getID());
        driverPickUp.setDriver(driverService.queryDriverByID(driverPickUpDO.getDriverID()));
        driverPickUp.setOrderStatus(OrderStatus.choose(driverPickUpDO.getOrderStatus()));
        driverPickUp.setUserJourney(userJourneyService.queryUserJourneyByID(driverPickUpDO.getUserJourneyID()));

        return driverPickUp;
    }

    /**
     * 转换方法
     * 将driverPickUp转换为driverPickUpDO
     * @param driverPickUp
     * @return
     */
    public DriverPickUpDO toDriverPickUpDO(DriverPickUp driverPickUp){
        DriverPickUpDO driverPickUpDO=new DriverPickUpDO();

        driverPickUpDO.setID(driverPickUp.getID());
        driverPickUpDO.setDriverID(driverPickUp.getDriver().getID());
        driverPickUpDO.setOrderStatus(driverPickUp.getOrderStatus().getNum());
        driverPickUpDO.setUserJourneyID(driverPickUp.getUserJourney().getID());

        return driverPickUpDO;
    }
    
}
