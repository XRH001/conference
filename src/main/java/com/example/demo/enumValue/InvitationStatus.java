package com.example.demo.enumValue;

public enum InvitationStatus {
    /**
     * @author 李嘉旭
     * 这个枚举类型用来说明邀请是否被拒绝
     */
    Refused("被拒绝",-1),
    Checking("审核中",0),
    Accepted("已接受",1),
    NoStatus("无状态",2);



    InvitationStatus(String statusInfo,int num) {
        this.statusInfo = statusInfo;
        this.num=num;
    }

    public static InvitationStatus choose(int num){
        switch (num){
            case -1:return Refused;
            case 0:return Checking;
            case 1:return Accepted;
            case 2:return NoStatus;
        }
        return null;
    }

    public String getStatusInfo() {
        return statusInfo;
    }

    public int getNum() {
        return num;
    }

    private String statusInfo;
    private int num;
}
