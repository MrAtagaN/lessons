package com.plekhanov.HelloWorld;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

/**
 * Created by AtagaN on 11.01.2019.
 */
public class HelloWorld {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(Conf.class);
        //ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
        //ApplicationContext context = new ClassPathXmlApplicationContext("classpath*:config.xml");
        //ApplicationContext context = new FileSystemXmlApplicationContext("Spring\\src\\main\\resources\\config.xml");



        DaVinchiCode daVinchiCode = context.getBean(DaVinchiCode.class);
        daVinchiCode.read();
    }
}
