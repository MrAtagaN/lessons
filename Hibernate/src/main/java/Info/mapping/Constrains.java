package Info.mapping;

import org.hibernate.annotations.Check;

import javax.persistence.Column;
import javax.persistence.Index;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import java.util.Date;

/**
 * columnDefinition - Ограничение домена (столбца)
 *
 * @Check() - Ограничение уровня базы
 *
 *
 */

@Table(uniqueConstraints = @UniqueConstraint(name = "CONSTRAIN_NAME", columnNames = {"secondName"}),
        indexes = @Index(name = "INDEX_NAME", columnList = "LIST"))
@Check(constraints = "start > end")
public class Constrains {

    @Column(columnDefinition = "EMAIL_ADDRESS(255)")
    String name;


    String secondName;

    Date start;
    Date end;
}
