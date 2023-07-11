package com.cts.academy.spring.mvc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@EnableWebMvc
@Configuration
@ComponentScan(basePackages = "com.cts.academy.spring.mvc.controller")
public class WebMvcConfig implements WebMvcConfigurer {
	
	
	/*
	 * 1. @Component
	 * 2. @Controller
	 * 3. @Repository
	 * 4. @Service
	 */
	@Bean
	public ViewResolver internalResourceViewResolver() {
	    InternalResourceViewResolver bean = new InternalResourceViewResolver();
	    bean.setViewClass(JstlView.class);
	    bean.setPrefix("/WEB-INF/views/");
	    bean.setSuffix(".jsp");
	    return bean;
	}
	
//	@Bean
//	public ViewResolver resourceBundleViewResolver() {
//	    ResourceBundleViewResolver bean = new ResourceBundleViewResolver();
//	    bean.setBasename("views");
//	    return bean;
//	}
}

//			/WEB-INF/views/hello.jsp