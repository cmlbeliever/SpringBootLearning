package com.cml.springboot.sample.db;

import java.sql.SQLException;

import com.cml.springboot.sample.bean.User;

public interface UserMapper {
	User getUserByToken(String token) throws SQLException;

	User getUser(User user);

	Integer updateToken(User loginUser);
}
