package com.plekhanov.httpClient;

import org.apache.http.HttpHeaders;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.ssl.SSLContextBuilder;
import org.apache.http.ssl.SSLContexts;

import javax.net.ssl.SSLContext;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;

/**
 * https://www.baeldung.com/apache-httpclient-tls
 */
public class TLSVersion {

    private static SSLConnectionSocketFactory sslsf;
    private static String trustStorePath = "";
    private static String trustStorePasword = "";

    public static void main(String[] args) {
        prepareHttpClient();
        CloseableHttpClient httpClient = client();
    }


    private static void prepareHttpClient() {
        try (final FileInputStream fileInputStream = new FileInputStream(new File(trustStorePath))) {
            KeyStore truststore = KeyStore.getInstance(KeyStore.getDefaultType());
            truststore.load(fileInputStream, trustStorePasword.toCharArray());
            System.out.println("Https client truststore created.");

            final SSLContext sslContext = new SSLContextBuilder()
                    .loadTrustMaterial(truststore, (certificate, authType) -> true)
                    .build();
            sslsf = new SSLConnectionSocketFactory(
                    sslContext,
                    new String[]{"TLSv1.2"},
                    null,
                    SSLConnectionSocketFactory.getDefaultHostnameVerifier());
        } catch (CertificateException | KeyStoreException | NoSuchAlgorithmException | KeyManagementException | IOException e) {
            System.out.println("Exception when loading truststore: " + e.getMessage());
        }
    }

    private static CloseableHttpClient client() {
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
