package com.cml.learn.redis;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

@Component
@CacheConfig(cacheNames = "name")
public class CacheService {
	@Autowired
	private StringRedisTemplate template;

	public void setList(String... v) {
		template.opsForList().rightPushAll("list", v);
	}

	public List<String> getList() {
		return template.boundListOps("list").range(0, template.boundListOps("list").size());
	}

	public void setName(String name) {
		template.boundValueOps("name").set(name);
	}

	/**
	 * 高并发下缓存击穿问题解决
	 * 
	 * @param username
	 * @return
	 */
	@Cacheable(key = "#username")
	public String getUser(String username) {
		synchronized (username) {

			String oldValue = template.boundValueOps(username).get();
			System.out.println("before oldValue:" + oldValue);
			if (null != oldValue) {
				return oldValue;
			}
			template.boundValueOps(username).set(username);

			System.out.println("after oldValue:" + oldValue);
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		System.out.println("==================getUser load from db===============" + Thread.currentThread().getId());
		return "user:" + username;
	}

	/**
	 * 读取缓存测试
	 * 
	 * @return
	 */
	@Cacheable(key = "'username'")
	public String getName4() {
		System.out.println("==================getName4========================");
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "name3";
	}

	/**
	 * 更新缓存测试
	 * 
	 * @param username
	 * @return
	 */
	@CachePut(key = "'username'")
	public String updateUsername(String username) {
		return username;
	}

	/**
	 * 删除缓存测试
	 */
	@CacheEvict(key = "'username'")
	public void deleteCache() {
		System.out.println("==================deleteCache========================");
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
