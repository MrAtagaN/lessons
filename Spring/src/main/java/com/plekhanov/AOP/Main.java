package com.plekhanov.AOP;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by AtagaN on 18.01.2019.
 */
public class Main {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyConf.class);
        MyRepository repository = context.getBean(MyRepository.class);

        repository.getInfo();
    }
}
