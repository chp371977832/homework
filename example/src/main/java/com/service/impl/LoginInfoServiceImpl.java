package com.service.impl;

import com.dao.LoginInfoDao;
import com.dao.impl.LoginInfoDaoImpl;
import com.pojo.LoginInfo;
import com.service.LoginInfoService;
import sun.misc.BASE64Encoder;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

/**
 * Created by Administrator on 2017/12/20 0020.
 */
public class LoginInfoServiceImpl implements LoginInfoService {
    private  LoginInfoDao loginInfoDao = new LoginInfoDaoImpl();
    public LoginInfo getLoginInfoByAccout(String account) {
        return loginInfoDao.getLoginInfoByAccout(account);
    }

    public boolean isCorrect(LoginInfo loginInfo) {
        LoginInfo temp = getLoginInfoByAccout(loginInfo.getEmpAccount());
        boolean flag = false;
        try {
            MessageDigest md = MessageDigest.getInstance("md5");
            byte[] md5 = md.digest(loginInfo.getEmpPassword().getBytes("utf-8"));
            BASE64Encoder base64en = new BASE64Encoder();
            String t = base64en.encode(md5);
            if(t !=null && t.equals(temp.getEmpPassword())){
                flag = true;
                loginInfo = temp;
            }
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return flag;
    }

    public boolean isLogin(LoginInfo loginInfo) {
        return loginInfo.getEmpState();
    }

    public boolean updateLoginInfo(LoginInfo loginInfo) {
        return loginInfoDao.updateLoginInfo(loginInfo);
    }

    public boolean updateAllLoginState(boolean state){
        return loginInfoDao.updateAllLoginState(state);
    }

}
