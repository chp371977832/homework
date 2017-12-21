package com.dao;

import com.pojo.EmploymentInfo;

/**
 * Created by Administrator on 2017/12/20 0020.
 */
public interface EmploymentInfoDao {
    String FILE_NAME = "employmentInfo.properties";
    EmploymentInfo getEmploymentInfoByForeignId(long foreignId);
}
