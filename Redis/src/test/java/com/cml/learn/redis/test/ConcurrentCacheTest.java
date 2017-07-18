package com.cml.learn.redis.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.cml.learn.redis.Application;
import com.cml.learn.redis.CacheService;

/**
 * 高并发下缓存测试
 * 
 * @author cml
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class ConcurrentCacheTest {
	@Autowired
	private CacheService service;

	@Test
	public void testConcurrentCache() throws Exception {
		final int index = 8;
		for (int i = 0; i < 10; i++) {
			new Thread(new Runnable() {

				@Override
				public void run() {
					System.out.println(service.getUser("key" + index));
				}
			}).start();
		}
		Thread.sleep(10000);
	}
}
