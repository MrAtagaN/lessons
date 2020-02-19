package active_mq;


import active_mq.producer.Producer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.jms.annotation.EnableJms;


/**
 *  ActiveMQ Скачиваем с https://activemq.apache.org/components/classic/download/
 *  в папке apache-activemq-5.15.11\bin запускаем в командной строке .\activemq start
 *
 *  админская страница http://localhost:8161/
 *  заходим на ActiveMQ broker
 *  логин и пароль admin admin
 */

@SpringBootApplication
@EnableJms
public class Main {

    @Autowired
    Producer producer;

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);

    }

    @Bean
    public CommandLineRunner commandLineRunner(ApplicationContext context){
        return args -> {
           producer.sendMessage("testTextInMessage_BLA_BLA_BLA");


        };
    }

}
