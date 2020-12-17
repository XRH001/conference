package com.example.demo.dao;

import com.example.demo.entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdminDAO extends JpaRepository<Admin,Integer> {
    /**
     * 通过用户名查询admin
     * @param username
     * @return
     */
    public Admin queryAdminByUsername(String username);

    /**
     * 分页查询
     * @param begin
     * @param pageSize
     * @return
     */
    @Query(value = "select * from admin limit ?1,?2",nativeQuery = true)
    public List<Admin> queryForPageItems(int begin,int pageSize);
}
