package com.cml.learn.starter.framework.scanner;

import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.AnnotatedBeanDefinition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanDefinitionHolder;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.context.annotation.ClassPathBeanDefinitionScanner;

import com.cml.learn.starter.framework.MyLogFactoryBean;

public class MyLogClasspathScanner extends ClassPathBeanDefinitionScanner {

	private static Logger log = LoggerFactory.getLogger(MyLogClasspathScanner.class);
	private BeanDefinitionRegistry registry;

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
				//设置bean工厂和对应的属性值
				defination.setBeanClass(MyLogFactoryBean.class);
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
}
