package com.example.demo.service.mehod;

import com.example.demo.dao.ConferenceDAO;
import com.example.demo.entity.DTO.Conference;
import com.example.demo.entity.DO.ConferenceDO;
import com.example.demo.enumValue.OrderStatus;
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
 * 会议Service
 * 用来调用会议信息
 */
@Service
public class ConferenceService {
    @Autowired
    ConferenceDAO conferenceDAO;
    List<Conference> list=new ArrayList<>();
    List<ConferenceDO> conferenceDOList;

    /**
     * 增加或修改一个conference
     * 根据ID
     * 有则修改,无则增加
     * @param conference 给出的conference
     * @return 插入后的conference
     */
    public Conference saveConference(Conference conference){
        if (conference!=null){
            return toConference(conferenceDAO.save(toConferenceDO(conference)));
        }else {
            return null;
        }
    }

    /**
     * 删除一个conference
     * 根据ID
     * @param conferenceID
     * @return
     */
    public int deleteConference(int conferenceID){
        try {
            conferenceDAO.deleteById(conferenceID);
            return 1;
        }catch (EmptyResultDataAccessException e){
            return -1;
        }
    }

    public Conference queryConferenceByID(int conferenceID){
        try {
            return toConference(conferenceDAO.findById(conferenceID).get());
        }catch (NoSuchElementException|NullPointerException e){
            return null;
        }
    }

    /**
     * 查询所有的conference信息
     * @return 查询的conference集合
     */
    public List<Conference> queryConferences(){
        list.clear();
        conferenceDOList=conferenceDAO.findAll();
        if (conferenceDOList.size()!=0){
            for(ConferenceDO c:conferenceDOList){
                list.add(toConference(c));
            }
            return list;
        }else {
            return null;
        }
    }

    /**
     * 查询conference集合
     * 根据名字
     * @param name
     * @return
     */
    public List<Conference> queryConferencesByName(String name){
        list.clear();
        conferenceDOList=conferenceDAO.queryConferenceDOSByName(name);
        if (conferenceDOList.size()!=0){
            for(ConferenceDO c:conferenceDOList){
                list.add(toConference(c));
            }
            return list;
        }else {
            return null;
        }
    }

    /**
     * 查询conference集合
     * 根据地址
     * @param address
     * @return
     */
    public List<Conference> queryConferencesByAddress(String address){
        list.clear();
        conferenceDOList=conferenceDAO.queryConferenceDOSByAddress(address);
        if (conferenceDOList.size()!=0){
            for(ConferenceDO c:conferenceDOList){
                list.add(toConference(c));
            }
            return list;
        }else {
            return null;
        }
    }

    /**
     * 查询conference集合
     * 根据会议进行的状态
     * @param orderStatus
     * @return
     */
    public List<Conference> queryConferencesByOrderStatus(OrderStatus orderStatus){
        list.clear();
        conferenceDOList=conferenceDAO.queryConferenceDOSByOrderStatus(orderStatus.getNum());
        if (conferenceDOList.size()!=0){
            for(ConferenceDO c:conferenceDOList){
                list.add(toConference(c));
            }
            return list;
        }else {
            return null;
        }
    }

    /**
     * 查询conference集合
     * 根据创建时间
     * 在一个时间段内的所有conference
     * @param beginTime 开始时间
     * @param endTime 结束时间
     * @return
     */
    public List<Conference> queryConferencesByCreateTimeBetween(LocalDateTime beginTime, LocalDateTime endTime){
        list.clear();
        conferenceDOList=conferenceDAO.queryConferenceDOSByCreateTimeBetween(
                TimeUtils.converseTrans(beginTime), TimeUtils.converseTrans(endTime));
        if (conferenceDOList.size()!=0){
            for(ConferenceDO c:conferenceDOList){
                list.add(toConference(c));
            }
            return list;
        }else {
            return null;
        }
    }

    /**
     * 查询conference集合
     * 根据创建时间
     * 在一个时间段内的所有conference
     * @param beginTime 开始时间
     * @param endTime 结束时间
     * @return
     */
    public List<Conference> queryConferencesByCreateTimeBetween(LocalDate beginTime, LocalDate endTime){
        list.clear();
        conferenceDOList=conferenceDAO.queryConferenceDOSByCreateTimeBetween(
                TimeUtils.converseTrans(beginTime), TimeUtils.converseTrans(endTime));
        if (conferenceDOList.size()!=0){
            for(ConferenceDO c:conferenceDOList){
                list.add(toConference(c));
            }
            return list;
        }else {
            return null;
        }
    }

    /**
     * 查询conference集合
     * 根据开始时间
     * 在一个时间段内的所有conference
     * @param beginTime 开始时间
     * @param endTime 结束时间
     * @return
     */
    public List<Conference> queryConferencesByBeginTimeBetween(LocalDateTime beginTime,LocalDateTime endTime){
        list.clear();
        conferenceDOList=conferenceDAO.queryConferenceDOSByCreateTimeBetween(
                TimeUtils.converseTrans(beginTime), TimeUtils.converseTrans(endTime));
        if (conferenceDOList.size()!=0){
            for(ConferenceDO c:conferenceDOList){
                list.add(toConference(c));
            }
            return list;
        }else {
            return null;
        }
    }

    /**
     * 查询conference集合
     * 根据开始时间
     * 在一个时间段内的所有conference
     * @param beginTime 开始时间
     * @param endTime 结束时间
     * @return
     */
    public List<Conference> queryConferencesByBeginTimeBetween(LocalDate beginTime,LocalDate endTime){
        list.clear();
        conferenceDOList=conferenceDAO.queryConferenceDOSByCreateTimeBetween(
                TimeUtils.converseTrans(beginTime), TimeUtils.converseTrans(endTime));
        if (conferenceDOList.size()!=0){
            for(ConferenceDO c:conferenceDOList){
                list.add(toConference(c));
            }
            return list;
        }else {
            return null;
        }
    }

    /**
     * 查询conference集合
     * 根据结束时间
     * 在一个时间段内的所有conference
     * @param beginTime 开始时间
     * @param endTime 结束时间
     * @return
     */
    public List<Conference> queryConferencesByEndTimeBetween(LocalDateTime beginTime,LocalDateTime endTime){
        list.clear();
        conferenceDOList=conferenceDAO.queryConferenceDOSByCreateTimeBetween(
                TimeUtils.converseTrans(beginTime), TimeUtils.converseTrans(endTime));
        if (conferenceDOList.size()!=0){
            for(ConferenceDO c:conferenceDOList){
                list.add(toConference(c));
            }
            return list;
        }else {
            return null;
        }
    }

    /**
     * 查询conference集合
     * 根据结束时间
     * 在一个时间段内的所有conference
     * @param beginTime 开始时间
     * @param endTime 结束时间
     * @return
     */
    public List<Conference> queryConferencesByEndTimeBetween(LocalDate beginTime,LocalDate endTime){
        list.clear();
        conferenceDOList=conferenceDAO.queryConferenceDOSByCreateTimeBetween(
                TimeUtils.converseTrans(beginTime), TimeUtils.converseTrans(endTime));
        if (conferenceDOList.size()!=0){
            for(ConferenceDO c:conferenceDOList){
                list.add(toConference(c));
            }
            return list;
        }else {
            return null;
        }
    }

    public List<Conference> queryConferenceDOSByNameContaining(String name){
        list.clear();
        conferenceDOList=conferenceDAO.queryConferenceDOSByNameContaining(name);
        if (conferenceDOList.size()!=0){
            for(ConferenceDO c:conferenceDOList){
                list.add(toConference(c));
            }
            return list;
        }else {
            return null;
        }
    }

    /**
     * 查询总共的记录结果
     * @return
     */
    public int queryForPageCountTotal(){
        Number count=conferenceDAO.count();
        return count.intValue();
    }

    /**
     * 查询从begin开始的,长度为pageSize的记录
     * @param begin 起始位置
     * @param pageSize 页面长度
     * @return 一个页面的conference集合
     */
    public List<Conference> queryForPageItems(int begin,int pageSize){
        try {
            list.clear();
            conferenceDOList=conferenceDAO.queryForPageItems(begin,pageSize);
            if (conferenceDOList.size()!=0){
                for(ConferenceDO c:conferenceDOList){
                    list.add(toConference(c));
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
     * 将ConferenceDO转换为Conference
     * @param conferenceDO
     * @return
     */
    public Conference toConference(ConferenceDO conferenceDO){
        Conference conference=new Conference();

        conference.setID(conferenceDO.getID());
        conference.setName(conferenceDO.getName());
        conference.setAddress(conferenceDO.getAddress());
        conference.setOrderStatus(OrderStatus.choose(conferenceDO.getOrderStatus()));
        conference.setNum(conferenceDO.getNum());
        conference.setCreateTime(TimeUtils.transLocalDateTime(conferenceDO.getCreateTime()));
        conference.setBeginTime(TimeUtils.transLocalDateTime(conferenceDO.getBeginTime()));
        conference.setEndTime(TimeUtils.transLocalDateTime(conferenceDO.getEndTime()));
        conference.setPrivate(conferenceDO.getIsPrivate()==0?true:false);

        return conference;
    }

    /**
     * 转换方法
     * 将Conference转换为ConferenceDO
     * @param conference
     * @return
     */
    public ConferenceDO toConferenceDO(Conference conference){
        ConferenceDO conferenceDO=new ConferenceDO();

        conferenceDO.setID(conference.getID());
        conferenceDO.setName(conference.getName());
        conferenceDO.setAddress(conference.getAddress());
        conferenceDO.setOrderStatus(conference.getOrderStatus().getNum());
        conferenceDO.setNum(conference.getNum());
        conferenceDO.setCreateTime(TimeUtils.converseTrans(conference.getCreateTime()));
        conferenceDO.setBeginTime(TimeUtils.converseTrans(conference.getBeginTime()));
        conferenceDO.setEndTime(TimeUtils.converseTrans(conference.getEndTime()));
        conferenceDO.setIsPrivate(conference.isPrivate()==true?0:1);

        return conferenceDO;
    }

}
