package com.cml.learn.starter.framework.factorybean;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.InitializingBean;

import com.cml.learn.starter.framework.factorybean.support.DefaultLogSupport;
import com.cml.learn.starter.framework.factorybean.support.LogSupport;

public abstract class AbstractMyLogFactoryBean<T> implements FactoryBean<T>, InitializingBean {

	private T proxyTarget;
	private Class<T> mapperInterface;
	private LogSupport logSupport = new DefaultLogSupport();

	@Override
	public T getObject() throws Exception {
		return proxyTarget;
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

	public LogSupport getLogSupport() {
		return logSupport;
	}

	public void setProxyTarget(T proxyTarget) {
		this.proxyTarget = proxyTarget;
	}

	public void setLogSupport(DefaultLogSupport logSupport) {
		this.logSupport = logSupport;
	}

}
