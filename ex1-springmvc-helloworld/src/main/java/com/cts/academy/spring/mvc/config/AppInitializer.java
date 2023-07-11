package com.cts.academy.spring.mvc.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class AppInitializer implements WebApplicationInitializer {

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        WebApplicationContext context = getContext();
        servletContext.addListener(new ContextLoaderListener(context));
        System.err.println("#########################################2");
        ServletRegistration.Dynamic dispatcher = servletContext.addServlet("DispatcherServlet", new DispatcherServlet(context));
        dispatcher.setLoadOnStartup(1);
        dispatcher.addMapping("/");
    }
    
    /*
     * Disp : BeanA(inject BeanB) : Controllers, Validators, HandlerMapping, Interceptor, ViewResolver, View
     * ContLoaderLister : BeanB : Service, DAO, JDBCTEmplate, Delegates, All Other stuff including Models
     */
    

    private AnnotationConfigWebApplicationContext getContext() {
        AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
        System.err.println("#########################################1");
        context.setConfigLocation("com.cts.academy.spring.mvc.config");
        return context;
    }

}

//1. Create SErvlet Java class
//2. Create an XML config