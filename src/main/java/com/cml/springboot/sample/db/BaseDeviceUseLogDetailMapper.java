package com.cml.springboot.sample.db;

import com.cml.springboot.sample.bean.BaseDeviceUseLogDetail;

public interface BaseDeviceUseLogDetailMapper {
    int insert(BaseDeviceUseLogDetail record);

    int insertSelective(BaseDeviceUseLogDetail record);
}