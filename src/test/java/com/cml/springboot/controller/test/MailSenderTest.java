package com.cml.springboot.controller.test;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.cml.springboot.BootApplication;
import com.cml.springboot.sample.service.impl.MailServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = BootApplication.class)
@AutoConfigureMockMvc
public class MailSenderTest {

	@Resource(name = "mailServiceImpl")
	private MailServiceImpl mailServiceImpl;

	@Test
	public void getHello() throws Exception {
		System.out.println("=================================sendMail start==========================");
		try {
			mailServiceImpl.sendMail("xxxxx@qq.com","我是邮件", "12222222222222222222222222");
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("=================================sendMail end==========================");
	}
}