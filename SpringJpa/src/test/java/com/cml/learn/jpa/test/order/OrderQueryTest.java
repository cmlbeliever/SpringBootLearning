package com.cml.learn.jpa.test.order;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.cml.learn.jpa.Application;
import com.cml.learn.jpa.db.bean.Order;
import com.cml.learn.jpa.db.read.OrderReadRepository;
import com.cml.learn.jpa.dto.OrderQueryDTO;
import com.cml.learn.jpa.dto.OrderQueryDTO2;
import com.cml.learn.jpa.dto.OrderQueryDTO3;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class OrderQueryTest {

	private Logger log = LoggerFactory.getLogger(OrderQueryTest.class);

	@Autowired
	private OrderReadRepository orderReadRepository;
	
	@Test
	public void tesetReadOrder() {

		log.info("=======================start=======================");
		Order order1 = orderReadRepository.findById(1L);
		log.info("1=======================普通查询=======================" + order1);
		Order cacheOrder = orderReadRepository.findById(1L);
		log.info("1=======================普通缓存查询=======================" + cacheOrder);
		

		OrderQueryDTO order2 = orderReadRepository.findOrderWithUserNameByOrderId(1L, OrderQueryDTO.class);
		log.info("2=====使用接口作为projection===" + order2 + "," + order2.getClass().getName());

		OrderQueryDTO order3 = orderReadRepository.findOrderWithUserNameByOrderId2(1L);
		log.info("3=====使用bean作为projection===" + order3);

		OrderQueryDTO2 order4 = orderReadRepository.findOrderName111ById(1L, OrderQueryDTO2.class);
		log.info("4=====findOrderNameById 跟方法名无关，而是根据返回的bean的字段来的===" + order4.getOrderName());

		OrderQueryDTO2 order5 = orderReadRepository.findOrderName222ById(1L);
		log.info("5=====findOrderNameById 跟方法名无关，而是根据返回的bean的字段来的===" + order5.getOrderName());

		OrderQueryDTO3 order6 = orderReadRepository.findOrderAndUserById(1L);
		log.info("6=====获取用户和订单部分信息===" + order6 + ",username:" + order6.getUser().getUsername() + "," + order6.getUser().getClass());

		OrderQueryDTO3 order7 = orderReadRepository.findOrderAndUser2ById(1L, OrderQueryDTO3.class);
		log.info("7=====获取用户和订单部分信息===" + order7 + ",username:" + order7.getUser().getUsername() + "," + order7.getUser().getClass());

	}
}
