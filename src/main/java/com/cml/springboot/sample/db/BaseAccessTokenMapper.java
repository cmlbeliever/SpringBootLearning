package com.cml.springboot.sample.db;

import com.cml.springboot.sample.bean.BaseAccessToken;

public interface BaseAccessTokenMapper {
    int insert(BaseAccessToken record);

    int insertSelective(BaseAccessToken record);
}