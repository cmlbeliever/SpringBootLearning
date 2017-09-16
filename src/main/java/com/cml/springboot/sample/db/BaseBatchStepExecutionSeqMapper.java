package com.cml.springboot.sample.db;

import com.cml.springboot.sample.bean.BaseBatchStepExecutionSeq;

public interface BaseBatchStepExecutionSeqMapper {
    int insert(BaseBatchStepExecutionSeq record);

    int insertSelective(BaseBatchStepExecutionSeq record);
}