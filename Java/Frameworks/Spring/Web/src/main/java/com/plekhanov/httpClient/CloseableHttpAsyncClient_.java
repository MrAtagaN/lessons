package com.plekhanov.httpClient;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.nio.client.CloseableHttpAsyncClient;
import org.apache.http.impl.nio.client.HttpAsyncClients;

import java.io.IOException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * https://www.baeldung.com/httpasyncclient-tutorial
 *
 * //TODO дописать
 */
public class CloseableHttpAsyncClient_ {

    public static void main(String[] args) throws ExecutionException, InterruptedException, IOException {
        CloseableHttpAsyncClient client = HttpAsyncClients.createDefault();
        client.start();
        HttpGet request = new HttpGet("http://www.google.com");

        Future<HttpResponse> future = client.execute(request, null);
        HttpResponse response = future.get();
        System.out.println("StatusCode: " + response.getStatusLine().getStatusCode());
        client.close();
    }
}
