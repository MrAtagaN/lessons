package active_mq.listener;


import org.apache.activemq.command.ActiveMQTextMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.TextMessage;


@Component
public class Listener {

    @Autowired
    JmsTemplate jmsTemplate;


//    @JmsListener(destination = "testingQueueCreateNewQ", containerFactory = "myFactory", selector = "CustomKeyPropety like '%Value'")
//    public void receiveMessage(String message) {
//        System.out.println("Received  message -> " + message);
//    }

    public void reciveMessageWithJmsTemplate() throws JMSException {
        // получение сообщения по селектору
        // в селекторе можно использовать SQL выражения для выборки сообщений например "JMSCorrelationID like '%4%'"
        // Message message2 =  jmsTemplate.receiveSelected("testingQueueCreateNewQ", "JMSCorrelationID = '441'");
        Message message = jmsTemplate.receive("testingQueueCreateNewQ");
        TextMessage textMessage = (TextMessage) message;
        System.out.println("recieve message = " + textMessage.getText());
    }

}
