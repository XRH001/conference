package com.example.demo.enumValue;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * @author 李嘉旭
 * 这个枚举类型用来指定订单状态
 */
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum OrderStatus {
    Block("被拒绝",-2),
    Suspend("需要改正",-1),
    Checking("审核中",0),
    Ready("审核通过但还未开始",1),
    Running("进行中",2),
    Finished("已完成",3),
    NoStatus("无状态",4);




    OrderStatus(String statusInfo,int num) {
        this.statusInfo = statusInfo;
        this.num=num;
    }

    public static OrderStatus choose(int num){
        switch (num){
            case -2:return Block;
            case -1:return Suspend;
            case 0:return Checking;
            case 1:return Ready;
            case 2:return Running;
            case 3:return Finished;
            case 4:return NoStatus;
            default:return null;
        }
    }

    @JsonValue
    public String getStatusInfo() {
        return statusInfo;
    }

    public int getNum() {
        return num;
    }

    private String statusInfo;
    private int num;
}
