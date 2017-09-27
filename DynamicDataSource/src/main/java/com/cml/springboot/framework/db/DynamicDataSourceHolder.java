package com.cml.springboot.framework.db;

import javax.sql.DataSource;

/**
 * 动态数据源处理
 * 
 * @author cml
 *
 */
public class DynamicDataSourceHolder {
	private static ThreadLocal<DataSource> holderDataSource = new ThreadLocal<>();

	public static void setDataSource(DataSource dataSource) {
		holderDataSource.set(dataSource);
	}

	public static DataSource getDataSource() {
		return holderDataSource.get();
	}
	
	public static void clear() {
		holderDataSource.remove();
	}
}
