package com.cml.springboot.sample.service;

import com.cml.springboot.sample.bean.LogBean;

public interface LogService {
	Integer insertLog(LogBean logbean);

	Integer insertLogReadOnly(LogBean logbean);
}
