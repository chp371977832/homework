package com.dao;

import com.pojo.BasicInfo;

/**
 * Created by Administrator on 2017/12/20 0020.
 */
public interface BasicInfoDao {
    String FILE_NAME = "basicInfo.properties";
    BasicInfo getBasicInfoByForeignId(long foreignId);
}
