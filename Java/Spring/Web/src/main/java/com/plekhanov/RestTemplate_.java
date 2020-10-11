package com.plekhanov;

import org.apache.http.client.config.RequestConfig;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.TrustStrategy;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.ssl.SSLContextBuilder;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import javax.net.ssl.SSLContext;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.X509Certificate;
import java.util.Set;


/**
 * https://www.baeldung.com/rest-template
 *
 * Методы restTemplate:
 *
 * Методы responseEntity:
 */
public class RestTemplate_ {

    public static void main(String[] args) throws NoSuchAlgorithmException, KeyStoreException, KeyManagementException {

        String postUrl = "https://postman-echo.com/post";
        String getUrl = "https://postman-echo.com/get?foo1=bar1&foo2=bar2";

        RestTemplate restTemplate = getRestTemplateWithAuth();

        ResponseEntity<String> responseEntity = restTemplate.getForEntity(getUrl, String.class);
        log(responseEntity);
        ResponseEntity<String> responseEntity2 = restTemplate.postForEntity(postUrl, "TEST BODY", String.class);
        log(responseEntity2);

        Set<HttpMethod> optionsForAllow = restTemplate.optionsForAllow(postUrl);
        System.out.println(optionsForAllow);

        HttpHeaders httpHeaders = restTemplate.headForHeaders(getUrl);
        System.out.println(httpHeaders);
    }


    private static void log(ResponseEntity<String> responseEntity) {
        System.out.println("StatusCode: " + responseEntity.getStatusCode());
        System.out.println("HttpHeaders: " + responseEntity.getHeaders());
        System.out.println("Body: " + responseEntity.getBody());
    }


    /**
     * RestTemplate доверяющий всем сертификатам. Нужен для тестирования
     */
    private static RestTemplate getRestTemplateWithAuth() throws KeyStoreException, NoSuchAlgorithmException, KeyManagementException {
        final TrustStrategy acceptingTrustStrategy = (X509Certificate[] chain, String authType) -> true;

        final SSLContext sslContext = SSLContextBuilder.create()
                .loadTrustMaterial(null, acceptingTrustStrategy)
                .build();

        final SSLConnectionSocketFactory csf = new SSLConnectionSocketFactory(sslContext);

        final CloseableHttpClient httpClient = HttpClientBuilder.create()
                .setSSLSocketFactory(csf)
                .build();

        final HttpComponentsClientHttpRequestFactory requestFactory = new HttpComponentsClientHttpRequestFactory(httpClient);
        return new RestTemplate(requestFactory);
    }


    private RestTemplate getRestTemplateWithTimeout() {
        int timeout = 5000;
        final RequestConfig config = RequestConfig.custom()
                .setConnectTimeout(timeout)
                .setConnectionRequestTimeout(timeout)
                .setSocketTimeout(timeout)
                .build();
        final CloseableHttpClient httpClient = HttpClientBuilder.create()
                .setDefaultRequestConfig(config)
                .build();
        final HttpComponentsClientHttpRequestFactory requestFactory = new HttpComponentsClientHttpRequestFactory(httpClient);
        return new RestTemplate(requestFactory);
    }
}
