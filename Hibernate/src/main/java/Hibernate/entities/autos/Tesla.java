package Hibernate.entities.autos;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("TESLA")
public class Tesla extends Auto {

    private int battaryCharge;

    public void setBattaryCharge(int battaryCharge) {
        this.battaryCharge = battaryCharge;
    }

    public Tesla() {

    }
}
