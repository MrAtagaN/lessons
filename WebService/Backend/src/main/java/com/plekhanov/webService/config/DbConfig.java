package com.plekhanov.webService.config;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.jdbc.core.convert.JdbcConverter;
import org.springframework.data.jdbc.core.convert.JdbcCustomConversions;
import org.springframework.data.jdbc.core.convert.RelationResolver;
import org.springframework.data.jdbc.repository.config.AbstractJdbcConfiguration;
import org.springframework.data.relational.core.mapping.RelationalMappingContext;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;

import javax.sql.DataSource;

@Configuration
public class DbConfig {

    @Bean("BasicDataSource")
    public DataSource getBasicDataSource() {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName("org.postgresql.Driver");
        dataSource.setUrl("jdbc:postgresql://localhost:5432/postgres");
        dataSource.setUsername("postgres");
        dataSource.setPassword("12345678");
        dataSource.setInitialSize(10);
        dataSource.setMaxTotal(20);

        return dataSource;
    }

    @Bean
    public JdbcConverter jdbcConverter(final RelationalMappingContext mappingContext,
                                       final NamedParameterJdbcOperations operations,
                                       final @Lazy RelationResolver relationResolver,
                                       final JdbcCustomConversions conversions) {
        return new AbstractJdbcConfiguration().jdbcConverter(mappingContext, operations, relationResolver, conversions);
    }
}
