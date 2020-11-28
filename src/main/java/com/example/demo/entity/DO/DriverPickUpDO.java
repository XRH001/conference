package com.example.demo.entity.DO;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Objects;

@DynamicInsert
@Entity(name = "driverpickup")
public class DriverPickUpDO {
    /**
     * @author 李嘉旭
     * 基本Do类,对应数据库的司机接送表
     * @param ID 司机接送ID
     * @param driverID 司机ID
     * @param userJourneyID 用户出行ID
     * @param orderStatus 接送状态,在数据库中以int类型进行存储,0表示没完成,1表示已完成
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO,generator = "generator")
    @GenericGenerator(name = "generator",strategy = "com.example.demo.utils.GeneratedInsertGenerator")
    private int ID;
    private int driverID;
    private int userJourneyID;
    private int orderStatus;

    public DriverPickUpDO() {
    }

    public DriverPickUpDO(int ID, int driverID, int userJourneyID, int orderStatus) {
        this.ID = ID;
        this.driverID = driverID;
        this.userJourneyID = userJourneyID;
        this.orderStatus = orderStatus;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getDriverID() {
        return driverID;
    }

    public void setDriverID(int driverID) {
        this.driverID = driverID;
    }

    public int getUserJourneyID() {
        return userJourneyID;
    }

    public void setUserJourneyID(int userJourneyID) {
        this.userJourneyID = userJourneyID;
    }

    public int getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(int orderStatus) {
        this.orderStatus = orderStatus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DriverPickUpDO that = (DriverPickUpDO) o;
        return ID == that.ID &&
                driverID == that.driverID &&
                userJourneyID == that.userJourneyID &&
                orderStatus == that.orderStatus;
    }

    @Override
    public int hashCode() {
        return Objects.hash(ID, driverID, userJourneyID, orderStatus);
    }

    @Override
    public String toString() {
        return "DriverPickUpInfoDo{" +
                "ID=" + ID +
                ", driverID=" + driverID +
                ", userJourneyID=" + userJourneyID +
                ", orderStatus=" + orderStatus +
                '}';
    }
}
