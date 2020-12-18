package com.example.demo.entity.DTO;



import com.example.demo.entity.DO.JourneyDO;
import com.example.demo.utils.TimeUtils;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;

import java.time.LocalDateTime;
import java.util.Objects;


public class Journey {
    /**
     * @author 李嘉旭
     * 基本类:行程信息
     * 这个类用来说明一次行程的基本信息
     * @param ID 行程编号
     * @param time 出发时间
     * @param origin 出发地点
     * @param target 目的地
     */
    private int ID;
    @JsonSerialize(using= LocalDateTimeSerializer.class)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime time;
    private String origin;
    private String target;

    public Journey() {
    }

    public Journey(int ID, LocalDateTime time, String origin, String target) {
        this.ID = ID;
        this.time = time;
        this.origin = origin;
        this.target = target;
    }

    public Journey(LocalDateTime time, String origin, String target) {
        this.time = time;
        this.origin = origin;
        this.target = target;
    }
//    public Journey(JourneyDO journeyDO){
//        this.ID=journeyDO.getID();
//        this.time= TimeUtils.transLocalDateTime(journeyDO.getTime());
//        this.origin=journeyDO.getOrigin();
//        this.target= journeyDO.getTarget();
//    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    public String getorigin() {
        return origin;
    }

    public void setorigin(String origin) {
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
        Journey that = (Journey) o;
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
        return "JourneyInfo{" +
                "ID=" + ID +
                ", time=" + time +
                ", origin='" + origin + '\'' +
                ", target='" + target + '\'' +
                '}';
    }
}
