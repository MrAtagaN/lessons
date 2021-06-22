package com.plekhanov.restTemplate;

import org.springframework.http.*;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.client.ResponseErrorHandler;
import org.springframework.web.client.RestTemplate;

/**
 * https://www.baeldung.com/rest-template
 *
 * Методы {@link RestTemplate}:
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
 *   headForHeaders - Делает head запрос, возвращает {@link HttpHeaders}
 *   optionsForAllow - Делает option запрос, возвращает {@link HttpMethod}
 *
 *   acceptHeaderRequestCallback -
 *
 *   getErrorHandler - Возвращает {@link ResponseErrorHandler}
 *   setErrorHandler - Задать обработчик ошибок {@link ResponseErrorHandler}
 *
 *   getMessageConverters - Возвращает {@link HttpMessageConverter}
 *   setMessageConverters - Задать {@link HttpMessageConverter}
 *
 *   getUriTemplateHandler -
 *   setUriTemplateHandler -
 *
 *
 *   httpEntityCallback -
 *   postForLocation -
 *
 *   responseEntityExtractor -
 *   setDefaultUriVariables -
 *
 * Методы {@link ResponseEntity}:
 *   getStatusCode - Возвращает {@link HttpStatus}
 *   getStatusCodeValue - Возвращает значение кода ответа
 *   getBody - Возвращает тело ответа
 *   hasBody - Есть ли тело ответа
 *   getHeaders - Возвращает {@link HttpHeaders}
 *
 */
public class SimpleRestTemplate {

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
