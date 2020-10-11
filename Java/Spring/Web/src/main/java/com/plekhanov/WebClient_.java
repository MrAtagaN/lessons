package com.plekhanov;


import org.springframework.web.reactive.function.client.WebClient;

/**
 * https://www.baeldung.com/spring-5-webclient
 *
 */
public class WebClient_ {

    public static void main(String[] args) {
        WebClient client = WebClient.create();
    }
}
