package com.dao;

import com.pojo.LoginInfo;

/**
 * Created by Administrator on 2017/12/20 0020.
 */
public interface LoginInfoDao {
    String FILE_NAME = "loginInfo.properties";
    LoginInfo getLoginInfoByAccout(String account);
    LoginInfo getLoginInfoById(long id);

    boolean updateLoginInfo(LoginInfo login);

    public boolean updateAllLoginState(boolean state);

}
