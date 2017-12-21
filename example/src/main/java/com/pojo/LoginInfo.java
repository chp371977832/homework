package com.pojo;

import java.util.Date;

/**
 * @author hanpocheng
 * @version 1.0 2017.12.20 14.30
 * 实体类，与login_info表对应
 */
public class LoginInfo {
    private long id;     /** 主键*/
    private String empName;  /** 用户名*/
    private String empAccount;  /**登录账号*/
    private String empPassword; /** 登录密码*/
    private boolean empState;   /** 登录状态*/
    private Date lastLoginTime; /**最后登陆时间*/

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
