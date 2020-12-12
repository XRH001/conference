package com.example.demo.enumValue;

public enum Identity {
    Common(1,"普通用户","common"),
    Driver(2,"司机","driver"),
    Hotel(3,"酒店","hotel");

    Identity(int ID, String info,String enInfo) {
        this.ID = ID;
        this.info = info;
        this.enInfo=enInfo;
    }

    public int getID() {
        return ID;
    }

    public String getInfo() {
        return info;
    }

    public String getEnInfo() {
        return enInfo;
    }

    public static Identity choose(int ID){
        switch (ID){
            case 1:return Identity.Common;
            case 2:return Identity.Driver;
            case 3:return Identity.Hotel;
        }
        return null;
    }

    private int ID;
    private String info;
    private String enInfo;
}
