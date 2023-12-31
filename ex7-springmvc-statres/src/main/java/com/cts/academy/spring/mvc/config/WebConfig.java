package com.cts.academy.spring.mvc.config;

import java.io.IOException;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.CacheControl;
import org.springframework.http.MediaType;
import org.springframework.ui.context.support.ResourceBundleThemeSource;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.resource.EncodedResourceResolver;
import org.springframework.web.servlet.resource.PathResourceResolver;
import org.springframework.web.servlet.resource.ResourceUrlEncodingFilter;
import org.springframework.web.servlet.theme.CookieThemeResolver;
import org.springframework.web.servlet.theme.ThemeChangeInterceptor;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.ResourceBundleViewResolver;
import org.springframework.web.servlet.view.XmlViewResolver;

@EnableWebMvc
@ComponentScan(basePackages = { "com.baeldung.web.controller" })
@Configuration
public class WebConfig implements WebMvcConfigurer {

	/** Multipart file uploading configuratioin */
	@Bean
	public CommonsMultipartResolver multipartResolver() throws IOException {
		CommonsMultipartResolver resolver = new CommonsMultipartResolver();
		resolver.setMaxUploadSize(10000000);
		return resolver;
	}
	



	/** BEGIN theme configuration */
	@Bean
	public ResourceBundleThemeSource themeSource() {
		ResourceBundleThemeSource themeSource = new ResourceBundleThemeSource();
		themeSource.setDefaultEncoding("UTF-8");
		themeSource.setBasenamePrefix("themes.");
		return themeSource;
	}

	@Bean
	public CookieThemeResolver themeResolver() {
		CookieThemeResolver resolver = new CookieThemeResolver();
		resolver.setDefaultThemeName("default");
		resolver.setCookieName("example-theme-cookie");
		return resolver;
	}

	@Bean
	public ThemeChangeInterceptor themeChangeInterceptor() {
		ThemeChangeInterceptor interceptor = new ThemeChangeInterceptor();
		interceptor.setParamName("theme");
		return interceptor;
	}

	/** END theme configuration */

	@Bean
	public ViewResolver resourceBundleViewResolver() {

		final ResourceBundleViewResolver bean = new ResourceBundleViewResolver();
		bean.setBasename("views");
		bean.setOrder(0);
		return bean;
	}

	@Bean
	public ViewResolver xmlViewResolver() {
		final XmlViewResolver bean = new XmlViewResolver();
		bean.setLocation(new ClassPathResource("views.xml"));
		bean.setOrder(1);
		return bean;
	}

	/**
	 * Spring Boot allows configuring Content Negotiation using properties
	 */
	@Override
	public void configureContentNegotiation(final ContentNegotiationConfigurer configurer) {
		configurer.favorPathExtension(true).favorParameter(true).parameterName("mediaType").ignoreAcceptHeader(false)
				.useRegisteredExtensionsOnly(false).defaultContentType(MediaType.APPLICATION_JSON)
				.mediaType("xml", MediaType.APPLICATION_XML).mediaType("json", MediaType.APPLICATION_JSON);
	}

	@Autowired
	Environment env;

	// API

	@Override
	public void addViewControllers(final ViewControllerRegistry registry) {
		registry.addViewController("/login.html");
		registry.addViewController("/home.html");
		registry.addViewController("/").setViewName("index");

	}

	@Bean
	public ViewResolver viewResolver() {

		final InternalResourceViewResolver bean = new InternalResourceViewResolver();
		bean.setViewClass(JstlView.class);
		bean.setPrefix("/WEB-INF/view/");
		bean.setSuffix(".jsp");
		bean.setOrder(2);
		return bean;

	}

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resources/**/*").addResourceLocations("/", "/resources/").setCachePeriod(3600)
				.resourceChain(true).addResolver(new PathResourceResolver());

		registry.addResourceHandler("/js/**").addResourceLocations("/js/").setCacheControl(CacheControl.maxAge(1, TimeUnit.DAYS)).resourceChain(true)
				.addResolver(new EncodedResourceResolver()).addResolver(new PathResourceResolver());
		registry.addResourceHandler("/resources/**").addResourceLocations("/resources/", "classpath:/other-resources/")
				.setCachePeriod(3600).resourceChain(true).addResolver(new PathResourceResolver());
		registry.addResourceHandler("/files/**").addResourceLocations("file:/Vignesh/").setCachePeriod(3600)
				.resourceChain(true).addResolver(new PathResourceResolver());
		registry.addResourceHandler("/other-files/**").addResourceLocations("file:/Vignesh/").setCachePeriod(3600)
				.resourceChain(true).addResolver(new EncodedResourceResolver());
	}

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(themeChangeInterceptor());
		LocaleChangeInterceptor localeChangeInterceptor = new LocaleChangeInterceptor();
		localeChangeInterceptor.setParamName("lang");
		registry.addInterceptor(localeChangeInterceptor);
	}

	@Bean
	public ResourceUrlEncodingFilter resourceUrlEncodingFilter() {
		ResourceUrlEncodingFilter filter = new ResourceUrlEncodingFilter();

		return filter;
	}

	@Bean
	public LocaleResolver localeResolver() {
		CookieLocaleResolver cookieLocaleResolver = new CookieLocaleResolver();
		cookieLocaleResolver.setDefaultLocale(Locale.ENGLISH);
		return cookieLocaleResolver;
	}

	@Bean
	public MessageSource messageSource() {
		ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
		messageSource.setBasename("classpath:messages");
		messageSource.setUseCodeAsDefaultMessage(true);
		messageSource.setDefaultEncoding("UTF-8");
		messageSource.setCacheSeconds(0);
		return messageSource;
	}
}