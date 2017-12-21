package com.service;

import com.pojo.BasicInfo;

/**
 * Created by Administrator on 2017/12/20 0020.
 */
public interface BasicInfoService {
    BasicInfo getBasicInfoByForeignId(long foreignId);
}
