package com.example.demo.entity.DTO;

import com.example.demo.entity.DO.ConferenceDO;
import com.example.demo.enumValue.OrderStatus;
import com.example.demo.utils.TimeUtils;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;

import java.time.LocalDateTime;
import java.util.Objects;

public class Conference {
    /**
     * @author 李嘉旭
     * 基本类:会议信息,对应数据库中的会议表
     * 这个类用来说明会议信息
     * 对于用int存储的boolean值,0代表true,1代表false
     * @param ID 会议编号
     * @param name 会议名称
     * @param address 会议地点
     * @param status 会议结束状态
     * @param num 参会人数
     * @param createTime 会议创建时间
     * @param beginTime 会议开始时间
     * @param endTime 会议结束时间
     * @param isPrivate 是否为内部会议
     */
    private int ID;
    private String name;
    private String address;
    private OrderStatus orderStatus;
    private int num;
    @JsonSerialize(using= LocalDateTimeSerializer.class)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime;
    @JsonSerialize(using= LocalDateTimeSerializer.class)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime beginTime;
    @JsonSerialize(using= LocalDateTimeSerializer.class)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime endTime;
    private boolean isPrivate;


    public Conference() {
    }

    public Conference(int ID, String name, String address, OrderStatus orderStatus, int num, LocalDateTime createTime, LocalDateTime beginTime, LocalDateTime endTime, boolean isPrivate) {
        this.ID = ID;
        this.name = name;
        this.address = address;
        this.orderStatus = orderStatus;
        this.num = num;
        this.createTime = createTime;
        this.beginTime = beginTime;
        this.endTime = endTime;
        this.isPrivate = isPrivate;
    }

    public Conference(String name, String address, OrderStatus orderStatus, int num, LocalDateTime createTime, LocalDateTime beginTime, LocalDateTime endTime, boolean isPrivate) {
        this.name = name;
        this.address = address;
        this.orderStatus = orderStatus;
        this.num = num;
        this.createTime = createTime;
        this.beginTime = beginTime;
        this.endTime = endTime;
        this.isPrivate = isPrivate;
    }

    //    public Conference(ConferenceDO conferenceDO){
//        this.ID = conferenceDO.getID();
//        this.name = conferenceDO.getName();
//        this.address = conferenceDO.getAddress();
//        this.orderStatus=OrderStatus.choose(conferenceDO.getOrderStatus());
//        this.num = conferenceDO.getNum();
//        this.createTime = TimeUtils.transLocalDateTime(conferenceDO.getCreateTime());
//        this.beginTime = TimeUtils.transLocalDateTime(conferenceDO.getBeginTime());
//        this.endTime = TimeUtils.transLocalDateTime(conferenceDO.getEndTime());
//        this.isPrivate = conferenceDO.getIsPrivate()==0?true:false;
//    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }


    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
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

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    public boolean isPrivate() {
        return isPrivate;
    }

    public void setPrivate(boolean aPrivate) {
        isPrivate = aPrivate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Conference that = (Conference) o;
        return ID == that.ID &&
                num == that.num &&
                isPrivate == that.isPrivate &&
                Objects.equals(name, that.name) &&
                Objects.equals(address, that.address) &&
                orderStatus == that.orderStatus &&
                Objects.equals(createTime, that.createTime) &&
                Objects.equals(beginTime, that.beginTime) &&
                Objects.equals(endTime, that.endTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ID, name, address, orderStatus, num, createTime, beginTime, endTime, isPrivate);
    }

    @Override
    public String toString() {
        return "Conference{" +
                "ID=" + ID +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", status=" + orderStatus +
                ", num=" + num +
                ", createTime=" + createTime +
                ", beginTime=" + beginTime +
                ", endTime=" + endTime +
                ", is_private=" + isPrivate +
                '}';
    }
}
