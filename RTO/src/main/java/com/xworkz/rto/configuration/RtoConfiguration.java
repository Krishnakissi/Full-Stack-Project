package com.xworkz.rto.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@ComponentScan("com.xworkz")
public class RtoConfiguration {
public RtoConfiguration() {
	System.out.println("this is RtoConfiguration");
}

@Bean
public ViewResolver viewResolver() {
	System.out.println("view resolver bean is insitiated");
	InternalResourceViewResolver resolver=new InternalResourceViewResolver();
	resolver.setPrefix("/");
	resolver.setSuffix(".jsp");
	return resolver;
}
@Bean
public LocalContainerEntityManagerFactoryBean lcef() {
	System.out.println("LocalContainerEntityManagerFactoryBean is started");
	LocalContainerEntityManagerFactoryBean lcef=new LocalContainerEntityManagerFactoryBean();
	System.out.println("LocalContainerEntityManagerFactoryBean is created");
	System.out.println(lcef);
	return lcef;
}
}
