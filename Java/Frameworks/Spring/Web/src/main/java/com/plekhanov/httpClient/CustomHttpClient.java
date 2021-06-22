package com.plekhanov.httpClient;


import org.apache.http.HeaderElement;
import org.apache.http.HeaderElementIterator;
import org.apache.http.HttpHost;
import org.apache.http.conn.ConnectionKeepAliveStrategy;
import org.apache.http.conn.routing.HttpRoute;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.message.BasicHeaderElementIterator;
import org.apache.http.protocol.HTTP;


/**
 * //TODO посмотреть все методы
 *
 * Методы {@link HttpClientBuilder}:
 *
 */
public class CustomHttpClient {

    public static void main(String[] args) {

        //настройка PoolingHttpClientConnectionManager
        final PoolingHttpClientConnectionManager connManager = new PoolingHttpClientConnectionManager();
        connManager.setMaxTotal(5);
        connManager.setDefaultMaxPerRoute(4);
        final HttpHost host = new HttpHost("www.baeldung.com", 80);
        connManager.setMaxPerRoute(new HttpRoute(host), 5);

        //настройка ConnectionKeepAliveStrategy
        final ConnectionKeepAliveStrategy myStrategy = (response, context) -> {
            final HeaderElementIterator it = new BasicHeaderElementIterator(response.headerIterator(HTTP.CONN_KEEP_ALIVE));
            while (it.hasNext()) {
                final HeaderElement header = it.nextElement();
                final String param = header.getName();
                final String value = header.getValue();
                if (value != null && param.equalsIgnoreCase("timeout")) {
                    return Long.parseLong(value) * 1000;
                }
            }
            return 5 * 1000;
        };


        final CloseableHttpClient httpClient = HttpClientBuilder.create()
                .setConnectionManager(connManager)
                .setKeepAliveStrategy(myStrategy)
                .build();
    }
}
