package com.example.demo.service.mehod;

import com.example.demo.dao.JourneyDAO;
import com.example.demo.entity.DTO.Journey;
import com.example.demo.entity.DO.JourneyDO;
import com.example.demo.utils.TimeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * @author 李嘉旭
 * 行程Service
 * 负责调用行程信息
 */
@Service
public class JourneyService {
    @Autowired
    JourneyDAO journeyDAO;
    List<Journey> list=new ArrayList<>();
    List<JourneyDO> journeyDOList;

    /**
     * 增加或修改一个journey
     * 根据ID
     * 有则修改,无则增加
     * @param journey
     * @return
     */
    public Journey saveJourney(Journey journey){
        if (journey!=null){
            return toJourney(journeyDAO.save(toJourneyDO(journey)));
        }else {
            return null;
        }

    }

    /**
     * 删除一个journey
     * 根据ID
     * @param journeyID
     */
    public int deleteJourney(int journeyID){
        try {
            journeyDAO.deleteById(journeyID);
            return 1;
        }catch (EmptyResultDataAccessException e){
            return -1;
        }
    }

    /**
     * 查询一个journey
     * 根据ID
     * @param journeyID
     * @return
     */
    public Journey queryJourneyByID(int journeyID){
        try {
            return toJourney(journeyDAO.findById(journeyID).get());
        }catch (NoSuchElementException|NullPointerException e){
            return null;
        }
    }

    /**
     * 查询所有的journey记录
     * @return
     */
    public List<Journey> queryJourneys(){
        journeyDOList=journeyDAO.findAll();
        for(JourneyDO j:journeyDOList){
            list.add(toJourney(j));
        }
        return list;
    }

    /**
     * 查询journey集合
     * 根据时间片
     * @param beginTime 时间片的开始时间
     * @param endTime 时间片的结束时间
     * @return
     */
    public List<Journey> queryJourneysByTimeBetween(LocalDateTime beginTime,LocalDateTime endTime){
        journeyDOList=journeyDAO.queryJourneyDOSByTimeBetween(TimeUtils.converseTrans(beginTime),TimeUtils.converseTrans(endTime));
        if (journeyDOList.size()!=0){
            for(JourneyDO j:journeyDOList){
                list.add(toJourney(j));
            }
            return list;
        }else {
            return null;
        }
    }

    /**
     * 查询journey集合
     * 根据时间片
     * @param beginTime 时间片的开始时间
     * @param endTime 时间片的结束时间
     * @return
     */
    public List<Journey> queryJourneysByTimeBetween(LocalDate beginTime, LocalDate endTime){
        journeyDOList=journeyDAO.queryJourneyDOSByTimeBetween(TimeUtils.converseTrans(beginTime),TimeUtils.converseTrans(endTime));
        if (journeyDOList.size()!=0){
            for(JourneyDO j:journeyDOList){
                list.add(toJourney(j));
            }
            return list;
        }else {
            return null;
        }
    }

    /**
     * 查询journey集合
     * 根据出发地点
     * @param origin
     * @return
     */
    public List<Journey> queryJourneysByOrigin(String origin){
        journeyDOList=journeyDAO.queryJourneyDOSByOrigin(origin);
        if (journeyDOList.size()!=0){
            for(JourneyDO j:journeyDOList){
                list.add(toJourney(j));
            }
            return list;
        }else {
            return null;
        }
    }

    /**
     * 查询journey集合
     * 根据目的地
     * @param target
     * @return
     */
    public List<Journey> queryJourneysByTarget(String target){
        journeyDOList=journeyDAO.queryJourneyDOSByTarget(target);
        if (journeyDOList.size()!=0){
            for(JourneyDO j:journeyDOList){
                list.add(toJourney(j));
            }
            return list;
        }else {
            return null;
        }
    }

    /**
     * 查询journey集合
     * 查询出发地点和目的地
     * @param origin 出发地点
     * @param target 目的地
     * @return
     */
    public List<Journey> queryJourneysByOriginAndTarget(String origin,String target){
        journeyDOList=journeyDAO.queryJourneyDOSByOriginAndTarget(origin,target);
        if (journeyDOList.size()!=0){
            for(JourneyDO j:journeyDOList){
                list.add(toJourney(j));
            }
            return list;
        }else {
            return null;
        }
    }

    public Journey queryJourneyDOByOriginAndTargetAndTime(String origin,String target,LocalDateTime time){
        try {
            return toJourney(journeyDAO.queryJourneyDOByOriginAndTargetAndTime(origin,target,TimeUtils.converseTrans(time)));
        }catch (NoSuchElementException|NullPointerException e){
            return null;
        }
    }

    /**
     * 查询journey记录的总数量
     * @return
     */
    public int queryForCountTotal(){
        return (int) journeyDAO.count();
    }

    /**
     * 查询从begin开始的,长度为pageSize的记录
     * @param begin 起始位置
     * @param pageSize 页面长度
     * @return 一个页面的journey集合
     */
    public List<Journey> queryForPageItems(int begin,int pageSize){
        try {
            journeyDOList=journeyDAO.queryForPageItems(begin,pageSize);
            if (journeyDOList.size()!=0){
                for(JourneyDO j:journeyDOList){
                    list.add(toJourney(j));
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
     * 将journeyDO转换为journey
     * @param journeyDO
     * @return
     */
    public Journey toJourney(JourneyDO journeyDO){
        Journey journey=new Journey();

        journey.setID(journeyDO.getID());
        journey.setTime(TimeUtils.transLocalDateTime(journeyDO.getTime()));
        journey.setorigin(journeyDO.getOrigin());
        journey.setTarget(journeyDO.getTarget());

        return journey;
    }

    /**
     * 转换方法
     * 将journey转换为journeyDO
     * @param journey
     * @return
     */
    public JourneyDO toJourneyDO(Journey journey){
        JourneyDO journeyDO=new JourneyDO();

        journeyDO.setID(journey.getID());
        journeyDO.setTime(TimeUtils.converseTrans(journey.getTime()));
        journeyDO.setOrigin(journey.getorigin());
        journeyDO.setTarget(journey.getTarget());

        return journeyDO;
    }
}
