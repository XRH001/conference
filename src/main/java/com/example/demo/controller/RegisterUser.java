package com.example.demo.controller;



import java.time.LocalDate;
import java.util.Objects;


public class RegisterUser {
    /**
     * @author 刘凯
     * 基本类:用户中间类
     * 在本类中性别以枚举类型Sex存储
     * 在数据库中性别以int类型存储
     * 数据库中的0代表男性,1代表女性
     * @param ID 用户编号
     * @param name 用户真实姓名
     * @param username 用户名
     * @param password 密码
     * @param sex 性别
     * @param birth 出生日期
     * @param identify 职务
     * @param workID 工号
     * @param email 电子邮箱
     * @param phone 电话号码
     * @param imgPath 头像图片存放路径
     */

    private int ID;
    private String name;
    private String username;
    private String password;
    private String sex;
    private LocalDate birth;
    private String identity;
    private String workID;
    private String email;
    private String imgPath;
    private String phone;

    public RegisterUser() {
    }

    public RegisterUser(int ID, String name, String username, String password, String sex, LocalDate birth, String identity, String workID, String email, String imgPath, String phone) {
        this.ID = ID;
        this.name = name;
        this.username = username;
        this.password = password;
        this.sex = sex;
        this.birth = birth;
        this.identity = identity;
        this.workID = workID;
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

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public LocalDate getBirth() {
        return birth;
    }

    public void setBirth(LocalDate birth) {
        this.birth = birth;
    }

    public String getIdentity() {
        return identity;
    }

    public void setIdentity(String identity) {
        this.identity = identity;
    }

    public String getWorkID() {
        return workID;
    }

    public void setWorkID(String workID) {
        this.workID = workID;
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
        RegisterUser registerUser = (RegisterUser) o;
        return ID == registerUser.ID &&
                Objects.equals(name, registerUser.name) &&
                Objects.equals(username, registerUser.username) &&
                Objects.equals(password, registerUser.password) &&
                sex == registerUser.sex &&
                Objects.equals(birth, registerUser.birth) &&
                Objects.equals(identity, registerUser.identity) &&
                Objects.equals(workID, registerUser.workID) &&
                Objects.equals(email, registerUser.email) &&
                Objects.equals(imgPath, registerUser.imgPath) &&
                Objects.equals(phone, registerUser.phone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ID, name, username, password, sex, birth, identity, workID, email, imgPath, phone);
    }

    @Override
    public String toString() {
        return "User{" +
                "ID=" + ID +
                ", name='" + name + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", sex=" + sex +
                ", birth=" + birth +
                ", position='" + identity + '\'' +
                ", workID='" + workID + '\'' +
                ", email='" + email + '\'' +
                ", imgPath='" + imgPath + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
