package Info.transactions;


import Hibernate2.HibernateUtil;
import Hibernate2.User;
import org.hibernate.ReplicationMode;
import org.hibernate.Session;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.OptimisticLock;
import org.hibernate.annotations.OptimisticLockType;
import org.hibernate.annotations.OptimisticLocking;

import javax.persistence.LockModeType;
import javax.persistence.Version;

/**
 *
 * состояния объектов в hibernate :
 *    transient - объект не был никогда соединём с сессией hibernate, у объекта нет id
 *    persistent - объект соединён с сессией , при закрытии сессии или коммите транзакции будет сохранён
 *    detached - объект отсоединён от сессии, у объекта есть id
 *
 *
 * session.persist - переводим объект в состояние persistent из состояния transient, если объект уже в
 *    состоянии persistent ничего не произойдёт, если объект в состоянии detached будет кинут EXCEPTION,
 *    метод относится к JPA спецификация
 *
 *
 * session.save - сохраняет объект и возвращает id , если объект в состоянии transient переводит в состояние persistent,
 *    если объект в состоянии persistent состояние не меняется , если объект в состоянии detached, объект будет сохранён
 *    повторно (появится дублирующая строка в базе), метод относится к спецификации Hibernate
 *
 *
 * session.update - если объект в состоянии persistent обновляет его, если объект в состоянии detached находит объект
 *    в базе по id и обновляет запись в базе , переводит из состояния detached в состояние persistent, в состоянии
 *    transient нет id и будет кинут EXCEPTION, относится к спецификации Hibernate
 *
 *
 * session.merge - если объект в состоянии persistent обновляет его, если объект в состоянии detached находит объект
 *     в базе по id и обновляет запись в базе, возвращает обновлённый объект в состоянии persistent, у передаваемого
 *     объекта не меняет состояние, если объект в сотоянии transient сохраняет в базу.
 *
 * session.refresh - Обновить состояние объекта из базы
 *
 * session.flush - Перевести контекст хранения в базу.
 *
 * session.getReference - Получить пустой прокси объект.
 *
 * session.lock - Явная блокировка
 *
 * session.get - Немедлено берет данные из базы. Если нет в базе объекта, возвращает null
 *
 * session.load - Возвращает прокси, данные не загружаются из базы до первого обращенияю.  Если нет в базе объекта,
 *     выкидывает исключение.
 *
 * transaction.commit - коммит,  обекты привязанные к сессии сохраняются
 *
 *
 * Оптимистичные блокировки:
 *
 * @Version - Версионирование. Побеждает первая подтвержденная транзакция
 * @OptimisticLocking(type = OptimisticLockType.ALL) - Вместо отдельного поля для версионирования используются все
 * поля класса
 * @OptimisticLock(excluded = true) - убрать поле из версионирования
 *
 * LockModeType.OPTIMISTIC_FORCE_INCREMENT - принудительное изменение версии.
 * Применяется, если изменяется сущность внутри коллекции (связанная ManyToOne).
 *
 *
 * Пессимистичные блокировки:
 *
 * PESSIMISTIC_READ - повторимость чтения
 * PESSIMISTIC_WRITE - последовательный досуп к данным, чтобы предотвратить фантомные чтения
 *
 * order_updates - упорядочивает все update в порядке возрастания primary_key
 *
 * unwrap - JPA приводит к Hibernate Api. EntityManagerFactory приводит к SessionFactory, EntityManager приводит к Session
 *
 *
 * replicate - Репликация данных из одной базы в другую
 *   ReplicationMode:
 *   IGNORE -
 *   OVERWRITE -
 *   EXCEPTION -
 *   LATEST_VERSION -
 *
 * https://habr.com/ru/post/265061/
 * Топ 20 вопросов https://www.java67.com/2016/02/top-20-hibernate-interview-questions.html
 *
 */
@OptimisticLocking(type = OptimisticLockType.ALL)
@DynamicUpdate
public class Transactions {

    @Version
    int version;

    @OptimisticLock(excluded = true)
    int a;

    public static void main(String[] args) {

        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        User user = session.getReference(User.class, 12);


        session.replicate(user, ReplicationMode.LATEST_VERSION);
        session.find(User.class, 12, LockModeType.PESSIMISTIC_WRITE);

    }
}
