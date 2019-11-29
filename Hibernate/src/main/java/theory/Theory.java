package theory;
/**
 * Состояния объектов в hibernate :
 *    transient - объект не был никогда соединём с сессией hibernate, у объекта нет id
 *    persistent - объект соединён с сессией , при закрытии сессии или коммите транзакции будет сохранён
 *    detached - объект отсоединён от сессии, у объекта есть id
 *
 *
 * Конфигурация:
 *    в коде
 *    hibernate.cfg.xml
 *    hibernate.properties
 *    persistence.xml
 *

 * Стратегии загрузки:
 *
 *
 * Наследование:
 * @Inheritance(strategy=JOINED)
 * SINGLE_TABLE -
 * TABLE_PER_CLASS -
 * JOINED -
 *
 *
 * Аннотации:
 *    http://javastudy.ru/spring-data-jpa/annotation-persistence/
 *
 *
 *
 */
public class Theory {
}
