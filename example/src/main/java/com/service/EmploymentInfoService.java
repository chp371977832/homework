package com.service;

import com.pojo.EmploymentInfo;

/**
 * Created by Administrator on 2017/12/20 0020.
 */
public interface EmploymentInfoService {
    EmploymentInfo getEmploymentInfoByForeignId(long foreignId);
}
