package restClient;

import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

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
    public ResponseEntity<String> post(String url, String body,  Map<String, List<String>> headers) {
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
     * @param headers headers to add
     * @param httpHeaders target headers
     */
    public void addHeaders(Map<String, List<String>> headers, HttpHeaders httpHeaders) {
        if (headers != null && httpHeaders != null) {
            headers.forEach( (nameValue, values) -> {
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


}
