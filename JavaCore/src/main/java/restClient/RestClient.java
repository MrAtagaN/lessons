package restClient;

import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;


public class RestClient {

    RestTemplate restTemplate = new RestTemplate();


    public ResponseEntity<String> get(String url, Map<String, List<String>> headers) {
        HttpHeaders httpHeaders = new HttpHeaders();

        // Добавляем заголовки в httpHeaders
        if (headers != null) {
            headers.forEach( (nameValue, values) -> {
                values.forEach(value -> {
                    httpHeaders.add(nameValue, value);
                });
            });
        }

        ResponseEntity<String> responseEntity = restTemplate.getForEntity(url, String.class, httpHeaders);

        System.out.println("StatusCode: " + responseEntity.getStatusCode());
        System.out.println("HttpHeaders: " + responseEntity.getHeaders());
        System.out.println("Body: " + responseEntity.getBody());
        return responseEntity;
    }


}
