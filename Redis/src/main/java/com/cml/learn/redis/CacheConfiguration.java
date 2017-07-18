package com.cml.learn.redis;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;

import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCache;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.cache.support.SimpleCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.core.RedisTemplate;

@EnableCaching
@Configuration
public class CacheConfiguration {

	@Bean
	public KeyGenerator wiselyKeyGenerator() {
		return new KeyGenerator() {
			@Override
			public Object generate(Object target, Method method, Object... params) {
				StringBuilder sb = new StringBuilder();
				sb.append(target.getClass().getName());
				sb.append(method.getName());
				for (Object obj : params) {
					sb.append(obj.toString());
				}
				System.out.println("=======================" + sb.toString() + "================================================");
				return sb.toString();
			}
		};

	}

	@Bean
	public CacheManager cacheManager(@SuppressWarnings("rawtypes") RedisTemplate redisTemplate) {
		System.out.println("=======================cacheManager================================================");
		return new RedisCacheManager(redisTemplate);
	}

	// @Bean
	// public RedisTemplate<String, String> redisTemplate(RedisConnectionFactory
	// factory) {
	// StringRedisTemplate template = new StringRedisTemplate(factory);
	// Jackson2JsonRedisSerializer jackson2JsonRedisSerializer = new
	// Jackson2JsonRedisSerializer(Object.class);
	// ObjectMapper om = new ObjectMapper();
	// om.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
	// om.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
	// jackson2JsonRedisSerializer.setObjectMapper(om);
	// template.setValueSerializer(jackson2JsonRedisSerializer);
	// template.afterPropertiesSet();
	// return template;
	// }

	public CacheManager cacheManager() {
		SimpleCacheManager manager = new SimpleCacheManager();
		ConcurrentMapCache c = new ConcurrentMapCache("name");
		Collection<Cache> caches = new ArrayList<>();
		caches.add(c);
		manager.setCaches(caches);
		return manager;
	}
}
