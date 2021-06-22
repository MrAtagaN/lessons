package active_mq.listener;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.TextMessage;


@Component
public class Consumer {

    @Autowired
    JmsTemplate jmsTemplate;


//    @JmsListener(destination = "testingQueueCreateNewQ", containerFactory = "myFactory", selector = "CustomKeyPropety like '%Value'")
//    public void receiveMessage(String message) {
//        System.out.println("Received  message -> " + message);
//    }

    public String receiveMessage() throws JMSException {
        Message message = jmsTemplate.receive("testingQueueCreateNewQ");
        TextMessage textMessage = (TextMessage) message;
        System.out.println("recieve message = " + textMessage.getText());
        return textMessage.getText();
    }

    /**
     *  получение сообщения по селектору
     *  в селекторе можно использовать SQL выражения для выборки сообщений например "JMSCorrelationID like '%4%'"
     */
    public String receiveMessageWithSelector() throws JMSException {
        Message message = jmsTemplate.receiveSelected("testingQueueCreateNewQ", "JMSCorrelationID = '441'");
        TextMessage textMessage = (TextMessage) message;
        System.out.println("recieve message = " + textMessage.getText());
        return textMessage.getText();
    }

}
