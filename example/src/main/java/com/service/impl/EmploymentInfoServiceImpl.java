package com.service.impl;

import com.dao.EmploymentInfoDao;
import com.dao.impl.EmploymentInfoDaoImpl;
import com.pojo.EmploymentInfo;
import com.service.EmploymentInfoService;

/**
 * Created by Administrator on 2017/12/20 0020.
 */
public class EmploymentInfoServiceImpl implements EmploymentInfoService {
    private EmploymentInfoDao empInfoDao = new EmploymentInfoDaoImpl();
    public EmploymentInfo getEmploymentInfoByForeignId(long foreignId) {
        return empInfoDao.getEmploymentInfoByForeignId(foreignId);
    }
}
