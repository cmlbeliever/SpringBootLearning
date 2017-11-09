package com.cml.learn.jpa.db.write;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import com.cml.learn.jpa.db.bean.User;

/**
 * 用户信息相关
 * 
 * @author cml
 *
 */
public interface UserRepository extends CrudRepository<User, Long> {

	/**
	 * 获取根据昵称升序的第一条数据
	 * 
	 * @return
	 */
	User findFirstByOrderByNicknameAsc();

	Page<User> findAll(Pageable page);

	<T> T findByUserId(Integer id, Class<T> result);
}
