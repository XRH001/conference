package com.example.demo.entity.DTO;



import com.example.demo.enumValue.Identity;
import com.example.demo.enumValue.Sex;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;


public class User {
    /**
     * @author 李嘉旭
     * 基本类:用户
     * 在本类中性别以枚举类型Sex存储
     * 在数据库中性别以int类型存储
     * 数据库中的0代表男性,1代表女性
     * @param ID 用户编号
     * @param name 用户真实姓名
     * @param username 用户名
     * @param password 密码
     * @param sex 性别
     * @param birth 出生日期
     * @param workID 工号
     * @param email 电子邮箱
     * @param phone 电话号码
     * @param imgPath 头像图片存放路径
     */

    private int ID;
    private String name;
    private String username;
    private String password;
    private Sex sex;
    private LocalDate birth;
    private String email;
    private String imgPath;
    private String phone;

    public User() {
    }

    public User(int ID, String name, String username, String password, Sex sex, LocalDate birth, String email, String imgPath, String phone) {
        this.ID = ID;
        this.name = name;
        this.username = username;
        this.password = password;
        this.sex = sex;
        this.birth = birth;
        this.email = email;
        this.imgPath = imgPath;
        this.phone = phone;
    }

    public User(String name, String username, String password, Sex sex, LocalDate birth, String email, String imgPath, String phone) {
        this.name = name;
        this.username = username;
        this.password = password;
        this.sex = sex;
        this.birth = birth;
        this.email = email;
        this.imgPath = imgPath;
        this.phone = phone;
    }


    //    public User(UserDO userDo){
//        this.ID = userDo.getID();
//        this.name = userDo.getName();
//        this.username = userDo.getUsername();
//        this.password = userDo.getPassword();
//        this.sex = userDo.getSex()==0?Sex.Male: Sex.Female;
//        this.birth = TimeUtils.transLocalDate(userDo.getBirth());
//        this.position = userDo.getPosition();
//        this.workID = userDo.getWorkID();
//        this.email = userDo.getEmail();
//        this.imgPath=userDo.getImgPath();
//        this.phone=userDo.getPhone();
//    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    public LocalDate getBirth() {
        return birth;
    }

    public void setBirth(LocalDate birth) {
        this.birth = birth;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return ID == user.ID &&
                Objects.equals(name, user.name) &&
                Objects.equals(username, user.username) &&
                Objects.equals(password, user.password) &&
                sex == user.sex &&
                Objects.equals(birth, user.birth) &&
                Objects.equals(email, user.email) &&
                Objects.equals(imgPath, user.imgPath) &&
                Objects.equals(phone, user.phone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ID, name, username, password, sex, birth, email, imgPath, phone);
    }

    @Override
    public String toString() {
        DateTimeFormatter formatters = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        String Birth = birth.format(formatters);
        //增加的一个日期格式改造方法 by XRH

        return "{" +
                "id:" + ID +
                ", name:'" + name+
                "', username:'" + username +
                "', sex:'" + sex +
                "', birth:'"  + Birth +
                "', email:'" + email +
                "', imgPath:'" + imgPath +
                "', phone:'" + phone +
                "'}";
    }
}
