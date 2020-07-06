package com.plekhanov;

import com.plekhanov.service.KafkaProducer;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

/**
 * Для запуска Kafka в контейнере Docker выполнить первый шаг:
 * https://docs.confluent.io/current/quickstart/ce-docker-quickstart.html
 *
 * Для просмотра сообщений в Kafka можно использовать клиент Kafka Tool:
 * https://www.kafkatool.com/
 * при подключении во вкладке advanced, в поле bootstrap servers указать:  localhost:29092,localhost:9092
 */
@SpringBootApplication
public class Main {

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    /**
     * Выполнение при старте приложения
     */
    @Bean
    public CommandLineRunner commandLineRunner(ApplicationContext context) {
        return (args) -> {
            context.getBean(KafkaProducer.class).send("{\n" +
                    "  \"messageId\" : 10000001,\n" +
                    "  \"messageName\" : \"ESB_FS_HANDLER_REQ\",\n" +
                    "  \"userChannel\" : \"SBERBANK\",\n" +
                    "  \"nextSystem\" : \"UNDEFINED\",\n" +
                    "  \"handlerName\" : \"AI_HANDLER\",\n" +
                    "  \"uuid\" : {\n" +
                    "    \"userChannel\" : \"SBERBANK_MESSENGER\",\n" +
                    "    \"userId\" : \"6dcac2c7b0becb60feb60ad0738e6029\",\n" +
                    "    \"chatId\" : \"329599772\"\n" +
                    "  },\n" +
                    "  \"payload\" : {\n" +
                    "    \"requestType\": \"ESB_MQ_SPASIBO_CLIENT\",\n" +
                    "    \"epkId\": \"203483208\",\n" +
                    "    \"showBonusBalance\": \"true\",\n" +
                    "    \"timeDependentAttributes\":[\"PURCHASED_LEVEL\", \"OWI_LEVEL\",\"MIN_LEVEL\",\"LEVEL2\"]\n" +
                    "  }\n" +
                    "}") ;
        };
    }
}