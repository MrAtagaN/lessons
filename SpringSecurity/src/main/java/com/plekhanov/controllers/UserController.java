package com.plekhanov.controllers;

import com.plekhanov.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    User user;

    @GetMapping(value = "/getUser")
    public User getUser() {
        return user;
    }

    @GetMapping(value = "/getInfo")
    public String getInfo() {
        return "SOME INFO";
    }

    @GetMapping(value = "/getSec")
    public String getSec() {
        return "SOME SECURITY CHANNEL";
    }
}
