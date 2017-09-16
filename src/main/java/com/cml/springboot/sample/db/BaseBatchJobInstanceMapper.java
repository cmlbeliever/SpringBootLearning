package com.cml.springboot.sample.db;

import com.cml.springboot.sample.bean.BaseBatchJobInstance;
import java.math.BigInteger;

public interface BaseBatchJobInstanceMapper {
    int deleteByPrimaryKey(BigInteger jobInstanceId);

    int insert(BaseBatchJobInstance record);

    int insertSelective(BaseBatchJobInstance record);

    BaseBatchJobInstance selectByPrimaryKey(BigInteger jobInstanceId);

    int updateByPrimaryKeySelective(BaseBatchJobInstance record);

    int updateByPrimaryKey(BaseBatchJobInstance record);
}