package com.plekhanov;

import com.plekhanov.service.KafkaProducer;
import org.apache.kafka.clients.CommonClientConfigs;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.config.SslConfigs;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.annotation.EnableKafka;


/**
 * Автоконфигурация kafka в spring-boot
 *
 * ====================================================
 * Параметры указываются в application.yaml, они передаются в KafkaClient
 * {@link ConsumerConfig}
 * {@link CommonClientConfigs}
 * {@link ProducerConfig}
 * {@link SslConfigs}
 *
 * Описание параметров автоконфигурации в исходном коде:
 * {@link KafkaProperties}
 * Произвольные параметры нужно указывать в properties
 *
 * Описание параметров автоконфигурации страница 480
 * https://docs.spring.io/spring-boot/docs/current/reference/pdf/spring-boot-reference.pdf
 *
 * ====================================================
 *
 * Запуск Kafka сервера:
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
    @Bean
    public CommandLineRunner commandLineRunner(ApplicationContext context) {
        return (args) -> {
            context.getBean(KafkaProducer.class).send("{\n" +
                    "  \"messageId\" : 163017,\n" +
                    "  \"messageName\" : \"ESB_FS_HANDLER_REQ\",\n" +
                    "  \"userChannel\" : \"SBERBANK_MESSENGER\",\n" +
                    "  \"nextSystem\" : \"UNDEFINED\",\n" +
                    " \"handlerName\" : \"ESB_FS_HANDLER\",\n" +
                    "  \"uuid\" : {\n" +
                    "    \"userChannel\" : \"SBERBANK_MESSENGER\",\n" +
                    "    \"userId\" : \"32\",\n" +
                    "    \"chatId\" : \"96221\"\n" +
                    "  },\n" +
                    "  \"payload\" : {\n" +
                    "  }\n" +
                    "}") ;
        };
    }
}
