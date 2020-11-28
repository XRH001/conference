package com.example.demo.enumValue;

/**
 * @author 李嘉旭
 * 这个枚举类型用来指定性别
 */
public enum Sex {
    Male("男性",0),
    Female("女性",1);
    Sex(String sexCNName,int num){
        this.SexCNName=sexCNName;
        this.num=num;
    }
    public String getSexCNName(){
        return SexCNName;
    }

    public int getNum() {
        return num;
    }

    private String SexCNName;
    private int num;
}
