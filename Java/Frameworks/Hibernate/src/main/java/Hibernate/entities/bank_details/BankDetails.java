package Hibernate.entities.bank_details;

import Hibernate.entities.User;

import javax.persistence.*;


@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class BankDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "owner_credit_card")
    protected String owner;

    @OneToOne
    @JoinColumn(name = "id", referencedColumnName = "bankDetailsID")
    protected User user;


    public BankDetails() {
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }
}
