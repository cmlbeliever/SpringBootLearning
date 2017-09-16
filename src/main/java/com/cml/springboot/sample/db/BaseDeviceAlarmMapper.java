package com.cml.springboot.sample.db;

import com.cml.springboot.sample.bean.BaseDeviceAlarm;
import java.math.BigInteger;

public interface BaseDeviceAlarmMapper {
    int deleteByPrimaryKey(BigInteger id);

    int insert(BaseDeviceAlarm record);

    int insertSelective(BaseDeviceAlarm record);

    BaseDeviceAlarm selectByPrimaryKey(BigInteger id);

    int updateByPrimaryKeySelective(BaseDeviceAlarm record);

    int updateByPrimaryKey(BaseDeviceAlarm record);
}