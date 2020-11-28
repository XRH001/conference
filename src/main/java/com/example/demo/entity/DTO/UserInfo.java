package com.example.demo.entity.DTO;

import java.util.Objects;

/**
 * @author 李嘉旭
 * 基本类:用户附加信息表
 */
public class UserInfo {
/**
* @param ID 编号
* @param user 用户
* @param image_path 图片存放路径
*/
    private int ID;
    private User user;
    private String image_path;

    public UserInfo() {
    }

    public UserInfo(int ID, User user, String image_path) {
        this.ID = ID;
        this.user = user;
        this.image_path = image_path;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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
        UserInfo userInfo = (UserInfo) o;
        return ID == userInfo.ID &&
                Objects.equals(user, userInfo.user) &&
                Objects.equals(image_path, userInfo.image_path);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ID, user, image_path);
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "ID=" + ID +
                ", user=" + user +
                ", image_path='" + image_path + '\'' +
                '}';
    }
}
