package com.example.demo.entity.DO;

import com.example.demo.entity.DTO.Conference;
import com.example.demo.utils.TimeUtils;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;
import java.util.Objects;
@DynamicInsert
@Entity(name = "conference")
public class ConferenceDO {
    /**
     * @author 李嘉旭
     * 基本DO类:会议信息,对应数据库中的会议表
     * 这个类用来说明会议的基本信息
     * @param ID 会议编号
     * @param name 会议名称
     * @param address 会议地点
     * @param status 会议结束状态,在数据库中以int类型表示,0代表进行中,1代表已完成
     * @param num 参会人数
     * @param createTime 会议创建时间
     * @param beginTime 会议开始时间
     * @param endTime 会议结束时间
     * @param isPrivate 是否为内部会议
     */

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO,generator = "generator")
    @GenericGenerator(name = "generator",strategy = "com.example.demo.utils.GeneratedInsertGenerator")
    private int ID;
    private String name;
    private String address;
    private int orderStatus;
    private int num;
    private Date createTime;
    private Date beginTime;
    private Date endTime;
    private int isPrivate;

    public ConferenceDO() {
    }

    public ConferenceDO(int ID, String name, String address, int orderStatus, int num, Date createTime, Date beginTime, Date endTime, int isPrivate) {
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

//    public ConferenceDO(Conference conference) {
//        this.ID=conference.getID();
//        this.name=conference.getName();
//        this.address=conference.getAddress();
//        this.orderStatus=conference.getOrderStatus().getNum();
//        this.num=conference.getNum();
//        this.createTime= TimeUtils.converseTrans(conference.getCreateTime());
//        this.beginTime=TimeUtils.converseTrans(conference.getBeginTime());
//        this.endTime=TimeUtils.converseTrans(conference.getEndTime());
//        this.isPrivate=conference.isPrivate()==true?0:1;
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

    public int getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(int orderStatus) {
        this.orderStatus = orderStatus;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
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

    public int getIsPrivate() {
        return isPrivate;
    }

    public void setIsPrivate(int isPrivate) {
        this.isPrivate = isPrivate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ConferenceDO that = (ConferenceDO) o;
        return ID == that.ID &&
                orderStatus == that.orderStatus &&
                num == that.num &&
                isPrivate == that.isPrivate &&
                Objects.equals(name, that.name) &&
                Objects.equals(address, that.address) &&
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
        return "ConferenceDO{" +
                "ID=" + ID +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", orderStatus=" + orderStatus +
                ", num=" + num +
                ", createTime=" + createTime +
                ", beginTime=" + beginTime +
                ", endTime=" + endTime +
                ", isPrivate=" + isPrivate +
                '}';
    }
}
