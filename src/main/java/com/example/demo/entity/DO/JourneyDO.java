package com.example.demo.entity.DO;

import com.example.demo.entity.DTO.Journey;
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
@Entity(name = "journey")
public class JourneyDO {
    /**
     * @author 李嘉旭
     * 基本DO类:行程信息
     * 这个类用来说明一次行程的基本信息
     * @param ID 行程编号
     * @param time 出发时间
     * @param origin 出发地点
     * @param target 目的地
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO,generator = "generator")
    @GenericGenerator(name = "generator",strategy = "com.example.demo.utils.GeneratedInsertGenerator")
    private int ID;
    private Date time;
    private String origin;
    private String target;

    public JourneyDO() {
    }

    public JourneyDO(int ID, Date time, String origin, String target) {
        this.ID = ID;
        this.time = time;
        this.origin = origin;
        this.target = target;
    }

//    public JourneyDO(Journey journey){
//        this.ID=journey.getID();
//        this.time= TimeUtils.converseTrans(journey.getTime());
//        this.origin=journey.getorigin();
//        this.target=journey.getTarget();
//    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        JourneyDO that = (JourneyDO) o;
        return ID == that.ID &&
                Objects.equals(time, that.time) &&
                Objects.equals(origin, that.origin) &&
                Objects.equals(target, that.target);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ID, time, origin, target);
    }

    @Override
    public String toString() {
        return "JourneyInfoDo{" +
                "ID=" + ID +
                ", time=" + time +
                ", origin='" + origin + '\'' +
                ", target='" + target + '\'' +
                '}';
    }
}
