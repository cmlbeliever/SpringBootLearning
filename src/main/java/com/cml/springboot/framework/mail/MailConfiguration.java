package com.cml.springboot.framework.mail;

import java.util.Properties;

import org.springframework.boot.autoconfigure.mail.MailProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.mail.MailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

@Configuration
@Import(MailProperties.class)
public class MailConfiguration {
	
	@Bean(name="mailSender")
	public MailSender mailSender(MailProperties propterties) {
		System.out.println("===>" + propterties);

		JavaMailSenderImpl mailSender = new JavaMailSenderImpl();

		mailSender.setUsername(propterties.getUsername());
		mailSender.setPassword(propterties.getPassword());

		mailSender.setHost(propterties.getHost());
		mailSender.setDefaultEncoding(propterties.getDefaultEncoding().name());

		Properties prop = new Properties();
		prop.putAll(propterties.getProperties());

		System.out.println(propterties.getProperties());

		return mailSender;
	}

}
