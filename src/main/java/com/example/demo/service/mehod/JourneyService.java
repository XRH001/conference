package com.example.demo.service.mehod;

import com.example.demo.dao.JourneyDAO;
import com.example.demo.entity.DTO.Journey;
import com.example.demo.entity.DO.JourneyDO;
import com.example.demo.utils.TimeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

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

    /**
     * 增加或修改一个journey
     * 根据ID
     * 有则修改,无则增加
     * @param journey
     * @return
     */
    public Journey saveJourney(Journey journey){
        return toJourney(journeyDAO.save(toJourneyDO(journey)));
    }

    /**
     * 删除一个journey
     * 根据ID
     * @param journeyID
     */
    public void deleteJourney(int journeyID){
        journeyDAO.deleteById(journeyID);
    }

    /**
     * 查询一个journey
     * 根据ID
     * @param journeyID
     * @return
     */
    public Journey queryJourneyByID(int journeyID){
        return toJourney(journeyDAO.findById(journeyID).get());
    }

    /**
     * 查询所有的journey记录
     * @return
     */
    public List<Journey> queryJourneys(){
        List<JourneyDO> journeyDOList=journeyDAO.findAll();
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
        List<JourneyDO> journeyDOList=journeyDAO.queryJourneyDOSByTimeBetween(TimeUtils.converseTrans(beginTime),TimeUtils.converseTrans(endTime));
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
    public List<Journey> queryJourneysByTimeBetween(LocalDate beginTime, LocalDate endTime){
        List<JourneyDO> journeyDOList=journeyDAO.queryJourneyDOSByTimeBetween(TimeUtils.converseTrans(beginTime),TimeUtils.converseTrans(endTime));
        for(JourneyDO j:journeyDOList){
            list.add(toJourney(j));
        }
        return list;
    }

    /**
     * 查询journey集合
     * 根据出发地点
     * @param origin
     * @return
     */
    public List<Journey> queryJourneysByOrigin(String origin){
        List<JourneyDO> journeyDOList=journeyDAO.queryJourneyDOSByOrigin(origin);
        for(JourneyDO j:journeyDOList){
            list.add(toJourney(j));
        }
        return list;
    }

    /**
     * 查询journey集合
     * 根据目的地
     * @param target
     * @return
     */
    public List<Journey> queryJourneysByTarget(String target){
        List<JourneyDO> journeyDOList=journeyDAO.queryJourneyDOSByTarget(target);
        for(JourneyDO j:journeyDOList){
            list.add(toJourney(j));
        }
        return list;
    }

    /**
     * 查询journey集合
     * 查询出发地点和目的地
     * @param origin 出发地点
     * @param target 目的地
     * @return
     */
    public List<Journey> queryJourneysByOriginAndTarget(String origin,String target){
        List<JourneyDO> journeyDOList=journeyDAO.queryJourneyDOSByOriginAndTarget(origin,target);
        for(JourneyDO j:journeyDOList){
            list.add(toJourney(j));
        }
        return list;
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
        List<JourneyDO> journeyDOList=journeyDAO.queryForPageItems(begin,pageSize);
        for(JourneyDO j:journeyDOList){
            list.add(toJourney(j));
        }
        return list;
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
