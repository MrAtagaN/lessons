package com.plekhanov.MVC;


import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.context.support.XmlWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

/**
 * Created by AtagaN on 23.01.2019.
 */
public class MydispatvherInitializer implements WebApplicationInitializer {

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
//        AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
//        context.register(MyConfig.class);
//        context.refresh();

        XmlWebApplicationContext context = new XmlWebApplicationContext();
        context.setConfigLocation("/WEB-INF/MyDispatcherServlet-servlet.xml");

        ServletRegistration.Dynamic registration = servletContext.addServlet("dispInit", new DispatcherServlet(context));
        registration.setLoadOnStartup(1);
        registration.addMapping("/dispInit/*");
    }
}
