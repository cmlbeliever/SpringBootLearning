package com.cml.springboot.sample.service;

public interface MailService {
	public void sendMail(String to,String subject, String msg) throws Exception;
}
