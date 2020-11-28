package com.example.demo.enumValue;

/**
 * @author 李嘉旭
 * 这个枚举类型用来指定参会人员的身份
 */
public enum Position {
    creator("创建者"),
    administrator("管理员"),
    organizer("组织者"),
    ordinary("普通用户");

    Position(String positionName){
        this.positionName=positionName;
    }
    public static Position choose(String name){
        switch (name){
            case "创建者":return creator;
            case "管理员": return administrator;
            case "组织者":return organizer;
            case "普通用户":return ordinary;
        }
            return null;
    }
    public String getPositionName(){
        return positionName;
    }


    private String positionName;
}
