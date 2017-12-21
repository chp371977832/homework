package com.pojo;

/**
 * @author hanpo cheng
 * @version 1.0 2017.12.20 14:57
 * 实体类，用来存放员工基本信息，与表 basic_info 对应
 */
public class BasicInfo {
    private long id;     /** 主键*/
    private String idNumber;    /** 身份证号*/
    private String phone;   /** 手机号*/
    private String gender;  /** 性别*/
    private String birthday;  /** 出生日期 YYYY-MM-DD*/
    private String birthPlace;  /** 出生地*/
    private String nationality; /** 民族*/
    private String education;   /** 学历*/
    private String address;     /** 住址*/
    private long foreignId;     /** 外键 和 login_info(id) 关联*/

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getBirthPlace() {
        return birthPlace;
    }

    public void setBirthPlace(String birthPlace) {
        this.birthPlace = birthPlace;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public long getForeignId() {
        return foreignId;
    }

    public void setForeignId(long foreignId) {
        this.foreignId = foreignId;
    }
}
