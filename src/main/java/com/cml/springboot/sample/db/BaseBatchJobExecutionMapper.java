package com.cml.springboot.sample.db;

import com.cml.springboot.sample.bean.BaseBatchJobExecution;
import java.math.BigInteger;

public interface BaseBatchJobExecutionMapper {
    int deleteByPrimaryKey(BigInteger jobExecutionId);

    int insert(BaseBatchJobExecution record);

    int insertSelective(BaseBatchJobExecution record);

    BaseBatchJobExecution selectByPrimaryKey(BigInteger jobExecutionId);

    int updateByPrimaryKeySelective(BaseBatchJobExecution record);

    int updateByPrimaryKey(BaseBatchJobExecution record);
}