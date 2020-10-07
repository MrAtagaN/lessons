package com.plekhanov.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.*;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

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
@PropertySource("")
//@ConditionalOnProperty
//@ConditionalOnBean(DataSource.class)
//@ConditionalOnMissingBean(DataSource.class)
//@ConditionalOnClass(DataSource.class)
//@ConditionalOnMissingClass("DataSource")
//@ConditionalOnResource(resources = "classpath:mysql.properties")
public class AppConfig {

    @Value( "${app.prop}" )
    private String appProp;

}
