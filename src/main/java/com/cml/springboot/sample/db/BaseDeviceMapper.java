package com.cml.springboot.sample.db;

import com.cml.springboot.sample.bean.BaseDevice;
import java.math.BigInteger;

public interface BaseDeviceMapper {
    int deleteByPrimaryKey(BigInteger deviceId);

    int insert(BaseDevice record);

    int insertSelective(BaseDevice record);

    BaseDevice selectByPrimaryKey(BigInteger deviceId);

    int updateByPrimaryKeySelective(BaseDevice record);

    int updateByPrimaryKey(BaseDevice record);
}