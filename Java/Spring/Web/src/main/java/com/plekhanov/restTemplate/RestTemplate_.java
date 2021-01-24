package com.plekhanov.restTemplate;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

/**
 * https://www.baeldung.com/rest-template
 *
 * Методы restTemplate:
 *  getForEntity -
 *  postForEntity -
 *  acceptHeaderRequestCallback -
 *  delete -
 *  exchange -
 *  getErrorHandler -
 *  setErrorHandler -
 *  getForObject -
 *  postForObject -
 *  getMessageConverters -
 *  setUriTemplateHandler -
 *  getUriTemplateHandler -
 *  headForHeaders -
 *  httpEntityCallback -
 *  optionsForAllow -
 *  patchForObject -
 *  postForLocation -
 *  put -
 *  execute -
 *  responseEntityExtractor -
 *  setDefaultUriVariables -
 *
 * Методы responseEntity:
 */
public class RestTemplate_ {

    private static final String GET_URL = "https://postman-echo.com/get?foo1=bar1&foo2=bar2";

    public static void main(String[] args) {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(GET_URL, String.class);


        System.out.println("StatusCode: " + responseEntity.getStatusCode());
        System.out.println("HttpHeaders: " + responseEntity.getHeaders());
        System.out.println("Body: " + responseEntity.getBody());
    }
}
