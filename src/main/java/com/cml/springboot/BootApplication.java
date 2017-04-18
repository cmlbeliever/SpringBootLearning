package com.cml.springboot;

import org.springframework.aop.support.RegexpMethodPointcutAdvisor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.interceptor.DefaultTransactionAttribute;
import org.springframework.transaction.interceptor.NameMatchTransactionAttributeSource;
import org.springframework.transaction.interceptor.TransactionAttributeSource;
import org.springframework.transaction.interceptor.TransactionInterceptor;

@Configuration
@EnableAutoConfiguration(exclude = { DataSourceAutoConfiguration.class })
@ComponentScan()
@EnableAsync
@PropertySources({ @PropertySource("classpath:config/application-jdbc.properties") })
public class BootApplication {

	// @Bean
	// public PropertyPlaceholderConfigurer placeHolder() {
	//
	// PropertyPlaceholderConfigurer configure = new
	// PropertyPlaceholderConfigurer();
	// configure.setLocations(null);
	//
	// return configure;
	// }

	public static void main(String[] args) throws Exception {
		SpringApplication.run(BootApplication.class, args);
//
//		TransactionInterceptor interceptor = new TransactionInterceptor();
//		interceptor.setTransactionManager(null);
//
//		DefaultTransactionAttribute attribute = new DefaultTransactionAttribute();
//		attribute.setPropagationBehavior(Propagation.REQUIRED.value());
//		attribute.rollbackOn(new Exception());
//
//		// <tx:method name="*" rollback-for="java.lang.Throwable" />
//		NameMatchTransactionAttributeSource source = new NameMatchTransactionAttributeSource();
//		source.addTransactionalMethod("update*", attribute);
//
//		interceptor.setTransactionAttributeSources(new TransactionAttributeSource[] { source });
//
//		RegexpMethodPointcutAdvisor advisor = new RegexpMethodPointcutAdvisor();
//		// advisor.setPatterns("*set", "update*");
//		advisor.setPattern("execution(* *..service..*Service.*(..))");
//		advisor.setAdvice(interceptor);

		// <aop:config> 配置
		// BeanFactoryTransactionAttributeSourceAdvisor advisor = new
		// BeanFactoryTransactionAttributeSourceAdvisor();
		// Pointcut pointCut = new StaticMethodMatcherPointcutAdvisor() {
		// @Override
		// public boolean matches(Method method, Class<?> targetClass) {
		// return false;
		// }
		// };

		// DefaultAopProxyFactory proxy=new DefaultAopProxyFactory();

	}
}
