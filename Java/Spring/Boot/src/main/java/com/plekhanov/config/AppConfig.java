package com.plekhanov.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.*;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.core.env.Environment;

import javax.sql.DataSource;

/**
 * {@link Configuration} -
 * Настройка условий для работы аннотации {@link Configuration}:
 * {@link ConditionalOnProperty} - если у определенной проперти есть определенное значение
 * {@link ConditionalOnBean} -
 * {@link ConditionalOnMissingBean} -
 * {@link ConditionalOnClass} -
 * {@link ConditionalOnMissingClass} -
 * {@link ConditionalOnResource} -
 * {@link ConditionalOnWebApplication} - если приложение является веб сервером
 *
 * ========================================
 *
 * {@link PropertySource} -
 * {@link Import} -
 * {@link EnableConfigurationProperties} - включает работу аннотации {@link ConfigurationProperties}
 * {@link ConfigurationProperties} -
 * {@link ConstructorBinding} - внедрение значений через конструктор, а не через сеттеры
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
@ConstructorBinding //внедрение значений через конструктор, а не через сеттеры
public class AppConfig {

    @Autowired
    private AdditionalProperties additionalProperties;

    @Value( "${app.prop:defaultAppProp}" )
    private String appProp;

    @Autowired
    private Environment env; // переменные окружения

}
