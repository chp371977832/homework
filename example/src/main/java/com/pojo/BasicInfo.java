package com.pojo;

/**
 * @author hanpo cheng
 * @version 1.0 2017.12.20 14:57
 * ʵ���࣬�������Ա��������Ϣ����� basic_info ��Ӧ
 */
public class BasicInfo {
    private long id;     /** ����*/
    private String idNumber;    /** ���֤��*/
    private String phone;   /** �ֻ���*/
    private String gender;  /** �Ա�*/
    private String birthday;  /** �������� YYYY-MM-DD*/
    private String birthPlace;  /** ������*/
    private String nationality; /** ����*/
    private String education;   /** ѧ��*/
    private String address;     /** סַ*/
    private long foreignId;     /** ��� �� login_info(id) ����*/

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
