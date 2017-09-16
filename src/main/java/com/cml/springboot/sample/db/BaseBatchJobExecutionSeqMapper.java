package com.cml.springboot.sample.db;

import com.cml.springboot.sample.bean.BaseBatchJobExecutionSeq;

public interface BaseBatchJobExecutionSeqMapper {
    int insert(BaseBatchJobExecutionSeq record);

    int insertSelective(BaseBatchJobExecutionSeq record);
}