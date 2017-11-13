package com.cml.learn.starter.service;

import com.cml.learn.starter.framework.MyLog;
import com.cml.learn.starter.framework.MyLogScanner;

@MyLogScanner
public interface MyLogService {

	@MyLog(log = "logStart")
	public void logStart(String log);

	@MyLog(log = "logEnd")
	public String logEnd(String log);

}
