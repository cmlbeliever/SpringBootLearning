package com.cml.springboot.sample.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cml.springboot.sample.bean.LogBean;
import com.cml.springboot.sample.db.LogMapper;
import com.cml.springboot.sample.service.LogService;

@Service("logServiceImpl")
@Transactional
public class LogServiceImpl implements LogService {

	@Autowired
	private LogMapper logMapper;

	@Override
	public Integer insertLog(LogBean logbean) {
		return logMapper.insertLog(logbean);
	}

	@Transactional(readOnly = true)
	@Override
	public Integer insertLogReadOnly(LogBean logbean) {
		return logMapper.insertLog(logbean);
	}
}
