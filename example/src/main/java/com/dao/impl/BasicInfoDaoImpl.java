package com.dao.impl;

import com.dao.BasicInfoDao;
import com.pojo.BasicInfo;
import com.utils.BeanHandler;
import com.utils.JdbcUtil;

/**
 * Created by Administrator on 2017/12/20 0020.
 */
public class BasicInfoDaoImpl implements BasicInfoDao {
    public BasicInfo getBasicInfoByForeignId(long foreignId) {
        String sql = "SELECT * FROM basic_info WHERE foreign_id=?;";
        Object[] param = {foreignId};
        return (BasicInfo) JdbcUtil.query(sql, param, new BeanHandler(BasicInfo.class, FILE_NAME));
    }
}
