package com.plekhanov.controllers;


import com.plekhanov.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("users")
public class UserController {

    @Autowired
    User user;

    @RequestMapping(value = "/getUser", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public User getUser() {
        return user;
    }
}
