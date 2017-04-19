package com.cml.springboot.framework.transaction;

import java.util.regex.Pattern;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.springframework.aop.ClassFilter;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.interceptor.DefaultTransactionAttribute;
import org.springframework.transaction.interceptor.NameMatchTransactionAttributeSource;
import org.springframework.transaction.interceptor.TransactionAttributeSource;
import org.springframework.transaction.interceptor.TransactionAttributeSourceAdvisor;
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
	public DefaultAdvisorAutoProxyCreator advisorAutoProxyCreator() {
		return new DefaultAdvisorAutoProxyCreator();
	}

	/**
	 * 代码完成spring事务管理
	 * 
	 * @param tx
	 * @return
	 */
	@Bean
	public TransactionAttributeSourceAdvisor transactionAdvisor(PlatformTransactionManager tx) {
		TransactionAttributeSourceAdvisor advisor = new TransactionAttributeSourceAdvisor();
		TransactionInterceptor interceptor = new TransactionInterceptor();
		interceptor.setTransactionManager(tx);

		// 设置只读事务策略
		DefaultTransactionAttribute readOnlyAttribute = new DefaultTransactionAttribute();
		readOnlyAttribute.setPropagationBehavior(Propagation.REQUIRED.value());
		readOnlyAttribute.setReadOnly(true);

		// 设置回滚事务策略
		DefaultTransactionAttribute transactionAttribute = new DefaultTransactionAttribute();
		transactionAttribute.setPropagationBehavior(Propagation.REQUIRED.value());
		transactionAttribute.rollbackOn(new Exception());

		// <tx:method name="*" rollback-for="java.lang.Throwable" />
		NameMatchTransactionAttributeSource source = new NameMatchTransactionAttributeSource();
		source.addTransactionalMethod("test*", readOnlyAttribute);
		source.addTransactionalMethod("get*", readOnlyAttribute);
		source.addTransactionalMethod("update*", transactionAttribute);
		source.addTransactionalMethod("set*", transactionAttribute);
		source.addTransactionalMethod("insert*", transactionAttribute);

		// 设置pointcut
		interceptor.setTransactionAttributeSources(new TransactionAttributeSource[] { source });
		advisor.setTransactionInterceptor(interceptor);
		advisor.setClassFilter(new ClassFilter() {
			private Pattern pattern = Pattern.compile(".*service\\.impl.*");

			@Override
			public boolean matches(Class<?> clazz) {
				// 设置只读的service方法
				return pattern.matcher(clazz.getName()).matches();
			}
		});

		return advisor;
	}

	// @Bean
	// public BeanNameAutoProxyCreator
	// proxyTransaction(PlatformTransactionManager tx) {
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
	// BeanNameAutoProxyCreator proxy=new BeanNameAutoProxyCreator();
	// proxy.setInterceptorNames("");
	// proxy.setBeanNames("*");
	//
	// //DefaultAdvisorAutoProxyCreator
	//
	//// TransactionProxyFactoryBean proxy = new TransactionProxyFactoryBean();
	//// proxy.setPointcut(new StaticMethodMatcherPointcutAdvisor() {
	////
	//// @Override
	//// public boolean matches(Method method, Class<?> targetClass) {
	//// System.out.println("=>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>"
	// + targetClass);
	//// return true;
	//// }
	//// });
	//// proxy.setTransactionAttributeSource(source);
	//// proxy.setTransactionManager(tx);
	// return proxy;
	// }

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
