package com.example.demo.entity.DO;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;
import java.util.Objects;

@DynamicInsert
@Entity(name = "hotelorder")
public class HotelOrderDO {
    /**
     * @author 李嘉旭
     * 基本DO类:酒店订单信息 用来对应数据库中的酒店订单表
     * 这个类用来说明酒店订单的基本信息
     * @param ID 订单编号
     * @param hotelRoomID 酒店房间ID
     * @param createTime 下单时间
     * @param num 入住人数
     * @param orderStatus 订单结束状态
     * @param beginTime 入住时间
     * @param endTime 退房时间
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO,generator = "generator")
    @GenericGenerator(name = "generator",strategy = "com.example.demo.utils.GeneratedInsertGenerator")
    private int ID;
    private int hotelRoomID;
    private Date createTime;
    private int num;
    private int orderStatus;
    private Date beginTime;
    private Date endTime;

    public HotelOrderDO() {
    }

    public HotelOrderDO(int ID, int hotelRoomID, Date createTime, int num, int orderStatus, Date beginTime, Date endTime) {
        this.ID = ID;
        this.hotelRoomID = hotelRoomID;
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

    public int getHotelRoomID() {
        return hotelRoomID;
    }

    public void setHotelRoomID(int hotelRoomID) {
        this.hotelRoomID = hotelRoomID;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public int getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(int orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Date getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(Date beginTime) {
        this.beginTime = beginTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HotelOrderDO that = (HotelOrderDO) o;
        return ID == that.ID &&
                hotelRoomID == that.hotelRoomID &&
                num == that.num &&
                orderStatus == that.orderStatus &&
                Objects.equals(createTime, that.createTime) &&
                Objects.equals(beginTime, that.beginTime) &&
                Objects.equals(endTime, that.endTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ID, hotelRoomID, createTime, num, orderStatus, beginTime, endTime);
    }

    @Override
    public String toString() {
        return "HotelOrderDo{" +
                "ID=" + ID +
                ", hotelRoomID=" + hotelRoomID +
                ", createTime=" + createTime +
                ", num=" + num +
                ", orderStatus=" + orderStatus +
                ", beginTime=" + beginTime +
                ", endTime=" + endTime +
                '}';
    }
}
