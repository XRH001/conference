package com.example.demo.service.mehod;

import com.example.demo.dao.HotelDAO;
import com.example.demo.entity.Hotel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 李嘉旭
 * 酒店Service
 * 负责调用酒店的信息
 */
@Service
public class HotelService {
    @Autowired
    HotelDAO hotelDAO;

    /**
     * 增加或修改一个hotel
     * 根据ID
     * 有则修改,无则增加
     * @param hotel 要插入的hotel
     * @return null表示失败,否则返回插入后的hotel
     */
    public Hotel saveHotel(Hotel hotel){
        return hotelDAO.save(hotel);
    }

    /**
     * 删除一个hotel
     * 根据ID
     * @param hotelID
     */
    public void deleteHotel(int hotelID){
        hotelDAO.deleteById(hotelID);
    }

    /**
     * 查询一个hotel
     * 根据ID
     * @param hotelID
     * @return
     */
    public Hotel queryHotelByID(int hotelID){
        return hotelDAO.findById(hotelID).get();
    }

    /**
     * 查询一个hotel
     * 根据名字
     * @param name
     * @return
     */
    public Hotel queryHotelByName(String name){
        return hotelDAO.queryHotelByName(name);
    }

    /**
     * 查询一个hotel
     * 根据联系方式
     * @param phone
     * @return
     */
    public Hotel queryHotelByPhone(String phone){
        return hotelDAO.queryHotelByPhone(phone);
    }

    /**
     * 查询hotel集合
     * 根据地址
     * @param address
     * @return
     */
    public List<Hotel> queryHotelByAddress(String address){
        return hotelDAO.queryHotelsByAddress(address);
    }

    /**
     * 查询所有的hotel记录
     * @return
     */
    public List<Hotel> queryHotels(){
        return hotelDAO.findAll();
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
        return hotelDAO.queryForPageItems(begin,pageSize);
    }
}
