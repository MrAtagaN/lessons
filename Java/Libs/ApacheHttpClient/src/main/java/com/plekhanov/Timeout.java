package com.plekhanov;

import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;

import java.io.IOException;
import java.util.Arrays;

/**
 * Запрос с временем ожидания
 */
public class Timeout {

    private static final String GET_URL = "https://10.10.10.10/";


    public static void main(String[] args) throws IOException {
        final CloseableHttpClient httpClient = getHttpClientWithTimeout();

        final HttpGet httpGet = new HttpGet(GET_URL);
        final CloseableHttpResponse response = httpClient.execute(httpGet);


        System.out.println("StatusCode: " + response.getStatusLine());
        Arrays.stream(response.getAllHeaders())
                .forEach(header -> { System.out.println("Header name: "+header.getName() + ", value: " + header.getValue()); });
        System.out.println("Body: " + response.getEntity());
    }


    /**
     * Возвращает CloseableHttpClient с временем ожидания
     */
    private static CloseableHttpClient getHttpClientWithTimeout() {
        int timeout = 5000;
        final RequestConfig config = RequestConfig.custom()
                .setConnectTimeout(timeout)
                .setConnectionRequestTimeout(timeout)
                .setSocketTimeout(timeout)
                .build();
        return HttpClientBuilder.create()
                .setDefaultRequestConfig(config)
                .build();
    }
}
