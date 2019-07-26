package theory;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;

/**
 * ТЕОРИЯ
 *
 * https://habr.com/ru/post/265061/
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
    @Temporal(TemporalType.DATE) //yyyy-MM-dd
    Date date;

    @Column(name = "time")
    @Temporal(TemporalType.TIME) //HH:mm:ss
    Date time;

    @Column(name = "timestamp")
    @Temporal(TemporalType.TIMESTAMP) //yyyy-MM-dd HH:mm:ss.SSS  Timestamp - точность до наносекунд
    Timestamp timestamp;


}
