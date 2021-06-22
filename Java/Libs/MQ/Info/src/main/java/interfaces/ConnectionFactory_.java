package interfaces;

import javax.jms.ConnectionFactory;
import javax.jms.JMSException;

/**
 * {@link ConnectionFactory}
 *
 * ConnectionFactory инкапсулирует набор параметров конфигурации соединения, которые были определены администратором.
 *      Клиент использует его для создания соединения с поставщиком JMS.
 *
 * Методы:
 *
 * createConnection() - Создает соединение с идентификатором пользователя по умолчанию. Соединение создается в stopped mode.
 *      Сообщения не будут доставлены, пока метод Connection.start не будет вызван явно.
 *
 *
 * createContext() - Создает JMSContext с указанным идентификатором пользователя и указанным session mode. JMSContext создается
 *      в stopped mode, но будет автоматически запускаться при создании JMSConsumer. Эффект установки аргумента sessionMode
 *      зависит от того, вызывается ли этот метод в среде Java SE, в контейнере клиента приложения Java EE, в веб-контейнере
 *      Java EE или контейнере EJB.   Если этот метод вызывается в веб-контейнере Java EE или контейнере EJB, эффект установки
 *      аргумента sessionMode также зависит от того, выполняется ли активная транзакция JTA или нет.
 *
 *
 * In a Java SE environment or in the Java EE application client container:
 * Если для sessionMode установлено значение JMSContext.SESSION_TRANSACTED, то сеанс будет использовать локальную транзакцию,
 *      которая впоследствии может быть зафиксирована или откатана путем вызова методов фиксации или отката JMSContext.
 *
 * Если для sessionMode задано любое из JMSContext.CLIENT_ACKNOWLEDGE, JMSContext.AUTO_ACKNOWLEDGE или JMSContext.DUPS_OK_ACKNOWLEDGE.
 *      тогда сеанс не будет передаваться, и сообщения, полученные этим сеансом, будут подтверждены в соответствии со значением
 *      sessionMode. Для определения значения этих режимов подтверждения см. Ссылки ниже.
 *
 * In a Java EE web or EJB container, when there is an active JTA transaction in progress:
 * Аргумент sessionMode игнорируется. Сеанс будет участвовать в транзакции JTA и будет зафиксирован или откатан, когда эта
 *      транзакция будет зафиксирована или откатана, а не путем вызова методов фиксации или отката JMSContext. Поскольку
 *      аргумент игнорируется, разработчикам рекомендуется использовать createContext (String userName, String password)
 *      вместо этого метода.
 *
 * In the Java EE web or EJB container, when there is no active JTA transaction in progress:
 *      Аргумент ПодтверждениеModeMode должен быть установлен в любой из JMSContext.AUTO_ACKNOWLEDGE или JMSContext.DUPS_OK_ACKNOWLEDGE.
 *      Сеанс не будет передаваться, и сообщения, полученные этим сеансом, будут автоматически подтверждаться в соответствии
 *      со значением acceptledgeMode. Для определения значения этих режимов подтверждения см. Ссылки ниже. Значения
 *      JMSContext.SESSION_TRANSACTED и JMSContext.CLIENT_ACKNOWLEDGE могут не использоваться.
 */
public class ConnectionFactory_ {

    public static void main(String[] args) throws JMSException {
        ConnectionFactory connectionFactory = null;
        connectionFactory.createConnection();
        connectionFactory.createContext();
    }
}
