package com.example.demo.service.mehod;

import com.example.demo.dao.AdminDAO;
import com.example.demo.entity.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

/**
 * @author 李嘉旭
 * 系统管理员Service层
 * 负责调用系统管理员的信息
 */
@Service
public class AdminService{
    @Autowired
    AdminDAO adminDAO;

    /**
     * 增加或修改一个admin
     * 根据ID
     * 有则修改,无则增加
     * @param admin 新增加的admin
     * @return null表示失败,否则表示成功
     */
    public Admin saveAdmin(Admin admin){
        if (admin!=null){
            return adminDAO.save(admin);
        }else {
            return null;
        }
    }

    /**
     * 删除一个admin
     * @param adminID 要删除的adminID
     */
    public int deleteAdmin(int adminID){
        try {
            adminDAO.deleteById(adminID);
            return 1;
        }catch (EmptyResultDataAccessException e){
            return -1;
        }
    }

    /**
     * 返回所有admin
     * @return 包含所有admin的一个list
     */
    public List<Admin> queryAdmins(){
        return adminDAO.findAll();
    }

    /**
     * 根据ID查询admin
     * @param adminID 管理员ID
     * @return null表示失败,否则表示成功
     */
    public Admin queryAdminByID(int adminID){
        try {
            return adminDAO.findById(adminID).get();
        }catch (NoSuchElementException|NullPointerException e){
            return null;
        }
    }

    /**
     * 根据username查询admin
     * @param username 管理员用户名
     * @return null表示失败,否则表示成功
     */
    public Admin queryAdminByUsername(String username){
        try {
            return adminDAO.queryAdminByUsername(username);
        }catch (NoSuchElementException|NullPointerException e){
            return null;
        }
    }

    /**
     * 查询记录的数量
     * @return 记录的总数量
     */
    public int queryForPageCountTotal(){
        return (int) adminDAO.count();
    }

    /**
     * 查询从begin开始的,长度为pageSize的记录
     * @param begin 起始位置
     * @param pageSize 页面长度
     * @return 一个页面的admin集合
     */
    public List<Admin> queryForPageItems(int begin,int pageSize){
        return adminDAO.queryForPageItems(begin,pageSize);
    }
}
