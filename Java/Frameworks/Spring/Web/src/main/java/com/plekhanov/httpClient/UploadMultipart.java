package com.plekhanov.httpClient;


import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.HttpMultipartMode;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.entity.mime.content.StringBody;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;

import java.io.File;
import java.io.IOException;

/**
 * https://www.baeldung.com/httpclient-multipart-upload
 *
 * //TODO дописать
 */
public class UploadMultipart {

    public static void main(String[] args) throws IOException {
        final CloseableHttpClient httpClient = HttpClientBuilder.create()
                .build();

        File file = new File("README.md");
        HttpPost post = new HttpPost("http://www.postman.com/");
        FileBody fileBody = new FileBody(file, ContentType.DEFAULT_BINARY);
        StringBody stringBody1 = new StringBody("Message 1", ContentType.MULTIPART_FORM_DATA);
        StringBody stringBody2 = new StringBody("Message 2", ContentType.MULTIPART_FORM_DATA);

        MultipartEntityBuilder builder = MultipartEntityBuilder.create();
        builder.setMode(HttpMultipartMode.BROWSER_COMPATIBLE);
        builder.addPart("upfile", fileBody);
        builder.addPart("text1", stringBody1);
        builder.addPart("text2", stringBody2);
        HttpEntity entity = builder.build();

        post.setEntity(entity);
        HttpResponse response = httpClient.execute(post);
    }
}
