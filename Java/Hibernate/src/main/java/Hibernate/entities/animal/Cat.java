package Hibernate.entities.animal;

import javax.persistence.Entity;

@Entity
public class Cat extends Animal {


    private boolean canClimbing;

    public boolean isCanClimbing() {
        return canClimbing;
    }

    public void setCanClimbing(boolean canClimbing) {
        this.canClimbing = canClimbing;
    }

    public Cat() {

    }
}
