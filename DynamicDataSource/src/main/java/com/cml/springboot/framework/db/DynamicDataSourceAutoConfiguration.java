package com.cml.springboot.framework.db;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.sql.DataSource;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeansException;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;
import org.springframework.stereotype.Component;

/**
 * 动态数据源自动处理 TransactionProxyFactoryBean
 * 
 * @author cml
 *
 */
public class DynamicDataSourceAutoConfiguration {

	@Component("dynamicDataSource")
	@Primary
	@ConfigurationProperties(prefix = "dynamicDatasource")
	public static class DynamicDataSource extends AbstractRoutingDataSource implements ApplicationContextAware {

		public static final Map<String, String> DATASOURCE_STRATEGY = new HashMap<>();

		private Map<String, String> strategy = new HashMap<>();
		private ApplicationContext applicationContext;
		private String defaultDataSource;

		@Override
		protected Object determineCurrentLookupKey() {
			return DynamicDataSourceHolder.getDataSource();
		}

		@Override
		protected Object resolveSpecifiedLookupKey(Object lookupKey) {
			return super.resolveSpecifiedLookupKey(lookupKey);
		}

		@Override
		public void afterPropertiesSet() {
			Map<String, DataSource> dataSources = applicationContext.getBeansOfType(DataSource.class);
			if (dataSources.size() == 0) {
				throw new IllegalStateException("Datasource can not found!!!");
			}

			// exclude current datasource
			Map<Object, Object> targetDataSource = excludeCurrentDataSource(dataSources);
			setTargetDataSources(targetDataSource);

			// 多数据源方法设置
			Iterator<String> it = strategy.keySet().iterator();
			while (it.hasNext()) {
				String key = it.next();
				String[] values = strategy.get(key).split(",");
				for (String v : values) {
					if (StringUtils.isNotBlank(v)) {
						DATASOURCE_STRATEGY.put(v, key);
					}
				}
			}

			// 默认数据源设置
			setDefaultTargetDataSource(getDefaultDataSource());

			super.afterPropertiesSet();
		}

		/***
		 * exclude current Datasource
		 * 
		 * @param dataSources
		 * @return
		 */
		private Map<Object, Object> excludeCurrentDataSource(Map<String, DataSource> dataSources) {
			Map<Object, Object> targetDataSource = new HashMap<>();
			Iterator<String> keys = dataSources.keySet().iterator();
			while (keys.hasNext()) {
				String key = keys.next();
				if (!(dataSources.get(key) instanceof DynamicDataSource)) {
					targetDataSource.put(key, dataSources.get(key));
				}
			}
			return targetDataSource;
		}

		@Override
		public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
			this.applicationContext = applicationContext;
		}

		public Map<String, String> getStrategy() {
			return strategy;
		}

		public void setStrategy(Map<String, String> strategy) {
			this.strategy = strategy;
		}

		public String getDefaultDataSource() {
			return defaultDataSource;
		}

		public void setDefaultDataSource(String defaultDataSource) {
			this.defaultDataSource = defaultDataSource;
		}

	}

}
