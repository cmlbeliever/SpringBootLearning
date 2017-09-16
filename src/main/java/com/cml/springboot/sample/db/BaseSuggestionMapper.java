package com.cml.springboot.sample.db;

import com.cml.springboot.sample.bean.BaseSuggestion;
import java.math.BigInteger;

public interface BaseSuggestionMapper {
    int deleteByPrimaryKey(BigInteger id);

    int insert(BaseSuggestion record);

    int insertSelective(BaseSuggestion record);

    BaseSuggestion selectByPrimaryKey(BigInteger id);

    int updateByPrimaryKeySelective(BaseSuggestion record);

    int updateByPrimaryKey(BaseSuggestion record);
}