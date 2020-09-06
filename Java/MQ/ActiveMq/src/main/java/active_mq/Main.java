package active_mq;


import active_mq.listener.Consumer;
import active_mq.producer.Producer;
import active_mq.model.BalanceRequest;
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
 *
 *  Пример генерации классов по xsd:
 *  в pom есть соответствующий плагин для генерации классов, классы генерируются при mvn install
 *  пометить в target как source root  /src/main/java  ( чтобы idea видела классы )
 *
 *  Создаём объекты по сгенерированным классам, заполняем данными, перегоняем объект в строку в формате SOAP,
 *  отправляем в очередь, получаем из очереди, восстанавливает объект из строки.
 *
 */

@SpringBootApplication
@EnableJms
public class Main {

    @Autowired
    Producer producer;

    @Autowired
    Consumer consumer;

    @Autowired
    BalanceMarshaller balanceMarshaller;

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);

    }

    @Bean
    public CommandLineRunner commandLineRunner(ApplicationContext context) {
        return (args) -> {
            BalanceRequest balanceRequest = Utils.generateTestBalanceRequest();
            String jsonBalanceRequset = balanceMarshaller.marshall(balanceRequest);
            producer.sendMessage(jsonBalanceRequset);
            String receivedStringMessage = consumer.receiveMessage();
            BalanceRequest balanceRequestFromQueue = (BalanceRequest) balanceMarshaller.unmarshal(receivedStringMessage);
            System.out.println("Receive balance with account number " + balanceRequestFromQueue.getAccountNumber());
        };
    }

}
