package com.plekhanov.httpClient;

import org.apache.http.HttpRequest;
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
 *
 * Методы {@link HttpClientBuilder}:
 *
 * Методы {@link HttpUriRequest}:
 * Методы {@link HttpRequest}:
 *
 * Методы {@link HttpContext}:
 *
 *
 * Методы {@link CloseableHttpClient}:
 *   execute - Делает http запрос и возвращает {@link CloseableHttpResponse}
 *
 * Методы {@link CloseableHttpResponse}:
 *
 *
 */
public class HttpClient_ {

    private static final String URL = "https://google.com";


    public static void main(String[] args) throws IOException {
        final CloseableHttpClient httpClient = HttpClientBuilder.create()
                .build();

        final HttpUriRequest httpRequest = new HttpPost(URL);
        final CloseableHttpResponse httpResponse = httpClient.execute(httpRequest);
        System.out.println("Status line: " + httpResponse.getStatusLine());


        //CloseableHttpClient преобразуем в RestTemplate
        final HttpComponentsClientHttpRequestFactory requestFactory = new HttpComponentsClientHttpRequestFactory(httpClient);
        final RestTemplate restTemplate = new RestTemplate(requestFactory);
    }
}
