package com.cml.springboot.sample.db;

import com.cml.springboot.sample.bean.BaseDeviceUseLog;
import java.math.BigInteger;

public interface BaseDeviceUseLogMapper {
    int deleteByPrimaryKey(BigInteger id);

    int insert(BaseDeviceUseLog record);

    int insertSelective(BaseDeviceUseLog record);

    BaseDeviceUseLog selectByPrimaryKey(BigInteger id);

    int updateByPrimaryKeySelective(BaseDeviceUseLog record);

    int updateByPrimaryKey(BaseDeviceUseLog record);
}