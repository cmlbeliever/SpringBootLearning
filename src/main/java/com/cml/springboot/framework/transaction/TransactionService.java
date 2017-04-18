package com.cml.springboot.framework.transaction;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.springframework.aop.framework.autoproxy.BeanNameAutoProxyCreator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.interceptor.DefaultTransactionAttribute;
import org.springframework.transaction.interceptor.NameMatchTransactionAttributeSource;
import org.springframework.transaction.interceptor.TransactionProxyFactoryBean;

@Configuration
@EnableTransactionManagement()
public class TransactionService {

	@Resource
	private DataSource dataSource;

	@Bean(name = "txManager")
	public PlatformTransactionManager txManager() {
		return new DataSourceTransactionManager(dataSource);
	}

//	@Bean
	public BeanNameAutoProxyCreator proxyTransaction(PlatformTransactionManager tx) {

		DefaultTransactionAttribute attribute = new DefaultTransactionAttribute();
		attribute.setPropagationBehavior(Propagation.REQUIRED.value());
		attribute.rollbackOn(new Exception());
		attribute.setReadOnly(true);

		// <tx:method name="*" rollback-for="java.lang.Throwable" />
		NameMatchTransactionAttributeSource source = new NameMatchTransactionAttributeSource();
		source.addTransactionalMethod("update*", attribute);
		
		BeanNameAutoProxyCreator proxy=new BeanNameAutoProxyCreator();
		proxy.setInterceptorNames("");
		proxy.setBeanNames("*");
		
		//DefaultAdvisorAutoProxyCreator

//		TransactionProxyFactoryBean proxy = new TransactionProxyFactoryBean();
//		proxy.setPointcut(new StaticMethodMatcherPointcutAdvisor() {
//
//			@Override
//			public boolean matches(Method method, Class<?> targetClass) {
//				System.out.println("=>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>" + targetClass);
//				return true;
//			}
//		});
//		proxy.setTransactionAttributeSource(source);
//		proxy.setTransactionManager(tx);
		return proxy;
	}

	// @Bean
	// public RegexpMethodPointcutAdvisor
	// pointTransaction(PlatformTransactionManager tx) {
	//
	// TransactionInterceptor interceptor = new TransactionInterceptor();
	// interceptor.setTransactionManager(tx);
	//
	// DefaultTransactionAttribute attribute = new
	// DefaultTransactionAttribute();
	// attribute.setPropagationBehavior(Propagation.REQUIRED.value());
	// attribute.rollbackOn(new Exception());
	// attribute.setReadOnly(true);
	//
	// // <tx:method name="*" rollback-for="java.lang.Throwable" />
	// NameMatchTransactionAttributeSource source = new
	// NameMatchTransactionAttributeSource();
	// source.addTransactionalMethod("update*", attribute);
	//
	// interceptor.setTransactionAttributeSources(new
	// TransactionAttributeSource[] { source });
	//
	// RegexpMethodPointcutAdvisor advisor = new RegexpMethodPointcutAdvisor();
	// // advisor.setPatterns("*set", "update*");
	// // advisor.setPattern("execution(* *..service..*Service.*(..))");
	// advisor.setPattern(".*service\\..*Service.*");
	// advisor.setAdvice(interceptor);
	// return advisor;
	//
	// }

}
