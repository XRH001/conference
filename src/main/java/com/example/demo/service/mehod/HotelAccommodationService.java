package com.example.demo.service.mehod;

import com.example.demo.dao.HotelAccommodationDAO;
import com.example.demo.entity.DO.HotelAccommodationDO;
import com.example.demo.entity.DTO.HotelAccommodation;
import com.example.demo.entity.DTO.HotelOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * @author 李嘉旭
 * 酒店住宿Service
 * 负责hotelOrder和conferenceUser的多对多映射关系信息调用
 */
@Service
public class HotelAccommodationService {
    @Autowired
    HotelAccommodationDAO hotelAccommodationDAO;
    @Autowired
    ConferenceUserService conferenceUserService;
    @Autowired
    HotelOrderService hotelOrderService;
    List<HotelAccommodation> list=new ArrayList<>();
    List<HotelAccommodationDO> hotelAccommodationDOList=new ArrayList<>();

    /**
     * 增加或修改一个hotelAccommodation
     * 根据ID
     * 有则修改,无则增加
     * @param hotelAccommodation
     * @return
     */
    public HotelAccommodation saveHotelAccommodation(HotelAccommodation hotelAccommodation){
        if (hotelAccommodation!=null){
            return toHotelAccommodation(hotelAccommodationDAO.save(toHotelAccommodationDO(hotelAccommodation)));
        }else {
            return null;
        }
    }

    /**
     * 删除一个hotelAccommodation
     * 根据ID
     * @param hotelAccommodationID
     */
    public int deleteHotelAccommodation(int hotelAccommodationID){
        try {
            hotelAccommodationDAO.deleteById(hotelAccommodationID);
            return 1;
        }catch (EmptyResultDataAccessException e){
            return -1;
        }

    }

    /**
     * 查询一个hotelAccommodation
     * 根据ID
     * @param hotelAccommodationID
     * @return
     */
    public HotelAccommodation queryHotelAccommodationByID(int hotelAccommodationID){
        try {
            return toHotelAccommodation(hotelAccommodationDAO.findById(hotelAccommodationID).get());
        }catch (NoSuchElementException e){
            return null;
        }
    }

    /**
     * 查询所有的hotelAccommodation记录
     * @return
     */
    public List<HotelAccommodation> queryHotelAccommodations(){
        list.clear();
        hotelAccommodationDOList=hotelAccommodationDAO.findAll();
        for(HotelAccommodationDO h:hotelAccommodationDOList){
            list.add(toHotelAccommodation(h));
        }
        return list;
    }

    /**
     * 查询hotelAccommodation记录的总数量
     * @return
     */
    public int queryForCountTotal(){
        return (int)hotelAccommodationDAO.count();
    }

    /**
     * 转换方法
     * 将hotelAccommodationDO转换为hotelAccommodation
     * @param hotelAccommodationDO
     * @return
     */
    public HotelAccommodation toHotelAccommodation(HotelAccommodationDO hotelAccommodationDO){
        HotelAccommodation hotelAccommodation=new HotelAccommodation();

        hotelAccommodation.setID(hotelAccommodationDO.getID());
        hotelAccommodation.setConferenceUser(conferenceUserService.queryConferenceUserByID(hotelAccommodationDO.getConferenceUserID()));
        hotelAccommodation.setHotelOrder(hotelOrderService.queryHotelOrderByID(hotelAccommodationDO.getHotelOrderID()));

        return hotelAccommodation;
    }

    /**
     * 转换方法
     * 将hotelAccommodation转换为hotelAccommodationDO
     * @param hotelAccommodation
     * @return
     */
    public HotelAccommodationDO toHotelAccommodationDO(HotelAccommodation hotelAccommodation){
        HotelAccommodationDO hotelAccommodationDO=new HotelAccommodationDO();

        hotelAccommodationDO.setID(hotelAccommodation.getID());
        hotelAccommodationDO.setConferenceUserID(hotelAccommodation.getConferenceUser().getID());
        hotelAccommodationDO.setHotelOrderID(hotelAccommodation.getHotelOrder().getID());

        return hotelAccommodationDO;
    }
}
