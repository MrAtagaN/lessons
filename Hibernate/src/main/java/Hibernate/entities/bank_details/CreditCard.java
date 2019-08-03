package Hibernate.entities.bank_details;

import javax.persistence.*;

@Entity
@AttributeOverride(name = "owner", column = @Column(name = "CC_OWNER", nullable = false))
public class CreditCard extends BankDetails {

    public CreditCard (String owner) {
        this.owner = owner;
    }

    public CreditCard () {

    }
}
