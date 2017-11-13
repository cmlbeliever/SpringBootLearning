package com.cml.learn.starter.framework;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.InitializingBean;

public class MyLogFactoryBean<T> implements FactoryBean<T>, InitializingBean {

	private T myLogSupportBean;
	private Class<T> mapperInterface;

	@Override
	public T getObject() throws Exception {
		return myLogSupportBean;
	}

	@Override
	public Class<T> getObjectType() {
		return mapperInterface;
	}

	public Class<T> getMapperInterface() {
		return mapperInterface;
	}

	public void setMapperInterface(Class<T> mapperInterface) {
		this.mapperInterface = mapperInterface;
	}

	@Override
	public boolean isSingleton() {
		return true;
	}

	@SuppressWarnings("unchecked")
	@Override
	public void afterPropertiesSet() throws Exception {
		myLogSupportBean = (T) Proxy.newProxyInstance(getClass().getClassLoader(), new Class[] { mapperInterface }, new InvocationHandler() {

			@Override
			public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
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
		});
	}

}
