package active_mq.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

@Service
public class Producer {

    @Autowired
    private JmsTemplate jmsTemplate;

    public void sendMessage(String textInMessage) {

        jmsTemplate.convertAndSend("testingQueueCreateNewQ", textInMessage, message -> {
            message.setStringProperty("CustomKeyPropety", "SomeValue");
            message.setJMSCorrelationID("441");
            return message;
        });
    }

}
