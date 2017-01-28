package com.cml.springboot.cache3;

import org.ehcache.Cache;
import org.ehcache.CacheManager;
import org.ehcache.config.builders.CacheConfigurationBuilder;
import org.ehcache.config.builders.CacheManagerBuilder;
import org.ehcache.config.builders.ResourcePoolsBuilder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultHandler;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import com.cml.springboot.BootApplication;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = BootApplication.class)
@AutoConfigureMockMvc
public class Ehcache3Test {
	public void testEhcache() {
		CacheManager cacheManager = CacheManagerBuilder.newCacheManagerBuilder()
				.withCache("preConfigured", CacheConfigurationBuilder
						.newCacheConfigurationBuilder(Long.class, String.class, ResourcePoolsBuilder.heap(100)).build())
				.build(true);

		Cache<Long, String> preConfigured = cacheManager.getCache("preConfigured", Long.class, String.class);

		Cache<Long, String> myCache = cacheManager.createCache("myCache", CacheConfigurationBuilder
				.newCacheConfigurationBuilder(Long.class, String.class, ResourcePoolsBuilder.heap(100)).build());

		myCache.put(1L, "da one!");
		String value = myCache.get(1L);

		System.out.println("mycache value is:" + value);

		cacheManager.close();
	}

	@Autowired
	private MockMvc mvc;

	@Test
	public void testCache() throws Exception {
		String req1 = mvc.perform(MockMvcRequestBuilders.get("/cache/C78CE23552BC46328959C8C0AE391886")).andReturn()
				.getResponse().getContentAsString();
		System.out.println(req1);
		System.out.println("=====================read data second==========================");
		req1 = mvc.perform(MockMvcRequestBuilders.get("/cache/C78CE23552BC46328959C8C0AE391886")).andReturn()
				.getResponse().getContentAsString();
		System.out.println(req1);
	}
}
