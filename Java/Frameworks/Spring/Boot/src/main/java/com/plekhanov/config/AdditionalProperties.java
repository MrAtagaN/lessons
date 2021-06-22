package com.plekhanov.config;


import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "database")
public class AdditionalProperties {

    String url;
    String username;
    String password;
}
