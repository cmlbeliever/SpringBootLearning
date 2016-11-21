package com.cml.springboot.sample.db.rw;

import com.cml.springboot.sample.bean.User;

public interface UserMapper {
	Integer updateToken(User loginUser);
}
