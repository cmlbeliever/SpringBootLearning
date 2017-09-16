package com.cml.springboot.sample.db;

import com.cml.springboot.sample.bean.BaseUseDayRange;
import java.math.BigInteger;

public interface BaseUseDayRangeMapper {
    int deleteByPrimaryKey(BigInteger id);

    int insert(BaseUseDayRange record);

    int insertSelective(BaseUseDayRange record);

    BaseUseDayRange selectByPrimaryKey(BigInteger id);

    int updateByPrimaryKeySelective(BaseUseDayRange record);

    int updateByPrimaryKey(BaseUseDayRange record);
}