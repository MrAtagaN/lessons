package interfaces;

import javax.jms.MessageConsumer;

/**
 * {@link MessageConsumer}
 *
 * getMessageListener() - Этот метод нельзя использовать в веб-приложениях Java EE или EJB.
 * getMessageSelector() - Получает выражение селектора сообщений этого получателя сообщения
 * receive() - Получает следующее сообщение, созданное для этого получателя сообщения. Этот вызов блокируется на неопределенный
 *      срок до тех пор, пока не будет создано сообщение или пока этот потребитель не будет закрыт.
 *
 */
public class MessageConsumer_ {

    public static void main(String[] args) {

    }
}
