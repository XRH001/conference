package com.example.demo.service.mehod;

import com.example.demo.dao.HotelRoomDAO;
import com.example.demo.entity.DO.HotelRoomDO;
import com.example.demo.entity.DTO.HotelRoom;
import com.example.demo.entity.Hotel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 李嘉旭
 * 酒店房间Service
 * 负责调用酒店房间的信息
 */
@Service
public class HotelRoomService {
    @Autowired
    HotelRoomDAO hotelRoomDAO;
    @Autowired
    HotelService hotelService;
    List<HotelRoom> list=new ArrayList<>();
    List<HotelRoomDO> hotelRoomDOList=new ArrayList<>();

    /**
     * 增加或修改一个hotelRoom
     * 根据ID
     * 有则修改,无则增加
     * @param hotelRoom
     * @return
     */
    public HotelRoom saveHotelRoom(HotelRoom hotelRoom){
        return toHotelRoom(hotelRoomDAO.save(toHotelRoomDO(hotelRoom)));
    }

    /**
     * 删除一个hotelRoom
     * 根据ID
     * @param hotelRoomID
     */
    public void deleteHotelRoom(int hotelRoomID){
        hotelRoomDAO.deleteById(hotelRoomID);
    }

    /**
     * 查询一个hotelRoom
     * 根据ID
     * @param hotelRoomID
     * @return
     */
    public HotelRoom queryHotelRoomByID(int hotelRoomID){
        return toHotelRoom(hotelRoomDAO.findById(hotelRoomID).get());
    }

    /**
     * 查询所有的hotelRoom
     * @return
     */
    public List<HotelRoom> queryHotelRooms(){
        list.clear();
        hotelRoomDOList.clear();
        hotelRoomDOList=hotelRoomDAO.findAll();
        for(HotelRoomDO h:hotelRoomDOList){
            list.add(toHotelRoom(h));
        }
        return list;
    }

    /**
     * 查询hotelRoom记录的总数量
     * @return
     */
    public int queryForCountTotal(){
        return (int)hotelRoomDAO.count();
    }

    /**
     * 查询从begin开始的,长度为pageSize的记录
     * @param begin 起始位置
     * @param pageSize 页面长度
     * @return 一个页面的hotelRoom集合
     */
    public List<HotelRoom> queryForPageItems(int begin,int pageSize){
        list.clear();
        hotelRoomDOList.clear();
        hotelRoomDOList=hotelRoomDAO.queryForPageItems(begin, pageSize);
        for(HotelRoomDO h:hotelRoomDOList){
            list.add(toHotelRoom(h));
        }
        return list;
    }

    /**
     * 转换方法
     * 将hotelRoomDO转换为hotelRoom
     * @param hotelRoomDO
     * @return
     */
    public HotelRoom toHotelRoom(HotelRoomDO hotelRoomDO){
        HotelRoom hotelRoom=new HotelRoom();

        hotelRoom.setID(hotelRoomDO.getID());
        hotelRoom.setHotel(hotelService.queryHotelByID(hotelRoomDO.getHotelID()));
        hotelRoom.setIsUsed(hotelRoomDO.getIsUsed()==0?true:false);
        hotelRoom.setMaxNum(hotelRoomDO.getMaxNum());
        hotelRoom.setPrice(hotelRoomDO.getPrice());
        hotelRoom.setRoomID(hotelRoomDO.getRoomID());
        hotelRoom.setType(hotelRoomDO.getType());

        return hotelRoom;
    }

    /**
     * 转换方法
     * 将hotelRoom转换为hotelRoomDO
     * @param hotelRoom
     * @return
     */
    public HotelRoomDO toHotelRoomDO(HotelRoom hotelRoom){
        HotelRoomDO hotelRoomDO=new HotelRoomDO();

        hotelRoomDO.setID(hotelRoom.getID());
        hotelRoomDO.setHotelID(hotelRoom.getHotel().getID());
        hotelRoomDO.setIsUsed(hotelRoom.getIsUsed()==true?0:1);
        hotelRoomDO.setMaxNum(hotelRoom.getMaxNum());
        hotelRoomDO.setPrice(hotelRoom.getPrice());
        hotelRoomDO.setRoomID(hotelRoom.getRoomID());
        hotelRoomDO.setType(hotelRoom.getType());

        return hotelRoomDO;
    }
}
