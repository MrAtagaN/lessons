package Hibernate.entities.bank_details;

import javax.persistence.*;

@Entity
@AttributeOverride(name = "owner", column = @Column(name = "DC_OWNER", nullable = false))
public class DebitCard extends BankDetails {

    public DebitCard() {

    }

    public DebitCard(String owner) {
        this.owner = owner;
    }


}
