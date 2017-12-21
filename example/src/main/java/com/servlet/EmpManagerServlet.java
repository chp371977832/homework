package com.servlet;

import com.pojo.BasicInfo;
import com.pojo.EmploymentInfo;
import com.pojo.LoginInfo;
import com.service.BasicInfoService;
import com.service.EmploymentInfoService;
import com.service.LoginInfoService;
import com.service.impl.BasicInfoServiceImpl;
import com.service.impl.EmploymentInfoServiceImpl;
import com.service.impl.LoginInfoServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Date;


/**
 * Created by Administrator on 2017/12/20 0020.
 */
public class EmpManagerServlet extends HttpServlet {
    private LoginInfoService loginService = new LoginInfoServiceImpl();
    private BasicInfoService basicService = new BasicInfoServiceImpl();
    private EmploymentInfoService employmentService = new EmploymentInfoServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String method = request.getParameter("method");
        System.out.println("method = " + method);
        HttpSession session = request.getSession();
        if(session.getAttribute("msg") != null){
            session.removeAttribute("msg");
        }
        if("login".equals(method)){
            login(request,response);
        }else if("logout".equals(method)){
            logout(request,response);
        }else if("checkLoginInfo".equals(method)){
            checkLoginInfo(request,response);
        }else if("checkBasicInfo".equals(method)){
            checkBasicInfo(request,response);
        }else if("checkEmploymentInfo".equals(method)){
            checkEmploymentInfo(request,response);
        }else{
            response.sendRedirect("error.jsp");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
    private void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
//        System.out.println("to login");
        String account = request.getParameter("account");
        String password = request.getParameter("password");

        boolean flag = false;
        LoginInfo login = new LoginInfo();
        login.setEmpAccount(account);
        login.setEmpPassword(password);

        if(account != null && password != null){
            flag = loginService.isCorrect(login);
            login = loginService.getLoginInfoByAccout(login.getEmpAccount());
        }

        HttpSession session = request.getSession();
        if(flag == true){
            if(login.getEmpState() == false){
                login.setEmpState(true);
                login.setLastLoginTime(new Date());
                loginService.updateLoginInfo(login);
                session.setAttribute("login",login);
                response.sendRedirect("main.jsp");
            }else{
                String msg = "ÕËºÅÒÑÔÚ±ð´¦µÇÂ¼";
                session.setAttribute("msg",msg);
                response.sendRedirect("login.jsp");
            }
        }else{
            String msg = "ÕËºÅ»òÃÜÂë´íÎó";
            session.setAttribute("msg",msg);
            response.sendRedirect("login.jsp");
        }

    }

    private void logout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        HttpSession session = request.getSession();
        LoginInfo loginInfo = (LoginInfo) session.getAttribute("login");
        if(loginInfo != null){
            loginInfo.setEmpState(false);
            loginService.updateLoginInfo(loginInfo);
            session.removeAttribute("login");
        }
        response.sendRedirect("index.jsp");
    }

    private void checkLoginInfo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        HttpSession session = request.getSession();
        if(session.getAttribute("login") != null){
            response.sendRedirect("checkLoginInfo.jsp");
        }else{
            String msg = "µÇÂ¼Ê§Ð§£¬ÇëµÇÂ¼";
            session.setAttribute("msg",msg);
            response.sendRedirect("index.jsp");
        }
    }

    private void checkBasicInfo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        HttpSession session = request.getSession();
        LoginInfo login = (LoginInfo) session.getAttribute("login");
        if(login == null){
            String msg = "µÇÂ¼Ê§Ð§£¬ÇëµÇÂ¼";
            session.setAttribute("msg",msg);
            response.sendRedirect("index.jsp");
        }else {
            BasicInfo basicInfo = basicService.getBasicInfoByForeignId(login.getId());
            session.setAttribute("basicInfo",basicInfo);
            response.sendRedirect("checkBasicInfo.jsp");
        }
    }

    private void checkEmploymentInfo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        HttpSession session = request.getSession();
        LoginInfo login = (LoginInfo) session.getAttribute("login");
        if(login == null){
            String msg = "µÇÂ¼Ê§Ð§£¬ÇëµÇÂ¼";
            session.setAttribute("msg",msg);
            response.sendRedirect("index.jsp");
        }else {
            EmploymentInfo employmentInfo = employmentService.getEmploymentInfoByForeignId(login.getId());
            session.setAttribute("employmentInfo",employmentInfo);
            response.sendRedirect("checkEmploymentInfo.jsp");
        }
    }
}
