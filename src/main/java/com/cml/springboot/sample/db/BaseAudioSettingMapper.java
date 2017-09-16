package com.cml.springboot.sample.db;

import com.cml.springboot.sample.bean.BaseAudioSetting;

public interface BaseAudioSettingMapper {
    int insert(BaseAudioSetting record);

    int insertSelective(BaseAudioSetting record);
}