package com.cml.springboot.sample.db;

import com.cml.springboot.sample.bean.BaseWechatApiLog;
import java.math.BigInteger;

public interface BaseWechatApiLogMapper {
    int deleteByPrimaryKey(BigInteger id);

    int insert(BaseWechatApiLog record);

    int insertSelective(BaseWechatApiLog record);

    BaseWechatApiLog selectByPrimaryKey(BigInteger id);

    int updateByPrimaryKeySelective(BaseWechatApiLog record);

    int updateByPrimaryKey(BaseWechatApiLog record);
}