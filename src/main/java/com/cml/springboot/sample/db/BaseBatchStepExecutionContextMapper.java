package com.cml.springboot.sample.db;

import com.cml.springboot.sample.bean.BaseBatchStepExecutionContext;
import java.math.BigInteger;

public interface BaseBatchStepExecutionContextMapper {
    int deleteByPrimaryKey(BigInteger stepExecutionId);

    int insert(BaseBatchStepExecutionContext record);

    int insertSelective(BaseBatchStepExecutionContext record);

    BaseBatchStepExecutionContext selectByPrimaryKey(BigInteger stepExecutionId);

    int updateByPrimaryKeySelective(BaseBatchStepExecutionContext record);

    int updateByPrimaryKey(BaseBatchStepExecutionContext record);
}