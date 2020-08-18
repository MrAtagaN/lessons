package com.plekhanov.configuration;


import org.apache.kafka.clients.CommonClientConfigs;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.config.SaslConfigs;
import org.apache.kafka.common.config.SslConfigs;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.config.KafkaListenerContainerFactory;
import org.springframework.kafka.core.*;
import org.springframework.kafka.listener.AbstractMessageListenerContainer;
import org.springframework.kafka.listener.ConcurrentMessageListenerContainer;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class KafkaConfig {

    /*************
     * Producer
     *************/
    @Value("${kafka.bootstrapService}")
    private String bootstrapService;
    @Value("${kafka.producer.blockTimeMs}")
    private String blockTimeMs;
    @Value("${kafka.producer.groupId}")
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

    /*************
     * Consumer
     *************/
    @Value("${kafka.consumer.autoCommitIntervalMs}")
    private int autoCommitIntervalMs;
    @Value("${kafka.consumer.sessionTimeoutMs}")
    private int sessionTimeoutMs;
    @Value("${kafka.consumer.pollTimeMs}")
    private int pollTimeMs;
    @Value("${kafka.consumer.maxPollTimeMs}")
    private int maxPollTimeMs;
    @Value("${kafka.consumer.groupId}")
    private String consumerGroupId;
    @Value("${kafka.consumer.enableAutoCommit}")
    private String enableAutoCommit;
    @Value("${kafka.consumer.threads}")
    private int threads;
    @Value("${kafka.consumer.maxPollRecords}")
    private int maxPollRecords;
    @Value("${kafka.consumer.heartbeatIntervalMs}")
    private int heartbeatIntervalMs;
    @Value("${kafka.consumer.autoOffsetReset}")
    private String autoOffsetReset;


    /*************
     * Security (Kerberos SASL)
     *************/
    @Value("${kafka.security.kerberos.enabled}")
    private boolean isEnableKerberos;
    @Value("${kafka.security.kerberos.protocol}")
    private String kerberosProtocol;
    @Value("${kafka.security.kerberos.serviceName}")
    private String kerberosServiceName;

    /*************
     * Security (SSL)
     *************/
    @Value("${kafka.security.ssl.enabled}")
    private boolean isEnabledSsl;
    @Value("${kafka.security.ssl.security.protocol}")
    private String sslProtocol;
    @Value("${kafka.security.ssl.truststore.location}")
    private String sslTruststoreLocation;
    @Value("${kafka.security.ssl.truststore.password}")
    private String sslTruststorePassword;
    @Value("${kafka.security.ssl.keystore.password}")
    private String sslKeystorePass;
    @Value("${kafka.security.ssl.keystore.location}")
    private String sslKeystoreLocation;
    @Value("${kafka.security.ssl.key.password}")
    private String sslKeyPassword;




    /*************
     * Producer
     *************/
    @Bean
    public Map<String, Object> producerConfigs() {
        Map<String, Object> props = new HashMap<>();
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapService);
        props.put(ProducerConfig.BATCH_SIZE_CONFIG, batchSize);
        props.put(ProducerConfig.LINGER_MS_CONFIG, lingerMs);
        props.put(ProducerConfig.CLIENT_ID_CONFIG, producerGroupId);
        props.put(ProducerConfig.MAX_REQUEST_SIZE_CONFIG, maxRequestSize);
        props.put(ProducerConfig.MAX_BLOCK_MS_CONFIG, blockTimeMs);
        props.put(ProducerConfig.BUFFER_MEMORY_CONFIG, bufferMemory);
        props.put(ProducerConfig.RETRIES_CONFIG, retries);
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        props.put(ProducerConfig.REQUEST_TIMEOUT_MS_CONFIG, requestTimeout);
        if (isEnableKerberos) {
            props.put(CommonClientConfigs.SECURITY_PROTOCOL_CONFIG, kerberosProtocol);
            props.put(SaslConfigs.SASL_KERBEROS_SERVICE_NAME, kerberosServiceName);
        }
        if(isEnabledSsl) {
            props.put(CommonClientConfigs.SECURITY_PROTOCOL_CONFIG, sslProtocol);
            props.put(SslConfigs.SSL_TRUSTSTORE_LOCATION_CONFIG, sslTruststoreLocation);
            props.put(SslConfigs.SSL_TRUSTSTORE_PASSWORD_CONFIG, sslTruststorePassword);
            props.put(SslConfigs.SSL_KEYSTORE_LOCATION_CONFIG, sslKeystoreLocation);
            props.put(SslConfigs.SSL_KEYSTORE_PASSWORD_CONFIG, sslKeystorePass);
            if (sslKeyPassword !=null && !sslKeyPassword.isEmpty()) {
                props.put(SslConfigs.SSL_KEY_PASSWORD_CONFIG, sslKeyPassword);
            }
        }

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


    /*************
     * Consumer
     *************/
    @Bean
    public Map<String, Object> consumerConfigs() {
        Map<String, Object> props = new HashMap<>();
        props.put(ConsumerConfig.GROUP_ID_CONFIG, consumerGroupId);
        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapService);
        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        props.put(ConsumerConfig.MAX_POLL_INTERVAL_MS_CONFIG, maxPollTimeMs);
        props.put(ConsumerConfig.AUTO_COMMIT_INTERVAL_MS_CONFIG, autoCommitIntervalMs);
        props.put(ConsumerConfig.SESSION_TIMEOUT_MS_CONFIG, sessionTimeoutMs);
        props.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, enableAutoCommit);
        props.put(ConsumerConfig.MAX_POLL_RECORDS_CONFIG, maxPollRecords);
        props.put(ConsumerConfig.HEARTBEAT_INTERVAL_MS_CONFIG, heartbeatIntervalMs);
        props.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, autoOffsetReset);
        if (isEnableKerberos) {
            props.put(CommonClientConfigs.SECURITY_PROTOCOL_CONFIG, kerberosProtocol);
            props.put(SaslConfigs.SASL_KERBEROS_SERVICE_NAME, kerberosServiceName);
        }
        if(isEnabledSsl) {
            props.put(CommonClientConfigs.SECURITY_PROTOCOL_CONFIG, sslProtocol);
            props.put(SslConfigs.SSL_TRUSTSTORE_LOCATION_CONFIG, sslTruststoreLocation);
            props.put(SslConfigs.SSL_TRUSTSTORE_PASSWORD_CONFIG, sslTruststorePassword);
            props.put(SslConfigs.SSL_KEYSTORE_LOCATION_CONFIG, sslKeystoreLocation);
            props.put(SslConfigs.SSL_KEYSTORE_PASSWORD_CONFIG, sslKeystorePass);
            if (sslKeyPassword !=null && !sslKeyPassword.isEmpty()) {
                props.put(SslConfigs.SSL_KEY_PASSWORD_CONFIG, sslKeyPassword);
            }
        }
        return props;
    }

    @Bean
    public ConsumerFactory<Object, Object> consumerFactory() {
        return new DefaultKafkaConsumerFactory<>(consumerConfigs());
    }

    @Bean
    public KafkaListenerContainerFactory<ConcurrentMessageListenerContainer<Object, Object>> kafkaListenerContainerFactory() {
        ConcurrentKafkaListenerContainerFactory<Object, Object> factory = new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(consumerFactory());
        factory.setConcurrency(threads);
        factory.getContainerProperties().setAckMode(AbstractMessageListenerContainer.AckMode.BATCH);
        factory.getContainerProperties().setAckOnError(false);
        factory.getContainerProperties().setPollTimeout(pollTimeMs);
        factory.setBatchListener(true);
        return factory;
    }


}
