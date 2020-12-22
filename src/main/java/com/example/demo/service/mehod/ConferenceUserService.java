package com.example.demo.service.mehod;

import com.example.demo.dao.ConferenceUserDAO;
import com.example.demo.entity.DTO.Conference;
import com.example.demo.entity.DTO.ConferenceUser;
import com.example.demo.entity.DO.ConferenceUserDO;
import com.example.demo.entity.DTO.User;
import com.example.demo.enumValue.InvitationStatus;
import com.example.demo.enumValue.OrderStatus;
import com.example.demo.enumValue.Position;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * @author 李嘉旭 
 * 参会人员Service
 * 负责user和conference的多对多映射关系调用
 */
@Service
public class ConferenceUserService {
    @Autowired
    ConferenceUserDAO conferenceUserDAO;
    @Autowired
    UserService userService;
    @Autowired
    ConferenceService conferenceService;
    List<ConferenceUser> list=new ArrayList<>();
    List<ConferenceUserDO> conferenceUserDOList;

    /**
     * 增加或修改一个conferenceUser
     * 根据ID
     * 有则修改,无则增加
     * @param conferenceUser 要插入的conferenceUser
     * @return 插入后conferenceUser
     */
    public ConferenceUser saveConferenceUser(ConferenceUser conferenceUser){
        if (conferenceUser!=null){
            return toConferenceUser(conferenceUserDAO.save(toConferenceUserDO(conferenceUser)));
        }else {
            return null;
        }

    }

    /**
     * 删除一个conferenceUser
     * 根据ID
     * @param conferenceUserID 要删除的conferenceUserID
     */
    public int deleteConferenceUser(int conferenceUserID){
        try {
            conferenceUserDAO.deleteById(conferenceUserID);
            return 1;
        }catch (EmptyResultDataAccessException e){
            return -1;
        }

    }

    /**
     * 查询一个conferenceUser
     * 根据ID
     * @param conferenceUserID
     * @return
     */
    public ConferenceUser queryConferenceUserByID(int conferenceUserID){
        try {
            return toConferenceUser(conferenceUserDAO.findById(conferenceUserID).get());
        }catch (NoSuchElementException|NullPointerException e){
            return null;
        }

    }

    /**
     * 查询所有的conferenceUser
     * @return
     */
    public List<ConferenceUser> queryConferenceUsers(){
        list.clear();
        conferenceUserDOList=conferenceUserDAO.findAll();
        if (conferenceUserDOList.size()!=0){
            for(ConferenceUserDO c:conferenceUserDOList){
                list.add(toConferenceUser(c));
            }
            return list;
        }else {
            return null;
        }
    }

    /**
     * 查询conferenceUser集合
     * 根据user
     * @param user
     * @return
     */
    public List<ConferenceUser> queryConferenceUsersByUser(User user){
        list.clear();
        conferenceUserDOList=conferenceUserDAO.queryConferenceUserDOSByUserID(user.getID());
        if (conferenceUserDOList.size()!=0){
            for(ConferenceUserDO c:conferenceUserDOList){
                list.add(toConferenceUser(c));
            }
            return list;
        }else {
            return null;
        }
    }

    /**
     * 查询conferenceUser集合
     * 根据conference
     * @param conference
     * @return
     */
    public List<ConferenceUser> queryConferenceUsersByConference(Conference conference){
        list.clear();
        conferenceUserDOList=conferenceUserDAO.queryConferenceUserDOSByConferenceID(conference.getID());
        if (conferenceUserDOList.size()!=0){
            for(ConferenceUserDO c:conferenceUserDOList){
                list.add(toConferenceUser(c));
            }
            return list;
        }else {
            return null;
        }
    }

    /**
     * 查询conferenceUser集合
     * 根据user和position(在会议中的身份)
     * @param user
     * @param position
     * @return
     */
    public List<ConferenceUser> queryConferenceUsersByUserAndPosition(User user, Position position){
        list.clear();
        conferenceUserDOList=conferenceUserDAO.queryConferenceUserDOSByUserIDAndPosition(user.getID(),position.getPositionName());
        if (conferenceUserDOList.size()!=0){
            for(ConferenceUserDO c:conferenceUserDOList){
                list.add(toConferenceUser(c));
            }
            return list;
        }else {
            return null;
        }
    }

    /**
     * 查询conferenceUser集合
     * 根据user和invitationStatus(接受邀请的状态)
     * @param user
     * @param invitationStatus
     * @return
     */
    public List<ConferenceUser> queryConferenceUsersByUserAndInvitationStatus(User user, InvitationStatus invitationStatus){
        list.clear();
        conferenceUserDOList=conferenceUserDAO.queryConferenceUserDOSByUserIDAndInvitationStatus(user.getID(),invitationStatus.getNum());
        if (conferenceUserDOList.size()!=0){
            for(ConferenceUserDO c:conferenceUserDOList){
                list.add(toConferenceUser(c));
            }
            return list;
        }else {
            return null;
        }
    }

    /**
     * 查询conferenceUser集合
     * 根据user和orderStatus(申请接受的状态)
     * @param user
     * @param orderStatus
     * @return
     */
    public List<ConferenceUser> queryConferenceUsersByUserAndOrderStatus(User user, OrderStatus orderStatus){
        list.clear();
        conferenceUserDOList=conferenceUserDAO.queryConferenceUserDOSByUserIDAndOrderStatus(user.getID(),orderStatus.getNum());
        if (conferenceUserDOList.size()!=0){
            for(ConferenceUserDO c:conferenceUserDOList){
                list.add(toConferenceUser(c));
            }
            return list;
        }else {
            return null;
        }
    }

    /**
     * 查询conferenceUser集合
     * 根据conference和position(在会议中的身份)
     * @param conference
     * @param position
     * @return
     */
    public List<ConferenceUser> queryConferenceUsersByConferenceAndPosition(Conference conference,Position position){
        list.clear();
        conferenceUserDOList=conferenceUserDAO.queryConferenceUserDOSByConferenceIDAndPosition(conference.getID(),position.getPositionName());
        if (conferenceUserDOList.size()!=0){
            for(ConferenceUserDO c:conferenceUserDOList){
                list.add(toConferenceUser(c));
            }
            return list;
        }else {
            return null;
        }
    }

    /**
     * 查询conferenceUser集合
     * 根据conference和invitationStatus(接受邀请的状态)
     * @param conference
     * @param invitationStatus
     * @return
     */
    public List<ConferenceUser> queryConferenceUsersByConferenceAndInvitationStatus(Conference conference,InvitationStatus invitationStatus){
        list.clear();
        conferenceUserDOList=conferenceUserDAO.queryConferenceUserDOSByConferenceIDAndInvitationStatus(conference.getID(),invitationStatus.getNum());
        if (conferenceUserDOList.size()!=0){
            for(ConferenceUserDO c:conferenceUserDOList){
                list.add(toConferenceUser(c));
            }
            return list;
        }else {
            return null;
        }
    }

    /**
     * 查询conferenceUser集合
     * 根据conference和orderStatus(申请接受的状态)
     * @param conference
     * @param orderStatus
     * @return
     */
    public List<ConferenceUser> queryConferenceUsersByConferenceAndOrderStatus(Conference conference,OrderStatus orderStatus){
        list.clear();
        conferenceUserDOList=conferenceUserDAO.queryConferenceUserDOSByConferenceIDAndOrderStatus(conference.getID(),orderStatus.getNum());
        if (conferenceUserDOList.size()!=0){
            for(ConferenceUserDO c:conferenceUserDOList){
                list.add(toConferenceUser(c));
            }
            return list;
        }else {
            return null;
        }
    }

    /**
     * 查询conferenceUser记录的总数量
     * @return
     */
    public int queryForCountTotal(){
        return (int)conferenceUserDAO.count();
    }

    /**
     * 查询从begin开始的,长度为pageSize的记录
     * @param begin 起始位置
     * @param pageSize 页面长度
     * @return 一个页面的ConferenceUser集合
     */
    public List<ConferenceUser> queryForPageItems(int begin,int pageSize){
        list.clear();
        conferenceUserDOList=conferenceUserDAO.queryForPageItems(begin,pageSize);
        if (conferenceUserDOList.size()!=0){
            for(ConferenceUserDO c:conferenceUserDOList){
                list.add(toConferenceUser(c));
            }
            return list;
        }else {
            return null;
        }
    }

    /**
     * 转换方法
     * 将conferenceUserDO转换为conferenceUserDO
     * @param conferenceUserDO
     * @return
     */
    public ConferenceUser toConferenceUser(ConferenceUserDO conferenceUserDO){
        ConferenceUser conferenceUser=new ConferenceUser();

        conferenceUser.setID(conferenceUserDO.getID());
        conferenceUser.setUser(userService.queryUserByID(conferenceUserDO.getUserID()));
        conferenceUser.setConference(conferenceService.queryConferenceByID(conferenceUserDO.getConferenceID()));
        conferenceUser.setPosition(Position.choose(conferenceUserDO.getPosition()));
        conferenceUser.setInvitationStatus(InvitationStatus.choose(conferenceUserDO.getInvitationStatus()));
        conferenceUser.setOrderStatus(OrderStatus.choose(conferenceUserDO.getOrderStatus()));
        conferenceUser.setInfo(conferenceUserDO.getInfo());

        return conferenceUser;
    }

    /**
     * 转换方法
     * 将conferenceUser转换为conferenceUserDO
     * @param conferenceUser
     * @return
     */
    public ConferenceUserDO toConferenceUserDO(ConferenceUser conferenceUser){
        ConferenceUserDO conferenceUserDO=new ConferenceUserDO();

        conferenceUserDO.setID(conferenceUser.getID());
        conferenceUserDO.setUserID(conferenceUser.getUser().getID());
        conferenceUserDO.setConferenceID(conferenceUser.getConference().getID());
        conferenceUserDO.setPosition(conferenceUser.getPosition().getNum());
        conferenceUserDO.setInvitationStatus(conferenceUser.getInvitationStatus().getNum());
        conferenceUserDO.setOrderStatus(conferenceUser.getOrderStatus().getNum());
        conferenceUserDO.setInfo(conferenceUser.getInfo());

        return conferenceUserDO;
    }

}
