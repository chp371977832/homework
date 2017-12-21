package com.service;

import com.pojo.LoginInfo;

/**
 * Created by Administrator on 2017/12/20 0020.
 */
public interface LoginInfoService {
    LoginInfo getLoginInfoByAccout(String account);

    boolean isCorrect(LoginInfo loginInfo);

    boolean isLogin(LoginInfo loginInfo);

    boolean updateLoginInfo(LoginInfo loginInfo);

    public boolean updateAllLoginState(boolean state);
}
