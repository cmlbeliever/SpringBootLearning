package com.cml.learn.starter.framework.factorybean;

import java.lang.reflect.Method;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

/**
 * 使用Cglib的方式实现代理
 * 
 * @author cml
 *
 * @param <T>
 */
public class MyLogFactoryBeanInCglib<T> extends AbstractMyLogFactoryBean<T> implements MethodInterceptor {

	@SuppressWarnings("unchecked")
	@Override
	public void afterPropertiesSet() throws Exception {
		Enhancer enhancer = new Enhancer();
		enhancer.setCallback(this);
		enhancer.setSuperclass(getMapperInterface());
		setProxyTarget((T) enhancer.create());
	}

	@Override
	public Object intercept(Object obj, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
		return "CGLIB:" + getLogSupport().invoke(method, args);
	}

}
