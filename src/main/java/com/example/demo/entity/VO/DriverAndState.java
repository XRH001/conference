package com.example.demo.entity.VO;

import com.example.demo.entity.Driver;
import com.example.demo.enumValue.OrderStatus;

import java.util.Objects;

public class DriverAndState extends Driver {
    private OrderStatus orderStatus;

    public DriverAndState(int ID, String name, String phone, String type, int maxNum, String carNum, String username, String password, String email, String imgPath, OrderStatus orderStatus) {
        super(ID, name, phone, type, maxNum, carNum, username, password, email, imgPath);
        this.orderStatus = orderStatus;
    }

    public DriverAndState(String name, String phone, String type, int maxNum, String carNum, String username, String password, String email, String imgPath, OrderStatus orderStatus) {
        super(name, phone, type, maxNum, carNum, username, password, email, imgPath);
        this.orderStatus = orderStatus;
    }

    public DriverAndState(Driver driver,OrderStatus orderStatus){
        super(driver);
        this.orderStatus = orderStatus;
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
        if (!super.equals(o)) return false;
        DriverAndState that = (DriverAndState) o;
        return orderStatus == that.orderStatus;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), orderStatus);
    }

    @Override
    public String toString() {
        return "DriverAndState{" +
                super.toString()+
                "orderStatus=" + orderStatus +
                '}';
    }
}
