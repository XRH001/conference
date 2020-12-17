package com.example.demo.entity.DTO;

import com.example.demo.dao.ConferenceDAO;
import com.example.demo.entity.DO.ConferenceInfoDO;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Objects;

public class ConferenceInfo {
    /**
     *会议附加信息,这是一个备用类
     * @param ID 编号
     * @param conference 会议
     * @param info 会议备注
     */
    private int ID;
    private Conference conference;
    private String info;

    public ConferenceInfo() {
    }

    public ConferenceInfo(int ID, Conference conference, String info) {
        this.ID = ID;
        this.conference = conference;
        this.info = info;
    }

    public ConferenceInfo(Conference conference, String info) {
        this.conference = conference;
        this.info = info;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public Conference getConference() {
        return conference;
    }

    public void setConference(Conference conference) {
        this.conference = conference;
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
        ConferenceInfo that = (ConferenceInfo) o;
        return ID == that.ID &&
                Objects.equals(conference, that.conference) &&
                Objects.equals(info, that.info);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ID, conference, info);
    }

    @Override
    public String toString() {
        return "ConferenceInfo{" +
                "ID=" + ID +
                ", conference=" + conference +
                ", info='" + info + '\'' +
                '}';
    }
}
