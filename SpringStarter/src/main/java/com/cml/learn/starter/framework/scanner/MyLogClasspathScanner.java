package com.cml.learn.starter.framework.scanner;

import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.AnnotatedBeanDefinition;
import org.springframework.beans.factory.config.AbstractFactoryBean;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanDefinitionHolder;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.context.annotation.ClassPathBeanDefinitionScanner;

public class MyLogClasspathScanner extends ClassPathBeanDefinitionScanner {

	private static Logger log = LoggerFactory.getLogger(MyLogClasspathScanner.class);

	private Class<? extends AbstractFactoryBean> factoryBeanImplClass;

	public MyLogClasspathScanner(BeanDefinitionRegistry registry) {
		super(registry);
	}

	@Override
	public Set<BeanDefinitionHolder> doScan(String... basePackages) {
		Set<BeanDefinitionHolder> beanDefinitions = super.doScan(basePackages);
		log.info("find beanDefinitions :" + beanDefinitions);
		if (!beanDefinitions.isEmpty()) {
			for (BeanDefinitionHolder holder : beanDefinitions) {
				GenericBeanDefinition defination = (GenericBeanDefinition) holder.getBeanDefinition();
				defination.getPropertyValues().addPropertyValue("mapperInterface", defination.getBeanClassName());
				// 设置bean工厂和对应的属性值
				defination.setBeanClass(this.factoryBeanImplClass);
				defination.setAutowireMode(AbstractBeanDefinition.AUTOWIRE_BY_TYPE);
			}
		}
		return beanDefinitions;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected boolean isCandidateComponent(AnnotatedBeanDefinition beanDefinition) {
		return (beanDefinition.getMetadata().isInterface() && beanDefinition.getMetadata().isIndependent());
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected boolean checkCandidate(String beanName, BeanDefinition beanDefinition) throws IllegalStateException {
		if (super.checkCandidate(beanName, beanDefinition)) {
			return true;
		} else {
			logger.warn("Skipping MapperFactoryBean with name '" + beanName + "' and '" + beanDefinition.getBeanClassName() + "' mapperInterface"
					+ ". Bean already defined with the same name!");
			return false;
		}
	}

	public void setFactoryBeanImplClass(Class<? extends AbstractFactoryBean> factoryBeanImplClass) {
		this.factoryBeanImplClass = factoryBeanImplClass;
	}

}
