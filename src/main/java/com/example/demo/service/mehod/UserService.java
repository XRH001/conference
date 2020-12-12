package com.example.demo.service.mehod;

import com.example.demo.dao.UserDAO;
import com.example.demo.entity.DTO.User;
import com.example.demo.entity.DO.UserDO;
import com.example.demo.enumValue.Identity;
import com.example.demo.enumValue.Sex;
import com.example.demo.utils.TimeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 李嘉旭
 * 用户Service
 * 负责调用用户信息
 */
@Service
public class UserService {
    @Autowired
    UserDAO userDAO;
    List<User> list=new ArrayList<>();

    /**
     * 增加或修改一个user
     * 根据ID
     * 有则修改,无则增加
     * @param user
     * @return
     */
    public User saveUser(User user){
        return toUser(userDAO.save(toUserDO(user)));
    }

    /**
     * 删除一个user
     * 根据ID
     * @param userID
     */
    public void deleteUser(int userID){
        userDAO.deleteById(userID);
    }

    /**
     * 查询一个user
     * 根据ID
     * @param userID
     * @return
     */
    public User queryUserByID(int userID){
        return toUser(userDAO.findById(userID).get());
    }

    /**
     * 查询所有的user集合
     * @return
     */
    public List<User> queryUsers(){
        List<UserDO> userDOList=userDAO.findAll();
        for(UserDO u:userDOList){
            list.add(toUser(u));
        }
        return list;
    }

    /**
     * 查询一个user
     * 根据用户名
     * @param username
     * @return
     */
    public User queryUserByUsername(String username){
        return toUser(userDAO.queryUserDOByUsername(username));
    }

    /**
     * 查询user集合
     * 根据姓名
     * @param name
     * @return
     */
    public List<User> queryUsersByName(String name){
        List<UserDO> userDOList=userDAO.queryUserDOSByName(name);
        for(UserDO u:userDOList){
            list.add(toUser(u));
        }
        return list;
    }

    /**
     * 查询user集合
     * 根据性别
     * @param sex
     * @return
     */
    public List<User> queryUsersBySex(Sex sex){
        List<UserDO> userDOList=userDAO.queryUserDOSBySex(sex.getNum());
        for(UserDO u:userDOList){
            list.add(toUser(u));
        }
        return list;
    }

    /**
     * 查询user集合
     * 根据出生日期
     * @param time
     * @return
     */
    public List<User> queryUsersByBirth(LocalDate time){
        List<UserDO> userDOList=userDAO.queryUserDOSByBirth(TimeUtils.converseTrans(LocalDateTime.of(time, LocalTime.of(0,0,0))));
        for(UserDO u:userDOList){
            list.add(toUser(u));
        }
        return list;
    }

    /**
     * 查询user集合
     * 根据用户身份
     * @param identity
     * @return
     */
    public List<User> queryUsersByIdentity(Identity identity){
        List<UserDO> userDOList=userDAO.queryUserDOSByIdentity(identity.getID());
        for(UserDO u:userDOList){
            list.add(toUser(u));
        }
        return list;
    }

    /**
     * 查询一个user
     * 根据电子邮箱
     * @param email
     * @return
     */
    public User queryUserByEmail(String email){
        return toUser(userDAO.queryUserDOByEmail(email));
    }

    /**
     * 查询一个user
     * 根据电话号码
     * @param phone
     * @return
     */
    public User queryUserByPhone(String phone){
        return toUser(userDAO.queryUserDOByPhone(phone));
    }

    /**
     * 查询user记录的总数量
     * @return
     */
    public int queryForPageCountTotal(){
        return (int)userDAO.count();
    }

    /**
     * 查询从begin开始的,长度为pageSize的记录
     * @param begin 起始位置
     * @param pageSize 页面长度
     * @return 一个页面的user集合
     */
    public List<User> queryForPageItems(int begin,int pageSize){
        List<UserDO> userDOList=userDAO.queryForPageItems(begin,pageSize);
        for(UserDO u:userDOList){
            list.add(toUser(u));
        }
        return list;
    }

    /**
     * 转换方法
     * 将userDO转换为user
     * @param userDO
     * @return
     */
    public User toUser(UserDO userDO){
        User user=new User();
        
        user.setID(userDO.getID()); ;
        user.setName(userDO.getName());;
        user.setUsername(userDO.getUsername());
        user.setPassword(userDO.getPassword());
        user.setSex(userDO.getSex()==0?Sex.Male: Sex.Female); ;
        user.setBirth(TimeUtils.transLocalDate(userDO.getBirth())) ;
        user.setIdentity (Identity.choose(userDO.getIdentity())); ;
        user.setEmail(userDO.getEmail())  ;
        user.setImgPath(userDO.getImgPath());
        user.setPhone(userDO.getPhone());
        
        return user;
    }

    /**
     * 转换方法
     * 将user转换为userDO
     * @param user
     * @return
     */
    public UserDO toUserDO(User user){
        UserDO userDO=new UserDO();

        userDO.setID(user.getID());
        userDO.setName(user.getName());
        userDO.setUsername(user.getUsername());
        userDO.setPassword(user.getPassword());
        userDO.setSex(user.getSex().getNum());
        userDO.setBirth(TimeUtils.converseTrans(user.getBirth()));
        userDO.setIdentity(user.getIdentity().getID());
        userDO.setEmail(user.getEmail());
        userDO.setImgPath(user.getImgPath());
        userDO.setPhone(user.getPhone());

        return userDO;
    }
}
