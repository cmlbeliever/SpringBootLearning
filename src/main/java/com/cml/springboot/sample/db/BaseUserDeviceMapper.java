package com.cml.springboot.sample.db;

import com.cml.springboot.sample.bean.BaseUserDevice;
import java.math.BigInteger;

public interface BaseUserDeviceMapper {
    int deleteByPrimaryKey(BigInteger id);

    int insert(BaseUserDevice record);

    int insertSelective(BaseUserDevice record);

    BaseUserDevice selectByPrimaryKey(BigInteger id);

    int updateByPrimaryKeySelective(BaseUserDevice record);

    int updateByPrimaryKey(BaseUserDevice record);
}