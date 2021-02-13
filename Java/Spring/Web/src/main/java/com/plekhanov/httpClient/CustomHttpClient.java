package com.plekhanov.httpClient;


import org.apache.http.HttpHost;
import org.apache.http.conn.routing.HttpRoute;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;


/**
 * //TODO посмотреть все методы
 *
 * Методы {@link HttpClientBuilder}:
 *
 */
public class CustomHttpClient {

    public static void main(String[] args) {

        //PoolingHttpClientConnectionManager
        final PoolingHttpClientConnectionManager connManager = new PoolingHttpClientConnectionManager();
        connManager.setMaxTotal(5);
        connManager.setDefaultMaxPerRoute(4);
        final HttpHost host = new HttpHost("www.baeldung.com", 80);
        connManager.setMaxPerRoute(new HttpRoute(host), 5);


        final CloseableHttpClient httpClient = HttpClientBuilder.create()
                .setConnectionManager(connManager)
                .build();
    }
}
