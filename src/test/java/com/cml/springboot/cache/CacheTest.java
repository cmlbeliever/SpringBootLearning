package com.cml.springboot.cache;

import java.io.IOException;

import org.junit.Test;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;

public class CacheTest {
	@Test
	public void testCache() throws Exception, IOException {
		ResourcePatternResolver patternResolver = new PathMatchingResourcePatternResolver();

		CacheManager cacheManager = CacheManager
				.newInstance(patternResolver.getResource("classpath:cache/ehcache.xml").getInputStream());

//		cacheManager.addCache("userCache");

		Cache cache = cacheManager.getCache("demo");

		cache.put(new Element("mine", "menglin.chen"));
		
		System.out.println(cacheManager.cacheExists("demo"));
		
		cacheManager.shutdown();

		System.out.println(1);
	}
}
