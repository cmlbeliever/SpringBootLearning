package com.cml.springboot.sample.service;

import java.sql.SQLException;

import org.springframework.cache.annotation.CacheConfig;

import com.cml.springboot.sample.bean.User;

@CacheConfig(cacheNames="people")
public interface UserService {
	User findUserByToken(String token) throws SQLException;

	User login(User user) throws Exception;
}
