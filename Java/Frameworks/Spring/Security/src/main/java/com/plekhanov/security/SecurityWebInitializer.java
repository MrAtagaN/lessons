package com.plekhanov.security;

import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;

/**
 * Класс нужен для включения Фильтра запросов
 * Можно настроить действия перед и после обработки фильтром
 *
 * Registers the DelegatingFilterProxy to use the springSecurityFilterChain before any other registered Filter
 */
public class SecurityWebInitializer extends AbstractSecurityWebApplicationInitializer {


}
