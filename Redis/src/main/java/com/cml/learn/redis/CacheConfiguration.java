package com.cml.learn.redis;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.cache.concurrent.ConcurrentMapCache;
import org.springframework.cache.support.SimpleCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CacheConfiguration {

	@Bean
	public CacheManager cacheManager() {
		SimpleCacheManager manager = new SimpleCacheManager();
		ConcurrentMapCache c = new ConcurrentMapCache("name");
		Collection<Cache> caches = new ArrayList<>();
		caches.add(c);
		manager.setCaches(caches);
		return manager;
	}
}
