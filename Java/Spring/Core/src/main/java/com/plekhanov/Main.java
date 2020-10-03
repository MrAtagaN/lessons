package com.plekhanov;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * {@link SpringBootApplication} - состоит из трех аннотаций:
 *
 * {@link Configuration) -
 * Параметры:
 * proxyBeanMethods -
 *
 * {@link EnableAutoConfiguration} -
 * Параметры:
 * exclude, excludeName - Не создавать бины автоконфигурации
 *
 * {@link ComponentScan} -
 * Параметры:
 * scanBasePackages, scanBasePackageClasses - сканирование пакетов для создания бинов
 *

 *
 */
@SpringBootApplication
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);

//        без сервера
//        new SpringApplicationBuilder(Main.class)
//                .web(WebApplicationType.NONE) // .REACTIVE, .SERVLET
//                .run(args);
    }

    //TODO проходится тема:
    // https://www.baeldung.com/spring-boot-annotations
}
