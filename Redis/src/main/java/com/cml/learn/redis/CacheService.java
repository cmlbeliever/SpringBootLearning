package com.cml.learn.redis;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

@Component
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

	public String getName() {
		return (String) template.boundValueOps("name").get();
	}

}
