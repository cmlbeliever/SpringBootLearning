package com.cml.springboot.framework.db;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;
import org.springframework.stereotype.Component;

/**
 * 动态数据源处理
 * 
 * @author admin
 *
 */
public class DynamicDataSource extends AbstractRoutingDataSource {

	@Override
	protected Object determineCurrentLookupKey() {
		return null;
	}

	@Override
	protected Object resolveSpecifiedLookupKey(Object lookupKey) {
		return super.resolveSpecifiedLookupKey(lookupKey);
	}
}
