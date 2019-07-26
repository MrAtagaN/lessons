package Hibernate;

import javax.persistence.*;
import java.time.LocalDateTime;


@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Basic //
    @Column(name = "name")
    private String name;

    @Column(name = "age")
    private int age;

    @Column(name = "birthday")
    @Temporal(TemporalType.TIMESTAMP) //yyyy-MM-dd HH:mm:ss.SSS
    private LocalDateTime birthday;

    @Column(name = "state")
    @Enumerated(EnumType.STRING)
    private State state;


    public User() {
    }

    public enum State {
        MALE,
        FEMALE
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public LocalDateTime getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDateTime birthday) {
        this.birthday = birthday;
    }

    public int getId() {
        return id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
