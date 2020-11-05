package libs.restClient;

import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.TrustStrategy;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import javax.net.ssl.SSLContext;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.X509Certificate;
import java.util.List;
import java.util.Map;


public class RestClient {

    private RestTemplate restTemplate = new RestTemplate();
    private HttpHeaders httpHeaders = new HttpHeaders();


    /**
     * Get request
     */
    public ResponseEntity<String> get(String url, Map<String, List<String>> headers) {
        if (headers == null) {
            headers = this.httpHeaders;
        }
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(url, String.class, headers);
        log(responseEntity);
        return responseEntity;
    }


    /**
     * Post request
     */
    public ResponseEntity<String> post(String url, String body, Map<String, List<String>> headers) {
        if (headers == null) {
            headers = this.httpHeaders;
        }
        ResponseEntity<String> responseEntity = restTemplate.postForEntity(url, body, String.class, headers);
        log(responseEntity);
        return responseEntity;

    }


    /**
     * Add headers to another headers
     *
     * @param headers     headers to add
     * @param httpHeaders target headers
     */
    public void addHeaders(Map<String, List<String>> headers, HttpHeaders httpHeaders) {
        if (headers != null && httpHeaders != null) {
            headers.forEach((nameValue, values) -> {
                values.forEach(value -> {
                    httpHeaders.add(nameValue, value);
                });
            });
        }
    }


    private void log(ResponseEntity<String> responseEntity) {
        System.out.println("StatusCode: " + responseEntity.getStatusCode());
        System.out.println("HttpHeaders: " + responseEntity.getHeaders());
        System.out.println("Body: " + responseEntity.getBody());
    }


    /**
     * RestTemplate доверяющий всем сертификатам
     */
    public RestTemplate restTemplate()
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
