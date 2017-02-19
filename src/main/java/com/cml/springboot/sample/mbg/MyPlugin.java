package com.cml.springboot.sample.mbg;

import java.lang.reflect.Field;
import java.util.List;

import javax.swing.text.AbstractDocument.Content;

import org.mybatis.generator.api.GeneratedJavaFile;
import org.mybatis.generator.api.GeneratedXmlFile;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.PluginAdapter;
import org.mybatis.generator.api.dom.java.FullyQualifiedJavaType;
import org.mybatis.generator.api.dom.java.TopLevelClass;
import org.mybatis.generator.config.Context;
import org.springframework.util.ReflectionUtils;

public class MyPlugin extends PluginAdapter {

	/**
	 * 
	 */
	public MyPlugin() {
	}

	public boolean validate(List<String> warnings) {
		// false 表示此plugin不执行
		return false;
	}

	@Override
	public void initialized(IntrospectedTable introspectedTable) {
	}

	@Override
	public boolean modelBaseRecordClassGenerated(TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {
		// 重命名bean
		Field field = ReflectionUtils.findField(topLevelClass.getClass(), "type");
		field.setAccessible(true);
		String fullyBeanName = null;
		try {
			FullyQualifiedJavaType oldType = topLevelClass.getType();
			fullyBeanName = oldType.getPackageName() + ".Base" + oldType.getShortName();
			field.set(topLevelClass, new FullyQualifiedJavaType(fullyBeanName));
		} catch (IllegalArgumentException | IllegalAccessException e) {
			e.printStackTrace();
		}

		// 重命名Mapper对应bean
		introspectedTable.setDAOImplementationType(fullyBeanName);
		System.out.println(topLevelClass.getType().getFullyQualifiedName() + ",===="
				+ introspectedTable.getAttribute("ATTR_DAO_INTERFACE_TYPE"));
		return true;
	}

}
