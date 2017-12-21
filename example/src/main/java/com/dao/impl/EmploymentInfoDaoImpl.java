package com.dao.impl;

import com.dao.EmploymentInfoDao;
import com.pojo.EmploymentInfo;
import com.utils.BeanHandler;
import com.utils.JdbcUtil;

/**
 * Created by Administrator on 2017/12/20 0020.
 */
public class EmploymentInfoDaoImpl implements EmploymentInfoDao {
    public EmploymentInfo getEmploymentInfoByForeignId(long foreignId) {
        String sql = "SELECT * FROM employment_info WHERE foreign_id=?;";
        Object[] param = {foreignId};
        return (EmploymentInfo) JdbcUtil.query(sql, param, new BeanHandler(EmploymentInfo.class, FILE_NAME));
    }
}
