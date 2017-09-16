package com.cml.springboot.sample.db;

import com.cml.springboot.sample.bean.BaseAdminUser;
import java.math.BigInteger;

public interface BaseAdminUserMapper {
    int deleteByPrimaryKey(BigInteger id);

    int insert(BaseAdminUser record);

    int insertSelective(BaseAdminUser record);

    BaseAdminUser selectByPrimaryKey(BigInteger id);

    int updateByPrimaryKeySelective(BaseAdminUser record);

    int updateByPrimaryKey(BaseAdminUser record);
}