package Hibernate.entities;

import Hibernate.entities.bank_details.BankDetails;
import com.sun.istack.internal.Nullable;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.Cache;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Objects;


@Entity
@Table(name = "users")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
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
    //@Temporal(TemporalType.TIMESTAMP) //yyyy-MM-dd HH:mm:ss.SSS
    private LocalDateTime birthday;

    @Column(name = "state")
    @Enumerated(EnumType.STRING)
    private State state;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "bankDetailsID", referencedColumnName = "id")
    BankDetails bankDetails;

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

//    public BankDetails getBankDetails() {
//        return bankDetails;
//    }
//
    public void setBankDetails(BankDetails bankDetails) {
        this.bankDetails = bankDetails;
    }


}
