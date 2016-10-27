package com.cml.springboot.sample.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
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
	@Async
	public void insertLog(LogBean logbean) {
		System.out.println("LogServiceImpl.insertLog threadId:" + Thread.currentThread().getId() + ","
				+ Thread.currentThread().getName());
		logMapper.insertLog(logbean);
	}

	@Transactional(readOnly = true)
	@Override
	public void insertLogReadOnly(LogBean logbean) {
		logMapper.insertLog(logbean);
	}
}
