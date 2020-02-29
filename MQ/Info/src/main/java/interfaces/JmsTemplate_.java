package interfaces;

import org.springframework.jms.core.JmsTemplate;


/**
 * {@link JmsTemplate}
 *
 * browse(BrowserCallback<T> action) - Просматривайте сообщения в очереди JMS. Action - действие после просмотра очереди
 *      и реагирования на ее содержимое.
 *
 * browseSelected(Queue queue, String messageSelector, BrowserCallback<T> action) -
 *
 * convertAndSend(Destination destination, Object message, MessagePostProcessor postProcessor) - Отправьте данный объект
 *      в указанное место назначения, преобразовав объект в сообщение JMS с настроенным MessageConverter.
 *
 */
public class JmsTemplate_ {

    public static void main(String[] args) {
        JmsTemplate jmsTemplate = null;
        jmsTemplate.receiveSelected("");
        jmsTemplate.browse(null);
    }
}
