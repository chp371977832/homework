package com.utils;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * @author hanpo cheng
 * @version 1.0 2017.12.20 16:54
 */
public class BeanListHandler implements ResultSetHandler{
    private Class clazz;
    private Properties prop;

    public BeanListHandler(Class clazz,String fileName){
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
            List<Object> list = new ArrayList<Object>();
            while(rs.next()){
                Object bean = clazz.newInstance();

                ResultSetMetaData metadata = rs.getMetaData();
                int count = metadata.getColumnCount();
                for(int i=0;i<count;i++){
                    String name = metadata.getColumnName(i+1);
                    Object value = rs.getObject(name);
                    String beanCoulmnName = prop.getProperty(name);
                    Field f = bean.getClass().getDeclaredField(beanCoulmnName);
                    f.setAccessible(true);
                    f.set(bean, value);
                }
                list.add(bean);
            }
            return list.size()>0?list:null;

        }catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
