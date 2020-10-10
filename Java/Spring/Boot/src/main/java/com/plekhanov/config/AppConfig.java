package com.plekhanov.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.*;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.core.env.Environment;

import javax.sql.DataSource;

/**
 * Настройка условий для работы аннотации {@link Configuration}:
 *
 * Аннотация {@link ConditionalOnProperty} - если у определенной проперти есть определенное значение
 *
 * Аннотация {@link ConditionalOnBean} -
 *
 * Аннотация {@link ConditionalOnMissingBean} -
 *
 * Аннотация {@link ConditionalOnClass} -
 *
 * Аннотация {@link ConditionalOnMissingClass} -
 *
 * Аннотация {@link ConditionalOnResource} -
 *
 * Аннотация {@link ConditionalOnWebApplication} - если приложение является веб сервером
 *
 *
 * Аннотация {@link PropertySource} -
 *
 *
 */
@Configuration
@PropertySources({
        @PropertySource("classpath:application.yml"),
        @PropertySource("classpath:application.yml")
})
//@ConditionalOnProperty
//@ConditionalOnBean(DataSource.class)
//@ConditionalOnMissingBean(DataSource.class)
//@ConditionalOnClass(DataSource.class)
//@ConditionalOnMissingClass("DataSource")
//@ConditionalOnResource(resources = "classpath:mysql.properties")
@EnableConfigurationProperties(AdditionalProperties.class) //работает вместе с ConfigurationProperties
@ConstructorBinding //инжекция в конструктор
public class AppConfig {

    @Autowired
    private AdditionalProperties additionalProperties;

    @Value( "${app.prop:defaultAppProp}" )
    private String appProp;

    @Autowired
    private Environment env; // переменные окружения

}
