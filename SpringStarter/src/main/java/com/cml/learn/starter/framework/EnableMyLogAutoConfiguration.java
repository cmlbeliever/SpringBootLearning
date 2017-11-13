package com.cml.learn.starter.framework;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.context.annotation.Import;

import com.cml.learn.starter.framework.factorybean.AbstractMyLogFactoryBean;
import com.cml.learn.starter.framework.factorybean.MyLogFactoryBean;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
@Import(MyLogAutofigurationRegistrar.class)
public @interface EnableMyLogAutoConfiguration {
	String basePackage() default "";

	Class<? extends AbstractMyLogFactoryBean> implClass() default MyLogFactoryBean.class;
}
