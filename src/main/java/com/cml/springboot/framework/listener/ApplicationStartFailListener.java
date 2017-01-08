package com.cml.springboot.framework.listener;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.boot.context.event.ApplicationFailedEvent;
import org.springframework.context.ApplicationListener;

/**
 * application启动失败监听，记得在BootApplication上注册，或者在 META-INF/spring.factories上注册。
 * 可以在此类上添加邮件功能，提示开发者容器启动失败。
 * 
 * @author admin
 *
 */
public class ApplicationStartFailListener implements ApplicationListener<ApplicationFailedEvent> {

	protected static Log log = LogFactory.getLog(ApplicationStartFailListener.class);

	@Override
	public void onApplicationEvent(ApplicationFailedEvent fail) {
		log.error("======================application start fail===========================================");
		log.error(fail.getException());
		log.error("======================application start fail===========================================");
	}

}
