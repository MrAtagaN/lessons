package com.plekhanov.controllers;


import com.plekhanov.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    User user;

    @GetMapping(value = "/getUser")
    public String getUser() {
        return "test";
    }
}
