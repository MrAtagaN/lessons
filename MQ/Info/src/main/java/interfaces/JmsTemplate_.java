package interfaces;

import org.springframework.jms.core.JmsTemplate;


/**
 * {@link JmsTemplate}
 *
 * browse() - Просматреть сообщения в очереди JMS. Action - действие после просмотра очереди и реагирования на ее содержимое.
 *
 * browseSelected() -
 *
 * convertAndSend() - Отправляет данный объект в указанное место назначения, преобразовав объект в сообщение JMS с
 *      настроенным MessageConverter.
 *
 * execute() - Отправляет сообщения в пункт назначения JMS.
 *
 * isExplicitQosEnabled() - Если «true», то при отправке сообщения будут использоваться значения deliveryMode, priority и timeToLive.
 *      В противном случае будут использоваться значения по умолчанию, которые могут быть установлены административно.
 *
 * receive() -
 * receiveAndConvert()
 * receiveSelected() -
 * receiveSelectedAndConvert() -
 * send() -
 * sendAndReceive() -
 * setMessageConverter() -
 * setReceiveTimeout() -
 *
 */
public class JmsTemplate_ {

    public static void main(String[] args) {
        JmsTemplate jmsTemplate = null;
        jmsTemplate.browse(null);
        jmsTemplate.browseSelected(null,null);
        jmsTemplate.convertAndSend(null);
        jmsTemplate.execute((session)-> {return null;});
        jmsTemplate.isExplicitQosEnabled();
        jmsTemplate.receive();
        jmsTemplate.receiveAndConvert();
        jmsTemplate.receiveSelected("");
        jmsTemplate.receiveSelectedAndConvert("");
        jmsTemplate.send(null);
        jmsTemplate.sendAndReceive(null);
        jmsTemplate.setMessageConverter(null);
        jmsTemplate.setReceiveTimeout(0);
    }
}
