package com.xworkz.rto.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import lombok.extern.slf4j.Slf4j;

@Configuration
@ComponentScan("com.xworkz")
@Slf4j
public class RtoConfiguration {
public RtoConfiguration() {
	log.info("this is RtoConfiguration");
	System.out.println("this is RtoConfiguration");
}

@Bean
public ViewResolver viewResolver() {
	log.info("view resolver bean is insitiated");
	InternalResourceViewResolver resolver=new InternalResourceViewResolver();
	resolver.setPrefix("/");
	resolver.setSuffix(".jsp");
	return resolver;
}
@Bean
public LocalContainerEntityManagerFactoryBean lcef() {
	log.info("LocalContainerEntityManagerFactoryBean is started");
	LocalContainerEntityManagerFactoryBean lcef=new LocalContainerEntityManagerFactoryBean();
	log.info("LocalContainerEntityManagerFactoryBean is created");
	return lcef;
}
}
