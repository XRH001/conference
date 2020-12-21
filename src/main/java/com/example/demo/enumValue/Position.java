package com.example.demo.enumValue;

/**
 * @author 李嘉旭
 * 这个枚举类型用来指定参会人员的身份
 */
public enum Position {
    creator("创建者",0),
    administrator("管理员",1),
    organizer("组织者",2),
    ordinary("普通用户",3);

    Position(String positionName,int num){
        this.positionName=positionName;
        this.num=num;
    }

    public static Position choose(int num){
        switch (num){
            case 0:return creator;
            case 1: return administrator;
            case 2:return organizer;
            case 3:return ordinary;
        }
            return null;
    }
    public String getPositionName(){
        return positionName;
    }
    public int getNum(){return num;}


    private String positionName;
    private int num;
}
