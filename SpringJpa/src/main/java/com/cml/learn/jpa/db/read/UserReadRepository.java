package com.cml.learn.jpa.db.read;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.cml.learn.jpa.db.bean.User;

/**
 * 用户信息相关
 * 
 * @author cml
 *
 */
public interface UserReadRepository extends CrudRepository<User, Long> {
	/**
	 * 自定义查询字段，注意这里查询使用的是bean对应的属性字段而不是数据库字段
	 * @param username
	 * @return
	 */
	@Query("select userId from User where username = ?1")
	Long findUserIdByUsername(String username);
}
