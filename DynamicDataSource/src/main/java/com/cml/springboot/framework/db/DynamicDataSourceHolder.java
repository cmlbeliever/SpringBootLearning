package com.cml.springboot.framework.db;

/**
 * 动态数据源处理
 * 
 * @author cml
 *
 */
public class DynamicDataSourceHolder {
	private static ThreadLocal<String> holderDataSource = new ThreadLocal<>();

	public static void setDataSource(String dataSource) {
		holderDataSource.set(dataSource);
	}

	public static String getDataSource() {
		return holderDataSource.get();
	}

	public static void clear() {
		holderDataSource.remove();
	}

}
