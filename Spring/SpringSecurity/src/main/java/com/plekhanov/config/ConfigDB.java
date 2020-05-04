package com.plekhanov.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;
import java.io.File;

@Configuration
public class ConfigDB {

    private static final String FS = File.separator;
    private static final String URL = "jdbc:sqlite:lessonsSpringSecurity.db"; //база должна быть в  apache-tomcat-9.0.17\bin


//    @Bean("SQLite")
//    public DataSource getDataSourceSqLite() {
//        DriverManagerDataSource dataSource = new DriverManagerDataSource();
//        dataSource.setDriverClassName("org.sqlite.JDBC");
//        dataSource.setUrl(URL);
//        dataSource.setUsername("");
//        dataSource.setPassword("");
//        return dataSource;
//    }
}
