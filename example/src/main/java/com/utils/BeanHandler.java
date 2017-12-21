package com.utils;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.Properties;

/**
 * Created by Administrator on 2017/12/20 0020.
 */
public class BeanHandler implements  ResultSetHandler {
    private Class clazz;
    private Properties prop;

    public BeanHandler(Class clazz,String fileName){
        this.clazz = clazz;
        InputStream in = getClass().getClassLoader().getResourceAsStream(fileName);
        prop = new Properties();
        try {
            prop.load(in);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Object handler(ResultSet rs) {
        try{
            if(!rs.next()){
                return null;
            }
            Object bean = clazz.newInstance();
            //�õ������Ԫ����
            ResultSetMetaData metadata = rs.getMetaData();
            int columnCount = metadata.getColumnCount();//�õ���������м�������
            for(int i=0;i<columnCount;i++){
                String coulmnName = metadata.getColumnName(i+1);//�õ�ÿ�е�����
//                System.out.println(prop);
                String beanCoulmnName = prop.getProperty(coulmnName); //ͨ�������õ���Ӧʵ��������
//                System.out.println("sql :" + coulmnName);
//                System.out.println("bean : " + beanCoulmnName);
                Object value = rs.getObject(i+1);
//                System.out.println(beanCoulmnName + ":" + value);
                Field f = clazz.getDeclaredField(beanCoulmnName);//���������������Ӧ������
                f.setAccessible(true);
                f.set(bean, value);
            }
            return bean;
        }catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
