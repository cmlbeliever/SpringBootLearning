package com.cml.springboot.sample.db.r;

import java.sql.SQLException;

import com.cml.springboot.sample.bean.User;

public interface ReadOnlyUserMapper {
	User getUserByToken(String token) throws SQLException;

	User getUser(User user);
}
