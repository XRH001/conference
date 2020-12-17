package com.example.demo.service.mehod;

import com.example.demo.dao.HotelDAO;
import com.example.demo.entity.DTO.HotelRoom;
import com.example.demo.entity.Hotel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

/**
 * @author 李嘉旭
 * 酒店Service
 * 负责调用酒店的信息
 */
@Service
public class HotelService {
    @Autowired
    HotelDAO hotelDAO;
    List<Hotel> list;

    /**
     * 增加或修改一个hotel
     * 根据ID
     * 有则修改,无则增加
     * @param hotel 要插入的hotel
     * @return null表示失败,否则返回插入后的hotel
     */
    public Hotel saveHotel(Hotel hotel){
        if (hotel!=null){
            return hotelDAO.save(hotel);
        }else {
            return null;
        }
    }

    /**
     * 删除一个hotel
     * 根据ID
     * @param hotelID
     */
    public int deleteHotel(int hotelID){
        try {
            hotelDAO.deleteById(hotelID);
            return 1;
        }catch (EmptyResultDataAccessException e){
            return -1;
        }
    }

    /**
     * 查询一个hotel
     * 根据ID
     * @param hotelID
     * @return
     */
    public Hotel queryHotelByID(int hotelID){
        try {
            return hotelDAO.findById(hotelID).get();
        }catch (NoSuchElementException|NullPointerException e){
            return null;
        }

    }

    /**
     * 查询一个hotel
     * 根据名字
     * @param name
     * @return
     */
    public Hotel queryHotelByName(String name){
        try {
            return hotelDAO.queryHotelByName(name);
        }catch (NoSuchElementException|NullPointerException e){
            return null;
        }
    }

    /**
     * 查询一个hotel
     * 根据联系方式
     * @param phone
     * @return
     */
    public Hotel queryHotelByPhone(String phone){
        try {
            return hotelDAO.queryHotelByPhone(phone);
        }catch (NoSuchElementException|NullPointerException e){
            return null;
        }
    }

    /**
     * 查询hotel集合
     * 根据地址
     * @param address
     * @return
     */
    public List<Hotel> queryHotelByAddress(String address){
        list=hotelDAO.queryHotelsByAddress(address);
        if (list.size()!=0){
            return list;
        }else {
            return null;
        }
    }

    /**
     * 查询所有的hotel记录
     * @return
     */
    public List<Hotel> queryHotels(){
        return hotelDAO.findAll();
    }

    public Hotel queryHotelByEmail(String email){
        try {
            return hotelDAO.queryHotelByEmail(email);
        }catch (NoSuchElementException|NullPointerException e){
            return null;
        }
    }

    public Hotel queryHotelByUsername(String username){
        try {
            return hotelDAO.queryHotelByUsername(username);
        }catch (NoSuchElementException|NullPointerException e){
            return null;
        }
    }

    public List<Hotel> queryHotelsByNameContainingOrAddressContaining(String key){
        try {
            return hotelDAO.queryHotelsByNameContainingOrAddressContaining(key,key);
        }catch (NoSuchElementException|NullPointerException e){
            return null;
        }

    }

    /**
     * 查询hotel记录的总数量
     * @return
     */
    public int queryForPageCountTotal(){
        return (int) hotelDAO.count();
    }

    /**
     * 查询从begin开始的,长度为pageSize的记录
     * @param begin 起始位置
     * @param pageSize 页面长度
     * @return 一个页面的hotel集合
     */
    public List<Hotel> queryForPageItems(int begin,int pageSize){
        list=hotelDAO.queryForPageItems(begin,pageSize);
        if (list.size()!=0){
            return list;
        }else {
            return null;
        }
    }
}
