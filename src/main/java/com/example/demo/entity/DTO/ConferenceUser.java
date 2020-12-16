package com.example.demo.entity.DTO;

import com.example.demo.enumValue.InvitationStatus;
import com.example.demo.enumValue.OrderStatus;
import com.example.demo.enumValue.Position;


import java.util.Objects;


public class ConferenceUser{
    /**
     * @author 李嘉旭
     * 基本类:参会人员
     * @param ID 编号
     * @param user 用户
     * @param conference 会议
     * @param position 职位
     * @param invitationStatus 邀请状态
     * @param orderStatus 申请状态
     * @param info 备注
     */
    private int ID;
    private User user;
    private Conference conference;
    private Position position;
    private InvitationStatus invitationStatus;
    private OrderStatus orderStatus;
    private String info;

    public ConferenceUser() {
    }

    public ConferenceUser(int ID, User user, Conference conference, Position position, InvitationStatus invitationStatus, OrderStatus orderStatus, String info) {
        this.ID = ID;
        this.user = user;
        this.conference = conference;
        this.position = position;
        this.invitationStatus = invitationStatus;
        this.orderStatus = orderStatus;
        this.info = info;
    }

    public ConferenceUser(User user, Conference conference, Position position, InvitationStatus invitationStatus, OrderStatus orderStatus, String info) {
        this.user = user;
        this.conference = conference;
        this.position = position;
        this.invitationStatus = invitationStatus;
        this.orderStatus = orderStatus;
        this.info = info;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Conference getConference() {
        return conference;
    }

    public void setConference(Conference conference) {
        this.conference = conference;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public InvitationStatus getInvitationStatus() {
        return invitationStatus;
    }

    public void setInvitationStatus(InvitationStatus invitationStatus) {
        this.invitationStatus = invitationStatus;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ConferenceUser that = (ConferenceUser) o;
        return ID == that.ID &&
                Objects.equals(user, that.user) &&
                Objects.equals(conference, that.conference) &&
                position == that.position &&
                invitationStatus == that.invitationStatus &&
                orderStatus == that.orderStatus &&
                Objects.equals(info, that.info);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ID, user, conference, position, invitationStatus, orderStatus, info);
    }

    @Override
    public String toString() {
        return "ConferenceUser{" +
                "ID=" + ID +
                ", user=" + user +
                ", conference=" + conference +
                ", posiotion=" + position +
                ", invitationStatus=" + invitationStatus +
                ", orderStatus=" + orderStatus +
                ", info='" + info + '\'' +
                '}';
    }
}
