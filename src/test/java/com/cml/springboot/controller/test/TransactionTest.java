package com.cml.springboot.controller.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.cml.springboot.BootApplication;
import com.cml.springboot.sample.service.TestService;

import junit.framework.Assert;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = { BootApplication.class })
// @AutoConfigureMockMvc
public class TransactionTest {
	@Autowired
	TestService testService;

	/**
	 * 测试在只读事务中执行插入操作(抛出异常)
	 */
	@Test
	public void testReadonlyTransaction() {
		try {
			testService.getTest();
		} catch (Exception e) {
			System.out.println("只读事务添加成功");
			e.printStackTrace();
			return;
		}
		Assert.fail();
	}

	/**
	 * 测试在读写事务中执行写操作
	 */
	@Test
	public void testInsert() {
		testService.insertSingleTest();
	}

	/**
	 * 测试在读写事务中回滚功能
	 */
	@Test
	public void testInsertRollback() {
		testService.insertTest();
	}
}
