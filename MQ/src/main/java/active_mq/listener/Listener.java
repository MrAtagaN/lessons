package active_mq.listener;


import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class Listener {


    @JmsListener(destination = "testingQueueCreateNewQ", containerFactory = "myFactory")
    public void receiveMessage(String message) {
        System.out.println("Received  message -> " + message);
    }

}
