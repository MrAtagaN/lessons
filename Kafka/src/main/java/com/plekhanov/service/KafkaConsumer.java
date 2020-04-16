package com.plekhanov.service;


import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KafkaConsumer {

    @KafkaListener(topics = "${kafka.consumer.topic}")
    public void listen(List<ConsumerRecord<String, String>> consumerRecords) {
        consumerRecords.forEach(consumerRecord -> {
            String value = consumerRecord.value();
            System.out.println("Incoming message body: " + value);
        });
    }
}
