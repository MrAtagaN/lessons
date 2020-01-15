package com.plekhanov.webService;

import com.plekhanov.webService.dao.AutoDao;
import com.plekhanov.webService.dao.UserDao;
import com.plekhanov.webService.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jdbc.repository.config.EnableJdbcRepositories;

import javax.annotation.PostConstruct;
import java.util.Optional;


/**
 * http://localhost:8080/
 */
@SpringBootApplication
@EnableJdbcRepositories
public class Main {

    @Autowired
    UserDao userDao;
    @Autowired
    AutoDao autoDao;

    @PostConstruct
    public void init() {

        System.out.println();

        Optional<User> byId = userDao.findById(1L);
        User user = byId.get();
        userDao.customMethod();
    }

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);

    }
}
