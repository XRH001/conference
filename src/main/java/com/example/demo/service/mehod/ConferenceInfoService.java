package com.example.demo.service.mehod;

import com.example.demo.dao.ConferenceInfoDAO;
import com.example.demo.entity.DO.ConferenceDO;
import com.example.demo.entity.DTO.Conference;
import com.example.demo.entity.DTO.ConferenceInfo;
import com.example.demo.entity.DO.ConferenceInfoDO;
import com.example.demo.enumValue.OrderStatus;
import com.example.demo.utils.TimeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * @author 李嘉旭
 * 会议信息Service
 * 用来调用会议类的附加信息
 */
@Service
public class ConferenceInfoService {
    @Autowired
    ConferenceInfoDAO conferenceInfoDAO;
    @Autowired
    ConferenceService conferenceService;
    List<ConferenceInfo> list=new ArrayList<>();
    List<ConferenceInfoDO> conferenceInfoDOList;

    /**
     * 增加或修改一个conferenceInfo
     * 根据ID
     * 有则修改,无则增加
     * @param conferenceInfo 给出的conferenceInfo
     * @return 插入后的conferenceInfo
     */
    public ConferenceInfo saveConferenceInfo(ConferenceInfo conferenceInfo){
        if (conferenceInfo!=null){
            return toConferenceInfo(conferenceInfoDAO.save(toConferenceInfoDO(conferenceInfo)));
        }else {
            return null;
        }
    }

    /**
     * 删除一个conferenceID
     * 根据ID
     * @param conferenceInfoID 给出的conferenceInfo
     */
    public int deleteConferenceInfo(int conferenceInfoID){
        try {
            conferenceInfoDAO.deleteById(conferenceInfoID);
            return 1;
        }catch (EmptyResultDataAccessException e){
            return -1;
        }
    }

    /**
     * 查询一个conferenceInfo
     * 根据ID
     * @param conferenceInfoID 给出的conferenceInfo
     * @return null表示失败,否则表示查询结果
     */
    public ConferenceInfo queryConferenceInfoByID(int conferenceInfoID){
        try {
            return toConferenceInfo(conferenceInfoDAO.findById(conferenceInfoID).get());
        }catch (NoSuchElementException|NullPointerException e){
            return null;
        }
    }

    public ConferenceInfo queryConferenceInfoByConference(Conference conference){
        try {
            return toConferenceInfo(conferenceInfoDAO.queryConferenceInfoDOByConferenceID(conference.getID()));
        }catch (NoSuchElementException|NullPointerException e){
            return null;
        }
    }

    /**
     * 查询所有的conferenceInfo
     * @return null表示失败,否则表示查询结果
     */
    public List<ConferenceInfo> queryConferenceInfos(){
        list.clear();
        conferenceInfoDOList=conferenceInfoDAO.findAll();
        if (conferenceInfoDOList.size()!=0){
            for (ConferenceInfoDO c:conferenceInfoDOList){
                list.add(toConferenceInfo(c));
            }
            return list;
        }else {
            return null;
        }
    }

    /**
     * 查询conferenceInfo的总数量
     * @return 查询结果
     */
    public int queryForCountTotal(){
        return (int) conferenceInfoDAO.count();
    }

    /**
     * 查询从begin开始,长度为pageSize的分页记录
     * @param begin 起始位置
     * @param pageSize 页面长度
     * @return null表示查询失败,否则表示查询结果
     */
    public List<ConferenceInfo> queryPageItems(int begin,int pageSize){
        try {
            list.clear();
            conferenceInfoDOList=conferenceInfoDAO.queryForPageItems(begin,pageSize);
            if (conferenceInfoDOList.size()!=0){
                for (ConferenceInfoDO c:conferenceInfoDOList){
                    list.add(toConferenceInfo(c));
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
     * 将ConferenceInfo转换为ConferenceInfoDO
     * @param conferenceInfoDO
     * @return
     */
    public ConferenceInfo toConferenceInfo(ConferenceInfoDO conferenceInfoDO){
        ConferenceInfo conferenceInfo=new ConferenceInfo();

        conferenceInfo.setID(conferenceInfoDO.getID());
        conferenceInfo.setConference(conferenceService.queryConferenceByID(conferenceInfoDO.getConferenceID()));
        conferenceInfo.setInfo(conferenceInfoDO.getInfo());

        return conferenceInfo;
    }

    /**
     * 转换方法
     * 将ConferenceInfo转换为ConferenceInfoDO
     * @param conferenceInfo
     * @return
     */
    public ConferenceInfoDO toConferenceInfoDO(ConferenceInfo conferenceInfo){
        ConferenceInfoDO conferenceInfoDO=new ConferenceInfoDO();

        conferenceInfoDO.setID(conferenceInfo.getID());
        conferenceInfoDO.setConferenceID(conferenceInfo.getConference().getID());
        conferenceInfoDO.setInfo(conferenceInfo.getInfo());

        return  conferenceInfoDO;
    }
}
