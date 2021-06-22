package com.plekhanov.httpClient;

import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.TrustStrategy;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.ssl.SSLContextBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import javax.net.ssl.SSLContext;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.X509Certificate;

/**
 * https://www.baeldung.com/httpclient-ssl
 *
 * Запрос доверяющий всем сертификатам. Нужен для тестирования
 */
public class TrustAllCert {
    private static final String GET_URL = "https://postman-echo.com/get?foo1=bar1&foo2=bar2";


    public static void main(String[] args) throws NoSuchAlgorithmException, KeyStoreException, KeyManagementException {
        final RestTemplate restTemplate = getRestTemplateWithAuth();
        final ResponseEntity<String> responseEntity = restTemplate.getForEntity(GET_URL, String.class);

        System.out.println("StatusCode: " + responseEntity.getStatusCode());
        System.out.println("HttpHeaders: " + responseEntity.getHeaders());
        System.out.println("Body: " + responseEntity.getBody());
    }


    /**
     * Возвращает RestTemplate доверяющий всем сертификатам. Нужен для тестирования
     */
    private static RestTemplate getRestTemplateWithAuth() throws KeyStoreException, NoSuchAlgorithmException, KeyManagementException {
        final SSLContext sslContext = SSLContextBuilder.create()
                .loadTrustMaterial(null, (X509Certificate[] chain, String authType) -> true)
                .build();

        final CloseableHttpClient httpClient = HttpClientBuilder.create()
                .setSSLSocketFactory(new SSLConnectionSocketFactory(sslContext, NoopHostnameVerifier.INSTANCE))
                .build();

        final HttpComponentsClientHttpRequestFactory requestFactory = new HttpComponentsClientHttpRequestFactory(httpClient);
        return new RestTemplate(requestFactory);
    }
}
