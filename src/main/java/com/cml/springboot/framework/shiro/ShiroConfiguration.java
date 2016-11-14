package com.cml.springboot.framework.shiro;

import java.util.ArrayList;
import java.util.List;

import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.remoting.SecureRemoteInvocationExecutor;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.web.filter.DelegatingFilterProxy;

@Configuration
public class ShiroConfiguration {
	@Bean
	public DefaultWebSecurityManager securityManager(UserRealm userRealm) {
		DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
		securityManager.setRealm(userRealm);
		return securityManager;
	}

	@Bean("lifecycleBeanPostProcessor")
	public LifecycleBeanPostProcessor lifecycleBeanPostProcessor() {
		return new LifecycleBeanPostProcessor();
	}

	@Bean()
	@DependsOn("lifecycleBeanPostProcessor")
	public DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator() {
		return new DefaultAdvisorAutoProxyCreator();
	}

	@Bean
	public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(
			DefaultWebSecurityManager securityManager) {
		AuthorizationAttributeSourceAdvisor advisor = new AuthorizationAttributeSourceAdvisor();
		advisor.setSecurityManager(securityManager);
		return advisor;
	}

	/**
	 * Secure Spring remoting: Ensure any Spring Remoting method invocations can
	 * be associated with a Subject for security checks.
	 * 
	 * @return
	 */
	@Bean
	public SecureRemoteInvocationExecutor secureRemoteInvocationExecutor(DefaultWebSecurityManager securityManager) {
		SecureRemoteInvocationExecutor secureRemoteInvocationExecutor = new SecureRemoteInvocationExecutor();
		secureRemoteInvocationExecutor.setSecurityManager(securityManager);
		return secureRemoteInvocationExecutor;
	}

	@Bean("shiroFilterFactoryBean")
	public ShiroFilterFactoryBean shiroFilterFactoryBean(DefaultWebSecurityManager securityManager,
			ShiroConfigProperties properties) {
		ShiroFilterFactoryBean shiroFilter = new ShiroFilterFactoryBean();
		shiroFilter.setSecurityManager(securityManager);
		shiroFilter.setLoginUrl(properties.getLoginUrl());
		shiroFilter.setSuccessUrl(properties.getLoginSuccess());
		shiroFilter.setUnauthorizedUrl(properties.getUnauthorized());
		shiroFilter.setFilterChainDefinitionMap(properties.getFilters());

		return shiroFilter;
	}

	@Bean
	public FilterRegistrationBean shiroFilter() {
		
		FilterRegistrationBean filterBean = new FilterRegistrationBean();

		List<String> urlPatterns = new ArrayList<String>();
		urlPatterns.add("/*");
		filterBean.setUrlPatterns(urlPatterns);

		DelegatingFilterProxy filter = new DelegatingFilterProxy();
		filter.setTargetFilterLifecycle(true);
		filterBean.setFilter(filter);

		return filterBean;
	}

}
