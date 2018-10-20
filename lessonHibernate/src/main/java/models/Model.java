package models;

import javax.persistence.*;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;

/**
 * Created by AtagaN on 13.05.2018.
 */
@MappedSuperclass
public abstract class Model implements Serializable {
    private final static long SerialVersionUID=1;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="Id")
    private long id;

    public Model() {
    }

    public Model(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
