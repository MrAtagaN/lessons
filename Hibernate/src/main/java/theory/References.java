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
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Temporal(TemporalType.DATE) //yyyy-MM-dd
    Date date;
    @Temporal(TemporalType.TIME) //HH:mm:ss
    Date time;
    @Temporal(TemporalType.TIMESTAMP) //yyyy-MM-dd HH:mm:ss.SSS  Timestamp - точность до наносекунд
    Timestamp timestamp;
}
