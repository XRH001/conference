package com.example.demo.service.mehod;

import com.example.demo.dao.HotelOrderDAO;
import com.example.demo.entity.DO.HotelOrderDO;
import com.example.demo.entity.DTO.HotelOrder;
import com.example.demo.enumValue.OrderStatus;
import com.example.demo.utils.TimeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 李嘉旭
 * 酒店订单Service
 * 负责调用hotelRoom的使用信息
 */
@Service
public class HotelOrderService {
    @Autowired
    HotelOrderDAO hotelOrderDAO;
    @Autowired
    HotelRoomService hotelRoomService;
    List<HotelOrder> list=new ArrayList<>();
    List<HotelOrderDO> hotelOrderDOList=new ArrayList<>();

    /**
     * 增加或修改一个hotelOrder
     * 根据ID
     * 有则修改,无则增加
     * @param hotelOrder 要插入的hotelOrder
     * @return null表示失败,否则返回查询的结果
     */
    public HotelOrder saveHotelOrder(HotelOrder hotelOrder){
        return toHotelOrder(hotelOrderDAO.save(toHotelOrderDO(hotelOrder)));
    }

    /**
     * 删除一个hotelOrder
     * 根据ID
     * @param hotelOrderID
     */
    public void deleteHotelOrder(int hotelOrderID){
        hotelOrderDAO.deleteById(hotelOrderID);
    }

    /**
     * 查询一个hotelOrder
     * 根据ID
     * @param hotelOrderID
     * @return
     */
    public HotelOrder queryHotelOrderByID(int hotelOrderID){
        return toHotelOrder(hotelOrderDAO.findById(hotelOrderID).get());
    }

    /**
     * 查询所有的hotelOrder记录
     * @return null表示失败,否则返回查询的结果
     */
    public List<HotelOrder> queryHotelOrders(){
        list.clear();
        hotelOrderDOList=hotelOrderDAO.findAll();
        for(HotelOrderDO h:hotelOrderDOList){
            list.add(toHotelOrder(h));
        }
        return list;
    }

    /**
     * 查询hotelOrder记录的总数量
     * @return
     */
    public int queryForCountTotal(){
        return (int)hotelOrderDAO.count();
    }

    /**i
     * 查询从begin开始的,长度为pageSize的记录
     * @param begin 起始位置
     * @param pageSize 页面长度
     * @return 一个页面的hotelOrder集合
     */
    public List<HotelOrder> queryForPageItems(int begin,int pageSize){
        list.clear();
        hotelOrderDOList=hotelOrderDAO.queryForPageItems(begin,pageSize);
        for(HotelOrderDO h:hotelOrderDOList){
            list.add(toHotelOrder(h));
        }
        return list;
    }

    /**
     * 转换方法
     * 将hotelOrderDO转换为hotelOrder
     * @param hotelOrderDO
     * @return
     */
    public HotelOrder toHotelOrder(HotelOrderDO hotelOrderDO){
        HotelOrder hotelOrder=new HotelOrder();

        hotelOrder.setID(hotelOrderDO.getID());
        hotelOrder.setHotelRoom(hotelRoomService.queryHotelRoomByID(hotelOrderDO.getHotelRoomID()));
        hotelOrder.setCreateTime(TimeUtils.transLocalDateTime(hotelOrderDO.getCreateTime()));
        hotelOrder.setBeginTime(TimeUtils.transLocalDateTime(hotelOrderDO.getBeginTime()));
        hotelOrder.setEndTime(TimeUtils.transLocalDateTime(hotelOrderDO.getEndTime()));
        hotelOrder.setNum(hotelOrderDO.getNum());
        hotelOrder.setOrderStatus(OrderStatus.choose(hotelOrderDO.getOrderStatus()));

        return hotelOrder;
    }

    /**
     * 转换方法
     * 将hotelOrder转换为hotelOrderDO
     * @param hotelOrder
     * @return
     */
    public HotelOrderDO toHotelOrderDO(HotelOrder hotelOrder){
        HotelOrderDO hotelOrderDO=new HotelOrderDO();

        hotelOrderDO.setID(hotelOrder.getID());
        hotelOrderDO.setHotelRoomID(hotelOrder.getHotelRoom().getID());
        hotelOrderDO.setCreateTime(TimeUtils.converseTrans(hotelOrder.getCreateTime()));
        hotelOrderDO.setBeginTime(TimeUtils.converseTrans(hotelOrder.getBeginTime()));
        hotelOrderDO.setEndTime(TimeUtils.converseTrans(hotelOrder.getEndTime()));
        hotelOrderDO.setNum(hotelOrder.getNum());
        hotelOrderDO.setOrderStatus(hotelOrder.getOrderStatus().getNum());

        return hotelOrderDO;
    }
}
