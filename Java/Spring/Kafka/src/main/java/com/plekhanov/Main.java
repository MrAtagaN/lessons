package com.plekhanov;

import com.plekhanov.service.KafkaProducer;
import org.apache.kafka.clients.CommonClientConfigs;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.config.SslConfigs;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.listener.config.ContainerProperties;

/**
 * Доки:
 * https://docs.spring.io/spring-kafka/docs/current/reference/pdf/spring-kafka-reference.pdf
 * https://docs.spring.io/spring-kafka/docs/current/reference/html/#reference
 *
 * Описание параметров и дефолтные значения в исходном коде:
 * {@link ConsumerConfig}
 * {@link ContainerProperties}
 * {@link CommonClientConfigs}
 * {@link ProducerConfig}
 * {@link SslConfigs}
 *
 * ================================================================================
 * acks
 *
 *
 * ================================================================================
 *
 * Для запуска Kafka в контейнере Docker выполнить первый шаг:
 * https://docs.confluent.io/current/quickstart/ce-docker-quickstart.html
 *
 * Для просмотра сообщений в Kafka можно использовать клиент Kafka Tool:
 * https://www.kafkatool.com/
 * при подключении во вкладке advanced, в поле bootstrap servers указать:  localhost:29092,localhost:9092
 *
 * TODO проверить следующую ссылку
 * https://hub.docker.com/r/bitnami/kafka/
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
