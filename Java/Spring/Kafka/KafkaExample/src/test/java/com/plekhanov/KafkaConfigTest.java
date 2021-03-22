package com.plekhanov;


import com.plekhanov.service.KafkaProducer;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.support.SendResult;
import org.springframework.kafka.test.context.EmbeddedKafka;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.concurrent.ListenableFuture;

import java.util.concurrent.ExecutionException;

@RunWith(SpringRunner.class)
@EmbeddedKafka(topics = {"test-topic"}, partitions = 1)
@SpringBootTest
public class KafkaConfigTest {

    public static final String REQUEST_MESSAGE = "{testMessage}";

    @Autowired
    private KafkaProducer kafkaProducer;


    @Test
    public void sendAndReceiveTest() throws ExecutionException, InterruptedException {
        ListenableFuture<SendResult<String, String>> send = kafkaProducer.send(REQUEST_MESSAGE);
        SendResult<String, String> stringStringSendResult = send.get();
        System.out.println("Send Result: "+ stringStringSendResult);

        Thread.sleep(1000);

        Assert.assertNotNull(stringStringSendResult);
    }
}
