package com.example.demo.entity.DTO;

import com.example.demo.enumValue.OrderStatus;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;
import java.util.Objects;

public class HotelOrder {
    /**
     * @author 李嘉旭
     * 基本类:酒店订单信息
     * 这个类用来说明酒店订单的基本信息
     * @param ID 订单编号
     * @param hotelRoom 酒店房间ID
     * @param createTime 下单时间
     * @param num 入住人数
     * @param orderStatus 订单结束状态
     * @param beginTime 入住时间
     * @param endTime 退房时间
     */
    private int ID;
    private HotelRoom hotelRoom;
    private LocalDateTime createTime;
    private int num;
    private OrderStatus orderStatus;
    private LocalDateTime beginTime;
    private LocalDateTime endTime;

    public HotelOrder() {
    }

    public HotelOrder(int ID, HotelRoom hotelRoom, LocalDateTime createTime, int num, OrderStatus orderStatus, LocalDateTime beginTime, LocalDateTime endTime) {
        this.ID = ID;
        this.hotelRoom = hotelRoom;
        this.createTime = createTime;
        this.num = num;
        this.orderStatus = orderStatus;
        this.beginTime = beginTime;
        this.endTime = endTime;
    }

    public HotelOrder(HotelRoom hotelRoom, LocalDateTime createTime, int num, OrderStatus orderStatus, LocalDateTime beginTime, LocalDateTime endTime) {
        this.hotelRoom = hotelRoom;
        this.createTime = createTime;
        this.num = num;
        this.orderStatus = orderStatus;
        this.beginTime = beginTime;
        this.endTime = endTime;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public HotelRoom getHotelRoom() {
        return hotelRoom;
    }

    public void setHotelRoom(HotelRoom hotelRoom) {
        this.hotelRoom = hotelRoom;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    public LocalDateTime getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(LocalDateTime beginTime) {
        this.beginTime = beginTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HotelOrder that = (HotelOrder) o;
        return ID == that.ID &&
                hotelRoom == that.hotelRoom &&
                num == that.num &&
                Objects.equals(createTime, that.createTime) &&
                orderStatus == that.orderStatus &&
                Objects.equals(beginTime, that.beginTime) &&
                Objects.equals(endTime, that.endTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ID, hotelRoom, createTime, num, orderStatus, beginTime, endTime);
    }

    @Override
    public String toString() {
        return "HotelOrder{" +
                "ID=" + ID +
                ", hotelRoom=" + hotelRoom +
                ", createTime=" + createTime +
                ", num=" + num +
                ", orderStatus=" + orderStatus +
                ", beginTime=" + beginTime +
                ", endTime=" + endTime +
                '}';
    }
}
