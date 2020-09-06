package Info.transactions;

import Hibernate2.HibernateUtil;
import org.hibernate.ScrollMode;
import org.hibernate.ScrollableResults;
import org.hibernate.Session;
import org.hibernate.annotations.*;
import org.hibernate.query.Query;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @LazyCollection(LazyCollectionOption.EXTRA) - Поддержка операций с коллекцией не вызывающий ее инициализацию.
 * size, isEmpty, contains. Список List загрузит только один элемент при вызове get(index).
 *
 *
 *  Проблема N + 1
 *
 *  Решения:
 *  @OneToMany(fetch = FetchType.EAGER) - По умолчанию использует стратегию JOIN. Работает для связей @OneToMany @OneToOne
 *  если извлекается одна коллекция, иначе возникает проблема декартова произведения
 *
 *  Массовая предварительная выборка данных:
 *  @BatchSize(size = 10) - При загрузке одного прокси объекта, может быть загружено до 10 объектов. Аннотация ставится
 *  над коллекцией или над классом
 *
 *  Предварительное извлечение подзапросов с помощью подзапросов:
 *  @Fetch(FetchMode.SUBSELECT) - Как только инициализируется одна из коллекций, Hibernate инициализирует все коллекции.
 *  На момент написания доступна только для коллекций с планом отложенной загрузки, но не для прокси-обектов сущностей.
 *
 *  Отложенное извлечение с несколькими выражениями SELECT:
 *  @OneToMany(fetch = FetchType.EAGER)
 *  @Fetch(FetchMode.SELECT)
 *
 *
 *  query.scroll(ScrollMode.SCROLL_INSENSITIVE) - Создание курсора
 *
 *  Именованные запросы:
 *  @NamedQueries(@NamedQuery(name = "", query = ""))
 *  session.createNamedQuery(" ");
 *
 *
 *  query.setHint(QueryHints.READ_ONLY, true) - Подсказки для запросов
 */

@BatchSize(size = 10)
@Entity
@NamedQueries(@NamedQuery(name = "", query = ""))
public class DataManagment {

    @OneToMany(fetch = FetchType.EAGER)
    @LazyCollection(LazyCollectionOption.EXTRA)
    @BatchSize(size = 10)
    @Fetch(FetchMode.SUBSELECT)
    private Set<String> stringSet= new HashSet<>();

    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        CriteriaBuilder criteriaBuilder =  session.getCriteriaBuilder();

        CriteriaQuery<Object> criteria = criteriaBuilder.createQuery();
        CriteriaQuery<Object> select = criteria.select(criteria.from(DataManagment.class));

        TypedQuery<Object> query = session.createQuery(criteria);


        //Создание курсора
        Query<DataManagment> query1 = session.createQuery(" ", DataManagment.class);
        ScrollableResults cursor = query1.scroll(ScrollMode.SCROLL_INSENSITIVE);
        cursor.setRowNumber(2);

        session.createNamedQuery(" ");

        //Подсказки
        query1.setHint(QueryHints.READ_ONLY, true);

    }
}
