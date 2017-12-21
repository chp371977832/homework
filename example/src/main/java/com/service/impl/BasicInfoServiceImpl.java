package com.service.impl;

import com.dao.BasicInfoDao;
import com.dao.impl.BasicInfoDaoImpl;
import com.pojo.BasicInfo;
import com.service.BasicInfoService;

/**
 * Created by Administrator on 2017/12/20 0020.
 */
public class BasicInfoServiceImpl implements BasicInfoService {
    private BasicInfoDao basicInfoDao = new BasicInfoDaoImpl();
    public BasicInfo getBasicInfoByForeignId(long foreignId) {
        return basicInfoDao.getBasicInfoByForeignId(foreignId);
    }
}
