package com.cml.learn.starter.framework.factorybean;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 使用jdk自带的动态代理方式处理
 * 
 * @author cml
 *
 * @param <T>
 */
public class MyLogFactoryBean<T> extends AbstractMyLogFactoryBean<T> {

	@SuppressWarnings("unchecked")
	@Override
	public void afterPropertiesSet() throws Exception {
		T target = (T) Proxy.newProxyInstance(getClass().getClassLoader(), new Class[] { getMapperInterface() }, new InvocationHandler() {

			@Override
			public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
				return "JDK:"+getLogSupport().invoke(method, args);
			}
		});
		setProxyTarget(target);
	}

}
