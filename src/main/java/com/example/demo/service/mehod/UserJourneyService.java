package com.example.demo.service.mehod;

import com.example.demo.dao.UserJourneyDAO;
import com.example.demo.entity.DO.UserJourneyDO;
import com.example.demo.entity.DTO.Conference;
import com.example.demo.entity.DTO.Journey;
import com.example.demo.entity.DTO.User;
import com.example.demo.entity.DTO.UserJourney;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * @author 李嘉旭
 * 用户出行Service
 * 负责user和journey的多对多映射关系信息
 */
@Service
public class UserJourneyService {
    @Autowired
    UserJourneyDAO userJourneyDAO;
    @Autowired
    UserService userService;
    @Autowired
    JourneyService journeyService;
    @Autowired
    ConferenceService conferenceService;
    List<UserJourney> list=new ArrayList<>();
    List<UserJourneyDO> userJourneyDOList=new ArrayList<>();

    /**
     * 增加或修改一个userJourney
     * 根据ID
     * 有则修改,无则增加
     * @param userJourney
     * @return
     */
    public UserJourney saveUserJourney(UserJourney userJourney){
        if (userJourney!=null){
            return toUserJourney(userJourneyDAO.save(toUserJourneyDO(userJourney)));
        }else {
            return null;
        }
    }

    /**
     * 删除一个userJourney
     * 根据ID
     * @param userJourneyID
     */
    public int deleteUserJourney(int userJourneyID){
        try {
            userJourneyDAO.deleteById(userJourneyID);
            return 1;
        }catch (EmptyResultDataAccessException e){
            return -1;
        }
    }

    /**
     * 查询一个userJourney
     * 根据ID
     * @param userJourneyID
     * @return
     */
    public UserJourney queryUserJourneyByID(int userJourneyID){
        try {
            return toUserJourney(userJourneyDAO.findById(userJourneyID).get());
        }catch (NoSuchElementException|NullPointerException e){
            return null;
        }
    }

    /**
     * 查询所有的userJourney记录
     * @return
     */
    public List<UserJourney> queryUserJourneys(){
        list.clear();
        userJourneyDOList=userJourneyDAO.findAll();
        if (userJourneyDOList.size()!=0){
            for(UserJourneyDO u:userJourneyDOList){
                list.add(toUserJourney(u));
            }
            return list;
        }else {
            return null;
        }
    }

    public List<UserJourney> queryUserJourneysByUser(User user){
        list.clear();
        userJourneyDOList=userJourneyDAO.queryUserJourneyDOSByUserID(user.getID());
        if (userJourneyDOList.size()!=0){
            for(UserJourneyDO u:userJourneyDOList){
                list.add(toUserJourney(u));
            }
            return list;
        }else {
            return null;
        }
    }

    public List<UserJourney> queryUserJourneysByJourney(Journey journey){
        list.clear();
        userJourneyDOList=userJourneyDAO.queryUserJourneyDOSByJourneyID(journey.getID());
        if (userJourneyDOList.size()!=0){
            for(UserJourneyDO u:userJourneyDOList){
                list.add(toUserJourney(u));
            }
            return list;
        }else {
            return null;
        }
    }

    public List<UserJourney> queryUserJourneysByConference(Conference conference){
        list.clear();
        userJourneyDOList=userJourneyDAO.queryUserJourneyDOSByConferenceID(conference.getID());
        if (userJourneyDOList.size()!=0){
            for(UserJourneyDO u:userJourneyDOList){
                list.add(toUserJourney(u));
            }
            return list;
        }else {
            return null;
        }
    }

    /**
     * 查询userJourney记录的总数量
     * @return
     */
    public int queryForCountTotal(){
        return (int) userJourneyDAO.count();
    }

    public List<UserJourney> queryForPageItems(int beign,int pageSize){
        try {
            list.clear();
            userJourneyDOList=userJourneyDAO.queryForPageItems(beign, pageSize);
            if (userJourneyDOList.size()!=0){
                for(UserJourneyDO u:userJourneyDOList){
                    list.add(toUserJourney(u));
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
     * 将userJourneyDO转换为userJourney
     * @param userJourneyDO
     * @return
     */
    public UserJourney toUserJourney(UserJourneyDO userJourneyDO){
          UserJourney userJourney=new UserJourney();

          userJourney.setID(userJourneyDO.getID());
          userJourney.setUser(userService.queryUserByID(userJourneyDO.getUserID()));
          userJourney.setJourney(journeyService.queryJourneyByID(userJourneyDO.getJourneyID()));
          userJourney.setConference(conferenceService.queryConferenceByID(userJourneyDO.getConferenceID()));

          return userJourney;
      }

    /**
     * 转换方法
     * 将userJourney转换为userJourneyDO
     * @param userJourney
     * @return
     */
    public UserJourneyDO toUserJourneyDO(UserJourney userJourney){
          UserJourneyDO userJourneyDO=new UserJourneyDO();

          userJourneyDO.setID(userJourney.getID());
          userJourneyDO.setJourneyID(userJourney.getJourney().getID());
          userJourneyDO.setUserID(userJourney.getUser().getID());
          userJourneyDO.setConferenceID(userJourney.getConference().getID());

          return userJourneyDO;
      }

}
