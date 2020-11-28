package com.example.demo.entity.DTO;


import com.example.demo.entity.Driver;
import com.example.demo.enumValue.OrderStatus;

import java.util.Objects;

public class DriverPickUp {
    /**
     * @author 李嘉旭
     * 基本类,对应数据库的司机接送表
     * @param ID 司机接送ID
     * @param driver 司机
     * @param userJourney 用户出行
     * @param orderStatus 接送状态
     */
    private int ID;
    private Driver driver;
    private UserJourney userJourney;
    private OrderStatus orderStatus;

    public DriverPickUp() {
    }

    public DriverPickUp(int ID, Driver driver, UserJourney userJourney, OrderStatus orderStatus) {
        this.ID = ID;
        this.driver = driver;
        this.userJourney = userJourney;
        this.orderStatus = orderStatus;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public UserJourney getUserJourney() {
        return userJourney;
    }

    public void setUserJourney(UserJourney userJourney) {
        this.userJourney = userJourney;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DriverPickUp that = (DriverPickUp) o;
        return ID == that.ID &&
                Objects.equals(driver, that.driver) &&
                Objects.equals(userJourney, that.userJourney) &&
                orderStatus == that.orderStatus;
    }

    @Override
    public int hashCode() {
        return Objects.hash(ID, driver, userJourney, orderStatus);
    }

    @Override
    public String toString() {
        return "DriverPickUp{" +
                "ID=" + ID +
                ", driver=" + driver +
                ", userJourney=" + userJourney +
                ", orderStatus=" + orderStatus +
                '}';
    }
}
