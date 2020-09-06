package com.plekhanov.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.sql.DataSource;

/**
 * Настройка Security
 */
@Configuration
@EnableWebSecurity  //configures spring security from the class WebSecurityConfigurerAdapter
public class ConfigSecurity extends WebSecurityConfigurerAdapter {

//    @Autowired
//    DataSource dataSource;


    /**
     * password encoder:
     * https://www.baeldung.com/spring-security-5-default-password-encoder
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder(12);
        PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
        auth.inMemoryAuthentication().withUser("admin").password(encoder.encode("admin")).roles("admin");

       // auth.jdbcAuthentication().passwordEncoder(passwordEncoder).dataSource(dataSource);
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //http.authorizeRequests().anyRequest().authenticated().and().httpBasic().and().formLogin();
        http.authorizeRequests().
                antMatchers("/users/getUser")
                .hasRole("admin").anyRequest()
                .authenticated().anyRequest()
                .permitAll()
                .and().formLogin();

    }
}
