package com.cml.springboot.sample.service.impl;

import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cml.springboot.sample.bean.LogBean;
import com.cml.springboot.sample.db.LogMapper;
import com.cml.springboot.sample.service.TestService;

@Service
public class TestServiceImpl implements TestService {

	@Autowired
	private LogMapper logMapper;

	@Override
	public void testTransaction() {
		LogBean logbean = new LogBean();
		logbean.setApiUrl("test url");
		logbean.setCallDayStr("20161111");
		logbean.setParameters("param:");
		logbean.setReturnStatusCode(200);
		logbean.setReturns("returns");
		logbean.setCreateDate(new DateTime());
		logMapper.insertLog(logbean);
		System.out.println("LogServiceImpl.insertLog threadId:" + Thread.currentThread().getId() + "," + Thread.currentThread().getName());

	}

	@Override
	public void getTest() {
		LogBean logbean = new LogBean();
		logbean.setApiUrl("test url");
		logbean.setCallDayStr("20161111");
		logbean.setParameters("param:");
		logbean.setReturnStatusCode(200);
		logbean.setReturns("returns");
		logbean.setCreateDate(new DateTime());
		logMapper.insertLog(logbean);
		System.out.println("LogServiceImpl.insertLog threadId:" + Thread.currentThread().getId() + "," + Thread.currentThread().getName());
	}

	@Override
	public void setTest() {
		LogBean logbean = new LogBean();
		logbean.setApiUrl("test url");
		logbean.setCallDayStr("20161111");
		logbean.setParameters("param:");
		logbean.setReturnStatusCode(200);
		logbean.setReturns("returns");
		logbean.setCreateDate(new DateTime());
		logMapper.insertLog(logbean);
		System.out.println("LogServiceImpl.insertLog threadId:" + Thread.currentThread().getId() + "," + Thread.currentThread().getName());
	}

	@Override
	public int insertTest() {
		LogBean logbean = new LogBean();
		logbean.setApiUrl("回滚的url");
		logbean.setCallDayStr("20161111");
		logbean.setParameters("param:");
		logbean.setReturnStatusCode(200);
		logbean.setReturns("returns");
		logbean.setCreateDate(new DateTime());
		logMapper.insertLog(logbean);

		logbean = new LogBean();
		logbean.setApiUrl("回滚的url2");
		logbean.setCallDayStr("20161111");
		logbean.setParameters("param:");
		logbean.setReturnStatusCode(200);
		logbean.setReturns("returns");
		logbean.setCreateDate(new DateTime());

		logMapper.insertLog(logbean);

		throw new RuntimeException("主动回滚");

		// return logMapper.insertLog(logbean);
	}

	@Override
	public int insertSingleTest() {
		LogBean logbean = new LogBean();
		logbean.setApiUrl("test url");
		logbean.setCallDayStr("20161111");
		logbean.setParameters("param:");
		logbean.setReturnStatusCode(200);
		logbean.setReturns("returns");
		logbean.setCreateDate(new DateTime());
		return logMapper.insertLog(logbean);
	}

}
