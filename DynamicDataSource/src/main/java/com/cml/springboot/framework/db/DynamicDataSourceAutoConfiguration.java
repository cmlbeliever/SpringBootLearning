package com.cml.springboot.framework.db;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;
import org.springframework.stereotype.Component;

/**
 * 动态数据源自动处理
 * TransactionProxyFactoryBean
 * @author cml
 *
 */
public class DynamicDataSourceAutoConfiguration {

	@Component("dynamicDataSource")
	@Primary
	public class DynamicDataSource extends AbstractRoutingDataSource implements ApplicationContextAware {

		private ApplicationContext applicationContext;

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
	}

}
