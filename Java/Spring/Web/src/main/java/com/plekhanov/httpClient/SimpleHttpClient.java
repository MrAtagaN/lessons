package com.plekhanov.httpClient;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.protocol.HttpContext;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;

/**
 * Методы {@link HttpUriRequest}:
 *
 *
 * Методы {@link HttpContext}:
 *
 *
 * Методы {@link CloseableHttpClient}:
 *   execute - Делает http запрос и возвращает {@link CloseableHttpResponse}
 *
 *
 * Методы {@link HttpResponse}:
 *
 *
 */
public class SimpleHttpClient {

    private static final String URL = "https://google.com";


    public static void main(String[] args) throws IOException {
        final CloseableHttpClient httpClient = HttpClientBuilder.create()
                .build();

        final HttpPost httpRequest = new HttpPost(URL);
        final HttpResponse httpResponse = httpClient.execute(httpRequest);
        System.out.println("Status line: " + httpResponse.getStatusLine());


        //CloseableHttpClient преобразуем в RestTemplate
        final HttpComponentsClientHttpRequestFactory requestFactory = new HttpComponentsClientHttpRequestFactory(httpClient);
        final RestTemplate restTemplate = new RestTemplate(requestFactory);
    }
}
