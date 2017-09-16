package com.cml.springboot.sample.db;

import com.cml.springboot.sample.bean.BaseBatchJobExecutionParams;

public interface BaseBatchJobExecutionParamsMapper {
    int insert(BaseBatchJobExecutionParams record);

    int insertSelective(BaseBatchJobExecutionParams record);
}