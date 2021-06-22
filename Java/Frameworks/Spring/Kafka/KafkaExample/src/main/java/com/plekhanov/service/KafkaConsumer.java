package com.plekhanov.service;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.PartitionOffset;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.kafka.listener.adapter.ConsumerRecordMetadata;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *
 */
@Service
public class KafkaConsumer {

    @KafkaListener(containerFactory = "ListenerContainerFactory_1", topics = "${kafka.consumer.topic}")
    public void listen(List<ConsumerRecord<String, String>> consumerRecords) {
        consumerRecords.forEach(consumerRecord -> {
            String value = consumerRecord.value();
            System.out.println("Incoming message body: " + value);
        });
    }

}
