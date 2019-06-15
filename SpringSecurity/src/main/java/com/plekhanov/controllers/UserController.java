package com.plekhanov.controllers;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.plekhanov.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    User user;

    @GetMapping(value = "/getUser")
    public String getUser() throws JsonProcessingException {

        ObjectMapper mapper = Jackson2ObjectMapperBuilder.json().build();
        return mapper.writeValueAsString(user);
    }
}
