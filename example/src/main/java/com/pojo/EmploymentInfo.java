package com.pojo;

/**
 * @author hanpocheng
 * @version 1.0 2017.12.20 14.30
 * 实体类，与表 employment_info对应
 */
public class EmploymentInfo {
    private long id; /** 主键*/
    private String empNumber;   /**员工编号*/
    private String department;  /**所在部门*/
    private String post;     /** 岗位*/
    private String empType; /** 员工类型（全职/兼职）*/
    private String empDate; /** 入职时间 YYYY-MM-DD*/
    private float salary;   /** 工资*/
    private long foreignId;  /** 外键 与 login_info(id) 关联*/

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
