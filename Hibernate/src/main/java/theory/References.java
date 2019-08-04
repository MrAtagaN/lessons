package theory;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;

/**
 * ТЕОРИЯ
 *
 * persist - переводим объект в состояние persistent
 * save - сохраняем объект и получаем id
 * commit - сохраняются обекты привязанные к сессии и переводятся в состояние detached
 *
 * https://habr.com/ru/post/265061/
 * Топ 20 вопросов https://www.java67.com/2016/02/top-20-hibernate-interview-questions.html
 *
 */
@Entity
@Table(name = "references")
public class References {

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
