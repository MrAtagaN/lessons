package Hibernate.entities.animal;

import javax.persistence.Entity;

@Entity
public class Dog extends Animal {

    private boolean canGuard;


    public Dog() {

    }

    public boolean isCanGuard() {
        return canGuard;
    }

    public void setCanGuard(boolean canGuard) {
        this.canGuard = canGuard;
    }
}
