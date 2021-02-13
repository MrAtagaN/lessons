package com.plekhanov.httpClient;

import org.apache.http.client.config.RequestConfig;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

/**
 * Запрос с временем ожидания
 */
public class Timeout {

    private static final String GET_URL = "https://10.10.10.10/";
    private static final int TIMEOUT = 5000;


    public static void main(String[] args) {
        final RestTemplate restTemplate = getRestTemplateWithTimeout();
        final ResponseEntity<String> responseEntity = restTemplate.getForEntity(GET_URL, String.class);

        System.out.println("StatusCode: " + responseEntity.getStatusCode());
        System.out.println("HttpHeaders: " + responseEntity.getHeaders());
        System.out.println("Body: " + responseEntity.getBody());
    }


    /**
     * Возвращает RestTemplate с временем ожидания
     */
    private static RestTemplate getRestTemplateWithTimeout() {
        final RequestConfig config = RequestConfig.custom()
                .setConnectTimeout(TIMEOUT)
                .setConnectionRequestTimeout(TIMEOUT)
                .setSocketTimeout(TIMEOUT)
                .build();
        final CloseableHttpClient httpClient = HttpClientBuilder.create()
                .setDefaultRequestConfig(config)
                .build();
        final HttpComponentsClientHttpRequestFactory requestFactory = new HttpComponentsClientHttpRequestFactory(httpClient);
        return new RestTemplate(requestFactory);
    }
}
