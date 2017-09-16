package com.cml.springboot.sample.db;

import com.cml.springboot.sample.bean.BaseBatchStepExecution;
import java.math.BigInteger;

public interface BaseBatchStepExecutionMapper {
    int deleteByPrimaryKey(BigInteger stepExecutionId);

    int insert(BaseBatchStepExecution record);

    int insertSelective(BaseBatchStepExecution record);

    BaseBatchStepExecution selectByPrimaryKey(BigInteger stepExecutionId);

    int updateByPrimaryKeySelective(BaseBatchStepExecution record);

    int updateByPrimaryKey(BaseBatchStepExecution record);
}