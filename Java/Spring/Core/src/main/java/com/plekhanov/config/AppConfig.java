package com.plekhanov.config;

import com.plekhanov.service.AppService;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Configuration;

/**
 * Аннотация {@link ConditionalOnProperty} -
 *
 *
 * Аннотация {@link ConditionalOnBean} -
 *
 *
 * Аннотация {@link ConditionalOnMissingBean} -
 *
 *
 *
 */
@Configuration
//@ConditionalOnProperty
//@ConditionalOnBean
@ConditionalOnMissingBean(AppService.class)
public class AppConfig {
}
