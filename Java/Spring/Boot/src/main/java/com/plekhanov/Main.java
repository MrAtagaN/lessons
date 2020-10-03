package com.plekhanov;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Аннотация {@link SpringBootApplication} - состоит из трех аннотаций:
 *
 * Аннотация {@link Configuration) -
 *     Параметры:
 *     proxyBeanMethods -
 *
 * Аннотация {@link EnableAutoConfiguration} -
 *     Параметры:
 *     exclude, excludeName - Не создавать бины автоконфигурации
 *
 * Аннотация {@link ComponentScan} - автоматическое создание bean-компонентов для каждого класса, аннотированного с
 *     помощью @Component, @Service, @Controller, @RestController, @Repository, и добавления их в контейнер Spring
 *     Параметры:
 *     scanBasePackages, scanBasePackageClasses - сканирование пакетов для создания бинов
 *
 * Аннотация {@link EntityScan} - Сканирует пакеты для регистрации Entity. Не создает бинов
 *
 * Аннотация {@link ConfigurationPropertiesScan} -
 *
 *
 */
@SpringBootApplication
@EntityScan
@ConfigurationPropertiesScan
public class Main {
    public static void main(String[] args) {
        ConfigurableApplicationContext applicationContext = SpringApplication.run(Main.class, args);

//        выключение приложения
//        SpringApplication.exit(applicationContext);
//
//        без сервера
//        new SpringApplicationBuilder(Main.class)
//                .web(WebApplicationType.NONE) // .REACTIVE, .SERVLET
//                .run(args);
    }

    //TODO
    // Курс по SpringBoot:
    // https://www.baeldung.com/spring-boot
    // проходится тема:
    // https://www.baeldung.com/properties-with-spring



    //TODO
    // Изучить аннотации
    // @InitBinder
    // @EntityScan
    // @ConfigurationPropertiesScan
}
