package com.plekhanov.service;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;


public class RestService {

    RestTemplate restTemplate;

    public RestService (RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public String doGet(String url) {
        ResponseEntity<String> entity = restTemplate.getForEntity(url, String.class);
        return entity.toString();
    }
}
