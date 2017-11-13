package com.cml.learn.jpa.db.read;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.cml.learn.jpa.db.bean.Order;
import com.cml.learn.jpa.dto.OrderQueryDTO;
import com.cml.learn.jpa.dto.OrderQueryDTO2;
import com.cml.learn.jpa.dto.OrderQueryDTO3;

public interface OrderReadRepository extends CrudRepository<Order, Long> {

	@Query("select  orderName , user.userId ,user.username  from Order where id = ?1")
	<T> T findOrderWithUserNameByOrderId(Long id, Class<T> target);

	/**
	 * 注意使用bean作为projection时需要手动设置字段别名(加AS)
	 * 
	 * @param id
	 * @return
	 */
	@Query("select  orderName as orderName, user.userId as userId,user.username as username  from Order where id = ?1")
	OrderQueryDTO findOrderWithUserNameByOrderId2(Long id);

	<T> T findOrderNameWithAnyTypeById(Long id, Class<T> target);

	OrderQueryDTO2 findOrderNameById(Long id);

	/**
	 * 获取用户和订单部分信息
	 * 
	 * @param id
	 * @return
	 */
	OrderQueryDTO3 findOrderAndUserById(Long id);

	<T> T findOrderAndUserWithAnyTypeById(Long id, Class<T> t);

	@Cacheable(value = "simpleCache",key="'users' + #root.args[0]")
	Order findById(Long id);
}
