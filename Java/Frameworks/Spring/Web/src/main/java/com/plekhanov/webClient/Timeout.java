package com.plekhanov.webClient;


import io.netty.channel.ChannelOption;
import io.netty.handler.timeout.ReadTimeoutHandler;
import io.netty.handler.timeout.WriteTimeoutHandler;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import reactor.netty.http.client.HttpClient;
import reactor.netty.tcp.TcpClient;

import java.util.concurrent.TimeUnit;

/**
 * https://www.baeldung.com/spring-5-webclient
 * https://docs.spring.io/spring-framework/docs/5.3.0-SNAPSHOT/spring-framework-reference/web-reactive.html#webflux-client
 * https://vk.com/@javatutorial-shpargalka-po-spring-boot-webclient
 *
 * WebClient with Timeout
 */
public class Timeout {

    private static final String BASE_URL = "https://google.com";
    public static final int TIMEOUT = 1000;

    public static void main(String[] args) {
        WebClient webClient = getWebClient();

        Mono<String> mono = webClient.get()
                .uri("/maps")
                .retrieve()
                .bodyToMono(String.class);

        System.out.println(mono.block());

    }



    public static WebClient getWebClient() {
        TcpClient tcpClient = TcpClient
                .create()
                .option(ChannelOption.CONNECT_TIMEOUT_MILLIS, TIMEOUT)
                .doOnConnected(connection -> {
                    connection.addHandlerLast(new ReadTimeoutHandler(TIMEOUT, TimeUnit.MILLISECONDS));
                    connection.addHandlerLast(new WriteTimeoutHandler(TIMEOUT, TimeUnit.MILLISECONDS));
                });

        return WebClient.builder()
                .baseUrl(BASE_URL)
                .clientConnector(new ReactorClientHttpConnector(HttpClient.from(tcpClient)))
                .build();
    }

}
