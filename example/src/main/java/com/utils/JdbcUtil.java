package com.utils;

import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

/**
 * @author hanpo cheng
 * @version 1.0 2017.12.20 15:22
 * 数据库访问工具
 */
public class JdbcUtil {
    private static String driver; /** 驱动 */
    private static String url;  /** 数据库url*/
    private static String username; /** 数据库登录名*/
    private static String password; /** 数据库登录密码*/

    static {
        try{
            //读取db.properties文件中的数据库连接信息
            InputStream in = JdbcUtil.class.getClassLoader().getResourceAsStream("db.properties");
            Properties prop = new Properties();
            prop.load(in);

            //获取数据库连接驱动
            driver = prop.getProperty("driver");
            //获取数据库连接URL地址
            url = prop.getProperty("url");
            //获取数据库连接用户名
            username = prop.getProperty("username");
            //获取数据库连接密码
            password = prop.getProperty("password");

            //加载数据库驱动
            Class.forName(driver);

        }catch (Exception e) {
            throw new ExceptionInInitializerError(e);
        }
    }

    /**
     * 此类做工具类，因此构造函数私有
     * */
    private JdbcUtil(){
    }



    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, username,password);
    }

    public static void release(Connection conn, Statement st, ResultSet rs){
        if(rs!=null){
            try{
                //关闭存储查询结果的ResultSet对象
                rs.close();
            }catch (Exception e) {
                e.printStackTrace();
            }
            rs = null;
        }
        if(st!=null){
            try{
                //关闭负责执行SQL命令的Statement对象
                st.close();
            }catch (Exception e) {
                e.printStackTrace();
            }
        }

        if(conn!=null){
            try{
                //关闭Connection数据库连接对象
                conn.close();
            }catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static boolean update(String sql,Object params[]){
        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        int n = 0;
        try{
            conn = getConnection();
            st = conn.prepareStatement(sql);
            for(int i=0;i<params.length;i++){
                st.setObject(i+1, params[i]);
            }
            n = st.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally{
            release(conn, st, rs);
        }
        if(n > 0){
            return true;
        }else{
            return false;
        }
    }
    public static Object query(String sql,Object params[],ResultSetHandler rsh) {

        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs = null;

        try{
            conn = getConnection();
            st = conn.prepareStatement(sql);
            for(int i=0;i<params.length;i++){
                st.setObject(i+1, params[i]);
            }
            rs = st.executeQuery();



        } catch (SQLException e) {
            e.printStackTrace();
        }
        /**
         * 对于查询返回的结果集处理使用到了策略模式，
         * 在设计query方法时，query方法事先是无法知道用户对返回的查询结果集如何进行处理的，即不知道结果集的处理策略，
         * 那么这个结果集的处理策略就让用户自己提供，query方法内部就调用用户提交的结果集处理策略进行处理
         * 为了能够让用户提供结果集的处理策略，需要对用户暴露出一个结果集处理接口ResultSetHandler
         * 用户只要实现了ResultSetHandler接口，那么query方法内部就知道用户要如何处理结果集了
         */
        try {
            return rsh.handler(rs);
        } finally{
            release(conn, st, rs);
        }
    }
}
