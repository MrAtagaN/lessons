package com.plekhanov.restTemplate;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

/**
 * https://www.baeldung.com/rest-template
 *
 * Методы RestTemplate:
 *   exchange - Делает запрос и возвращает {@link ResponseEntity} с типом, указанным в параметрах
 *   execute - Делает запрос и возвращает ответ в виде объекта, тип которого указывается в параметрах
 *
 *   getForEntity - Делает get запрос и возвращает {@link ResponseEntity} с типом, указанным в параметрах
 *   postForEntity - Делает post запрос и возвращает {@link ResponseEntity} с типом, указанным в параметрах
 *
 *   getForObject - Делает get запрос и возвращает ответ в виде объекта, тип которого указывается в параметрах
 *   postForObject - Делает post запрос и возвращает ответ в виде объекта, тип которого указывается в параметрах
 *   patchForObject - Делает patch запрос и возвращает ответ в виде объекта, тип которого указывается в параметрах
 *
 *   delete - Делает delete запрос, ничего не возвращает
 *   put - Делает put запрос, ничего не возвращает
 *
 *   acceptHeaderRequestCallback -
 *
 *   getErrorHandler -
 *   setErrorHandler -
 *   getMessageConverters -
 *   setUriTemplateHandler -
 *   getUriTemplateHandler -
 *   headForHeaders -
 *   httpEntityCallback -
 *   optionsForAllow -
 *   postForLocation -
 *
 *
 *  responseEntityExtractor -
 *  setDefaultUriVariables -
 *
 * Методы ResponseEntity:
 *   getStatusCode -
 *   getStatusCodeValue -
 *   getBody -
 *   hasBody -
 *   getHeaders -
 *
 */
public class RestTemplate_ {

    private static final String GET_URL = "https://postman-echo.com/get?foo1=bar1&foo2=bar2";

    public static void main(String[] args) {
        final RestTemplate restTemplate = new RestTemplate();
        final HttpHeaders headers = new HttpHeaders();
        headers.set("someHeader", "headerValue");

        final HttpEntity<String> request = new HttpEntity<>("TEST BODY", headers);
        final ResponseEntity<String> responseEntity = restTemplate.getForEntity(GET_URL, String.class, request);


        System.out.println("StatusCode: " + responseEntity.getStatusCode());
        System.out.println("HttpHeaders: " + responseEntity.getHeaders());
        System.out.println("Body: " + responseEntity.getBody());
    }
}
