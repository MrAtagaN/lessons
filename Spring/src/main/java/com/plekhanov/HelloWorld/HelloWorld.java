package com.plekhanov.HelloWorld;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by AtagaN on 11.01.2019.
 */
public class HelloWorld {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(Conf.class);
        DaVinchiCode daVinchiCode = applicationContext.getBean(DaVinchiCode.class);
        daVinchiCode.read();
    }
}
