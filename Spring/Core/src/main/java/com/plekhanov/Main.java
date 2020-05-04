package com.plekhanov;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @SpringBootApplication - состоит из трех аннотаций:
 * @Configuration, @EnableAutoConfiguration, @ComponentScan
 *
 * Параметры:
 * exclude, excludeName - Не создавать бины автоконфигурации
 * scanBasePackages, scanBasePackageClasses - сканирование пакетов для создания бинов
 * proxyBeanMethods -
 */
@SpringBootApplication
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    //TODO проходится тема:
    // https://www.baeldung.com/spring-boot-annotations
}
