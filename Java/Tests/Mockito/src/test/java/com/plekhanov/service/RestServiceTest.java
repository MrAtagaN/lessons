package com.plekhanov.service;

;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class RestServiceTest {


    RestService restService;

    @Mock
    RestTemplate restTemplate;

    @Before
    public void init() {
        ResponseEntity responseEntity = new ResponseEntity<>(HttpStatus.OK);
        responseEntity.toString();
        when(restTemplate.getForEntity("URL", String.class)).thenReturn(responseEntity);
        this.restService = new RestService(restTemplate);
    }

    @Test
    public void doGetTest() {
        restService.doGet("URL");
        verify(restTemplate, times(1)).getForEntity(eq("URL"), eq(String.class));
    }
}
