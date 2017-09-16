package com.cml.springboot.sample.db;

import com.cml.springboot.sample.bean.BaseBatchJobExecutionContext;
import java.math.BigInteger;

public interface BaseBatchJobExecutionContextMapper {
    int deleteByPrimaryKey(BigInteger jobExecutionId);

    int insert(BaseBatchJobExecutionContext record);

    int insertSelective(BaseBatchJobExecutionContext record);

    BaseBatchJobExecutionContext selectByPrimaryKey(BigInteger jobExecutionId);

    int updateByPrimaryKeySelective(BaseBatchJobExecutionContext record);

    int updateByPrimaryKey(BaseBatchJobExecutionContext record);
}