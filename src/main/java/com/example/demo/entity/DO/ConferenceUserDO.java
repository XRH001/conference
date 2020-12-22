package com.example.demo.entity.DO;

import com.example.demo.entity.DTO.ConferenceUser;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@DynamicInsert
@Entity(name = "conferenceuser")
public class ConferenceUserDO {
    /**
     * @author 李嘉旭
     * 基本DO类:参会人员,对应数据库中的参会人员表
     * @param ID 人员参会编号
     * @param userID 用户编号
     * @param conferenceID 会议ID
     * @param position 在会议扮演的身份
     * @param invitationStatus 邀请状态
     * @param orderStatus 申请状态
     * @param info 备注
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO,generator = "generator")
    @GenericGenerator(name = "generator",strategy = "com.example.demo.utils.GeneratedInsertGenerator")
    private Integer ID;
    private Integer userID;
    private Integer conferenceID;
    private int position;
    private Integer invitationStatus;
    private Integer orderStatus;
    private String info;

    public ConferenceUserDO() {
    }

    public ConferenceUserDO(Integer userID, Integer conferenceID, int position, Integer invitationStatus, Integer orderStatus, String info) {
        this.userID = userID;
        this.conferenceID = conferenceID;
        this.position = position;
        this.invitationStatus = invitationStatus;
        this.orderStatus = orderStatus;
        this.info = info;
    }

    public ConferenceUserDO(int ID, int userID, int conferenceID, int position, int invitationStatus, int orderStatus, String info) {
        this.ID = ID;
        this.userID = userID;
        this.conferenceID = conferenceID;
        this.position = position;
        this.invitationStatus = invitationStatus;
        this.orderStatus = orderStatus;
        this.info = info;
    }

//    public ConferenceUserDO(ConferenceUser conferenceUser) {
//        this.ID=conferenceUser.getID();
//        this.userID=conferenceUser.getUser().getID();
//        this.conferenceID=conferenceUser.getConference().getID();
//        this.position= conferenceUser.getPosition().getPositionName();
//        this.invitationStatus=conferenceUser.getInvitationStatus().getNum();
//        this.orderStatus=conferenceUser.getOrderStatus().getNum();
//        this.info=conferenceUser.getInfo();
//    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public int getConferenceID() {
        return conferenceID;
    }

    public void setConferenceID(int conferenceID) {
        this.conferenceID = conferenceID;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public int getInvitationStatus() {
        return invitationStatus;
    }

    public void setInvitationStatus(int invitationStatus) {
        this.invitationStatus = invitationStatus;
    }

    public int getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(int orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    @Override
    public String toString() {
        return "ConferenceUserDo{" +
                "ID=" + ID +
                ", userID=" + userID +
                ", conferenceID=" + conferenceID +
                ", position='" + position + '\'' +
                ", invitationStatus=" + invitationStatus +
                ", orderStatus=" + orderStatus +
                ", info='" + info + '\'' +
                '}';
    }
}
