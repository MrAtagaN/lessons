package com.plekhanov.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 *  Конфиг DispatcherServlet
 */
public class ConfigDispatcherServlet extends AbstractAnnotationConfigDispatcherServletInitializer {

    // Этот метод должен возвращать классы с @Configuration
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return null;
    }

    // DispatcherServlet application context  ( @EnableWebMvc ) ViewResolver
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[]{ConfigMVC.class};
    }


    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }

}
