package com.cml.springboot.sample.db;

import com.cml.springboot.sample.bean.BaseUser;
import java.math.BigInteger;

public interface BaseUserMapper {
    int deleteByPrimaryKey(BigInteger id);

    int insert(BaseUser record);

    int insertSelective(BaseUser record);

    BaseUser selectByPrimaryKey(BigInteger id);

    int updateByPrimaryKeySelective(BaseUser record);

    int updateByPrimaryKey(BaseUser record);
}