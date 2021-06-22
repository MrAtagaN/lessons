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
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.listener.ConcurrentMessageListenerContainer;
import org.springframework.kafka.listener.ContainerProperties;

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
    @Value("${kafka.producer.offsetsCommitRequiredAcks}")
    private String offsetsCommitRequiredAcks;

    //значения по умолчанию, можно переопределить в конфиге
    @Value("${kafka.producer.metadataMaxAge:300000}")
    private String metadataMaxAge;
    @Value("${kafka.producer.sendBufferConfig:131072}")
    private String sendBufferConfig;
    @Value("${kafka.producer.receiveBufferConfig:32768}")
    private String receiveBufferConfig;


    /*************
     * Consumer
     *************/
    @Value("${kafka.consumer.autoCommitIntervalMs}")
    private int autoCommitIntervalMs;
    @Value("${kafka.consumer.sessionTimeoutMs}")
    private int sessionTimeoutMs;
    @Value("${kafka.consumer.pollTimeoutMs}")
    private int pollTimeoutMs;
    @Value("${kafka.consumer.maxPollIntervalMs}")
    private int maxPollIntervalMs;
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
    @Value("${kafka.consumer.isBatchListener}")
    private boolean isBatchListener;
    @Value("${kafka.consumer.ackMode}")
    private ContainerProperties.AckMode ackMode;

    //значения по умолчанию, можно переопределить в конфиге
    @Value("${kafka.consumer.fetchMinBytesConfig:1}")
    private String fetchMinBytesConfig;


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
    private Map<String, Object> producerConfigs() {
        Map<String, Object> props = new HashMap<>();
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapService);
        props.put(ProducerConfig.ACKS_CONFIG, offsetsCommitRequiredAcks);
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

        //TODO проставить параметры
        props.put(ProducerConfig.METADATA_MAX_AGE_CONFIG, metadataMaxAge);
        props.put(ProducerConfig.SEND_BUFFER_CONFIG, sendBufferConfig);
        props.put(ProducerConfig.RECEIVE_BUFFER_CONFIG, receiveBufferConfig);
//        props.put(ProducerConfig.RECONNECT_BACKOFF_MS_CONFIG, requestTimeout);
//        props.put(ProducerConfig.RECONNECT_BACKOFF_MAX_MS_CONFIG, requestTimeout);
//        props.put(ProducerConfig.RETRY_BACKOFF_MS_CONFIG, requestTimeout);
//        props.put(ProducerConfig.METRICS_SAMPLE_WINDOW_MS_CONFIG, requestTimeout);
//        props.put(ProducerConfig.METRICS_NUM_SAMPLES_CONFIG, requestTimeout);
//        props.put(ProducerConfig.METRICS_RECORDING_LEVEL_CONFIG, requestTimeout);
//        props.put(ProducerConfig.METRIC_REPORTER_CLASSES_CONFIG, requestTimeout);
//        props.put(ProducerConfig.CONNECTIONS_MAX_IDLE_MS_CONFIG, requestTimeout);
//        props.put(ProducerConfig.COMPRESSION_TYPE_CONFIG, requestTimeout);
//        props.put(ProducerConfig.MAX_IN_FLIGHT_REQUESTS_PER_CONNECTION, requestTimeout);
//        props.put(ProducerConfig.PARTITIONER_CLASS_CONFIG, requestTimeout);
//        props.put(ProducerConfig.INTERCEPTOR_CLASSES_CONFIG, requestTimeout);
//        props.put(ProducerConfig.ENABLE_IDEMPOTENCE_CONFIG, requestTimeout);
//        props.put(ProducerConfig.TRANSACTION_TIMEOUT_CONFIG, requestTimeout);
//        props.put(ProducerConfig.TRANSACTIONAL_ID_CONFIG, requestTimeout);
        securityConfig(props);
        return props;
    }


    @Bean("kafkaTemplate_1")
    public KafkaTemplate<String, String> kafkaTemplate() {
        return new KafkaTemplate<>(new DefaultKafkaProducerFactory<>(producerConfigs()));
    }


    /*************
     * Consumer
     *************/
    private Map<String, Object> consumerConfigs() {
        Map<String, Object> props = new HashMap<>();
        props.put(ConsumerConfig.GROUP_ID_CONFIG, consumerGroupId);
        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapService);
        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        props.put(ConsumerConfig.MAX_POLL_INTERVAL_MS_CONFIG, maxPollIntervalMs);
        props.put(ConsumerConfig.AUTO_COMMIT_INTERVAL_MS_CONFIG, autoCommitIntervalMs);
        props.put(ConsumerConfig.SESSION_TIMEOUT_MS_CONFIG, sessionTimeoutMs);
        props.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, enableAutoCommit);
        props.put(ConsumerConfig.MAX_POLL_RECORDS_CONFIG, maxPollRecords);
        props.put(ConsumerConfig.HEARTBEAT_INTERVAL_MS_CONFIG, heartbeatIntervalMs);
        props.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, autoOffsetReset);

        //TODO проставить параметры
       // props.put(ConsumerConfig.PARTITION_ASSIGNMENT_STRATEGY_CONFIG, partitionAssigmentStrategyConfig);
        props.put(ConsumerConfig.FETCH_MIN_BYTES_CONFIG, fetchMinBytesConfig);
//        props.put(ConsumerConfig.FETCH_MAX_BYTES_CONFIG, autoOffsetReset);
//        props.put(ConsumerConfig.FETCH_MAX_WAIT_MS_CONFIG, autoOffsetReset);
//        props.put(ConsumerConfig.METADATA_MAX_AGE_CONFIG, autoOffsetReset);
//        props.put(ConsumerConfig.MAX_PARTITION_FETCH_BYTES_CONFIG, autoOffsetReset);
//        props.put(ConsumerConfig.SEND_BUFFER_CONFIG, autoOffsetReset);
//        props.put(ConsumerConfig.RECEIVE_BUFFER_CONFIG, autoOffsetReset);
//        props.put(ConsumerConfig.CLIENT_ID_CONFIG, autoOffsetReset);
//        props.put(ConsumerConfig.RECONNECT_BACKOFF_MS_CONFIG, autoOffsetReset);
//        props.put(ConsumerConfig.RECONNECT_BACKOFF_MAX_MS_CONFIG, autoOffsetReset);
//        props.put(ConsumerConfig.RETRY_BACKOFF_MS_CONFIG, autoOffsetReset);
//        props.put(ConsumerConfig.METRICS_SAMPLE_WINDOW_MS_CONFIG, autoOffsetReset);
//        props.put(ConsumerConfig.METRICS_NUM_SAMPLES_CONFIG, autoOffsetReset);
//        props.put(ConsumerConfig.METRICS_RECORDING_LEVEL_CONFIG, autoOffsetReset);
//        props.put(ConsumerConfig.METRIC_REPORTER_CLASSES_CONFIG, autoOffsetReset);
//        props.put(ConsumerConfig.CHECK_CRCS_CONFIG, autoOffsetReset);
//        props.put(ConsumerConfig.CONNECTIONS_MAX_IDLE_MS_CONFIG, autoOffsetReset);
//        props.put(ConsumerConfig.REQUEST_TIMEOUT_MS_CONFIG, autoOffsetReset);
//        props.put(ConsumerConfig.INTERCEPTOR_CLASSES_CONFIG, autoOffsetReset);
//        props.put(ConsumerConfig.EXCLUDE_INTERNAL_TOPICS_CONFIG, autoOffsetReset);
//        props.put(ConsumerConfig.ISOLATION_LEVEL_CONFIG, autoOffsetReset);
//        props.put(ConsumerConfig.DEFAULT_ISOLATION_LEVEL, autoOffsetReset);


        securityConfig(props);
        return props;
    }


    @Bean("ListenerContainerFactory_1")
    public KafkaListenerContainerFactory<ConcurrentMessageListenerContainer<Object, Object>> kafkaListenerContainerFactory(ConsumerFactory<Object, Object> consumerFactory) {
        ConcurrentKafkaListenerContainerFactory<Object, Object> factory = new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(new DefaultKafkaConsumerFactory<>(consumerConfigs()));
        factory.setConcurrency(threads);
        factory.getContainerProperties().setAckMode(ackMode);
        factory.getContainerProperties().setPollTimeout(pollTimeoutMs);
        factory.setBatchListener(isBatchListener);
        return factory;
    }


    /*************
     * Security
     *************/
    private void securityConfig(Map<String, Object> props) {
        if (isEnableKerberos) {
            props.put(CommonClientConfigs.SECURITY_PROTOCOL_CONFIG, kerberosProtocol);
            props.put(SaslConfigs.SASL_KERBEROS_SERVICE_NAME, kerberosServiceName);
        }
        if (isEnabledSsl) {
            props.put(CommonClientConfigs.SECURITY_PROTOCOL_CONFIG, sslProtocol);
            props.put(SslConfigs.SSL_TRUSTSTORE_LOCATION_CONFIG, sslTruststoreLocation);
            props.put(SslConfigs.SSL_TRUSTSTORE_PASSWORD_CONFIG, sslTruststorePassword);
            props.put(SslConfigs.SSL_KEYSTORE_LOCATION_CONFIG, sslKeystoreLocation);
            props.put(SslConfigs.SSL_KEYSTORE_PASSWORD_CONFIG, sslKeystorePass);
            if (sslKeyPassword != null && !sslKeyPassword.isEmpty()) {
                props.put(SslConfigs.SSL_KEY_PASSWORD_CONFIG, sslKeyPassword);
            }
        }
    }

}
