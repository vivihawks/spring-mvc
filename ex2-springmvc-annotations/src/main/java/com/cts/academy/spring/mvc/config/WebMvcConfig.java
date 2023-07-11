package com.cts.academy.spring.mvc.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@EnableWebMvc
//<annotaion-driven/>
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
}