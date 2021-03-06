package com.plekhanov;

import org.apache.kafka.clients.CommonClientConfigs;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.config.SslConfigs;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.kafka.annotation.*;
import org.springframework.kafka.listener.ContainerProperties;


/**
 * Доки spring-kafka:
 * https://docs.spring.io/spring-kafka/docs/current/reference/pdf/spring-kafka-reference.pdf
 * https://docs.spring.io/spring-kafka/docs/current/reference/html/#reference
 *
 * Kafka в spring-boot страница 187
 * https://docs.spring.io/spring-boot/docs/current/reference/pdf/spring-boot-reference.pdf
 *
 * ===============================================================================
 * Описание параметров и дефолтные значения в исходном коде:
 * {@link KafkaProperties}
 * {@link ConsumerConfig}
 * {@link ContainerProperties}
 * {@link CommonClientConfigs}
 * {@link ProducerConfig}
 * {@link SslConfigs}
 *
 * ================================================================================
 *  {@link EnableKafka} -
 *  {@link EnableKafkaStreams} -
 *  {@link KafkaHandler} -
 *  {@link KafkaListener} -
 *  {@link KafkaListeners} -
 *  {@link PartitionOffset} -
 *  {@link TopicPartition} -
 *
 * ================================================================================
 *
 */
@EnableKafka
@SpringBootApplication
public class Main {

    public static void main(String[] args) {
        ConfigurableApplicationContext run = new SpringApplicationBuilder(Main.class)
                .web(WebApplicationType.NONE)
                .run(args);
       // System.exit(SpringApplication.exit(run));
    }

    /**
     * Выполнение при старте приложения
     */
//    @Bean
//    public CommandLineRunner commandLineRunner(ApplicationContext context) {
//        return (args) -> {
//            context.getBean(KafkaProducer.class).send("{\n" +
//                    "  \"messageId\" : 163017,\n" +
//                    "  \"messageName\" : \"ESB_FS_HANDLER_REQ\",\n" +
//                    "  \"userChannel\" : \"SBERBANK_MESSENGER\",\n" +
//                    "  \"nextSystem\" : \"UNDEFINED\",\n" +
//                    " \"handlerName\" : \"ESB_FS_HANDLER\",\n" +
//                    "  \"uuid\" : {\n" +
//                    "    \"userChannel\" : \"SBERBANK_MESSENGER\",\n" +
//                    "    \"userId\" : \"32\",\n" +
//                    "    \"chatId\" : \"96221\"\n" +
//                    "  },\n" +
//                    "  \"payload\" : {\n" +
//                    "  }\n" +
//                    "}") ;
//        };
//    }
}
