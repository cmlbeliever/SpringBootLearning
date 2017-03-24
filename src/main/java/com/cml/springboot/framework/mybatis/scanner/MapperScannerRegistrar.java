package com.cml.springboot.framework.mybatis.scanner;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.mybatis.spring.mapper.ClassPathMapperScanner;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanNameGenerator;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.ResourceLoaderAware;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.annotation.AnnotationAttributes;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.util.ClassUtils;
import org.springframework.util.StringUtils;

/**
 * 详情请查看{@link org.mybatis.spring.annotation.MapperScannerRegistrar}
 * 
 * @author admin
 *
 */
public class MapperScannerRegistrar implements ImportBeanDefinitionRegistrar, ResourceLoaderAware, EnvironmentAware {

	private ResourceLoader resourceLoader;
	private Environment env;

	protected final Log logger = LogFactory.getLog(getClass());

	@Override
	public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {

		AnnotationAttributes annoAttrs = AnnotationAttributes
				.fromMap(importingClassMetadata.getAnnotationAttributes(MapperScanner.class.getName()));
		ClassPathMapperScanner scanner = new ClassPathMapperScanner(registry);

		if (resourceLoader != null) { // this check is needed in Spring 3.1
			scanner.setResourceLoader(resourceLoader);
		}

		Class<? extends Annotation> annotationClass = annoAttrs.getClass("annotationClass");
		if (!Annotation.class.equals(annotationClass)) {
			scanner.setAnnotationClass(annotationClass);
		}

		Class<?> markerInterface = annoAttrs.getClass("markerInterface");
		if (!Class.class.equals(markerInterface)) {
			scanner.setMarkerInterface(markerInterface);
		}

		Class<? extends BeanNameGenerator> generatorClass = annoAttrs.getClass("nameGenerator");
		if (!BeanNameGenerator.class.equals(generatorClass)) {
			scanner.setBeanNameGenerator(BeanUtils.instantiateClass(generatorClass));
		}

		scanner.setSqlSessionTemplateBeanName(annoAttrs.getString("sqlSessionTemplateRef"));
		scanner.setSqlSessionFactoryBeanName(annoAttrs.getString("sqlSessionFactoryRef"));

		List<String> basePackages = new ArrayList<String>();
		for (String pkg : annoAttrs.getStringArray("value")) {
			if (StringUtils.hasText(pkg)) {
				basePackages.add(parsePlaceHolder(pkg));
			}
		}
		for (String pkg : annoAttrs.getStringArray("basePackages")) {
			if (StringUtils.hasText(pkg)) {
				basePackages.add(parsePlaceHolder(pkg));
			}
		}
		for (Class<?> clazz : annoAttrs.getClassArray("basePackageClasses")) {
			basePackages.add(ClassUtils.getPackageName(clazz));
		}
		scanner.registerFilters();
		scanner.doScan(StringUtils.toStringArray(basePackages));

	}

	private String parsePlaceHolder(String pro) {
		if (pro != null && pro.contains(PropertySourcesPlaceholderConfigurer.DEFAULT_PLACEHOLDER_PREFIX)) {
			String value = env.getProperty(pro.substring(2, pro.length() - 1));

			if (logger.isDebugEnabled()) {
				logger.debug("find placeholder value " + value + " for key " + pro);
			}

			if (null == value) {
				throw new IllegalArgumentException("property " + pro + " can not find!!!");
			}
			return value;
		}
		return pro;
	}

	/**
	 * load properties
	 * 
	 * @param properties
	 * @return
	 */
	private Properties loadProperties(String[] properties) {
		Properties container = new Properties();
		if (null != properties) {
			PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();

			for (String pro : properties) {
				try {
					container.load(resolver.getResource(pro).getInputStream());
				} catch (IOException e) {
					throw new IllegalArgumentException(e);
				}
			}

		}
		return container;
	}

	@Override
	public void setResourceLoader(ResourceLoader loader) {
		this.resourceLoader = loader;
	}

	@Override
	public void setEnvironment(Environment environment) {
		this.env = environment;
	}

}
