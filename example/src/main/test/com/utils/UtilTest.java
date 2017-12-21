package com.utils;

import com.pojo.BasicInfo;
import com.pojo.EmploymentInfo;
import com.pojo.LoginInfo;
import org.junit.Test;
import sun.misc.BASE64Encoder;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Administrator on 2017/12/20 0020.
 */
public class UtilTest {
    @Test
    public void testBeanHandler() throws SQLException {
        /*String sql = "select * from login_info where id=?;";
        Object[] param = {1};
        String fileName = "loginInfo.properties";
        LoginInfo login = (LoginInfo) JdbcUtil.query(sql,param,new BeanHandler(LoginInfo.class,fileName));
        System.out.println("account : " + login.getEmpAccount());
        System.out.println("pwd :" + login.getEmpPassword());*/

        /*String sql = "select * from basic_info where id=?;";
        Object[] param = {1};
        String fileName = "basicInfo.properties";
        BasicInfo basic = (BasicInfo) JdbcUtil.query(sql,param,new BeanHandler(BasicInfo.class,fileName));
        System.out.println("idNumber : " + basic.getIdNumber());
        System.out.println("gender :" + basic.getGender());*/

        String sql = "select * from employment_info where id=?;";
        Object[] param = {1};
        String fileName = "employmentInfo.properties";
        EmploymentInfo emp = (EmploymentInfo) JdbcUtil.query(sql,param,new BeanHandler(EmploymentInfo.class,fileName));
        System.out.println("empNumber : " + emp.getEmpNumber());
        System.out.println("empDate :" + emp.getEmpDate());
    }

    @Test
    public void testBeanListHandler() throws SQLException {
        String sql = "select * from login_info;";
        Object[] param = {};
        String fileName = "loginInfo.properties";
        List<LoginInfo> list = (List<LoginInfo>) JdbcUtil.query(sql,param,new BeanListHandler(LoginInfo.class,fileName));
        for(LoginInfo login : list) {
            System.out.println("account : " + login.getEmpAccount());
            System.out.println("pwd :" + login.getEmpPassword());
        }
    }
    @Test
    public void test3(){
        MessageDigest md = null;
        try {
            md = MessageDigest.getInstance("md5");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        byte[] md5 = new byte[0];
        try {
            md5 = md.digest("456789".getBytes("utf-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        BASE64Encoder base64en = new BASE64Encoder();
        String t = base64en.encode(md5);
        System.out.println(t);
    }
}