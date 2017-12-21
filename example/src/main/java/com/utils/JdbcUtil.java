package com.utils;

import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

/**
 * @author hanpo cheng
 * @version 1.0 2017.12.20 15:22
 * ���ݿ���ʹ���
 */
public class JdbcUtil {
    private static String driver; /** ���� */
    private static String url;  /** ���ݿ�url*/
    private static String username; /** ���ݿ��¼��*/
    private static String password; /** ���ݿ��¼����*/

    static {
        try{
            //��ȡdb.properties�ļ��е����ݿ�������Ϣ
            InputStream in = JdbcUtil.class.getClassLoader().getResourceAsStream("db.properties");
            Properties prop = new Properties();
            prop.load(in);

            //��ȡ���ݿ���������
            driver = prop.getProperty("driver");
            //��ȡ���ݿ�����URL��ַ
            url = prop.getProperty("url");
            //��ȡ���ݿ������û���
            username = prop.getProperty("username");
            //��ȡ���ݿ���������
            password = prop.getProperty("password");

            //�������ݿ�����
            Class.forName(driver);

        }catch (Exception e) {
            throw new ExceptionInInitializerError(e);
        }
    }

    /**
     * �����������࣬��˹��캯��˽��
     * */
    private JdbcUtil(){
    }



    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, username,password);
    }

    public static void release(Connection conn, Statement st, ResultSet rs){
        if(rs!=null){
            try{
                //�رմ洢��ѯ�����ResultSet����
                rs.close();
            }catch (Exception e) {
                e.printStackTrace();
            }
            rs = null;
        }
        if(st!=null){
            try{
                //�رո���ִ��SQL�����Statement����
                st.close();
            }catch (Exception e) {
                e.printStackTrace();
            }
        }

        if(conn!=null){
            try{
                //�ر�Connection���ݿ����Ӷ���
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
         * ���ڲ�ѯ���صĽ��������ʹ�õ��˲���ģʽ��
         * �����query����ʱ��query�����������޷�֪���û��Է��صĲ�ѯ�������ν��д���ģ�����֪��������Ĵ�����ԣ�
         * ��ô���������Ĵ�����Ծ����û��Լ��ṩ��query�����ڲ��͵����û��ύ�Ľ����������Խ��д���
         * Ϊ���ܹ����û��ṩ������Ĵ�����ԣ���Ҫ���û���¶��һ�����������ӿ�ResultSetHandler
         * �û�ֻҪʵ����ResultSetHandler�ӿڣ���ôquery�����ڲ���֪���û�Ҫ��δ���������
         */
        try {
            return rsh.handler(rs);
        } finally{
            release(conn, st, rs);
        }
    }
}
