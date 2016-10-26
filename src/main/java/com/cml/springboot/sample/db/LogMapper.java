package com.cml.springboot.sample.db;

import com.cml.springboot.sample.bean.LogBean;

public interface LogMapper {
	Integer insertLog(LogBean logbean);
}
