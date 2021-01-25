package com.plekhanov.httpClient;

import org.apache.http.HttpRequest;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.protocol.HttpContext;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;

/**
 *
 * Методы {@link HttpClientBuilder}
 *
 * Методы {@link HttpUriRequest}
 * Методы {@link HttpRequest}
 *
 * Методы {@link HttpContext}
 *
 *
 * Методы {@link CloseableHttpClient}
 *
 */
public class HttpClient_ {


    public static void main(String[] args) throws IOException {
        final CloseableHttpClient httpClient = HttpClientBuilder.create()
                .build();

        httpClient.execute(null);


        //CloseableHttpClient преобразуем в RestTemplate
        final HttpComponentsClientHttpRequestFactory requestFactory = new HttpComponentsClientHttpRequestFactory(httpClient);
        final RestTemplate restTemplate = new RestTemplate(requestFactory);
    }
}
