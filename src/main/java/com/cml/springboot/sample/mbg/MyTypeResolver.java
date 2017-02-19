package com.cml.springboot.sample.mbg;

import java.sql.Types;
import java.util.List;
import java.util.Properties;

import org.joda.time.DateTime;
import org.mybatis.generator.api.IntrospectedColumn;
import org.mybatis.generator.api.JavaTypeResolver;
import org.mybatis.generator.api.dom.java.FullyQualifiedJavaType;
import org.mybatis.generator.config.Context;
import org.mybatis.generator.internal.types.JavaTypeResolverDefaultImpl;

public class MyTypeResolver implements JavaTypeResolver {

	JavaTypeResolverDefaultImpl defaultImpl = new JavaTypeResolverDefaultImpl();

	public MyTypeResolver() {

	}

	@Override
	public void addConfigurationProperties(Properties arg0) {

	}

	@Override
	public FullyQualifiedJavaType calculateJavaType(IntrospectedColumn column) {
		switch (column.getJdbcType()) {
		case Types.TIMESTAMP:
		case Types.DATE:
		case Types.TIME:
			return new FullyQualifiedJavaType(DateTime.class.getName());

		case Types.TINYINT:
			return new FullyQualifiedJavaType(Integer.class.getName());
		case Types.BLOB:
			return new FullyQualifiedJavaType(String.class.getName());

		default:
			break;
		}
		return defaultImpl.calculateJavaType(column);
	}

	@Override
	public String calculateJdbcTypeName(IntrospectedColumn arg0) {
		System.out.println("=========calculateJdbcTypeName=====>"+arg0.getJdbcTypeName()+","+arg0.getActualColumnName()+","+arg0.isBLOBColumn());
//		return defaultImpl.calculateJdbcTypeName(arg0);
		return arg0.getJdbcTypeName();
	}

	@Override
	public void setContext(Context arg0) {
		defaultImpl.setContext(arg0);
	}

	@Override
	public void setWarnings(List<String> arg0) {
		defaultImpl.setWarnings(arg0);
	}

}
