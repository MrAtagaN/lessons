package com.plekhanov;

import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.TrustStrategy;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import javax.net.ssl.SSLContext;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.X509Certificate;


/**
 * Методы restTemplate:
 *
 *
 *
 * Методы responseEntity:
 *
 *
 */
public class RestTemplateApi {

    public static void main(String[] args) throws NoSuchAlgorithmException, KeyStoreException, KeyManagementException {

        RestTemplate restTemplate = restTemplate();

        ResponseEntity<String> responseEntity = restTemplate.getForEntity("https://postman-echo.com/get?foo1=bar1&foo2=bar2", String.class);
        log(responseEntity);
        ResponseEntity<String> responseEntity2 = restTemplate.postForEntity("https://postman-echo.com/post", "TEST BODY", String.class);
        log(responseEntity2);
    }


    private static void log(ResponseEntity<String> responseEntity) {
        System.out.println("StatusCode: " + responseEntity.getStatusCode());
        System.out.println("HttpHeaders: " + responseEntity.getHeaders());
        System.out.println("Body: " + responseEntity.getBody());
    }



    /**
     * RestTemplate доверяющий всем сертификатам. Нужен для тестирования
     */
    private static RestTemplate restTemplate()
            throws KeyStoreException, NoSuchAlgorithmException, KeyManagementException {
        TrustStrategy acceptingTrustStrategy = (X509Certificate[] chain, String authType) -> true;

        SSLContext sslContext = org.apache.http.ssl.SSLContexts.custom()
                .loadTrustMaterial(null, acceptingTrustStrategy)
                .build();

        SSLConnectionSocketFactory csf = new SSLConnectionSocketFactory(sslContext);

        CloseableHttpClient httpClient = HttpClients.custom()
                .setSSLSocketFactory(csf)
                .build();

        HttpComponentsClientHttpRequestFactory requestFactory = new HttpComponentsClientHttpRequestFactory();

        requestFactory.setHttpClient(httpClient);
        return new RestTemplate(requestFactory);

    }
}
