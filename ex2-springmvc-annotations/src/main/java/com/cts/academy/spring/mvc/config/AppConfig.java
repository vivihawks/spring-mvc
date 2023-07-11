package com.cts.academy.spring.mvc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@Configuration
@ComponentScan(basePackages = "com.cognizant.academy.spring.mvc.annotations")
public class AppConfig {
	
	//hello = /WEB-INF/views/+ hello + .jsp
	@Bean
	public ViewResolver internalResourceViewResolver() {
	    InternalResourceViewResolver bean = new InternalResourceViewResolver();
	    bean.setViewClass(JstlView.class);
	    bean.setPrefix("/WEB-INF/views/");
	    bean.setSuffix(".jsp");
	    return bean;
	}
	
//	@Bean
//	@Qualifier("bike")
//	public Vehicle getBike() {
//		Bike bike = new Bike();
//		bike.setColor("yellow");
//		return bike;
//	}
//	@Bean
//	public ViewResolver resourceBundleViewResolver() {
//	    ResourceBundleViewResolver bean = new ResourceBundleViewResolver();
//	    bean.setBasename("views");
//	    return bean;
//	}
}