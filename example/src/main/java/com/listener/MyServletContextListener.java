package com.listener; /**
 * Created by Administrator on 2017/12/21 0021.
 */

import com.service.LoginInfoService;
import com.service.impl.LoginInfoServiceImpl;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;


public class MyServletContextListener implements ServletContextListener{
    private LoginInfoService loginService = new LoginInfoServiceImpl();

    public void contextInitialized(ServletContextEvent servletContextEvent) {

    }

    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        loginService.updateAllLoginState(false);
    }
}
