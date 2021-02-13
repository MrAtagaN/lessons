package com.plekhanov.httpClient;


import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;

/**
 * //TODO посмотреть все методы
 */
public class CustomHttpClient {

    public static void main(String[] args) {
        final CloseableHttpClient httpClient = HttpClientBuilder.create()
                .build();
    }
}
