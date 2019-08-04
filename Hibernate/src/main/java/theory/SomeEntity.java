package theory;

import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;
import org.hibernate.annotations.Cache;

/**
 * ТЕОРИЯ
 *
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
 * session.update - находим объект в базе по id и обновляем запись в базе , переводит из состояния detached в состояние
 *    persistent, в состоянии transient нет id и будет кинут EXCEPTION, относится к спецификации Hibernate
 *
 * transaction.commit - обекты привязанные к сессии сохраняются и переводятся в состояние detached
 *
 *
 *
 * https://habr.com/ru/post/265061/
 * Топ 20 вопросов https://www.java67.com/2016/02/top-20-hibernate-interview-questions.html
 *
 */
@Entity
@Table(name = "references")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class SomeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) //
    //@GeneratedValue(strategy = GenerationType.IDENTITY) //
    //@GeneratedValue(strategy = GenerationType.SEQUENCE) //
    //@GeneratedValue(strategy = GenerationType.TABLE) //
    private long id;

    @Column(name = "date")
    @Temporal(TemporalType.DATE) //Отображение в базе: yyyy-MM-dd
    Date date;

    @Column(name = "time")
    @Temporal(TemporalType.TIME) //Отображение в базе: HH:mm:ss
    Date time;

    @Column(name = "timestamp")
    @Temporal(TemporalType.TIMESTAMP) //Отображение в базе: yyyy-MM-dd HH:mm:ss.SSS  Timestamp - точность до наносекунд
    Timestamp timestamp;


}
