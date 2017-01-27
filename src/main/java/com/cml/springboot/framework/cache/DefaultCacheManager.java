package com.cml.springboot.framework.cache;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.cache.ehcache.EhCacheManagerFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;

@Configuration
@EnableCaching
public class DefaultCacheManager {

	@Value(value = "classpath:cache/ehcache.xml")
	Resource ehcacheResource;

	@Bean
	public EhCacheCacheManager ehCacheManager(EhCacheManagerFactoryBean bean) {
		EhCacheCacheManager cacheCacheManager = new EhCacheCacheManager(bean.getObject());
		return cacheCacheManager;
	}

	@Bean
	public EhCacheManagerFactoryBean ehCacheManagerFactoryBean() throws Exception {
		EhCacheManagerFactoryBean ehCacheManagerFactoryBean = new EhCacheManagerFactoryBean();
		ehCacheManagerFactoryBean.setConfigLocation(ehcacheResource);
		ehCacheManagerFactoryBean.setShared(true);
		return ehCacheManagerFactoryBean;
	}
}
