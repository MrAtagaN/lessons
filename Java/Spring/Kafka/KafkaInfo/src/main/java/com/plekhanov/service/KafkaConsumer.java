package com.plekhanov.service;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
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







//    /*************************
//     * Examples
//     ************************/
//
//
//    /*********************************
//     * Explicit Partition Assignment
//     *********************************/
//    @KafkaListener(id = "thing2", topicPartitions =
//            {@TopicPartition(topic = "topic1", partitions = {"0", "1"}),
//             @TopicPartition(topic = "topic2", partitions = "0", partitionOffsets = @PartitionOffset(partition = "1", initialOffset = "100"))})
//    public void listen(ConsumerRecord<?, ?> record) { }
//
//
//    @KafkaListener(id = "thing3", topicPartitions =
//            {@TopicPartition(topic = "topic1", partitions = {"0", "1"}, partitionOffsets = @PartitionOffset(partition = "*", initialOffset = "0"))})
//    public void listen2(ConsumerRecord<?, ?> record) {}
//
//
//    @KafkaListener(id = "pp", autoStartup = "false", topicPartitions =
//            @TopicPartition(topic = "topic1", partitions = "0-5, 7, 10-15"))
//    public void process(String in) {}
//
//
//    @KafkaListener(id = "thing3", topicPartitions =
//            {@TopicPartition(topic = "topic1", partitionOffsets = @PartitionOffset(partition = "0-5", initialOffset = "0"))})
//    public void listen3(ConsumerRecord<?, ?> record) {}
//
//
//    /*************************
//     * Manual Acknowledgment
//     ************************/
//    @KafkaListener(id = "cat", topics = "myTopic", containerFactory = "kafkaManualAckListenerContainerFactory")
//    public void listen(String data, Acknowledgment ack) {
//        //
//        ack.acknowledge();
//    }
//
//
//    /*************************
//     * Record Metadata
//     ************************/
//    @KafkaListener(id = "qux", topicPattern = "myTopic1")
//    public void listen(@Payload String foo,
//                       @Header(name = KafkaHeaders.RECEIVED_MESSAGE_KEY, required = false)
//                               Integer key,
//                       @Header(KafkaHeaders.RECEIVED_PARTITION_ID) int partition,
//                       @Header(KafkaHeaders.RECEIVED_TOPIC) String topic,
//                       @Header(KafkaHeaders.RECEIVED_TIMESTAMP) long ts
//    ) {}
//
//
//    @KafkaListener(id = "qux", topicPattern = "myTopic1")
//    public void listen(String str, ConsumerRecordMetadata meta) {}


}
