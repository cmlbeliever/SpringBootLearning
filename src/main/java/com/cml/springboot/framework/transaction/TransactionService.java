package com.cml.springboot.framework.transaction;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.springframework.aop.support.RegexpMethodPointcutAdvisor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.interceptor.DefaultTransactionAttribute;
import org.springframework.transaction.interceptor.NameMatchTransactionAttributeSource;
import org.springframework.transaction.interceptor.TransactionAttributeSource;
import org.springframework.transaction.interceptor.TransactionInterceptor;

@Configuration
@EnableTransactionManagement()
public class TransactionService {

	@Resource
	private DataSource dataSource;

	@Bean(name = "txManager")
	public PlatformTransactionManager txManager() {
		return new DataSourceTransactionManager(dataSource);
	}

	@Bean
	public RegexpMethodPointcutAdvisor pointTransaction(PlatformTransactionManager tx) {
		TransactionInterceptor interceptor = new TransactionInterceptor();
		interceptor.setTransactionManager(tx);

		DefaultTransactionAttribute attribute = new DefaultTransactionAttribute();
		attribute.setPropagationBehavior(Propagation.REQUIRED.value());
		attribute.rollbackOn(new Exception());
		attribute.setReadOnly(true);

		// <tx:method name="*" rollback-for="java.lang.Throwable" />
		NameMatchTransactionAttributeSource source = new NameMatchTransactionAttributeSource();
		source.addTransactionalMethod("update*", attribute);

		interceptor.setTransactionAttributeSources(new TransactionAttributeSource[] { source });

		RegexpMethodPointcutAdvisor advisor = new RegexpMethodPointcutAdvisor();
		// advisor.setPatterns("*set", "update*");
		// advisor.setPattern("execution(* *..service..*Service.*(..))");
		advisor.setPattern(".*service\\..*Service.*");
		advisor.setAdvice(interceptor);
		return advisor;

	}

}
