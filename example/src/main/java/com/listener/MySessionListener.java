package com.listener; /**
 * Created by Administrator on 2017/12/20 0020.
 */
import com.pojo.LoginInfo;
import com.service.LoginInfoService;
import com.service.impl.LoginInfoServiceImpl;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;


public class MySessionListener implements HttpSessionListener {
    private LoginInfoService loginService = new LoginInfoServiceImpl();

    public void sessionCreated(HttpSessionEvent httpSessionEvent) {

        System.out.println("session created");

    }

    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {
        System.out.println("session destroyed");
        HttpSession session = httpSessionEvent.getSession();
        LoginInfo loginInfo = (LoginInfo) session.getAttribute("login");
        if(loginInfo != null){
            loginInfo.setEmpState(false);
            loginService.updateLoginInfo(loginInfo);
        }
    }
}
