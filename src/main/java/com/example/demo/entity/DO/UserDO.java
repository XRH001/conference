package com.example.demo.entity.DO;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;
import java.util.Objects;

/**
 * @author 李嘉旭
 * 基本DO类:用户类,对应数据库的用户表
 */
@DynamicInsert
@Entity(name = "user")
public class UserDO {
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
     * @param position 职务
     * @param workID 工号
     * @param email 电子邮箱
     * @param phone 电话号码
     * @param imgPath 头像图片存放路径
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO,generator = "generator")
    @GenericGenerator(name = "generator",strategy = "com.example.demo.utils.GeneratedInsertGenerator")
    private int ID;
    private String name;
    private String username;
    private String password;
    private int sex;
    private Date birth;
    private int identity;
    private String email;
    private String imgPath;
    private String phone;

    public UserDO() {
    }

    public UserDO(int ID, String name, String username, String password, int sex, Date birth, int identity, String email, String imgPath, String phone) {
        this.ID = ID;
        this.name = name;
        this.username = username;
        this.password = password;
        this.sex = sex;
        this.birth = birth;
        this.identity = identity;
        this.email = email;
        this.imgPath = imgPath;
        this.phone = phone;
    }

//    public UserDO(User user){
//        this.ID=user.getID();
//        this.name=user.getName();
//        this.username=user.getUsername();
//        this.password=user.getPassword();
//        this.sex=user.getSex().equals(Sex.Male)?0:1;
//        this.birth= TimeUtils.converseTrans(user.getBirth());
//        this.position=user.getPosition();
//        this.workID=user.getWorkID();
//        this.email=user.getEmail();
//        this.imgPath=user.getImgPath();
//        this.phone=user.getPhone();
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

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public int getIdentity() {
        return identity;
    }

    public void setIdentity(int identity) {
        this.identity = identity;
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
        UserDO userDO = (UserDO) o;
        return ID == userDO.ID &&
                sex == userDO.sex &&
                identity == userDO.identity &&
                Objects.equals(name, userDO.name) &&
                Objects.equals(username, userDO.username) &&
                Objects.equals(password, userDO.password) &&
                Objects.equals(birth, userDO.birth) &&
                Objects.equals(email, userDO.email) &&
                Objects.equals(imgPath, userDO.imgPath) &&
                Objects.equals(phone, userDO.phone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ID, name, username, password, sex, birth, identity, email, imgPath, phone);
    }

    @Override
    public String toString() {
        return "UserDO{" +
                "ID=" + ID +
                ", name='" + name + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", sex=" + sex +
                ", birth=" + birth +
                ", identity=" + identity +
                ", email='" + email + '\'' +
                ", imgPath='" + imgPath + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
