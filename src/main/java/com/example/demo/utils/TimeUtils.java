package com.example.demo.utils;

import java.time.*;
import java.util.Date;

/**
 * @author 李嘉旭
 * 这个工具类负责将Date转换为LocalTime
 * 或者将LocalDateTime装换为Date
 */
public class TimeUtils {
    public static LocalTime transLocalTime(Date date){
        Instant instant=date.toInstant();
        ZoneId zoneId=ZoneId.systemDefault();
        LocalDateTime localDateTime= LocalDateTime.ofInstant(instant,zoneId);
        return localDateTime.toLocalTime();
    }

    public static LocalDate transLocalDate(Date date){
        Instant instant=date.toInstant();
        ZoneId zoneId=ZoneId.systemDefault();
        LocalDateTime localDateTime= LocalDateTime.ofInstant(instant,zoneId);
        return localDateTime.toLocalDate();
    }

    public static LocalDateTime transLocalDateTime(Date date){
        Instant instant=date.toInstant();
        ZoneId zoneId=ZoneId.systemDefault();
        LocalDateTime localDateTime= LocalDateTime.ofInstant(instant,zoneId);
        return localDateTime;
    }

    public static Date converseTrans(LocalDateTime time){
        ZoneId zone = ZoneId.systemDefault();
        Instant instant = time.atZone(zone).toInstant();
        return Date.from(instant);
    }

    public static Date converseTrans(LocalDate time){
        ZonedDateTime zonedDateTime = time.atStartOfDay(ZoneId.systemDefault());
        return Date.from(zonedDateTime.toInstant());
    }
}
/**
 * localdatetime可以直接转换为datetime
 * 但是datetime不能直接转换为localdatetime
 * 必须先转换为date
 * 即localdatetime可以直接插入数据库,不需其他操作
 * 从数据库中取时间的时候要先转date,再转localdatetime
 */
