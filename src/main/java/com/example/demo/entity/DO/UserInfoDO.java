package com.example.demo.entity.DO;

import java.util.Objects;

/**
 * @author 李嘉旭
 * 基本DO类:用户附加信息表 对应数据库中的用户附加信息表
 */
public class UserInfoDO {
    /**
     * @param ID 编号
     * @param userID 用户编号
     * @param image_path 图片存放路径
     */
    private int ID;
    private int userID;
    private String image_path;

    public UserInfoDO() {
    }


    public UserInfoDO(int ID, int userID, String image_path) {
        this.ID = ID;
        this.userID = userID;
        this.image_path = image_path;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getImage_path() {
        return image_path;
    }

    public void setImage_path(String image_path) {
        this.image_path = image_path;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserInfoDO that = (UserInfoDO) o;
        return ID == that.ID &&
                userID == that.userID &&
                Objects.equals(image_path, that.image_path);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ID, userID, image_path);
    }

    @Override
    public String toString() {
        return "UserInfoDo{" +
                "ID=" + ID +
                ", userID=" + userID +
                ", image_path='" + image_path + '\'' +
                '}';
    }
}
