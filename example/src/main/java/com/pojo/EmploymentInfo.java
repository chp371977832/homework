package com.pojo;

/**
 * @author hanpocheng
 * @version 1.0 2017.12.20 14.30
 * ʵ���࣬��� employment_info��Ӧ
 */
public class EmploymentInfo {
    private long id; /** ����*/
    private String empNumber;   /**Ա�����*/
    private String department;  /**���ڲ���*/
    private String post;     /** ��λ*/
    private String empType; /** Ա�����ͣ�ȫְ/��ְ��*/
    private String empDate; /** ��ְʱ�� YYYY-MM-DD*/
    private float salary;   /** ����*/
    private long foreignId;  /** ��� �� login_info(id) ����*/

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEmpNumber() {
        return empNumber;
    }

    public void setEmpNumber(String empNumber) {
        this.empNumber = empNumber;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public String getEmpType() {
        return empType;
    }

    public void setEmpType(String empType) {
        this.empType = empType;
    }

    public String getEmpDate() {
        return empDate;
    }

    public void setEmpDate(String empDate) {
        this.empDate = empDate;
    }

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    public long getForeignId() {
        return foreignId;
    }

    public void setForeignId(long foreignId) {
        this.foreignId = foreignId;
    }
}
