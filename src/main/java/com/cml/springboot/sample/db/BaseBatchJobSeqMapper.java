package com.cml.springboot.sample.db;

import com.cml.springboot.sample.bean.BaseBatchJobSeq;

public interface BaseBatchJobSeqMapper {
    int insert(BaseBatchJobSeq record);

    int insertSelective(BaseBatchJobSeq record);
}