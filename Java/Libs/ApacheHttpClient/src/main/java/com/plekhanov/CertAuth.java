package com.plekhanov;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.TrustStrategy;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.ssl.SSLContextBuilder;

import javax.net.ssl.SSLContext;
import java.io.IOException;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.X509Certificate;
import java.util.Arrays;

/**
 * https://www.baeldung.com/httpclient-ssl
 *
 * Запрос доверяющий всем сертификатам. Нужен для тестирования
 */
public class CertAuth {
    private static final String GET_URL = "https://postman-echo.com/get?foo1=bar1&foo2=bar2";


    public static void main(String[] args) throws NoSuchAlgorithmException, KeyStoreException, KeyManagementException, IOException {
        final CloseableHttpClient httpClient = getRestTemplateWithAuth();
        final HttpGet httpGet = new HttpGet(GET_URL);
        CloseableHttpResponse response = httpClient.execute(httpGet);


        System.out.println("StatusCode: " + response.getStatusLine());
        Arrays.stream(response.getAllHeaders())
                .forEach(header -> { System.out.println("Header name: "+header.getName() + ", value: " + header.getValue()); });
        System.out.println("Body: " + response.getEntity());
    }


    /**
     * Возвращает CloseableHttpClient доверяющий всем сертификатам. Нужен для тестирования
     */
    private static CloseableHttpClient getRestTemplateWithAuth() throws KeyStoreException, NoSuchAlgorithmException, KeyManagementException {
        final TrustStrategy acceptingTrustStrategy = (X509Certificate[] chain, String authType) -> true;

        final SSLContext sslContext = SSLContextBuilder.create()
                .loadTrustMaterial(null, acceptingTrustStrategy)
                .build();

        final SSLConnectionSocketFactory connectionSocketFactory = new SSLConnectionSocketFactory(sslContext, NoopHostnameVerifier.INSTANCE);

        return HttpClientBuilder.create()
                .setSSLSocketFactory(connectionSocketFactory)
                .build();

    }
}
