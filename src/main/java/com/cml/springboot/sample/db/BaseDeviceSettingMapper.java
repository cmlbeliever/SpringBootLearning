package com.cml.springboot.sample.db;

import com.cml.springboot.sample.bean.BaseDeviceSetting;

public interface BaseDeviceSettingMapper {
    int insert(BaseDeviceSetting record);

    int insertSelective(BaseDeviceSetting record);
}