package com.cml.learn.jpa.db;

import org.springframework.data.repository.CrudRepository;

import com.cml.learn.jpa.db.bean.User;

/**
 * 用户信息相关
 * 
 * @author cml
 *
 */
public interface UserRepository extends CrudRepository<User, Integer> {

}
