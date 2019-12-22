package theory.transactions;


import Hibernate2.HibernateUtil;
import Hibernate2.User;
import org.hibernate.ReplicationMode;
import org.hibernate.Session;

import javax.persistence.EntityManagerFactory;

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
 *
 * session.refresh - Обновить состояние объекта из базы
 *
 *
 * session.flush -
 *
 *
 * session.getReference - Получить пустой прокси объект.
 *
 *
 * session.get - Немедлено берет данные из базы. Если нет в базе объекта, возвращает null
 *
 *
 * session.load - Возвращает прокси, данные не загружаются из базы до первого обращенияю.  Если нет в базе объекта,
 *     выкидывает исключение.
 *
 *
 * transaction.commit - коммит,  обекты привязанные к сессии сохраняются
 *
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
public class DataManagement {

    public static void main(String[] args) {

        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        User user = session.getReference(User.class, 12);

        session.replicate(user, ReplicationMode.LATEST_VERSION);
    }
}
