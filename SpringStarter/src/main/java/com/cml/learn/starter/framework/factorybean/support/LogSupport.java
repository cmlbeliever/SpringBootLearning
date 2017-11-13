package com.cml.learn.starter.framework.factorybean.support;

import java.lang.reflect.Method;

public interface LogSupport {
	Object invoke(Method method, Object[] args);
}
