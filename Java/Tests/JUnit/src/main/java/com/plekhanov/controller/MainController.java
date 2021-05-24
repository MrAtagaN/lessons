package com.plekhanov.controller;

import org.springframework.http.CacheControl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

    @PostMapping("/main")
    public ResponseEntity<?> main(@RequestBody String body) {
        return ResponseEntity
                .status(200)
                .cacheControl(CacheControl.noCache())
                .body("OK !");
    }
}
