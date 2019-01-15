package com.plekhanov.HelloWorld;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * Created by AtagaN on 11.01.2019.
 */

@Configuration
@ComponentScan(basePackages = "com.plekhanov")
@PropertySource("classpath:aplication.properties")
public class Conf {
}
