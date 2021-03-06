package com.plekhanov.httpClient;

import org.apache.http.HttpHeaders;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.ssl.SSLContextBuilder;

import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;

/**
 * https://www.baeldung.com/apache-httpclient-tls
 * https://stackoverflow.com/questions/1666052/java-https-client-certificate-authentication
 *
 * Проверка сертификатов сервера
 *
 * javax.net.debug=ssl
 * javax.net.ssl.keyStoreType=pkcs12
 * javax.net.ssl.keyStore=client.p12
 * javax.net.ssl.keyStorePassword=whatever
 * javax.net.ssl.trustStoreType=jks
 * javax.net.ssl.trustStore=client-truststore.jks
 * javax.net.ssl.trustStorePassword=whatever
 */
public class SSL {

    private static String trustStorePath = "";
    private static String trustStorePassword = "";

    public static void main(String[] args) throws NoSuchAlgorithmException, KeyManagementException {
        CloseableHttpClient httpClient = sslClient();
    }



    private static CloseableHttpClient sslClient() throws KeyManagementException, NoSuchAlgorithmException {
        System.setProperty("javax.net.ssl.trustStore", trustStorePath);
        System.setProperty("javax.net.ssl.trustStorePassword", trustStorePassword);

        final SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(
                new SSLContextBuilder().build(),
                new String[]{"TLSv1.2"},
                null,
                SSLConnectionSocketFactory.getDefaultHostnameVerifier());

        return HttpClients.custom()
                .setSSLSocketFactory(sslsf)
                .setDefaultRequestConfig(RequestConfig.custom()
                        .setConnectTimeout(3000)
                        .setConnectionRequestTimeout(3000)
                        .setSocketTimeout(3000)
                        .build())
                .build();
    }



    private static HttpGet createGet(String url) {
        HttpGet httpGet = new HttpGet(url);
        httpGet.setHeader(HttpHeaders.CONTENT_TYPE, "application/json");
        httpGet.setHeader("X-Requested-With", "rest");
        httpGet.setHeader(HttpHeaders.CACHE_CONTROL, "no-cache");
        return httpGet;
    }

    private static HttpPost createPost(String url) {
        HttpPost httpPost = new HttpPost(url);
        httpPost.setHeader(HttpHeaders.CONTENT_TYPE, "application/json");
        httpPost.setHeader("X-Requested-With", "rest");
        httpPost.setHeader(HttpHeaders.CACHE_CONTROL, "no-cache");
        return httpPost;
    }
}
