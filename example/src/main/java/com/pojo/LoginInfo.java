package com.pojo;

import java.util.Date;

/**
 * @author hanpocheng
 * @version 1.0 2017.12.20 14.30
 * ʵ���࣬��login_info���Ӧ
 */
public class LoginInfo {
    private long id;     /** ����*/
    private String empName;  /** �û���*/
    private String empAccount;  /**��¼�˺�*/
    private String empPassword; /** ��¼����*/
    private boolean empState;   /** ��¼״̬*/
    private Date lastLoginTime; /**����½ʱ��*/

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getEmpAccount() {
        return empAccount;
    }

    public void setEmpAccount(String empAccount) {
        this.empAccount = empAccount;
    }

    public String getEmpPassword() {
        return empPassword;
    }

    public void setEmpPassword(String empPassword) {
        this.empPassword = empPassword;
    }

    public boolean getEmpState() {
        return empState;
    }

    public void setEmpState(boolean empState) {
        this.empState = empState;
    }

    public Date getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }
}
