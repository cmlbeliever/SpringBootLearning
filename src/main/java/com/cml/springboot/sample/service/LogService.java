package com.cml.springboot.sample.service;

import com.cml.springboot.sample.bean.LogBean;

public interface LogService {
	void insertLog(LogBean logbean);

	void insertLogReadOnly(LogBean logbean);
}
