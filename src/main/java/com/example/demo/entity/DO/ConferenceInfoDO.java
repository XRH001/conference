package com.example.demo.entity.DO;

import com.example.demo.entity.DTO.ConferenceInfo;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Objects;

/**
 * @author 李嘉旭
 * 基本DO类:会议信息 对应数据库中的会议信息表
 */
@DynamicInsert
@Entity(name = "conferenceinfo")
public class ConferenceInfoDO {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO,generator = "generator")
    @GenericGenerator(name = "generator",strategy = "com.example.demo.utils.GeneratedInsertGenerator")
    private int ID;
    private int conferenceID;
    private String info;

    public ConferenceInfoDO() {
    }

    public ConferenceInfoDO(int ID, int conferenceID, String info) {
        this.ID = ID;
        this.conferenceID = conferenceID;
        this.info = info;
    }

//    public ConferenceInfoDO(ConferenceInfo conferenceInfo){
//        this.ID=conferenceInfo.getID();
//        this.conferenceID=conferenceInfo.getConference().getID();
//        this.info=conferenceInfo.getInfo();
//    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getConferenceID() {
        return conferenceID;
    }

    public void setConferenceID(int conferenceID) {
        this.conferenceID = conferenceID;
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
        ConferenceInfoDO that = (ConferenceInfoDO) o;
        return ID == that.ID &&
                conferenceID == that.conferenceID &&
                Objects.equals(info, that.info);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ID, conferenceID, info);
    }

    @Override
    public String toString() {
        return "ConferenceInfoDO{" +
                "ID=" + ID +
                ", conferenceID=" + conferenceID +
                ", info='" + info + '\'' +
                '}';
    }
}
