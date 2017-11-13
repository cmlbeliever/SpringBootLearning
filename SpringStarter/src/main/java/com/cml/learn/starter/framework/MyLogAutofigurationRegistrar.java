package com.cml.learn.starter.framework;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.config.AbstractFactoryBean;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.ResourceLoaderAware;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.annotation.AnnotationAttributes;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.core.type.filter.AnnotationTypeFilter;
import org.springframework.core.type.filter.TypeFilter;

import com.cml.learn.starter.framework.scanner.MyLogClasspathScanner;

public class MyLogAutofigurationRegistrar implements ImportBeanDefinitionRegistrar, ResourceLoaderAware, EnvironmentAware {

	private static Logger log = LoggerFactory.getLogger(MyLogAutofigurationRegistrar.class);
	private Environment env;
	private ResourceLoader resourceLoader;

	@Override
	public void setEnvironment(Environment environment) {
		this.env = environment;
		if (log.isDebugEnabled()) {
			log.debug("setEnvironment");
		}
	}

	@Override
	public void setResourceLoader(ResourceLoader resourceLoader) {
		this.resourceLoader = resourceLoader;
		if (log.isDebugEnabled()) {
			log.debug("setResourceLoader");
		}
	}

	@Override
	public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
		if (log.isDebugEnabled()) {
			log.debug("registerBeanDefinitions");
		}

		// 获取自动log配置的basePackage
		AnnotationAttributes annoAttrs = AnnotationAttributes
				.fromMap(importingClassMetadata.getAnnotationAttributes(EnableMyLogAutoConfiguration.class.getName()));
		String basePackage = annoAttrs.getString("basePackage");
		
		Class<? extends AbstractFactoryBean> implClass=annoAttrs.getClass("implClass");

		// 扫描基础包下所有带有MyLogScanner注解的接口
		MyLogClasspathScanner scanner = new MyLogClasspathScanner(registry);
		scanner.setResourceLoader(resourceLoader);
		scanner.addIncludeFilter(new AnnotationTypeFilter(MyLogScanner.class));
		// exclude package-info.java
		scanner.addExcludeFilter(new TypeFilter() {
			public boolean match(MetadataReader metadataReader, MetadataReaderFactory metadataReaderFactory) throws IOException {
				String className = metadataReader.getClassMetadata().getClassName();
				return className.endsWith("package-info");
			}
		});
		scanner.setFactoryBeanImplClass(implClass);
		scanner.doScan(basePackage);
	}

}
