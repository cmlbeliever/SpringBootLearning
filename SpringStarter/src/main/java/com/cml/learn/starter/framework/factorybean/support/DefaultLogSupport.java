package com.cml.learn.starter.framework.factorybean.support;

import java.lang.reflect.Method;

import com.cml.learn.starter.framework.MyLog;

public class DefaultLogSupport implements LogSupport {
	public Object invoke(Method method, Object[] args) {

		MyLog myLog = method.getAnnotation(MyLog.class);

		// 没有数据返回
		if (null == myLog) {
			return null;
		}

		String log = myLog.log();

		if (null != args && args.length == 1) {
			log += ":" + args[0];
		}

		System.out.println(log);

		if (method.getReturnType() == String.class || method.getReturnType() == Object.class) {
			return log;
		}

		return null;

	}
}
