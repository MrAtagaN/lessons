package Hibernate.entities.autos;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("BMW")
public class Bmw extends Auto {


    private int gasTankValume;


    public void setGasTankValume(int gasTankValume) {
        this.gasTankValume = gasTankValume;
    }

    public Bmw() {

    }
}
