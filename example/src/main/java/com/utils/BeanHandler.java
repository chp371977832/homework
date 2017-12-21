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
            //得到结果集元数据
            ResultSetMetaData metadata = rs.getMetaData();
            int columnCount = metadata.getColumnCount();//得到结果集中有几列数据
            for(int i=0;i<columnCount;i++){
                String coulmnName = metadata.getColumnName(i+1);//得到每列的列名
//                System.out.println(prop);
                String beanCoulmnName = prop.getProperty(coulmnName); //通过列名得到对应实体类列名
//                System.out.println("sql :" + coulmnName);
//                System.out.println("bean : " + beanCoulmnName);
                Object value = rs.getObject(i+1);
//                System.out.println(beanCoulmnName + ":" + value);
                Field f = clazz.getDeclaredField(beanCoulmnName);//反射出类上列名对应的属性
                f.setAccessible(true);
                f.set(bean, value);
            }
            return bean;
        }catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
