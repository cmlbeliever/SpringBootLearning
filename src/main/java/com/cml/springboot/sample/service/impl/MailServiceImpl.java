package com.cml.springboot.sample.service.impl;

import javax.annotation.Resource;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.mail.MailProperties;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.cml.springboot.sample.service.MailService;

@Service("mailServiceImpl")
public class MailServiceImpl implements MailService {

	@Resource
	private JavaMailSenderImpl mailSender;

	@Autowired
	private MailProperties mailProperties;

	@Override
	public void sendMail(String to, String subject, String msg) throws Exception {

		MimeMessage mimeMessage = mailSender.createMimeMessage();
		MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage, true, "UTF-8");
		messageHelper.setFrom(mailProperties.getUsername());
		messageHelper.setSubject(subject);
		messageHelper.setTo(to);
		messageHelper.setText(msg, false); // html: true

		mailSender.send(mimeMessage);
	}

}
