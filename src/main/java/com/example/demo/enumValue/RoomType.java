package com.example.demo.enumValue;


public enum RoomType {
    Single("单人间",1),
    Double("双人间",2),
    Triple("三人间",3),
    Business("商务间",4);
    RoomType(String roomTypeInfo,int num){
        this.roomTypeInfo=roomTypeInfo;
        this.num=num;
    }

    public static RoomType choose(int num){
        switch (num){
            case 0:return Single;
            case 1:return Double;
            case 2:return Triple;
            case 3:return Business;
        }
        return null;
    }

    public String getRoomTypeInfo(){
        return roomTypeInfo;
    }

    public int getNum() {
        return num;
    }

    private String roomTypeInfo;
    private int num;
}
