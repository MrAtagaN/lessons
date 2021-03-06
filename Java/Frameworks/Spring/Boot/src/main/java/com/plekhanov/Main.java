package com.plekhanov;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.boot.web.servlet.server.ConfigurableServletWebServerFactory;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.util.Collections;

/**
 * https://docs.spring.io/spring-boot/docs/current/reference/html/index.html
 * https://docs.spring.io/spring-boot/docs/current/reference/pdf/spring-boot-reference.pdf
 *
 * https://www.baeldung.com/spring-boot
 *
 * {@link SpringBootApplication} - состоит из трех аннотаций:
 *
 * {@link Configuration) -
 *     Параметры:
 *     proxyBeanMethods -
 *
 * {@link EnableAutoConfiguration} -  тоже что и {@link ComponentScan}, но еще ищет конфигурацию в classpath
 *     Параметры:
 *     exclude, excludeName - Не создавать бины автоконфигурации
 *
 * {@link ComponentScan} - автоматическое создание bean-компонентов для каждого класса, аннотированного с
 *     помощью @Component, @Service, @Controller, @RestController, @Repository, и добавления их в контейнер Spring
 *     Параметры:
 *     scanBasePackages, scanBasePackageClasses - сканирование пакетов для создания бинов
 *
 * {@link EntityScan} - Сканирует пакеты для регистрации @Entity для JPA. Не создает бинов
 *
 * {@link ConfigurationPropertiesScan} -
 *
 *
 * Приоритетный порядок конфигураций:
 *
 * Java Config
 * Command Line Arguments
 * Java System Properties
 * OS Environment Variables
 * application.properties in Current Directory
 * application.properties in the classpath (src/main/resources or the packaged jar file)
 *
 * //TODO Внести актуатор. Менять уровень логирования на лету rest запросом
 */
@SpringBootApplication
@EntityScan
//@EnableScheduling
@EnableAsync
@ConfigurationPropertiesScan
public class Main {
    public static void main(String[] args) {
        ConfigurableApplicationContext applicationContext = SpringApplication.run(Main.class, args);


//        SpringApplication app = new SpringApplication(Main.class);
//        app.setDefaultProperties(Collections.singletonMap("server.port", "8083"));
//        app.run(args);

//        выключение приложения
//        SpringApplication.exit(applicationContext);
//
//        без сервера
//        new SpringApplicationBuilder(Main.class)
//                .web(WebApplicationType.NONE) // .REACTIVE, .SERVLET
//                .run(args);


    }

    @Bean
    public WebServerFactoryCustomizer<ConfigurableServletWebServerFactory> webServerFactoryCustomizer() {
        return factory -> factory.setContextPath("/baeldung");
    }






    //TODO
    // Изучить аннотации
    // @InitBinder
}
