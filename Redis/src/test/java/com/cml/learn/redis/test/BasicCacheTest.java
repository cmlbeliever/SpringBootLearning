package com.cml.learn.redis.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.cml.learn.redis.Application;
import com.cml.learn.redis.CacheService;

/**
 * 缓存删除与测试
 * @author cml
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class BasicCacheTest {
	@Autowired
	private CacheService service;

	@Test
	public void testBasicCache() {
		System.out.println("update:" + service.updateUsername("username"));
		System.out.println("select:" + service.getName4());
		service.deleteCache();
		System.out.println("cache deleted!!!");
		System.out.println("select:" + service.getName4());
	
	}
}
