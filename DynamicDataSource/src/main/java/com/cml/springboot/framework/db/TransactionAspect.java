package com.cml.springboot.framework.db;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

import com.cml.springboot.framework.db.DynamicDataSourceAutoConfiguration.DynamicDataSource;

/**
 * 事务自动代理
 * 
 * @author admin
 *
 */
@Aspect
@EnableAspectJAutoProxy
@Component
public class TransactionAspect {

	protected static Log logger = LogFactory.getLog(TransactionAspect.class);

	@Pointcut("execution(* com.cml.springboot.sample.service.impl.*.*(..))")
	public void aspect() {
	}

	/**
	 * 配置前置通知,使用在方法aspect()上注册的切入点
	 */
	@Before("aspect()")
	public void before(JoinPoint point) {
		String className = point.getTarget().getClass().getName();
		String method = point.getSignature().getName();
		logger.info(className + "." + method + "(" + StringUtils.join(point.getArgs(), ",") + ")");
		try {
			// 根据方法获取对应的数据源
			for (String key : DynamicDataSource.DATASOURCE_STRATEGY.keySet()) {
				if (StringUtils.startsWith(method, key)) {
					DynamicDataSourceHolder.setDataSource(DynamicDataSource.DATASOURCE_STRATEGY.get(key));
					logger.info("find datasource ==>" + key + ",datasource:" + DynamicDataSourceHolder.getDataSource());
					break;
				}
			}
		} catch (Exception e) {
			logger.error(e.toString());
			// DynamicDataSourceHolder.setDataSource("write");
		}
	}

	@After("aspect()")
	public void after(JoinPoint point) {
		DynamicDataSourceHolder.clear();
	}
}
