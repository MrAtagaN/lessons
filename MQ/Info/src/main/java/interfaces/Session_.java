package interfaces;

import javax.jms.*;

/**
 * {@link Session}
 *
 * Session - это однопоточный контекст для создания и потребления сообщений.
 *
 * Сеанс может быть указан как транзакционный. Каждая транзакционная Session поддерживает одну серию транзакций. Каждая
 *      транзакция группирует набор отправляемых сообщений, а набор сообщений получает в атамарной единице работы. Когда
 *      транзакция фиксируется, ее атомная единица ввода подтверждается и соответствующая атомная единица вывода отправляется.
 *
 * Методы:
 * commit() -
 * rollback() -
 * createBrowser() - Creates a {@link QueueBrowser}
 * createConsumer() - Creates a {@link MessageConsumer}
 * createMessage() -
 * createProducer() - Creates a {@link MessageProducer}
 *
 *
 */
public class Session_ {

    public static void main(String[] args) throws JMSException {
        Session session = null;
        session.createBrowser(null);
        session.createConsumer(null);
        session.createMessage();
        session.createProducer(null);

    }
}
