package com.cml.springboot.sample.service;

import java.sql.SQLException;

import com.cml.springboot.sample.bean.User;

public interface UserService {
	User findUserByToken(String token) throws SQLException;
}
