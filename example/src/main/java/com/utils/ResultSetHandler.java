package com.utils;

import java.sql.ResultSet;
import java.util.Properties;

/**
 * Created by Administrator on 2017/12/20 0020.
 */
public interface ResultSetHandler {
    Object handler(ResultSet rs);
}
