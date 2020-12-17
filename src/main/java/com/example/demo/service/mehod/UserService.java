package com.example.demo.service.mehod;

import com.example.demo.dao.UserDAO;
import com.example.demo.entity.DTO.User;
import com.example.demo.entity.DO.UserDO;
import com.example.demo.enumValue.Identity;
import com.example.demo.enumValue.Sex;
import com.example.demo.utils.TimeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

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
    List<UserDO> userDOList;

    /**
     * 增加或修改一个user
     * 根据ID
     * 有则修改,无则增加
     * @param user
     * @return
     */
    public User saveUser(User user){
        if (user!=null){
            return toUser(userDAO.save(toUserDO(user)));
        }else {
            return null;
        }
    }

    /**
     * 删除一个user
     * 根据ID
     * @param userID
     */
    public int deleteUser(int userID){
        try {
            userDAO.deleteById(userID);
            return 1;
        }catch (EmptyResultDataAccessException e){
            return -1;
        }
    }

    /**
     * 查询一个user
     * 根据ID
     * @param userID
     * @return
     */
    public User queryUserByID(int userID){
        try {
            return toUser(userDAO.findById(userID).get());
        }catch (NoSuchElementException e){
            return null;
        }
    }

    /**
     * 查询所有的user集合
     * @return
     */
    public List<User> queryUsers(){
        userDOList=userDAO.findAll();
        if (userDOList.size()!=0){
            for(UserDO u:userDOList){
                list.add(toUser(u));
            }
            return list;
        }else {
            return null;
        }
    }

    /**
     * 查询一个user
     * 根据用户名
     * @param username
     * @return
     */
    public User queryUserByUsername(String username){
        try {
            return toUser(userDAO.queryUserDOByUsername(username));
        }catch (NoSuchElementException e){
            return null;
        }

    }

    /**
     * 查询user集合
     * 根据姓名
     * @param name
     * @return
     */
    public List<User> queryUsersByName(String name){
        userDOList=userDAO.queryUserDOSByName(name);
        if (userDOList.size()!=0){
            for(UserDO u:userDOList){
                list.add(toUser(u));
            }
            return list;
        }else {
            return null;
        }
    }

    /**
     * 查询user集合
     * 根据性别
     * @param sex
     * @return
     */
    public List<User> queryUsersBySex(Sex sex){
        userDOList=userDAO.queryUserDOSBySex(sex.getNum());
        if (userDOList.size()!=0){
            for(UserDO u:userDOList){
                list.add(toUser(u));
            }
            return list;
        }else {
            return null;
        }
    }

    /**
     * 查询user集合
     * 根据出生日期
     * @param time
     * @return
     */
    public List<User> queryUsersByBirth(LocalDate time){
        userDOList=userDAO.queryUserDOSByBirth(TimeUtils.converseTrans(LocalDateTime.of(time, LocalTime.of(0,0,0))));
        if (userDOList.size()!=0){
            for(UserDO u:userDOList){
                list.add(toUser(u));
            }
            return list;
        }else {
            return null;
        }
    }

    /**
     * 查询一个user
     * 根据电子邮箱
     * @param email
     * @return
     */
    public User queryUserByEmail(String email){
        try {
            return toUser(userDAO.queryUserDOByEmail(email));
        }catch (Exception e){
            return null;
        }
    }

    /**
     * 查询一个user
     * 根据电话号码
     * @param phone
     * @return
     */
    public User queryUserByPhone(String phone){
        try {
            return toUser(userDAO.queryUserDOByPhone(phone));
        }catch (NoSuchElementException e){
            return null;
        }
    }

    public List<User> queryUserDOSByNameContaining(String name){
        userDOList=userDAO.queryUserDOSByNameContaining(name);
        if (userDOList.size()!=0){
            for(UserDO u:userDOList){
                list.add(toUser(u));
            }
            return list;
        }else {
            return null;
        }
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
        try {
            userDOList=userDAO.queryForPageItems(begin,pageSize);
            if (userDOList.size()!=0){
                for(UserDO u:userDOList){
                    list.add(toUser(u));
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
        userDO.setEmail(user.getEmail());
        userDO.setImgPath(user.getImgPath());
        userDO.setPhone(user.getPhone());

        return userDO;
    }
}
