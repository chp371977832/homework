package com.dao.impl;

import com.dao.LoginInfoDao;
import com.pojo.LoginInfo;
import com.utils.BeanHandler;
import com.utils.JdbcUtil;

/**
 * Created by Administrator on 2017/12/20 0020.
 */
public class LoginInfoDaoImpl implements LoginInfoDao {
    public LoginInfo getLoginInfoByAccout(String account) {
        String sql = "SELECT * FROM login_info WHERE emp_account=?; ";
        Object[] param = {account};
        return (LoginInfo) JdbcUtil.query(sql, param, new BeanHandler(LoginInfo.class, FILE_NAME));
    }

    public LoginInfo getLoginInfoById(long id) {
        String sql = "SELECT * FROM login_info WHERE id=?; ";
        Object[] param = {id};
        return (LoginInfo) JdbcUtil.query(sql, param, new BeanHandler(LoginInfo.class, FILE_NAME));
    }

    public boolean updateLoginInfo(LoginInfo login) {
        String sql = "UPDATE login_info SET emp_name=?,emp_account=?," +
                "emp_password=?,emp_state=?,last_login_time=? WHERE id=? ;";
        Object[] param = {login.getEmpName(),login.getEmpAccount(),login.getEmpPassword(),
                            login.getEmpState(),login.getLastLoginTime(),login.getId()};
        return JdbcUtil.update(sql,param);
    }

    public boolean updateAllLoginState(boolean state) {
        String sql = "UPDATE login_info SET emp_state=?; ";
        Object[] param = {state};
        return JdbcUtil.update(sql,param);
    }
}
