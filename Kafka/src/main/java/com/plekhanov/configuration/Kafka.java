package com.plekhanov.configuration;


import kafka.tools.ConsoleProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class Kafka {

    /*************
     * Producer
     *************/
    @Value("${kafka.bootstrapService}")
    private String bootstrapService;
    @Value("${kafka.producer.blockTimeMs}")
    private String blockTimeMs;
    @Value("${kafka.producer.producerGroupId}")
    private String producerGroupId;
    @Value("${kafka.producer.requestTimeout}")
    private String requestTimeout;
    @Value("${kafka.producer.batchSize}")
    private String batchSize;
    @Value("${kafka.producer.lingerMs}")
    private String lingerMs;
    @Value("${kafka.producer.maxRequestSize}")
    private String maxRequestSize;
    @Value("${kafka.producer.bufferMemory}")
    private String bufferMemory;
    @Value("${kafka.producer.retries}")
    private String retries;





    @Bean
    public Map<String, Object> producerConfigs() {
        Map<String, Object> props = new HashMap<>();
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,bootstrapService);
        props.put(ProducerConfig.BATCH_SIZE_CONFIG,batchSize);
        props.put(ProducerConfig.LINGER_MS_CONFIG,lingerMs);
        props.put(ProducerConfig.CLIENT_ID_CONFIG, producerGroupId);
        props.put(ProducerConfig.MAX_REQUEST_SIZE_CONFIG,maxRequestSize);
        props.put(ProducerConfig.MAX_BLOCK_MS_CONFIG,blockTimeMs);
        props.put(ProducerConfig.BUFFER_MEMORY_CONFIG,bufferMemory);
        props.put(ProducerConfig.RETRIES_CONFIG,retries);
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,StringSerializer.class);
        props.put(ProducerConfig.REQUEST_TIMEOUT_MS_CONFIG,requestTimeout);

        return props;
    }

    @Bean
    public ProducerFactory<String, String> producerFactory() {
        return new DefaultKafkaProducerFactory<>(producerConfigs());
    }

    @Bean("kafkaTemplate")
    public KafkaTemplate<String, String> kafkaTemplate() {
        return new KafkaTemplate<>(producerFactory());
    }





















}
